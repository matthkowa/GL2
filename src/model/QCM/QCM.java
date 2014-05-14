package model.QCM;

import initialNode.*;
import java.util.*;

public class QCM {
	
	private int id;
	private String libelle;
	private Boolean estPrive;
	private Professeur createur;
	private Set<Question> questions;
	
	/**
	 * @param id
	 * @param libelle
	 * @param estPrive
	 */
	public QCM(int id, String libelle, Boolean estPrive, Professeur createur, Set<Question> questions) {
		this.id = id;
		this.libelle = libelle;
		this.estPrive = estPrive;
		this.createur = createur;
		this.questions = new HashSet<Question>();
		this.questions = questions;		
	}
	
	public QCM(String libelle, Professeur createur) {
		// GENERER ID !!
		this.libelle = libelle;
		this.createur = createur;
		this.questions = new HashSet<Question>();		
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
	 * @return the estPrive
	 */
	public Boolean getEstPrive() {
		return estPrive;
	}
	
	public Professeur getCreateur() {
		return createur;
	}
	
	public Set<Question> getQuestions() {
		return questions;
	}
	
	

}
