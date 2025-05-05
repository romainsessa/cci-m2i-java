package fr.cci.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import fr.cci.api.dtos.RoleDTO;
import fr.cci.api.dtos.UserDTO;
import fr.cci.api.entities.EUser;
import fr.cci.api.repositories.EUserRepository;

@Service
public class UserService {

	private EUserRepository eUserRepository;

	public UserService(EUserRepository eUserRepository) {
		this.eUserRepository = eUserRepository;
	}
	
	public List<UserDTO> get() {		
		List<EUser> entityUsers = eUserRepository.findAll();
		List<UserDTO> dtoUsers = new ArrayList<UserDTO>();
		
		entityUsers.forEach((entity) -> {			
			UserDTO dto = new UserDTO();
			dto.setId(entity.getId());
			dto.setUsername(entity.getUsername());
			
			List<RoleDTO> roles = new ArrayList<RoleDTO>();
			entity.getRoles().forEach((role) -> {
				RoleDTO roleDTO = new RoleDTO();
				roleDTO.setId(role.getId());
				roleDTO.setName(role.getName());
				roles.add(roleDTO);
			});
			dto.setRoles(roles);
			dtoUsers.add(dto);
		});
		return dtoUsers;		
	}

	public boolean isValid(UserDTO user) {
		return eUserRepository.findAll().stream().anyMatch(
				(u) -> 
					u.getUsername().equals(user.getUsername()) 
					&& u.getPassword().equals(user.getPassword())
				);
	}
	
}
