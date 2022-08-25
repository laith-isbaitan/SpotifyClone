package com.example.Spotify.Repositries;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Spotify.Models.Playlist;
import com.example.Spotify.Models.Song;

@Repository
public interface SongRepo extends CrudRepository<Song, Long> {

	List<Song> findAll();

	Song findByIdIs(Long id);

	List<Song> findAllByPlaylists(Playlist playlist);

	List<Song> findByPlaylistsNotContains(Playlist playlist);
}
