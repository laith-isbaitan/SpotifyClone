package com.example.Models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "songs")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



   @Size(min = 3, max = 30)
    private String title;



   @Size(min = 3, max = 30)
    private String artist;



   @ManyToMany(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinTable(name = "playlist-song",
    		joinColumns = @JoinColumn(name = "song_id"), 
    		inverseJoinColumns = @JoinColumn(name = "playlist_id"))
    private List<Playlist> playlists;



   public Long getId() {
        return id;
    }



   public void setId(Long id) {
        this.id = id;
    }



   public String getTitle() {
        return title;
    }



   public void setTitle(String title) {
        this.title = title;
    }



   public String getArtist() {
        return artist;
    }



   public void setArtist(String artist) {
        this.artist = artist;
    }



   public List<Playlist> getPlaylists() {
        return playlists;
    }



   public void setPlaylist(List<Playlist> playlists) {
        this.playlists = playlists;
    }



}