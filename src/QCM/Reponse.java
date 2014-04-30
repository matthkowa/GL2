package QCM;

public class Reponse {
	
	private int idReponse;
	private String libelle;
	private Boolean estVraie;
	private Question intitule;
	
	/**
	 * @param idReponse
	 * @param libelle
	 * @param estVraie
	 */
	public Reponse(int idReponse, String libelle, Boolean estVraie, Question intitule) {
		this.idReponse = idReponse;
		this.libelle = libelle;
		this.estVraie = estVraie;
		this.intitule = intitule;
	}

	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * @return the idReponse
	 */
	public int getIdReponse() {
		return idReponse;
	}

	/**
	 * @return the estVraie
	 */
	public Boolean getEstVraie() {
		return estVraie;
	}
	
	public Question getIntitule() {
		return intitule;
	}
	

}
