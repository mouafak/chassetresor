package fr.cnam.usal3b.alali.mouafak.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.cnam.usal3b.alali.mouafak.form.BriqueForm;
import fr.cnam.usal3b.alali.mouafak.model.Brique;
import fr.cnam.usal3b.alali.mouafak.model.BriqueTexte;
import fr.cnam.usal3b.alali.mouafak.model.Plot;
import fr.cnam.usal3b.alali.mouafak.repository.PlotRepository;
import fr.cnam.usal3b.alali.mouafak.service.BriqueService;
import fr.cnam.usal3b.alali.mouafak.service.CommonBriqueService;

@Controller
public class BriqueController {

	@Autowired
	private PlotRepository plotRepository;

	@Autowired
	private CommonBriqueService commonBriqueService;

	@Autowired
	@Qualifier("briqueTexteServiceImpl")
	private BriqueService<BriqueTexte> briqueTexteService;

	// Injectez (inject) via application.properties.
	@Value("${welcome.message}")
	private String message;

	@Value("${error.message}")
	private String errorMessage;

	@RequestMapping(value = { "/briqueList" }, method = RequestMethod.GET)
	public String briqueList(Model model) {

		Iterable<? extends Brique> briquesDb = commonBriqueService.getAllBriques();
		model.addAttribute("briques", briquesDb);

		return "briqueList";
	}

	@RequestMapping(value = { "/addBrique" }, method = RequestMethod.GET)
	public String showAddBriquePage(Model model) {

		BriqueForm briqueForm = new BriqueForm();
		model.addAttribute("briqueForm", briqueForm);
		model.addAttribute("plots", plotRepository.findAll());

		return "addBrique";
	}

	@RequestMapping(value = { "/addBrique" }, method = RequestMethod.POST)
	public String saveBrique(Model model, @ModelAttribute("briqueForm") BriqueForm briqueForm) {

		String titre = briqueForm.getTitre();
		String description = briqueForm.getDescription();
		Optional<Plot> plot = plotRepository.findById(briqueForm.getPlotId());

		if (plot.isPresent() && titre != null && titre.length() > 0 //
				&& description != null && description.length() > 0) {
			switch (briqueForm.getTypeBrique()) {
			case TEXTE:
				BriqueTexte newBrique = new BriqueTexte();
				newBrique.setTitre(titre);
				newBrique.setDescription(description);
				newBrique.setPlot(plot.get());
				briqueTexteService.sauvegarder(newBrique);
				break;
			default:
				break;
			}
			return "redirect:/briqueList";
		}

		model.addAttribute("errorMessage", errorMessage);
		return "addBrique";
	}

}
