package model.QCM;

import java.util.*;

public class Question {

	private int id;
	private String libelle;
	private ArrayList<Reponse> reponses;
	
	/**
	 * @param id
	 * @param libelle
	 */
	public Question(int id, String libelle, ArrayList<Reponse> reponses) {
		this.id = id;
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
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * @return the id
	 */
	
	public ArrayList<Reponse> getReponses() {
		return reponses;
	}
	
	
}
