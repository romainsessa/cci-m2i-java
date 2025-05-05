package fr.cci.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.cci.api.payload.requests.IsValidRequestDTO;
import fr.cci.api.payload.requests.SaveUserDTO;
import fr.cci.api.payload.responses.GetUserResponseDTO;
import fr.cci.api.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/valid")
	public boolean isValid(@RequestBody IsValidRequestDTO user) {
		return userService.isValid(user);
	}
	
	@GetMapping
	public List<GetUserResponseDTO> get() {
		return userService.get();
	}

	@PostMapping
	public void save(@RequestBody SaveUserDTO user) {
		userService.save(user);
	}

}
