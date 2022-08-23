package com.example.Spotify.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
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

}
