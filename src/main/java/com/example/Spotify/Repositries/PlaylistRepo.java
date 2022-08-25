package com.example.Spotify.Repositries;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.Spotify.Models.Playlist;

@Repository
public interface PlaylistRepo extends CrudRepository<Playlist, Long> {

	List<Playlist> findAll();

	Playlist findByIdIs(Long id);

	List<Playlist> findAllBySongs(Playlist playlist);

	List<Playlist> findAllByUser_id(Long id);

}
