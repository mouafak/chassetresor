package fr.cnam.usal3b.alali.mouafak.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.cnam.usal3b.alali.mouafak.model.Etape;
import fr.cnam.usal3b.alali.mouafak.model.Plot;
import fr.cnam.usal3b.alali.mouafak.repository.PlotRepository;
import fr.cnam.usal3b.alali.mouafak.service.PlotService;

@Service
public class PlotServiceImpl implements PlotService {
	@Autowired
	private PlotRepository plotRepository;

	@Override
	public boolean validerDonnees(Plot aValider) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void sauvegarder(Plot aSauvegarder) {
		// TODO Auto-generated method stub

	}

	@Override
	public void supprimer(Plot aSupprimer) {
		// TODO Auto-generated method stub

	}

	@Override
	public Plot getUnObjet(Integer identifiant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Plot> getTout() {
		List<Plot> listePlots = new ArrayList<>();
		for (Plot etape : plotRepository.findAll()) {
			listePlots.add(etape);
		}
		return listePlots;
	}

	@Override
	public List<Plot> getPlotsPourEtape(Etape etape) {
		List<Plot> listePlots = new ArrayList<>();
		for (Plot plot : plotRepository.findByEtape(etape)) {
			listePlots.add(plot);
		}
		return listePlots;
	}

}