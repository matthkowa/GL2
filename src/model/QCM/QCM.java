package model.QCM;

import java.util.*;

import model.utilisateur.*;

public class QCM{
	
	private String libelle;
	private Boolean estPrive;
	private Professeur createur;
	private Set<Question> questions;
	
	/**
	 * @param libelle
	 * @param estPrive
	 */
	public QCM(String libelle, Boolean estPrive, Professeur createur, Set<Question> questions) {
		this.libelle = libelle;
		this.estPrive = estPrive;
		this.createur = createur;
		this.questions = new HashSet<Question>();
		this.questions = questions;		
	}
	
	public QCM(String libelle, Boolean estPrive, Professeur createur) {
		this.libelle = libelle;
		this.estPrive = estPrive;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((createur == null) ? 0 : createur.hashCode());
		result = prime * result
				+ ((estPrive == null) ? 0 : estPrive.hashCode());
		result = prime * result + ((libelle == null) ? 0 : libelle.hashCode());
		result = prime * result
				+ ((questions == null) ? 0 : questions.hashCode());
		return result;
	}
	
	public void creerQuestion() {
	
	}

}
