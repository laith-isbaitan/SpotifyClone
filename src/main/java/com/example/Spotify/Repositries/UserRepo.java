package com.example.Spotify.Repositries;

import org.springframework.data.repository.CrudRepository;

import com.example.Spotify.Models.User;

public interface UserRepo extends CrudRepository<User,Long>{

	User findByEmail(String username);

	User findByFirstName(String Firstname);

}
