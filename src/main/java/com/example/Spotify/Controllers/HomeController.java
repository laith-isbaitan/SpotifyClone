package com.example.Spotify.Controllers;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Spotify.Models.MediUser;
import com.example.Spotify.Models.Playlist;
import com.example.Spotify.Models.Song;
import com.example.Spotify.Models.User;
import com.example.Spotify.Services.PlaylistService;
import com.example.Spotify.Services.SongService;
import com.example.Spotify.Services.UserService;
import com.example.Spotify.Validators.UserValidator;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserValidator userValidator;

	@Autowired
	private SongService songService;

	@Autowired
	private PlaylistService playlistService;

	///////// login signup page//////////////

	@RequestMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model,
			@Valid @ModelAttribute("user") User user, Principal principal) {

		if (principal != null) {
			return "redirect:/";

		} else {
			if (error != null) {
				model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
			}
			if (logout != null) {
				model.addAttribute("logoutMessage", "Logout Successful!");
			}
			return "LoginSignupPage.jsp";
		}
	}

	@RequestMapping(value = { "/", "/home" })
	public String home(Principal principal, Model model) {
		// 1
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		MediUser mediUser = (MediUser) auth.getPrincipal();

		String email = mediUser.getEmail();
		User user = userService.findByEmail(email);

		model.addAttribute("currUser", user);
		if (user != null) {
			user.setLastLogin(new Date());
			userService.updateUser(user);
			// ***********extra************
			// If the user is an ADMIN or SUPER_ADMIN they will be redirected to the admin
			// page
//			if(user.getRoles().get(0).getName().contains("ROLE_ADMIN")) {
////				model.addAttribute("currentUser", userService.findByEmail(email));
//				model.addAttribute("users", userService.findAll());
//				return "adminPage.jsp";
//			}
			// ***************************

			// All other users are redirected to the home page
		}
		List<Song> songs = songService.allSongs();
		model.addAttribute("songs", songs);
		return "dashboard.jsp";
	}

	////////////////// regestration/////////////////

	@PostMapping("/registration")
	public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {

		userValidator.validate(user, result);
		if (result.hasErrors()) {
			return "LoginSignupPage.jsp";
		}
		userService.regesterUser(user);
		return "redirect:/";
	}
	////////////////////////////////////

	@GetMapping("/songs")
	public String SongTable() {
		return "SongPage.jsp";
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
			return "redirect:/";
		}
	}

	@GetMapping("/songs/{id}")
	public String songData(@PathVariable("id") Long id, Model model) {
		model.addAttribute("songs", songService.findSong(id));

		return "SongPage.jsp";
	}

	@GetMapping("/users")
	public String UserTable(Model model) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		MediUser mediUser = (MediUser) auth.getPrincipal();

		String email = mediUser.getEmail();
		User user = userService.findByEmail(email);

		model.addAttribute("currUser", user);
		return "UserPage.jsp";
	}

	@PostMapping("/users")
	public String users(@ModelAttribute("user") User user, Principal principal, Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		MediUser mediUser = (MediUser) auth.getPrincipal();

		String email = mediUser.getEmail();
		User user1 = userService.findByEmail(email);
		model.addAttribute("currUser", user1);
		return "UserPage.jsp";
	}

	@GetMapping("/playlists")
	public String playlists(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		MediUser mediUser = (MediUser) auth.getPrincipal();
		String email = mediUser.getEmail();
		User user = userService.findByEmail(email);
		Long userId = user.getId();
		System.out.println(userId);
		model.addAttribute("playlists", playlistService.findAllUsersPlaylists(userId));

		return "Playlist.jsp";
	}

	@GetMapping("/playlists/new")
	public String addPlaylist(@ModelAttribute("playlist") Playlist playlist) {
		return "addPlayList.jsp";
	}

	@PostMapping("/playlists/new")
	public String addPlaylist(@Valid @ModelAttribute("playlist") Playlist playlist, BindingResult result,
			Principal principal) {
		if (result.hasErrors()) {
			return "addPlayList.jsp";
		} else {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();

			MediUser mediUser = (MediUser) auth.getPrincipal();
			String email = mediUser.getEmail();
			User user = userService.findByEmail(email);

			userService.addPlaylist(user, playlist);
			return "redirect:/playlists";
		}
	}

}
