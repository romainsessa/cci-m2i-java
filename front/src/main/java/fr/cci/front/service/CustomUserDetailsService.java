package fr.cci.front.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import fr.cci.front.datalayer.UserProxy;
import fr.cci.front.model.User;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	private UserProxy userProxy;
	
	public CustomUserDetailsService(UserProxy userProxy) {
		this.userProxy = userProxy;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = this.userProxy.getUsers().stream()
			.filter( u -> u.getUsername().equals(username))
			.findFirst();
		if(user == null || user.isEmpty()) {
			throw new UsernameNotFoundException(username);
		}
		
		return 
				new org.springframework.security.core.userdetails.User(
						user.get().getUsername(),
						new BCryptPasswordEncoder().encode("password"),
						getGrantedAuthorities(user.get().getRoles()));
	}
	
	private List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		roles.forEach(role -> {
			authorities.add(new SimpleGrantedAuthority("ROLE_"+ role));
		});
		return authorities;
	}

}
