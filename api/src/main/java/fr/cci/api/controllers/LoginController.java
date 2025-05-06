package fr.cci.api.controllers;

import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.cci.api.payload.requests.LoginDTO;
import fr.cci.api.service.JwtService;
import fr.cci.api.service.UserService;

@RestController
public class LoginController {

	private UserService userService;
	private JwtService jwtService;

	public LoginController(UserService userService, JwtService jwtService) {
		this.userService = userService;
		this.jwtService = jwtService;
	}

	@PostMapping("/login")
	public String login(@RequestBody LoginDTO login) {
		String token = null;
		User user = userService.validate(login);
		if (user != null) {
			token = jwtService.generateToken(user);
		}
		return token;
	}

}
