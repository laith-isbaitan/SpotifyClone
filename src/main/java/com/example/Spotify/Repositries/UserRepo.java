package com.example.Spotify.Repositries;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Spotify.Models.User;

@Repository
public interface UserRepo extends CrudRepository<User,Long>{

	User findByEmail(String username);

	User findByFirstName(String Firstname);

}
