package fr.cci.front.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import fr.cci.front.model.User;
import fr.cci.front.service.UserService;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

	private UserService userService;

	public LoginController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/login")
	public String loginDisplay(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}

	@PostMapping("/login")
	public RedirectView loginSubmit(@ModelAttribute User user, HttpSession session) {
		if (userService.exist(user)) {
			session.setAttribute("user", user);
			return new RedirectView("/");
		} else {
			return new RedirectView("/login");
		}
	}

}