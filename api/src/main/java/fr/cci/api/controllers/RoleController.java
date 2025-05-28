package fr.cci.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.cci.api.dtos.RoleDTO;
import fr.cci.api.entities.ERole;
import fr.cci.api.repositories.ERoleRepository;
import fr.cci.api.service.RoleService;

@RestController
@RequestMapping("/api/role")
public class RoleController {

	private RoleService apiRoleService;
	private ERoleRepository eRoleRepository;

	public RoleController(ERoleRepository eRoleRepository, RoleService apiRoleService) {
		this.eRoleRepository = eRoleRepository;
		this.apiRoleService = apiRoleService;
	}

	@GetMapping
	public List<RoleDTO> get() {
		return apiRoleService.get();
	}

	@PostMapping
	public void save(@RequestBody ERole eRole) {
		eRoleRepository.save(eRole);
	}

	@DeleteMapping
	public void delete(@RequestBody ERole eRole) {
		eRoleRepository.delete(eRole);
	}

}
