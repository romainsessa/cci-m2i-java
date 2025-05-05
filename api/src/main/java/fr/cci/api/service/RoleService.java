package fr.cci.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import fr.cci.api.dtos.RoleDTO;
import fr.cci.api.dtos.UserDTO;
import fr.cci.api.entities.ERole;
import fr.cci.api.repositories.ERoleRepository;

@Service
public class RoleService {

	private ERoleRepository eRoleRepository;

	public RoleService(ERoleRepository eRoleRepository) {
		this.eRoleRepository = eRoleRepository;
	}

	public List<RoleDTO> get() {
		List<ERole> entityRoles = eRoleRepository.findAll();
		List<RoleDTO> dtoRoles = new ArrayList<RoleDTO>();

		entityRoles.forEach((entity) -> {
			RoleDTO roleDTO = new RoleDTO();
			roleDTO.setId(entity.getId());
			roleDTO.setName(entity.getName());

			List<UserDTO> users = new ArrayList<UserDTO>();
			entity.getUsers().forEach((user) -> {
				UserDTO userDTO = new UserDTO();
				userDTO.setId(user.getId());
				userDTO.setUsername(user.getUsername());
				userDTO.setPassword(user.getPassword());
				users.add(userDTO);
			});
			roleDTO.setUsers(users);
			dtoRoles.add(roleDTO);
		});
		return dtoRoles;
	}

}
