package fr.cnam.usal3b.alali.mouafak.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.cnam.usal3b.alali.mouafak.form.PlotForm;
import fr.cnam.usal3b.alali.mouafak.model.Etape;
import fr.cnam.usal3b.alali.mouafak.model.Plot;
import fr.cnam.usal3b.alali.mouafak.model.TypePlotEnum;
import fr.cnam.usal3b.alali.mouafak.repository.EtapeRepository;
import fr.cnam.usal3b.alali.mouafak.repository.PlotRepository;
//import fr.cnam.usal3b.alali.mouafak.service.BriqueService;

@Controller
public class PlotController {

	@Autowired
	private PlotRepository plotRepository;

	@Autowired
	private EtapeRepository etapeRepository;
	
//	@Autowired
//	private BriqueService briqueService;
	
	// Injectez (inject) via application.properties.
	@Value("${welcome.message}")
	private String message;

	@Value("${error.message}")
	private String errorMessage;


	@RequestMapping(value = { "/plotList" }, method = RequestMethod.GET)
	public String plotList(Model model) {

		Iterable<Plot> plotsDb = plotRepository.findAll();
		model.addAttribute("plots", plotsDb);

		return "plotList";
	}

	@RequestMapping(value = { "/addPlot" }, method = RequestMethod.GET)
	public String showAddPlotPage(Model model) {

		PlotForm plotForm = new PlotForm();
		model.addAttribute("plotForm", plotForm);
		Iterable<Etape> listeEtapes = etapeRepository.findAll();
		model.addAttribute("etapes", listeEtapes);
 
		return "addPlot";
	}

	@RequestMapping(value = { "/addPlot" }, method = RequestMethod.POST)
	public String savePlot(Model model, @ModelAttribute("plotForm") PlotForm plotForm) {

		String titre = plotForm.getTitre();
		String description = plotForm.getDescription();
		TypePlotEnum typePlot = plotForm.getTypePlot();

		Optional<Etape> etape = etapeRepository.findById(plotForm.getEtapeId());
		if (etape.isPresent() && titre != null && titre.length() > 0 //
				&& description != null && description.length() > 0 
				&& typePlot != null ) {
			Plot newPlot = new Plot(titre, description);
			newPlot.setTypePlot(typePlot);
			newPlot.setEtape(etape.get());
			
			if(plotForm.getId() != null) {
				newPlot.setId(plotForm.getId());
			}
			
			plotRepository.save(newPlot);
 
			return "redirect:/plotList";
		}

		model.addAttribute("errorMessage", errorMessage);
		return "addPlot";
	}
	
	@RequestMapping(value = { "/updateplot/{id}" }, method = RequestMethod.GET)
	public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
		Optional<Plot> plot = plotRepository.findById(id);
		Iterable<Etape> listeEtapes = etapeRepository.findAll();
		String typeAction = "Modifier";
		PlotForm plotForm = new PlotForm();
		if (plot.isPresent()) {
			plotForm.setId(plot.get().getId());
			plotForm.setTitre(plot.get().getTitre());
			plotForm.setDescription(plot.get().getDescription());
			plotForm.setTypePlot(plot.get().getTypePlot());
			plotForm.setEtapeId(plot.get().getEtape().getId());
//			model.addAttribute("briques", briqueService.getBriquesPourPlot(plot.get()));
			model.addAttribute("plotForm", plotForm);
			model.addAttribute("libelleAction",typeAction );
			model.addAttribute("etapes", listeEtapes);
			return "addPlot";
		}
		return "addPlot";
	}


}
