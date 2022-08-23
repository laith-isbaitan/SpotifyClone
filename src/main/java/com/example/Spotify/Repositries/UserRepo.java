package com.example.Spotify.Repositries;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Spotify.Models.Song;

@Repository

public interface UserRepo extends CrudRepository<Song, Long> {

}
