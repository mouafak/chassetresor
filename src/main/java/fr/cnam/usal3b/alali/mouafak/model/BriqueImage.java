package fr.cnam.usal3b.alali.mouafak.model;

import javax.persistence.Entity;

@Entity
public class BriqueImage extends Brique {

	private String urlImage;
	private String texteAccessibilite;

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	public String getTexteAccessibilite() {
		return texteAccessibilite;
	}

	public void setTexteAccessibilite(String texteAccessibilite) {
		this.texteAccessibilite = texteAccessibilite;
	}

}
