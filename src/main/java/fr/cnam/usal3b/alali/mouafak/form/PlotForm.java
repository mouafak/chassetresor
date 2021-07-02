package fr.cnam.usal3b.alali.mouafak.form;

import fr.cnam.usal3b.alali.mouafak.model.TypePlotEnum;

public class PlotForm {
	private Integer id;
	private String titre;
	private String description;
	private TypePlotEnum typePlot;
	private Integer etapeId;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TypePlotEnum getTypePlot() {
		return typePlot;
	}

	public void setTypePlot(TypePlotEnum typePlot) {
		this.typePlot = typePlot;
	}
	public Integer getEtapeId() {
		return etapeId;
	}

	public void setEtapeId(Integer etapeId) {
		this.etapeId = etapeId;
	}

}
