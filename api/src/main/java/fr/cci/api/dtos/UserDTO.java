package fr.cci.api.dtos;

import java.util.ArrayList;
import java.util.List;

public class UserDTO {

	private Long id;

	private String username;

	private String password;

	private List<RoleDTO> roles = new ArrayList<RoleDTO>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<RoleDTO> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleDTO> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", username=" + username + ", password=" + password + ", roles=" + roles + "]";
	}

}
