package model.QCM;

import java.io.*;

public class Reponse implements Serializable {
	
	private String libelle;
	private Boolean estVraie;
	
	/**
	 * @param id
	 * @param libelle
	 * @param estVraie
	 */
	public Reponse(String libelle, Boolean estVraie) {
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
	 * @return the estVraie
	 */
	public Boolean getEstVraie() {
		return estVraie;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		String toStr = this.libelle + " ";
		
		if (this.estVraie){
			toStr += "Bonne réponse\n";
		}else{
			toStr += "Mauvaise réponse\n";
		}
			
		return toStr;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((estVraie == null) ? 0 : estVraie.hashCode());
		result = prime * result + ((libelle == null) ? 0 : libelle.hashCode());
		return result;
	}
}