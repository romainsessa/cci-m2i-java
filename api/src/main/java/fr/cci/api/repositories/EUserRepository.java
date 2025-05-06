package fr.cci.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.cci.api.entities.EUser;

@Repository
public interface EUserRepository extends JpaRepository<EUser, Long>{
	
	public EUser findByUsername(String username);
	
}
