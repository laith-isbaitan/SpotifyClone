package com.example.Spotify.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.Spotify.Models.Song;
import com.example.Spotify.Repositries.SongRepo;

@Service
public class SongService {
	private final SongRepo songRepo;

	public SongService(SongRepo songRepo) {
		this.songRepo = songRepo;
	}

	public List<Song> allSongs() {
		return songRepo.findAll();
	}

	public Song createSong(Song song) {
		return songRepo.save(song);
	}

	public Song findSong(Long id) {
		// Optional means the object can exist or not
		Optional<Song> optionalSong = songRepo.findById(id);
		if (optionalSong.isPresent()) {
			return optionalSong.get();
		} else {
			return null;
		}
	}

	public Song updateSong(Song song) {
		return songRepo.save(song);
	}

	public void deleteSong(Long id) {
		Optional<Song> optionalSong = songRepo.findById(id);
		if (optionalSong.isPresent()) {
			songRepo.deleteById(id);
		}
	}

}