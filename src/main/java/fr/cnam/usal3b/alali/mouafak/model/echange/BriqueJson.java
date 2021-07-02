package fr.cnam.usal3b.alali.mouafak.model.echange;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import fr.cnam.usal3b.alali.mouafak.model.Brique;
import fr.cnam.usal3b.alali.mouafak.model.TypeBriqueEnum;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"id" ,"titre", "description" , "typePlot" })
public class BriqueJson {

	@JsonIgnore
	private Brique brique;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<>();

	public BriqueJson() {
	}

	public BriqueJson(Brique brique) {
		this.brique = brique;
	}
	
	@JsonProperty("id")
	public Integer getId() {
		return brique.getId();
	}


	@JsonProperty("id")
	public void setId(Integer id) {
		brique.setId(id);
	}

	@JsonProperty("titre")
	public String getTitre() {
		return brique.getTitre();
	}

	@JsonProperty("titre")
	public void setTitre(String titre) {
		brique.setTitre(titre);
	}

	@JsonProperty("description")
	public String getDescription() {
		return brique.getDescription();
	}
	
	@JsonProperty("description")
	public void setDescription(String description) {
		brique.setDescription(description);
	}

	
	@JsonProperty("typeBrique")
	public TypeBriqueEnum getTypeBrique() {
		return brique.getTypeBrique();
	}
	
	@JsonProperty("typeBrique")
	public void setTypeBrique(TypeBriqueEnum typeBrique) {
		brique.setTypeBrique(typeBrique);
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
	public Brique getPlot() {
		return brique;
	}

	@JsonIgnore
	public void setPlot(Brique brique) {
		this.brique = brique;
	}

}