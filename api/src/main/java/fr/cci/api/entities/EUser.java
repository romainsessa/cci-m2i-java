package fr.cci.api.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "USERS")
public class EUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String username;

	private String password;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<ERole> roles = new ArrayList<ERole>();

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
	
	public List<ERole> getRoles() {
		return roles;
	}
	
	public void addRole(ERole role) {
		this.roles.add(role);
	}
	
	public void removeRole(ERole role) {
		this.roles.remove(role);
	}
}
