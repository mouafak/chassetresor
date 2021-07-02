package fr.cnam.usal3b.alali.mouafak.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Scenario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String titre;
	private String description;
	private String imageUrl;
	@OneToMany(mappedBy = "scenario")
	private List<Etape> etapes;

	public Scenario() {
	}

	public Scenario(String titre, String description ,String imageUrl) {
		this.titre = titre;
		this.description = description;
		this.imageUrl = imageUrl;
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
	public void setEtapes(List<Etape> etapes) {
		this.etapes = etapes;
	}
	
	public String getImageUrl() {
		
		return imageUrl;
	}
	
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Etape> getEtapes() {
		return etapes;
	}

}
