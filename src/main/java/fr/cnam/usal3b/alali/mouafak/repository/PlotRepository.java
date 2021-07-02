package fr.cnam.usal3b.alali.mouafak.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.cnam.usal3b.alali.mouafak.model.Etape;
import fr.cnam.usal3b.alali.mouafak.model.Plot;

public interface PlotRepository extends CrudRepository<Plot, Integer> {
	
	List<Plot> findByEtape(Etape etape);
}