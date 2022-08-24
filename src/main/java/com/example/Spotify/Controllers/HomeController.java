package com.example.Spotify.Controllers;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Spotify.Models.Song;
import com.example.Spotify.Models.User;
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
	SongService songService;

	///////// login signup page//////////////

	@RequestMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model,
			@Valid @ModelAttribute("user") User user) {

		if (error != null) {
			model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
		}
		if (logout != null) {
			model.addAttribute("logoutMessage", "Logout Successful!");
		}
		return "LoginSignupPage.jsp";
	}

	@RequestMapping(value = { "/", "/home" })
	public String home(Principal principal, Model model) {
		// 1
		String username = principal.getName();
		User user = userService.findByName(username);
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

//	@GetMapping("/users")
//	public String UserTable() {
//		return "UserPage.jsp";
//	}

//	@GetMapping("/dash")
//	public String dashboard(Model model) {
//		List<Song> songs = songService.allSongs();
//		model.addAttribute("songs", songs);
//
//		return "dashboard.jsp";
//	}

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

//	@RequestMapping("/dashboard/join/{id}")
//	public String joinTeam(@PathVariable("id") Long id, HttpSession session, Model model) {
//
//		if (session.getAttribute("userId") == null) {
//			return "redirect:/logout";
//		}
//		Long userId = (Long) session.getAttribute("userId");
//
//		Song song = songService.findById(id);
//		User user = userService.findById(userId);
//
//		user.getSongs().add(song);
//		userService.updateUser(user);
//
//		model.addAttribute("user", userService.findById(userId));
//		model.addAttribute("unassignedProjects", songService.getUnassignedUsers(user));
//		model.addAttribute("assignedProjects", songService.getAssignedUsers(user));
//
//		return "redirect:/dashboard";
//	}

	@GetMapping("/users")
	public String UserTable(Model model, Principal principal) {
		String username = principal.getName();
		User user1 = userService.findByName(username);
		model.addAttribute("currUser", user1);
		return "UserPage.jsp";
	}

	@PostMapping("/users")
	public String users(@ModelAttribute("user") User user, Principal principal, Model model) {
		String username = principal.getName();
		User user1 = userService.findByName(username);
		model.addAttribute("currUser", user1);
		return "UserPage.jsp";
	}

}
