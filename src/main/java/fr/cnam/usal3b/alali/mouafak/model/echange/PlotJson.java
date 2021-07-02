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

import fr.cnam.usal3b.alali.mouafak.model.Brique;
import fr.cnam.usal3b.alali.mouafak.model.Plot;
import fr.cnam.usal3b.alali.mouafak.model.TypePlotEnum;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"id" ,"titre", "description" , "typePlot" })
public class PlotJson {

	@JsonIgnore
	private Plot plot;
	@JsonProperty("plots")
	private List<BriqueJson> briques;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<>();

	public PlotJson() {
	}

	public PlotJson(Plot plot) {
		this.plot = plot;
	}
	
	@JsonProperty("id")
	public Integer getId() {
		return plot.getId();
	}

	@JsonProperty("id")
	public void setId(Integer id) {
		plot.setId(id);
	}

	@JsonProperty("titre")
	public String getTitre() {
		return plot.getTitre();
	}

	@JsonProperty("titre")
	public void setTitre(String titre) {
		plot.setTitre(titre);
	}

	@JsonProperty("description")
	public String getDescription() {
		return plot.getDescription();
	}
	
	@JsonProperty("description")
	public void setDescription(String description) {
		plot.setDescription(description);
	}

	
	@JsonProperty("typePlot")
	public TypePlotEnum getTypePlot() {
		return plot.getTypePlot();
	}
	
	@JsonProperty("typePlot")
	public void setTypePlot(TypePlotEnum typePlot) {
		plot.setTypePlot(typePlot);
	}
	
	
	@JsonProperty("briques")
	public List<BriqueJson> getBrique() {
		briques = new ArrayList<BriqueJson>();
		for (Brique brique : plot.getBriquesTextes()) {
			briques.add(new BriqueJson(brique));
		}
		for (Brique brique : plot.getBriquesGeolocs()) {
			briques.add(new BriqueJson(brique));
		}
		for (Brique brique : plot.getBriquesImages()) {
			briques.add(new BriqueJson(brique));
		}
		for (Brique brique : plot.getBriquesNFCs()) {
			briques.add(new BriqueJson(brique));
		}
		for (Brique brique : plot.getBriquesVideos()) {
			briques.add(new BriqueJson(brique));
		}
		return briques;
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
	public Plot getPlot() {
		return plot;
	}

	@JsonIgnore
	public void setPlot(Plot plot) {
		this.plot = plot;
	}

}