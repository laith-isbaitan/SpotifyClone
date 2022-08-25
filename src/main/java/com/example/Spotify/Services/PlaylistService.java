package com.example.Spotify.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.Spotify.Models.Playlist;
import com.example.Spotify.Models.Song;
import com.example.Spotify.Repositries.PlaylistRepo;
import com.example.Spotify.Repositries.SongRepo;

@Service
public class PlaylistService {
	private final PlaylistRepo playlistRepo;
	
	private final SongRepo songRepo;

	public PlaylistService(PlaylistRepo playlistRepo,SongRepo songRepo) {
		this.playlistRepo = playlistRepo;
		this.songRepo = songRepo;
	}

	public List<Playlist> allPlaylists() {
		return playlistRepo.findAll();
	}

	public Playlist findByName(String name) {
		return playlistRepo.findByName(name);
	}

	public Playlist findById(long id) {
		return playlistRepo.findByIdIs(id);
	}

	public Playlist findPlaylist(Long id) {
		Optional<Playlist> optionalPlaylist = playlistRepo.findById(id);
		if (optionalPlaylist.isPresent()) {
			return optionalPlaylist.get();
		} else {
			return null;
		}
	}

	public List<Playlist> findAllUsersPlaylists(Long userId) {
		return playlistRepo.findAllByUser_id(userId);
	}

	public List<Playlist> getAssignedSongs(Song song) {
		return playlistRepo.findAllBySongs(song);
	}

	public List<Playlist> getUnassignedSongs(Song song) {
		return playlistRepo.findBySongsNotContains(song);
	}
	
	public Playlist AddSongToPlaylist(Long playlistId, Long songId) {
		Playlist foundList = playlistRepo.findByIdIs(playlistId);
		Song foundSong = songRepo.findByIdIs(songId);
		
		if(foundList.getSongs().contains(foundSong)) {
			playlistRepo.findByPlaylistAndSong(playlistId, songId);
		}else {
			foundList.getSongs().add(foundSong);
			foundSong.getPlaylists().add(foundList);
			
			songRepo.save(foundSong);
			return playlistRepo.save(foundList);
		}
		return foundList;
	}

	public void deletePlaylist(Long id) {
		Optional<Playlist> optionalPlaylist = playlistRepo.findById(id);
		if (optionalPlaylist.isPresent()) {
			playlistRepo.deleteById(id);
		}
	}

}
