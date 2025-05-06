package fr.cci.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import fr.cci.api.entities.ERole;
import fr.cci.api.entities.EUser;
import fr.cci.api.payload.requests.LoginDTO;
import fr.cci.api.payload.requests.SaveUserDTO;
import fr.cci.api.payload.responses.GetUserByUsernameResponseDTO;
import fr.cci.api.payload.responses.GetUserResponseDTO;
import fr.cci.api.repositories.ERoleRepository;
import fr.cci.api.repositories.EUserRepository;

@Service
public class UserService {

	private PasswordEncoder passwordEncoder;
	private EUserRepository eUserRepository;
	private ERoleRepository eRoleRepository;

	public UserService(PasswordEncoder passwordEncoder, EUserRepository eUserRepository,
			ERoleRepository eRoleRepository) {
		this.passwordEncoder = passwordEncoder;
		this.eUserRepository = eUserRepository;
		this.eRoleRepository = eRoleRepository;
	}

	public void save(SaveUserDTO user) {

		ERole defaultRole = eRoleRepository.findByName("USER");

		EUser entityUser = new EUser();
		entityUser.setUsername(user.getUsername());
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		entityUser.setPassword(encodedPassword);
		entityUser.addRole(defaultRole);

		eUserRepository.save(entityUser);
	}

	public List<GetUserResponseDTO> get() {
		List<EUser> entityUsers = eUserRepository.findAll();
		List<GetUserResponseDTO> dtoUsers = new ArrayList<GetUserResponseDTO>();

		entityUsers.forEach((entity) -> {
			GetUserResponseDTO dto = new GetUserResponseDTO();
			dto.setId(entity.getId());
			dto.setUsername(entity.getUsername());
			if (entity.getCategory() != null) {
				dto.setCategory(entity.getCategory().getName());
			}
			List<String> roles = new ArrayList<String>();
			entity.getRoles().forEach((role) -> {
				roles.add(role.getName());
			});
			dto.setRoles(roles);
			dtoUsers.add(dto);
		});
		return dtoUsers;
	}

	public GetUserByUsernameResponseDTO getByUsername(String username) {
		EUser entity = eUserRepository.findByUsername(username);

		GetUserByUsernameResponseDTO dto = new GetUserByUsernameResponseDTO();
		dto.setId(entity.getId());
		dto.setUsername(entity.getUsername());
		dto.setPassword(entity.getPassword());

		List<String> roles = new ArrayList<String>();
		entity.getRoles().forEach((role) -> {
			roles.add(role.getName());
		});
		dto.setRoles(roles);

		return dto;
	}

	public User validate(LoginDTO loginDto) {
		EUser entity = eUserRepository.findByUsername(loginDto.getUsername());
		if (entity != null && passwordEncoder.matches(loginDto.getPassword(), entity.getPassword())) {
			return new User(entity.getUsername(), entity.getPassword(), getGrantedAuthorities(entity.getRoles()));
		}
		return null;
	}

	private List<GrantedAuthority> getGrantedAuthorities(List<ERole> roles) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		roles.forEach(role -> {
			authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
		});
		return authorities;
	}

}