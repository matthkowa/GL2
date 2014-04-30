package QCM;

public class Reponse {
	
	private int id;
	private String libelle;
	private Boolean estVraie;
	private Question intitule;
	
	/**
	 * @param id
	 * @param libelle
	 * @param estVraie
	 */
	public Reponse(int id, String libelle, Boolean estVraie, Question intitule) {
		this.id = id;
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
	 * @return the id
	 */
	public int getId() {
		return id;
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
