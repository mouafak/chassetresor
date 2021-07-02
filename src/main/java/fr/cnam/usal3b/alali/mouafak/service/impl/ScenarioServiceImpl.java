package fr.cnam.usal3b.alali.mouafak.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.cnam.usal3b.alali.mouafak.model.Scenario;
import fr.cnam.usal3b.alali.mouafak.repository.ScenarioRepository;
import fr.cnam.usal3b.alali.mouafak.service.ScenarioService;

@Service
public class ScenarioServiceImpl implements ScenarioService {
	@Autowired
	private ScenarioRepository scenarioRepository;
	
	@Override
	public boolean validerDonnees(Scenario aValider) {
		if (aValider.getTitre() == null || aValider.getTitre().trim().isEmpty())
			return false;
		else
			return true;
	}

	@Override
	public void sauvegarder(Scenario aSauvegarder) {
		scenarioRepository.save(aSauvegarder);

	}

	@Override
	public void supprimer(Scenario aSupprimer) {
		// TODO Auto-generated method stub

	}

	@Override
	public Scenario getUnObjet(Integer identifiant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Scenario> getTout() {
		List<Scenario> listeScenarios = new ArrayList<>();
		for (Scenario scenario : scenarioRepository.findAll()) {
			listeScenarios.add(scenario);
		}
		return listeScenarios;
	}

}
