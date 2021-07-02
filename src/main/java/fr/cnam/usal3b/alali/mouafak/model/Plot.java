package fr.cnam.usal3b.alali.mouafak.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Plot {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String titre;
	private String description;
	@Enumerated(EnumType.STRING)
	private TypePlotEnum typePlot;
	@ManyToOne
	@JoinColumn(name = "etape_id", nullable = false)
	private Etape etape;
	@OneToMany(mappedBy = "plot")
	private List<BriqueTexte> briquesTextes;
	@OneToMany(mappedBy = "plot")
	private List<BriqueGeoloc> briquesGeolocs;
	@OneToMany(mappedBy = "plot")
	private List<BriqueImage> briquesImages;
	@OneToMany(mappedBy = "plot")
	private List<BriqueNFC> briquesNFCs;
	@OneToMany(mappedBy = "plot")
	private List<BriqueVideo> briquesVideos;
		
	
	
	
	public Plot() {
	}

	public Plot(String titre, String description) {
		this.titre = titre;
		this.description = description;
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

	public TypePlotEnum getTypePlot() {
		return typePlot;
	}

	public void setTypePlot(TypePlotEnum typePlot) {
		this.typePlot = typePlot;
	}
	
	public List<BriqueTexte> getBriquesTextes() {
		return briquesTextes;
	}

	public void setBriquesTextes(List<BriqueTexte> briquesTextes) {
		this.briquesTextes = briquesTextes;
	}

	public List<BriqueGeoloc> getBriquesGeolocs() {
		return briquesGeolocs;
	}

	public void setBriquesGeolocs(List<BriqueGeoloc> briquesGeolocs) {
		this.briquesGeolocs = briquesGeolocs;
	}

	public List<BriqueImage> getBriquesImages() {
		return briquesImages;
	}

	public void setBriquesImages(List<BriqueImage> briquesImages) {
		this.briquesImages = briquesImages;
	}

	public List<BriqueNFC> getBriquesNFCs() {
		return briquesNFCs;
	}

	public void setBriquesNFCs(List<BriqueNFC> briquesNFCs) {
		this.briquesNFCs = briquesNFCs;
	}

	public List<BriqueVideo> getBriquesVideos() {
		return briquesVideos;
	}

	public void setBriquesVideos(List<BriqueVideo> briquesVideos) {
		this.briquesVideos = briquesVideos;
	}
	

	public Etape getEtape() {
		return etape;
	}

	public void setEtape(Etape etape) {
		this.etape = etape;
	}
}
