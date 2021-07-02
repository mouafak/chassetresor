package fr.cnam.usal3b.alali.mouafak.service;

import java.util.List;

import fr.cnam.usal3b.alali.mouafak.model.Brique;
import fr.cnam.usal3b.alali.mouafak.model.Plot;

public interface BriqueService<T extends Brique> extends ChasseTresorService<T> {

	List<T> getBriquesPourPlot(Plot plot);
}
