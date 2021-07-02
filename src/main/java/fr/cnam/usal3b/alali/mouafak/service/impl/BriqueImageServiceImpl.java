package fr.cnam.usal3b.alali.mouafak.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.cnam.usal3b.alali.mouafak.model.BriqueTexte;
import fr.cnam.usal3b.alali.mouafak.model.Plot;
import fr.cnam.usal3b.alali.mouafak.repository.BriqueTexteRepository;

@Service
public class BriqueImageServiceImpl extends AbstractBriqueServiceImpl<BriqueTexte> {
	@Autowired
	private BriqueTexteRepository briqueTexteRepository;

	@Override
	public List<BriqueTexte> getTout() {
		List<BriqueTexte> listeBriques = new ArrayList<>();
		for (BriqueTexte briqueTexte : briqueTexteRepository.findAll()) {
			listeBriques.add(briqueTexte);
		}
		return listeBriques;
	}

	@Override
	public boolean validerDonnees(BriqueTexte aValider) {
		if (super.validerDonnees(aValider) && aValider.getContenuHtml() != null && !aValider.getContenuHtml().isEmpty())
			return true;
		else
			return false;
	}

	@Override
	public void sauvegarder(BriqueTexte aSauvegarder) {
		briqueTexteRepository.save(aSauvegarder);

	}

	@Override
	public void supprimer(BriqueTexte aSupprimer) {
		// TODO Auto-generated method stub

	}

	@Override
	public BriqueTexte getUnObjet(Integer identifiant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BriqueTexte> getBriquesPourPlot(Plot plot) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean validerCompletion() {
		// TODO Auto-generated method stub
		return false;
	}

}
