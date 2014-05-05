package initialNode;

import java.util.*;

import QCM.*;

public class Etudiant extends Utilisateur{

	int idEtudiant;

	public Etudiant(String nom, String prenom, Date dateNaissance, String adresse, int tel, String pseudo, String motDePasse,int idEtudaint){
		super(nom, prenom, dateNaissance, adresse, tel, pseudo, motDePasse);
		this.idEtudiant=idEtudiant;
	}
	
	public Etudiant(){
		super();
	}
	
	public void setIdEtudiant(int idEtudiant){
		this.idEtudiant=idEtudiant;
	}
	
	public int getIdEtudiant(){
		return this.idEtudiant;
	}
	
	public void consulterResultat(Etudiant etu, Session sess){
		Date currentDate = new Date();
		if (currentDate.compareTo(sess.getDateFin())>1){
			
		}
		
	}

}
