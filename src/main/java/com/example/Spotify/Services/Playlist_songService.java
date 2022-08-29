package com.example.Spotify.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Spotify.Models.Playlist_song;
import com.example.Spotify.Models.Song;
import com.example.Spotify.Repositries.Play_SongRepo;

@Service
public class Playlist_songService {
	@Autowired
	private Play_SongRepo play_songRepo;

	public List<Playlist_song> findSongsInPlaylist(Long playId) {
		return play_songRepo.findAllByPlaylist_id(playId);
	}

	public List<Integer> findAllAddsforSong() {
		return play_songRepo.findByAllAddsforSong();

	}

	public List<Object[]> findAllAddsforSong2() {
		return play_songRepo.findByAllAddsforSong2();

	}

	public List<Object[]> findAllAddsforSong3() {
		return play_songRepo.findByAllAddsforSong3();

	}
}
