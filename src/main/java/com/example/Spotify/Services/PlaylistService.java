package com.example.Spotify.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.Spotify.Models.Playlist;
import com.example.Spotify.Repositries.PlaylistRepo;

@Service
public class PlaylistService {
	private final PlaylistRepo playlistRepo;

	public PlaylistService(PlaylistRepo playlistRepo) {
		this.playlistRepo = playlistRepo;
	}

	public List<Playlist> allPlaylists() {
		return playlistRepo.findAll();
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
}
