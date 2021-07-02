package fr.cnam.usal3b.alali.mouafak.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Brique {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Integer id;

	protected String titre;
	protected String description;
	protected TypeBriqueEnum briqueType;
	@ManyToOne
	@JoinColumn(name = "plot_id", nullable = false)
	protected Plot plot;
	
	public Brique() {
	}

	public Brique(String titre, String description ,TypeBriqueEnum briqueType ) {
		this.titre = titre;
		this.description = description;
		this.briqueType = briqueType;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Plot getPlot() {
		return plot;
	}

	public void setPlot(Plot plot) {
		this.plot = plot;
	}
	
	public TypeBriqueEnum getTypeBrique() {
		return briqueType;
		}
	
	public void setTypeBrique(TypeBriqueEnum briqueType) {
		this.briqueType = briqueType;
		}
}
