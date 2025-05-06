package fr.cci.api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.cci.api.entities.ERole;
import fr.cci.api.repositories.ERoleRepository;

@SpringBootApplication
public class ApiApplication implements CommandLineRunner {
	
	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);		
	}
	
	private ERoleRepository eRoleRepository;

	public ApiApplication(ERoleRepository eRoleRepository) {
		this.eRoleRepository = eRoleRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		
		ERole role = new ERole();
		role.setName("USER");
		eRoleRepository.save(role);	
		
	}

}
