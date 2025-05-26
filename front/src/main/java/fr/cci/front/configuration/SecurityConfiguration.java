//package fr.cci.front.configuration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@EnableWebSecurity
//@EnableMethodSecurity(jsr250Enabled = true)
//@Configuration
//public class SecurityConfiguration {
//
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) 
//			throws Exception {
//		
//		return http.authorizeHttpRequests(
//				auth -> 
//					auth
//					.requestMatchers("/register").permitAll()
//					.anyRequest().authenticated()
//				)
//				.formLogin(Customizer.withDefaults())
//				.build();
//	}
//	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//	
//}
