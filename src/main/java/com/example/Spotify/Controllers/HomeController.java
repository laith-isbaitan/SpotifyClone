package com.example.Spotify.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Spotify.Models.Song;
import com.example.Spotify.Services.SongService;

@Controller
public class HomeController {

	@Autowired
	SongService songService;

	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}

	@GetMapping("/login")
	public String login() {
		return "LoginSignupPage.jsp";
	}

	@GetMapping("/songs")
	public String SongTable() {
		return "SongPage.jsp";
	}

	@GetMapping("/users")
	public String UserTable() {
		return "UserPage.jsp";
	}

	@GetMapping("/dash")
	public String dashboard(Model model) {
		List<Song> songs = songService.allSongs();
		model.addAttribute("songs", songs);

		return "dashboard.jsp";
	}

	@GetMapping("/addsong")
	public String addSong(@ModelAttribute("addSongForm") Song song) {
		return "addSong.jsp";
	}

	@GetMapping("/songs/new")
	public String NewProduct(@ModelAttribute("addSongForm") Song song) {
		return "addSong.jsp";

	}

	@PostMapping("/songs/new")
	public String createNewSong(@Valid @ModelAttribute("addSongForm") Song song, BindingResult result) {
		if (result.hasErrors()) {
			return "addSong.jsp";
		} else {
			songService.createSong(song);
			return "redirect:/dash";
		}
	}

	@GetMapping("/songs/{id}")
	public String songData(@PathVariable("id") Long id, Model model) {
		model.addAttribute("songs", songService.findSong(id));

		return "SongPage.jsp";
	}

}
