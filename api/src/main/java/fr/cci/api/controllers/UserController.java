package fr.cci.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.cci.api.dtos.UserDTO;
import fr.cci.api.entities.EUser;
import fr.cci.api.repositories.EUserRepository;
import fr.cci.api.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	private UserService userService;
	private EUserRepository eUserRepository;

	public UserController(UserService userService, EUserRepository eUserRepository) {
		this.userService = userService;
		this.eUserRepository = eUserRepository;
	}

	@PostMapping("/valid")
	public Boolean isValid(@RequestBody UserDTO user) {
		return userService.isValid(user);
	}
	
	@GetMapping
	public List<UserDTO> get() {
		return userService.get();
	}

	@PostMapping
	public void save(@RequestBody EUser user) {
		eUserRepository.save(user);
	}

}
