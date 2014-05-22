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
	
	
	public boolean creerReponse() {
		try{
		String libelle = View.demandeString("Entrez le libell� de votre r�ponse :");
		Boolean estVrai = View.demandeBoolean("Cette r�ponse est-elle une bonne r�ponse ?");
		
		Reponse reponse = new Reponse(libelle, estVrai);
		
		
		System.out.println(reponse.toString());
		Boolean confimation = View.demandeBoolean("Cette r�ponse vous convient-elle ?");
		if (confimation){ 
			this.reponses.add(reponse);
			return true;
		}else{
			System.out.println("Reponse supprim�e.");
			return false;
		}	
		
		}catch (IOException e){
			System.out.println("Erreur d'entr�e sortie");
			return false;
		}	
		
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
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
