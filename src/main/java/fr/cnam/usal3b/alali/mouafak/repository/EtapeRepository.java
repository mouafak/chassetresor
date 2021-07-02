package fr.cnam.usal3b.alali.mouafak.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.cnam.usal3b.alali.mouafak.model.Etape;
import fr.cnam.usal3b.alali.mouafak.model.Scenario;


public interface EtapeRepository extends CrudRepository<Etape, Integer> {

	List<Etape> findByScenario(Scenario scenario);
}