package model.QCM;

public class Reponse {
	
	private int id;
	private String libelle;
	private Boolean estVraie;
	
	/**
	 * @param id
	 * @param libelle
	 * @param estVraie
	 */
	public Reponse(int id, String libelle, Boolean estVraie) {
		this.id = id;
		this.libelle = libelle;
		this.estVraie = estVraie;
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

	public String toString(){
		return id + " " + libelle + " " + estVraie;
	}
}