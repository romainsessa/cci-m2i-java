package fr.cci.front.datalayer;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import fr.cci.front.model.UserModel;

@Repository
public class UserProxy {
	
	private final String baseApiUrl = "http://localhost:8080";
	private RestTemplate restTemplate = new RestTemplate();

	public List<UserModel> getUsers() {		

		ResponseEntity<List<UserModel>> response = 
				restTemplate.exchange(
						baseApiUrl + "/user", 
						HttpMethod.GET, 
						null,
						new ParameterizedTypeReference<List<UserModel>>() {});
		
		return response.getBody();
	}
	
	public void add(UserModel user) {
		
		HttpEntity<UserModel> request = new HttpEntity<UserModel>(user);
		restTemplate.exchange(
					baseApiUrl + "/user", 
					HttpMethod.POST,
					request,
					Void.class);
	}

	public UserModel getUserByUsername(String username) {
		
		ResponseEntity<UserModel> response = restTemplate.exchange(
				baseApiUrl + "/user/" + username,
				HttpMethod.GET,
				null,
				UserModel.class
				);
		
		return response.getBody();
	}
	
}