package com.example.Spotify.Services;

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
        userRepo.save(user);
        Playlist userPlaylist = new Playlist();    
        
        user.setPlaylist(userPlaylist);
        userPlaylist.setUser(user);

        playlistRepo.save(userPlaylist);
        return userRepo.save(user);
    }
    
    /////////////login//////////////////
    public User findByEmail(String email) {
        return userRepo.findByEmail(email);
    }
    public User findByName(String name) {
    	return userRepo.findByFirstName(name);
    }
    public User updateUser(User u) {
    	return userRepo.save(u);
    }
}













