package QCM;

import java.util.*;

public class Question {

	private int id;
	private String libelle;
	private Set<Reponse> reponses;
	
	/**
	 * @param id
	 * @param libelle
	 */
	public Question(int id, String libelle, Set<Reponse> reponses) {
		this.id = id;
		this.libelle = libelle;
		this.reponses = new HashSet<Reponse>();
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
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	public Set<Reponse> getReponses() {
		return reponses;
	}
	
	
}
