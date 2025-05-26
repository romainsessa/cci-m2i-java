package fr.cci.api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.cci.api.entities.ECategory;
import fr.cci.api.entities.ERole;
import fr.cci.api.repositories.ECategoryRepository;
import fr.cci.api.repositories.ERoleRepository;

@SpringBootApplication
public class ApiApplication implements CommandLineRunner {
	
	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);		
	}
	
	private ERoleRepository eRoleRepository;
	private ECategoryRepository eCategoryRepository;
	
	public ApiApplication(
			final ERoleRepository eRoleRepository, 
			final ECategoryRepository eCategoryRepository) {
		this.eRoleRepository = eRoleRepository;
		this.eCategoryRepository = eCategoryRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		
		ERole roleUser = new ERole();
		roleUser.setName("USER");
		eRoleRepository.save(roleUser);
		
		ECategory category = new ECategory();
		category.setName("CategoryTest");
		eCategoryRepository.save(category);
		
	}

}
