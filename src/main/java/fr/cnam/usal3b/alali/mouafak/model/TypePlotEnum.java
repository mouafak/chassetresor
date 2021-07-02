package fr.cnam.usal3b.alali.mouafak.model;

public enum TypePlotEnum {
	/**
	 * Represente une interlude
	 */
	INTERLUDE(true),
	/**
	 * Represente une brique Question
	 */
	QUESTION(true),
	/**
	 * Represente un choix de reponse
	 */
	CHOIX_REPONSE(false),
	/**
	 * Represente une réponse juste
	 */
	REPONSE_JUSTE(false),
	/**
	 * Represente une reponse fausse
	 */
	REPONSE_FAUSSE(false);

	private boolean peutDebuterEtape;

	private TypePlotEnum(boolean peutDebuterEtape) {
		this.peutDebuterEtape = peutDebuterEtape;
	}

	public boolean isPeutDebuterEtape() {
		return peutDebuterEtape;
	}

}
