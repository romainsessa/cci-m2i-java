package fr.cci.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.cci.api.entities.ERole;

@Repository
public interface ERoleRepository extends JpaRepository<ERole, Long>{

}
