package model.QCM;

import java.io.Serializable;
import model.utilisateur.Etudiant;

import model.serializable.Serialiser;


public class Resultat implements Serializable{

	private int note;
	private Etudiant eleve;
	private int iterations;
	/**
	 * @param note
	 * @param eleve
	 * @param iterations
	 */
	public Resultat(int note, Etudiant eleve, int iterations) {
		this.note = note;
		this.eleve = eleve;
		this.iterations = iterations;
	}
	
	/**
	 * Constructeur vide
	 */
	
	public Resultat() {
	}

	/**
	 * @return the note
	 */
	public int getNote() {
		return note;
	}

	/**
	 * @param note the note to set
	 */
	public void setNote(int note) {
		this.note = note;
	}

	/**
	 * @return the eleve
	 */
	public Etudiant getEleve() {
		return eleve;
	}

	/**
	 * @param eleve the eleve to set
	 */
	public void setEleve(Etudiant eleve) {
		this.eleve = eleve;
	}

	/**
	 * @return the iterations
	 */
	public int getIterations() {
		return iterations;
	}

	/**
	 * @param iterations the iterations to set
	 */
	public void setIterations(int iterations) {
		this.iterations = iterations;
	}
	
	
	
	
	
	
}
