package com.example.Spotify.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Spotify.Models.Playlist;
import com.example.Spotify.Models.User;
import com.example.Spotify.Repositries.PlaylistRepo;
import com.example.Spotify.Repositries.SongRepo;
import com.example.Spotify.Repositries.UserRepo;

@Service
public class UserService {
	private UserRepo userRepo;
	private PlaylistRepo playlistRepo;
	private SongRepo songRepo;
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public UserService(UserRepo userRepo, PlaylistRepo playlistRepo, SongRepo songRepo,
			BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userRepo = userRepo;
		this.playlistRepo = playlistRepo;
		this.songRepo = songRepo;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	/////////// regestering user//////////

	//useing bcrypt to encript user password
	//adding a new playlist for user
	public User regesterUser(User user) {

		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userRepo.save(user);
		Playlist userPlaylist = new Playlist();
		userPlaylist.setName("first playlist");

		user.getPlaylist().add(userPlaylist);
		userPlaylist.setUser(user);

		playlistRepo.save(userPlaylist);
		return userRepo.save(user);
	}

	///////////// login//////////////////

	public User findByEmail(String email) {
		return userRepo.findByEmail(email);
	}

	public User findByName(String name) {
		return userRepo.findByFirstName(name);
	}

	public User updateUser(User u) {
		return userRepo.save(u);
	}

	public List<User> allUsers() {
		return userRepo.findAll();
	}

	public Playlist addPlaylist(User user, Playlist playlist) {

		user.getPlaylist().add(playlist);
		playlist.setUser(user);

		userRepo.save(user);
		return playlistRepo.save(playlist);
	}

	public User findById(Long id) {
		Optional<User> optionalUser = userRepo.findById(id);
		if (optionalUser.isPresent()) {
			return optionalUser.get();
		} else {
			return null;
		}
	}
}
