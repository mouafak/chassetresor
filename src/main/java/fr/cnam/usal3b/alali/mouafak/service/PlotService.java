package fr.cnam.usal3b.alali.mouafak.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.cnam.usal3b.alali.mouafak.model.Etape;
import fr.cnam.usal3b.alali.mouafak.model.Plot;

@Service
public interface PlotService extends ChasseTresorService<Plot> {

	List<Plot> getPlotsPourEtape(Etape etape);
}