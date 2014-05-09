package initialNode;

import java.util.*;

import QCM.*;

public class Etudiant extends Utilisateur{

	private int idEtudiant;

	public Etudiant(String nom, String prenom, Date dateNaissance, String adresse, int tel, String pseudo, String motDePasse,int idEtudiant){
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
		if (currentDate.compareTo(sess.getDateFin())==1){
			Resultat res = new Resultat();
			res = (Resultat) res.relecture("QCM/" + sess.getIdSession() + "/" + etu.idEtudiant);
			System.out.println(res);
		}
		else {
			System.out.println("Vous n'�tes pas autoris� � consulter les r�sultats. Veuillez r�essayer une fois la session termin�e.");
		}
		
	}
	
	public void consulterResultat(Etudiant etu){
		Date currentDate = new Date();
		if (currentDate.compareTo(sess.getDateFin())==1){
			Resultat res = new Resultat();
			res = (Resultat) res.relecture("QCM/*/" + etu.idEtudiant);
			System.out.println(res);
		}
		else {
			System.out.println("Vous n'�tes pas autoris� � consulter les r�sultats. Veuillez r�essayer une fois la session termin�e.");
		}
		
	}

}
