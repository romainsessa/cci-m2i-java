package fr.cci.front.configuration;

import org.springframework.stereotype.Component;

@Component
public class TokenContext {

	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
}
