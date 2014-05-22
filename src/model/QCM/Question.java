package model.QCM;

import java.util.*;

public class Question {

	private String libelle;
	private ArrayList<Reponse> reponses;
	
	/**
	 * @param libelle
	 */
	public Question(String libelle, ArrayList<Reponse> reponses) {
		this.libelle = libelle;
		this.reponses = new ArrayList<Reponse>();
		this.reponses = reponses;
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

	public ArrayList<Reponse> getReponses() {
		return reponses;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((libelle == null) ? 0 : libelle.hashCode());
		result = prime * result
				+ ((reponses == null) ? 0 : reponses.hashCode());
		return result;
	}	
	
}
