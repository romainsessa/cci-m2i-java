package fr.cci.front.service;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import fr.cci.front.datalayer.UserProxy;
import fr.cci.front.model.UserModel;

@Service
public class UserService {
	
	private PasswordEncoder passwordEncoder;

	private UserProxy userProxy;
	
	public UserService(
			PasswordEncoder passwordEncoder, 
			UserProxy userProxy) {
		this.passwordEncoder = passwordEncoder;
		this.userProxy = userProxy;
	}
	
	public List<UserModel> get() {
		return userProxy.getUsers();
	}

	public void add(UserModel user) {
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		
		userProxy.add(user);		
	}
}