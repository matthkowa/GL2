package model.QCM;

import java.io.Serializable;
import model.utilisateur.Etudiant;
import java.util.*;

import model.serializable.Serialiser;


public class Resultat implements Serializable{

	private double note;
	private Etudiant eleve;
	private int iterations;
	private ArrayList<Reponse> listeReponse;
	
	/**
	 * Constructeur complet de Resultat
	 * @param note
	 * @param eleve
	 * @param iterations
	 */
	public Resultat(double note, Etudiant eleve, int iterations, ArrayList<Reponse> listeReponse) {
		this.note = note;
		this.eleve = eleve;
		this.iterations = iterations;
		this.listeReponse = new ArrayList<Reponse>();
		this.listeReponse = listeReponse;
	}
	
	/**
	 * Constructeur vide
	 */
	
	public Resultat() {
	}

	/**
	 * @return the note
	 */
	public double getNote() {
		return note;
	}

	/**
	 * @param note the note to set
	 */
	public void setNote(double note) {
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

	/**
	 * @return the listeReponse
	 */
	public ArrayList<Reponse> getListeReponse() {
		return listeReponse;
	}
	
	public void afficherResultats() {
		
		Iterator<Reponse> it = this.listeReponse.iterator();
		int compteur = 1;
		System.out.println("Liste des réponses de l'élève "+ this.eleve.getNom() + " " + this.eleve.getPrenom() + " :");
		while (it.hasNext()){
			Reponse rep = (Reponse) it.next();
			System.out.println(compteur + " - " + this.listeReponse.get(compteur - 1));
		}
		
		System.out.println("Note : "+ this.note);
	}
}
