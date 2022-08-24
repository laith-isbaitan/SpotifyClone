package com.example.Spotify.Repositries;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Spotify.Models.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {

	List<User> findAll();

	User findByEmail(String username);

	User findByFirstName(String Firstname);

	User findByIdIs(Long id);

	@Query(value = "SELECT concat(users.firstName, users.lastName), sum(Playlist_song.NumOfTimesAdded) FROM users, playlists, playlist_song, songs"

			+ "WHERE users.id = playlists.user_id and" + "playlists.id = playlist_song.playlist_id and"
			+ "playlist_song.song_id = songs.id" + "group BY concat(users.firstName, users.lastName);", nativeQuery = true)

	List<Object[]> findAllBySongs();

}
