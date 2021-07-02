package fr.cnam.usal3b.alali.mouafak.model.echange;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import fr.cnam.usal3b.alali.mouafak.model.Etape;
import fr.cnam.usal3b.alali.mouafak.model.Scenario;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "titre", "description", "imageUrl", "etapes" })
public class ScenarioJson {

	@JsonIgnore
	private Scenario scenario;
	@JsonProperty("etapes")
	private List<EtapeJson> etapes;

	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<>();

	public ScenarioJson() {
	}

	public ScenarioJson(Scenario scenario) {
		this.scenario = scenario;
	}
	
	@JsonProperty("id")
	public Integer getId() {
		return scenario.getId();
	}

	@JsonProperty("titre")
	public String getTitre() {
		return scenario.getTitre();
	}

	@JsonProperty("titre")
	public void setTitre(String titre) {
		scenario.setTitre(titre);
	}

	@JsonProperty("description")
	public String getDescription() {
		return scenario.getDescription();
	}

	@JsonProperty("description")
	public void setDescription(String description) {
		scenario.setDescription(description);
	}
	
	@JsonProperty("imageUrl")
	public String getImageUrl() {
		return scenario.getImageUrl();
	}

	@JsonProperty("description")
	public void setImageUrl(String imageUrl) {
		scenario.setImageUrl(imageUrl);
	}

	@JsonProperty("etapes")
	public List<EtapeJson> getEtapes() {
		etapes = new ArrayList<EtapeJson>();
		for (Etape etape : scenario.getEtapes()) {
			etapes.add(new EtapeJson(etape));
		}
		return etapes;
	}

	@JsonProperty("etapes")
	public void setEtapes(List<EtapeJson> etapes) {
		this.etapes = etapes;
	}
	


	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	@JsonIgnore
	public Scenario getScenario() {
		return scenario;
	}

	@JsonIgnore
	public void setScenario(Scenario scenario) {
		this.scenario = scenario;
	}
}