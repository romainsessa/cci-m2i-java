package fr.cci.front.datalayer;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import fr.cci.front.model.User;

@Repository
public class UserProxy {
	
	public List<User> getUsers() {		
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<List<User>> response = 
				restTemplate.exchange(
						"http://localhost:8080/user", 
						HttpMethod.GET, 
						null,
						new ParameterizedTypeReference<List<User>>() {});
		
		return response.getBody();
	}
	
	public boolean isValid(User user) {		
		RestTemplate restTemplate = new RestTemplate();

		HttpEntity<User> request = new HttpEntity<User>(user);
		ResponseEntity<Boolean> response = 
				restTemplate.exchange(
						"http://localhost:8080/user/valid", 
						HttpMethod.POST, 
						request,
						Boolean.class);
		
		return response.getBody();
	}
	
	public void add(User user) {
		RestTemplate restTemplate = new RestTemplate();
		
		HttpEntity<User> request = new HttpEntity<User>(user);
		restTemplate.exchange(
					"http://localhost:8080/user", 
					HttpMethod.POST,
					request,
					Void.class);
	}
	
}