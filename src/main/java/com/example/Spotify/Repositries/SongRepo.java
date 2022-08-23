package com.example.Spotify.Repositries;

import org.springframework.data.repository.CrudRepository;

import com.example.Spotify.Models.Song;


public interface SongRepo extends CrudRepository<Song,Long>{

}
