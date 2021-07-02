package fr.cnam.usal3b.alali.mouafak.service;

import java.util.List;

import fr.cnam.usal3b.alali.mouafak.model.Etape;
import fr.cnam.usal3b.alali.mouafak.model.Scenario;

public interface EtapeService extends ChasseTresorService<Etape> {

	List<Etape> getEtapesPourScenario(Scenario scenario);

}
