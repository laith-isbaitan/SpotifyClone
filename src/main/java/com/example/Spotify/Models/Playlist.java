package com.example.Spotify.Models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "playlists")
public class Playlist {

   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   @OneToOne(fetch = FetchType.LAZY)
    @JsonIgnore
   @JoinColumn(name = "user_id")
    private User user;

   @ManyToMany(fetch = FetchType.LAZY)
    @JsonIgnore
   @JoinTable(name = "playlist_song",
   			joinColumns = @JoinColumn(name = "playlist_id"),
   			inverseJoinColumns = @JoinColumn(name = "song_id"))
    private List<Song> songs;

   public Long getId() {
        return id;
    }



   public void setId(Long id) {
        this.id = id;
    }



   public User getUser() {
        return user;
    }



   public void setUser(User user) {
        this.user = user;



   }



   public List<Song> getSongs() {
        return songs;
    }



   public void setSongs(List<Song> songs) {
        this.songs = songs;
    }



}