package com.example.Spotify.Repositries;

import org.springframework.data.repository.CrudRepository;

import com.example.Spotify.Models.Playlist;

public interface PlaylistRepo extends CrudRepository<Playlist,Long>{

}
