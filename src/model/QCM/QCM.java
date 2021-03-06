package model.QCM;

import java.io.*;
import java.util.*;
import view.menu.*;
import model.utilisateur.*;

public class QCM implements Serializable{
	private static final long serialVersionUID = 7353225222327832500L;
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

	/**
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
		QCM other = (QCM) obj;
		if (createur == null) {
			if (other.createur != null)
				return false;
		} else if (!createur.equals(other.createur))
			return false;
		if (estPrive == null) {
			if (other.estPrive != null)
				return false;
		} else if (!estPrive.equals(other.estPrive))
			return false;
		if (libelle == null) {
			if (other.libelle != null)
				return false;
		} else if (!libelle.equals(other.libelle))
			return false;
		if (questions == null) {
			if (other.questions != null)
				return false;
		} else if (!questions.equals(other.questions))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return libelle;
	}
	
	public boolean creerQuestion() {
		try{
		String libelle = View.demandeString("Entrez l'�nonc� de votre question :");
		Question question = new Question(libelle);
		
		Boolean finQuestion = true;
		Boolean ajoutReponse = false;
		
		int compteur = 0;
		
		while (finQuestion){
				
			System.out.println("Cr�ation de la r�ponse n�"+ (compteur+1));
			ajoutReponse = question.creerReponse();
			
			if (ajoutReponse){	
				compteur ++;
				ajoutReponse = false;
			}
			
			Iterator<Reponse> it = question.getReponses().iterator();
			boolean bonneReponse = false;
			
			while (it.hasNext() && !(bonneReponse)){
				Reponse rep = (Reponse) it.next();
				
				bonneReponse = rep.getEstVraie();
				
			}
			
				if (compteur > 1 && bonneReponse){
					finQuestion = View.demandeBoolean("Ajouter une autre r�ponse ?");
				}
							
			}
		
		System.out.println(question.toString());
		Boolean confimation = View.demandeBoolean("Cette question vous convient-elle ?");
		if (confimation){ 
			this.questions.add(question);
			return true;
		}
		else {
			System.out.println("Question supprim�e.");
			return false;
		}
		
		}catch (IOException e){
			System.out.println("Erreur d'entr�e sortie");
			return false;
		}
		
	}

}
