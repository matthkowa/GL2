package model;

import initialNode.*;


public class RechercheDonnees {
	
	public static All<Administrateur> rechercheAdmin(){
		String path = "Utilisateur/Administrateur/Administrateur";
		All<Administrateur> newAdmin = new All<Administrateur>();
		return (All<Administrateur>) newAdmin.relecture(path);
	}
	
	public static All<Professeur> rechercheProf(){
		String path = "Utilisateur/Professeur/Professeur";
		All<Professeur> newProf = new All<Professeur>();
		return (All<Professeur>) newProf.relecture(path);
	}
	
	public static All<Etudiant> rechercheEtudiant(){
		String path = "Utilisateur/Etudiant/promotion";
		All<Etudiant> newEtudiant = new All<Etudiant>();
		All<Promotion> p = (All<Promotion>) newEtudiant.relecture(path);
		for(Promotion p1 : p.getSet()){
			newEtudiant.addAll(p1.getSetEtudiant());
		}
		return (newEtudiant) ;
	}
	
}
