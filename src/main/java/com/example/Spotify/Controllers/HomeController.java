package com.example.Spotify.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.Spotify.Models.Song;

@Controller
public class HomeController {
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@GetMapping("/dash")
	public String dashboard() {
		return "dashboard.jsp";
	}
	
	@GetMapping("/addsong")
	public String addSong(@ModelAttribute("addSongForm") Song song) {
		return "addSong.jsp";
	}
}
