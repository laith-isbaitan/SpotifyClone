package com.example.Spotify.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
}
