package fr.cnam.usal3b.alali.mouafak.service.impl;

import fr.cnam.usal3b.alali.mouafak.model.Brique;
import fr.cnam.usal3b.alali.mouafak.service.BriqueService;

public abstract class AbstractBriqueServiceImpl<T extends Brique> implements BriqueService<T> {
	@Override
	public boolean validerDonnees(T aValider) {
		if (aValider.getTitre() == null || aValider.getTitre().trim().isEmpty())
			return false;
		else
			return true;
	}
	
	protected abstract boolean validerCompletion();
}
