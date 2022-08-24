package com.example.Spotify.Services;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.example.Spotify.Models.User;
import com.example.Spotify.Repositries.PlaylistRepo;
import com.example.Spotify.Repositries.SongRepo;
import com.example.Spotify.Repositries.UserRepo;

@Service
public class UserService {
    private UserRepo userRepo;
    private	PlaylistRepo playlistRepo;
    private SongRepo songRepo;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
	public UserService(UserRepo userRepo, PlaylistRepo playlistRepo, SongRepo songRepo,
			BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userRepo = userRepo;
		this.playlistRepo = playlistRepo;
		this.songRepo = songRepo;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
    
	///////////regestering user//////////
	
    public User regesterUser(User user) {
    	
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }
    
    /////////////login//////////////////
    public User findByUsername(String username) {
        return userRepo.findByEmail(username);
    }
    public User findByName(String name) {
    	return userRepo.findByFirstName(name);
    }
    public User updateUser(User u) {
    	return userRepo.save(u);
    }
}













