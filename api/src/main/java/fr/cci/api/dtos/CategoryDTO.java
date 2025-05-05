package fr.cci.api.dtos;

import java.util.ArrayList;
import java.util.List;

public class CategoryDTO {

	private Long id;
	private String name;
	private List<UserDTO> users = new ArrayList<UserDTO>();

	public CategoryDTO() {
	}

	public CategoryDTO(Long id, String nom, List<UserDTO> users) {
		this.id = id;
		this.name = nom;
		this.users = users;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<UserDTO> getUsers() {
		return users;
	}

	public void setUsers(List<UserDTO> users) {
		this.users = users;
	}

}
