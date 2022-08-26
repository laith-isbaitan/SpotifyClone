package com.example.Spotify.Repositries;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Spotify.Models.Playlist_song;

@Repository
public interface Play_SongRepo extends CrudRepository<Playlist_song, Long>{
	List<Playlist_song> findAllByPlaylist_id(Long Playlist_id);
	Playlist_song findAllByPlaylist_idAndSong_id(Long Playlist_id,Long Song_id);

	List<Playlist_song> findAllBySong_id(Long Song_id);

}
