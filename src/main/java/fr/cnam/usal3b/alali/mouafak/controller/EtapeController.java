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

import fr.cnam.usal3b.alali.mouafak.form.EtapeForm;
import fr.cnam.usal3b.alali.mouafak.model.Etape;
import fr.cnam.usal3b.alali.mouafak.model.Scenario;
import fr.cnam.usal3b.alali.mouafak.repository.EtapeRepository;
import fr.cnam.usal3b.alali.mouafak.repository.ScenarioRepository;
import fr.cnam.usal3b.alali.mouafak.service.PlotService;

@Controller
public class EtapeController {

	@Autowired
	private EtapeRepository etapeRepository;

	@Autowired
	private ScenarioRepository scenarioRepository;

	@Value("${welcome.message}")
	private String message;
	
	@Autowired
	private PlotService plotService;

	@Value("${error.message}")
	private String errorMessage;

	@RequestMapping(value = { "/etapeList" }, method = RequestMethod.GET)
	public String etapeList(Model model) {
		Iterable<Etape> etapesDb = etapeRepository.findAll();
		model.addAttribute("etapes", etapesDb);

		return "etapeList";
	}

	@RequestMapping(value = { "/addEtape" }, method = RequestMethod.GET)
	public String showAddEtapePage(Model model) {

		EtapeForm etapeForm = new EtapeForm();
		model.addAttribute("etapeForm", etapeForm);
		Iterable<Scenario> listeScenarios = scenarioRepository.findAll();
		model.addAttribute("scenarios", listeScenarios);

		return "addEtape";
	}

	@RequestMapping(value = { "/addEtape" }, method = RequestMethod.POST)
	public String saveEtape(Model model, @ModelAttribute("etapeForm") EtapeForm etapeForm) {

		String titre = etapeForm.getTitre();
		String description = etapeForm.getDescription();
		Optional<Scenario> scenario = scenarioRepository.findById(etapeForm.getScenarioId());
		if (scenario.isPresent() && titre != null && titre.length() > 0 // TODO si vous vous ennuyez : chercher @Valid
				&& description != null && description.length() > 0) {
			Etape newEtape = new Etape(titre, description);
			newEtape.setScenario(scenario.get());
			
			if(etapeForm.getId() != null) {
				newEtape.setId(etapeForm.getId());
			}
			
			etapeRepository.save(newEtape);

			return "redirect:/etapeList";
		}

		model.addAttribute("errorMessage", errorMessage);
		return "addEtape";
	}
	
	@RequestMapping(value = { "/updateetape/{id}" }, method = RequestMethod.GET)
	public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
		String typeAction = "Modifier" ;
		Optional<Etape> etape = etapeRepository.findById(id);
		Iterable<Scenario> listeScenarios = scenarioRepository.findAll();
		EtapeForm etapeForm = new EtapeForm();
		if (etape.isPresent()) {
			etapeForm.setId(etape.get().getId());
			etapeForm.setTitre(etape.get().getTitre());
			etapeForm.setDescription(etape.get().getDescription());
			if(etape.get().getScenario().getId() != null) {
//				etapeForm.setScenarioId(1);
				etapeForm.setScenarioId(etape.get().getScenario().getId());
			}
			model.addAttribute("plots", plotService.getPlotsPourEtape(etape.get()));
			model.addAttribute("etapeForm", etapeForm);
			model.addAttribute("scenarios", listeScenarios);
			model.addAttribute("typeAction", typeAction);
			return "addEtape";
		}
		return "addEtape";
	}

}
