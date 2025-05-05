package fr.cci.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.cci.api.entities.ECategory;

@Repository
public interface ECategoryRepository extends JpaRepository<ECategory, Long> {

}
