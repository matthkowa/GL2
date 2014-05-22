package model;

import model.utilisateur.*;
import model.QCM.*;

public class RechercheDonnees {
	
	/**
	 * Retourne la liste des administrateurs enregistrés sur le site
	 * @return All<Administrateur>
	 */
	public static All<Administrateur> rechercheAdmin(){
		String path = "Utilisateur/Administrateur/Administrateur";
		All<Administrateur> newAdmin = new All<Administrateur>();
		if(newAdmin.relecture(path)!=null){
		return (All<Administrateur>) newAdmin.relecture(path);}
		else return (new All<Administrateur>());
	}
	
	/**
	 * Retourne la liste des Professeurs enregistrés sur le site
	 * @return All<Professeur>
	 */
	public static All<Professeur> rechercheProf(){
		String path = "Utilisateur/Professeur/Professeur";
		All<Professeur> newProf = new All<Professeur>();
		if (newProf.relecture(path)!=null){
		return (All<Professeur>) newProf.relecture(path);
		}
		else return (new All<Professeur>());
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
		if (newEtudiant!=null){
		return (newEtudiant) ;
		}else{
			return (new All<Etudiant>());
		}
	}
	
	/**
	 * Retourne la liste des Modules enregistrés sur le site
	 * @return All<Module>
	 */
	public static All<Module> rechercheModule(){
		String path = "Module/module";
		All<Module> newModule = new All<Module>();
		if(newModule.relecture(path)!=null){
		return (All<Module>) newModule.relecture(path);
		}
		else return (new All<Module>());
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
	
	/**
	 * Retourne la liste des QCM enregistrés sur le site
	 * @return All<QCM>
	 */
	public static All<QCM> rechercheQCM(){
		String path = "QCM/qcm";
		All<QCM> newQCM = new All<QCM>();
		if(newQCM.relecture(path)==null) {
			return new All<QCM>();
		}else
		return (All<QCM>) newQCM.relecture(path);
	}
	
	/**
	 * Retourne la liste des Session enregistrés sur le site
	 * @return All<Session>
	 */
	public static All<Session> rechercheSession(){
		String path = "QCM/Session";
		All<Session> newSession = new All<Session>();
		if(newSession.relecture(path)==null) {
			return new All<Session>();
		}else
		return (All<Session>) newSession.relecture(path);
	}
}
