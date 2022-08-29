package com.example.Spotify.Controllers;

import java.io.File;
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
import com.example.Spotify.Models.Playlist_song;
import com.example.Spotify.Models.Song;
import com.example.Spotify.Models.User;
import com.example.Spotify.Services.PlaylistService;
import com.example.Spotify.Services.Playlist_songService;
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
	
	@Autowired
	private Playlist_songService play_songService;

	private Authentication auth = null;
	private MediUser mediUser = null;
	private User CurrentUser = null;

	///////// login signup page//////////////
	// if user is logged in (principle != null) then route to dashboard ("/")

	@RequestMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model,
			@Valid @ModelAttribute("user") User user, Principal principal) {

			if (error != null) {
				model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
			}
			if (logout != null) {
				model.addAttribute("logoutMessage", "Logout Successful!");
			}
			return "LoginSignupPage.jsp";
	}

	// after logging in then set auth ,mediUser and CurrentUser
	@RequestMapping(value = { "/", "/home" })
	public String home(Principal principal, Model model) {
		// 1
		if (principal != null) {
			auth = SecurityContextHolder.getContext().getAuthentication();
			mediUser = (MediUser) auth.getPrincipal();

			String email = mediUser.getEmail();
			CurrentUser = userService.findByEmail(email);

			model.addAttribute("currUser", CurrentUser);
			if (CurrentUser != null) {
				CurrentUser.setLastLogin(new Date());
				userService.updateUser(CurrentUser);
	        }
			
	        //to create song cards
	        List<Song> songs = songService.allSongs();
	        model.addAttribute("songs", songs);
	        
	        //to get playlist choices in song cards
	        List<Playlist> playlists = playlistService.findAllUsersPlaylists(CurrentUser.getId());
	        model.addAttribute("playlists",playlists);
	        
	        return "dashboard.jsp";
		}else {
			return "redirect:/login";
		}

    }
   ////////////////// regestration/////////////////

   @PostMapping("/registration")
    public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
       userValidator.validate(user, result);
        if (result.hasErrors()) {
            return "LoginSignupPage.jsp";
        }
		if(userService.allUsers().size() > 0) {
			userService.regesterUser(user);
		}else {
			userService.regesterAdmin(user);
		}
        return "redirect:/";
    }
   
   ///////////create new song//////////

   @GetMapping("/songs/new")
    public String NewProduct(@ModelAttribute("addSongForm") Song song) {
        return "addSong.jsp";
   }

   @PostMapping("/songs/new")
    public String createNewSong(@Valid @ModelAttribute("addSongForm") Song song,@RequestParam("img") String img, BindingResult result) {
       
	   System.out.println(img); 
       File newFolder = new File("/images/Songs_images/"+song.getTitle()+"-by-"+song.getArtist());
       File f = new File("/images/Songs_images");
       Boolean createFolder = newFolder.mkdirs();
       System.out.println(newFolder);
       
       System.out.println(f.canWrite());
       if(createFolder) {
    	   File imageFile = new File(newFolder+"/"+img);
    	   System.out.println("hiiiiiiiiiii");
       }else {
    	   System.out.println("error with img file");
       }
       
	   if (result.hasErrors()) {
            return "addSong.jsp";
        } else {
            songService.createSong(song);
            return "redirect:/";
        }
    }
   
   /////////////////song page/////////////////
   
   @GetMapping("/songs/{id}")
    public String songData(@PathVariable("id") Long id, Model model) {
       Song song = songService.findById(id);
        model.addAttribute("currSong", song);
        
        List<Object[]> users = userService.findAllUserForSong(song.getId());
        model.addAttribute("users",users);
        
        return "SongPage.jsp";
    }

    ////////////////view playlist////////////////
    
    //playlists of current user
    @GetMapping("/playlists")
    public String playlists(Model model) {

       Long userId = CurrentUser.getId();
        model.addAttribute("playlists", playlistService.findAllUsersPlaylists(userId));
        return "Playlist.jsp";
    }
    
    //playlists of user based on id
    @GetMapping("/playlists/{id}")
    public String PlaylistsOfUserId(@PathVariable("id") Long id, Model model) {
    	model.addAttribute("playlists", playlistService.findAllUsersPlaylists(id));
    	return "Playlist.jsp";
    }

    /////////////Add playlist////////////////
    
    //create new playlist to current user
    @GetMapping("/playlists/new")
    public String addPlaylist(@ModelAttribute("playlist") Playlist playlist) {
        return "addPlayList.jsp";
    }

   @PostMapping("/playlists/new")
    public String addPlaylist(@Valid @ModelAttribute("playlist") Playlist playlist
    		, BindingResult result) {
        
	   if (result.hasErrors()) {
            return "addPlayList.jsp";
        } else {
            userService.addPlaylist(CurrentUser, playlist);
            return "redirect:/playlists";
        }
    }
   
   //////////////add song to playlist of current user/////////////////
   
   @GetMapping("/playlist/addSong")
   public String addSongToPlaylist(@RequestParam("songId") Long songId 
		   ,@RequestParam("playlistId") Long playlistId) {

	   playlistService.AddSongToPlaylist(playlistId,songId);
	   return "redirect:/";
   }
    
    ////////////user playlist page ////////////
    
    @GetMapping("/playlist/{playId}")
    public String playlistData(@PathVariable("playId") Long playId, Model model) {
    	
    	Playlist playlist = playlistService.findById(playId);
        model.addAttribute("currPlaylist", playlist);

    	if(CurrentUser.getPlaylist().contains(playlist)) {
        	model.addAttribute("User", CurrentUser);
    	}else {
    		model.addAttribute("User", userService.findByPlaylistId(playId));
    	}
        
        List<Playlist_song> play_song = play_songService.findSongsInPlaylist(playId);
        model.addAttribute("play_song",play_song);

		return "UserPage.jsp";
	}

	@RequestMapping("/playlist/{id}/delete")
	public String delete(@PathVariable("id") Long id) {
		playlistService.deletePlaylist(id);
		return "redirect:/playlists";
	}
}