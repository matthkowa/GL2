package model.QCM;

import java.io.*;
import java.util.*;

import view.menu.View;

public class Question implements Serializable{

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
	
	public Question(String libelle) {
		this.libelle = libelle;
		this.reponses = new ArrayList<Reponse>();
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
	
	
	public void creerReponse() {
		try{
		String libelle = View.demandeString("Entrez le libellé de votre réponse :");
		Boolean estVrai = View.demandeBoolean("Cette réponse est-elle une bonne réponse ?");
		
		Reponse reponse = new Reponse(libelle, estVrai);
		
		this.reponses.add(reponse);	
		
		}catch (IOException e){
			System.out.println("Erreur d'entrée sortie");
		}	
		
	}
}
