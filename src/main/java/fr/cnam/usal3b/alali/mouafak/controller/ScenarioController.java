package fr.cnam.usal3b.alali.mouafak.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.cnam.usal3b.alali.mouafak.form.ScenarioForm;
import fr.cnam.usal3b.alali.mouafak.model.Scenario;
import fr.cnam.usal3b.alali.mouafak.model.echange.ScenarioJson;
import fr.cnam.usal3b.alali.mouafak.repository.ScenarioRepository;
import fr.cnam.usal3b.alali.mouafak.service.EtapeService;
import fr.cnam.usal3b.alali.mouafak.service.ScenarioService;

@Controller
public class ScenarioController {

	@Autowired
	private ScenarioService scenarioService;
	@Autowired
	private EtapeService etapeService;
	@Autowired
	private ScenarioRepository scenarioRepository;

	// Injectez (inject) via application.properties.
	@Value("${welcome.message}")
	private String message;

	@Value("${error.message}")
	private String errorMessage;

	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public String index(Model model) {

		model.addAttribute("message", message);

		return "index";
	}

	@RequestMapping(value = { "/scenarioList" }, method = RequestMethod.GET)
	public String scenarioList(Model model) {

		Iterable<Scenario> scenariosDb = scenarioRepository.findAll();
		model.addAttribute("scenarios", scenariosDb);

		return "scenarioList";
	}

	@RequestMapping(value = { "/addScenario" }, method = RequestMethod.GET)
	public String showAddScenarioPage(Model model) {

		ScenarioForm scenarioForm = new ScenarioForm();
		String typeAction = "Créer";
		model.addAttribute("scenarioForm", scenarioForm);
		model.addAttribute("libelleAction", typeAction );

		return "addScenario";
	}

	@RequestMapping(value = { "/addScenario" }, method = RequestMethod.POST)
	public String saveScenario(Model model, @ModelAttribute("scenarioForm") ScenarioForm scenarioForm) {

		String titre = scenarioForm.getTitre();
		String description = scenarioForm.getDescription();
		String imageUrl = scenarioForm.getImageUrl();
		if (titre != null && titre.length() > 0 //
				&& description != null && description.length() > 0) {
			Scenario newScenario = new Scenario(titre, description, imageUrl);
			if(scenarioForm.getId() != null) {
				newScenario.setId(scenarioForm.getId());
			}
			scenarioService.sauvegarder(newScenario);

			return "redirect:/scenarioList";
		}

		model.addAttribute("errorMessage", errorMessage);
		return "addScenario";
	}

	@RequestMapping(value = { "/updatescenario/{id}" }, method = RequestMethod.GET)
	public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
		Optional<Scenario> scenario = scenarioRepository.findById(id);
		ScenarioForm scenarioForm = new ScenarioForm();
		String typeAction = "save";
		if (scenario.isPresent()) {
			scenarioForm.setId(scenario.get().getId());
			scenarioForm.setTitre(scenario.get().getTitre());
			scenarioForm.setDescription(scenario.get().getDescription());
			scenarioForm.setImageUrl(scenario.get().getImageUrl());
			model.addAttribute("etapes", etapeService.getEtapesPourScenario(scenario.get()));
			model.addAttribute("scenarioForm", scenarioForm);
			model.addAttribute("libelleAction", typeAction);
			return "addScenario";
		}
		return "addScenario";
	}
	
	
	@RequestMapping(value = { "/deletescenario/{id}" }, method = RequestMethod.GET)
	public String showDeleteForm(@PathVariable("id") Integer id, Model model) {
		Optional<Scenario> scenario = scenarioRepository.findById(id);
		ScenarioForm scenarioForm = new ScenarioForm();
		String typeAction = "Supprimer";
		if (scenario.isPresent()) {
			scenarioForm.setId(scenario.get().getId());
			scenarioForm.setTitre(scenario.get().getTitre());
			scenarioForm.setDescription(scenario.get().getDescription());
			scenarioForm.setImageUrl(scenario.get().getImageUrl());
			model.addAttribute("etapes", etapeService.getEtapesPourScenario(scenario.get()));
			model.addAttribute("scenarioForm", scenarioForm);
			model.addAttribute("libelleAction", typeAction);
			return "deletescenario";
		}
		return "deletescenario";
	}
	

	
	@RequestMapping(value = { "/deleteScenario" }, method = RequestMethod.POST)
	public String deleteScenario( @ModelAttribute("scenarioForm") ScenarioForm scenarioForm) {
		Integer id = scenarioForm.getId() ;
		if(id != null) {
			scenarioRepository.deleteById(id);
			return "redirect:/scenarioList";
			
		}
			return "deleteScenario";
	}

	
	// REST API 
	
	
	@RequestMapping(value = { "/scenarioListJson" }, method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<List<ScenarioJson>> scenarioListJson() {
	    HttpHeaders responseHeaders = new HttpHeaders();
	    responseHeaders.set("Access-Control-Allow-Origin", "*");
        List<ScenarioJson> listeScenarios = new ArrayList<ScenarioJson>();
        for (Scenario scenario : scenarioRepository.findAll()) {
//            System.out.println(scenario);
            listeScenarios.add(new ScenarioJson(scenario));
        }
        return new ResponseEntity<List<ScenarioJson>>(listeScenarios, responseHeaders, HttpStatus.FOUND);
    }
	
//	@RequestMapping(value = { "/scenarioJson/{id}" }, method = RequestMethod.GET)
 //   public @ResponseBody  ResponseEntity<ScenarioJson> scenarioJson(@PathVariable("id") Integer id) {
 //       Optional<Scenario> scenario = scenarioRepository.findById(id);
 //       if (scenario.isPresent())
 //           return ResponseEntity.ok(new ScenarioJson(scenario.get()));
//        else
//            return ResponseEntity.noContent().build();
//    }
	
}
	


