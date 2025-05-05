package fr.cci.front.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.cci.front.datalayer.UserProxy;
import fr.cci.front.model.User;

@Service
public class UserService {
	
	private UserProxy userProxy;
	
	public UserService(UserProxy userProxy) {
		this.userProxy = userProxy;
	}
	
	public boolean exist(User user) {
		return userProxy.isValid(user);
	}
	
	public List<User> get() {
		return userProxy.getUsers();
	}

	public void add(User user) {
		userProxy.add(user);		
	}


}