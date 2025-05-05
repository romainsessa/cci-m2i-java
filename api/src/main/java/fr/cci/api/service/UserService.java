package fr.cci.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import fr.cci.api.entities.EUser;
import fr.cci.api.payload.requests.IsValidRequestDTO;
import fr.cci.api.payload.requests.SaveUserDTO;
import fr.cci.api.payload.responses.GetUserResponseDTO;
import fr.cci.api.repositories.EUserRepository;

@Service
public class UserService {

	private EUserRepository eUserRepository;

	public UserService(EUserRepository eUserRepository) {
		this.eUserRepository = eUserRepository;
	}
	
	public void save(SaveUserDTO user) {
		
		EUser entityUser = new EUser();
		entityUser.setUsername(user.getUsername());
		entityUser.setPassword(user.getPassword());
		
		eUserRepository.save(entityUser);
	}
	
	public List<GetUserResponseDTO> get() {		
		List<EUser> entityUsers = eUserRepository.findAll();
		List<GetUserResponseDTO> dtoUsers = new ArrayList<GetUserResponseDTO>();
		
		entityUsers.forEach((entity) -> {			
			GetUserResponseDTO dto = new GetUserResponseDTO();
			dto.setId(entity.getId());
			dto.setUsername(entity.getUsername());
			dto.setCategory(entity.getCategory().getName());
			List<String> roles = new ArrayList<String>();
			entity.getRoles().forEach((role) -> {
				roles.add(role.getName());
			});
			dto.setRoles(roles);
			dtoUsers.add(dto);
		});
		return dtoUsers;		
	}

	public boolean isValid(IsValidRequestDTO user) {
		return eUserRepository.findAll().stream().anyMatch(
				(u) -> 
					u.getUsername().equals(user.getUsername()) 
					&& u.getPassword().equals(user.getPassword())
				);
	}
	
}
