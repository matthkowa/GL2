package model;

import model.utilisateur.*;


public class RechercheDonnees {
	
	/**
	 * Retourne la liste des administrateurs enregistrés sur le site
	 * @return All<Administrateur>
	 */
	public static All<Administrateur> rechercheAdmin(){
		String path = "Utilisateur/Administrateur/Administrateur";
		All<Administrateur> newAdmin = new All<Administrateur>();
		return (All<Administrateur>) newAdmin.relecture(path);
	}
	
	/**
	 * Retourne la liste des Professeurs enregistrés sur le site
	 * @return All<Professeur>
	 */
	public static All<Professeur> rechercheProf(){
		String path = "Utilisateur/Professeur/Professeur";
		All<Professeur> newProf = new All<Professeur>();
		return (All<Professeur>) newProf.relecture(path);
	}
	
	/**
	 * Retourne la liste des Etudiants enregistrés sur le site
	 * @return All<Etudiant>
	 */
	
	public static All<Etudiant> rechercheEtudiant(){
		String path = "Utilisateur/Etudiant/promotion";
		All<Etudiant> newEtudiant = new All<Etudiant>();
		All<Promotion> p = (All<Promotion>) newEtudiant.relecture(path);
		for(Promotion p1 : p.getSet()){
			newEtudiant.addAll(p1.getSetEtudiant());
		}
		return (newEtudiant) ;
	}
	
	/**
	 * Retourne la liste des Modules enregistrés sur le site
	 * @return All<Module>
	 */
	public static All<Module> rechercheModule(){
		String path = "Module/module";
		All<Module> newModule = new All<Module>();
		return (All<Module>) newModule.relecture(path);
	}
	
	/**
	 * Retourne la liste des promotions enregistrés sur le site
	 * @return All<Promotion>
	 */
	public static All<Promotion> recherchePromo(){
		String path = "Utilisateur/Etudiant/promotion";
		All<Promotion> newPromo = new All<Promotion>();
		if(newPromo.relecture(path)==null) {
			return new All<Promotion>();
		}else
		return (All<Promotion>) newPromo.relecture(path);
	}
}
