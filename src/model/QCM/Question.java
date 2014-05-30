package model.QCM;

import java.io.*;
import java.util.*;

import view.menu.View;

public class Question implements Serializable{
	private static final long serialVersionUID = -7425131709858983169L;
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
	
	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Question other = (Question) obj;
		if (libelle == null) {
			if (other.libelle != null)
				return false;
		} else if (!libelle.equals(other.libelle))
			return false;
		if (reponses == null) {
			if (other.reponses != null)
				return false;
		} else if (!reponses.equals(other.reponses))
			return false;
		return true;
	}
	
	/**
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
	
	
	public boolean creerReponse() {
		try{
		String libelle = View.demandeString("Entrez le libellé de votre réponse :");
		Boolean estVrai = View.demandeBoolean("Cette réponse est-elle une bonne réponse ?");
		
		Reponse reponse = new Reponse(libelle, estVrai);
		
		
		System.out.println(reponse.toString());
		Boolean confimation = View.demandeBoolean("Cette réponse vous convient-elle ?");
		if (confimation){ 
			this.reponses.add(reponse);
			return true;
		}else{
			System.out.println("Reponse supprimée.");
			return false;
		}	
		
		}catch (IOException e){
			System.out.println("Erreur d'entrée sortie");
			return false;
		}	
		
	}

	@Override
	public String toString() {
		
		String toStr = this.libelle+"\n";
		Iterator it = this.reponses.iterator();
		
		while (it.hasNext()){
			Reponse rep = (Reponse) it.next();
			
			toStr = toStr +rep.toString();
			
		}
		
		return toStr;
	}
}
