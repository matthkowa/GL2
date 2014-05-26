package model;

import java.io.FileNotFoundException;

import model.utilisateur.*;
import model.QCM.*;

public class RechercheDonnees {
	
	/**
	 * Retourne la liste des administrateurs enregistrés sur le site
	 * @return All<Administrateur>
	 */
	public static All<Administrateur> rechercheAdmin(){
		try{
			String path = "Utilisateur/Administrateur/Administrateur";
			All<Administrateur> newAdmin = new All<Administrateur>();
			return (All<Administrateur>) newAdmin.relecture(path);
		}catch(FileNotFoundException e){
			return (new All<Administrateur>());
		}
	}
	
	/**
	 * Retourne la liste des Professeurs enregistrés sur le site
	 * @return All<Professeur>
	 */
	public static All<Professeur> rechercheProf(){
		try{
			String path = "Utilisateur/Professeur/Professeur";
			All<Professeur> newProf = new All<Professeur>();
			return (All<Professeur>) newProf.relecture(path);
		}catch(FileNotFoundException e){
			return (new All<Professeur>());
		}
	}
	
	/**
	 * Retourne la liste des Etudiants enregistrés sur le site
	 * @return All<Etudiant>
	 */
	
	public static All<Etudiant> rechercheEtudiant(){
		try{
			String path = "Utilisateur/Etudiant/promotion";
			All<Etudiant> newEtudiant = new All<Etudiant>();
			All<Promotion> p = (All<Promotion>) newEtudiant.relecture(path);
			for(Promotion p1 : p.getSet()){
				newEtudiant.addAll(p1.getSetEtudiant());
			}
			return (newEtudiant) ;
		}
		catch(FileNotFoundException e){
			return (new All<Etudiant>());
		}
	}
	
	/**
	 * Retourne la liste des Modules enregistrés sur le site
	 * @return All<Module>
	 */
	public static All<Module> rechercheModule(){
		try{
			String path = "Module/module";
			All<Module> newModule = new All<Module>();
			return (All<Module>) newModule.relecture(path);
		}
		catch(FileNotFoundException e){
			return (new All<Module>());
		}
	}
	
	/**
	 * Retourne la liste des promotions enregistrés sur le site
	 * @return All<Promotion>
	 */
	public static All<Promotion> recherchePromo(){
		try{
			String path = "Utilisateur/Etudiant/promotion";
			All<Promotion> newPromo = new All<Promotion>();
			newPromo = (All<Promotion>) newPromo.relecture(path);
			return newPromo;
		}
		catch(FileNotFoundException e){
			return new All<Promotion>();
		}
	}
	
	/**
	 * Retourne la liste des QCM enregistrés sur le site
	 * @return All<QCM>
	 */
	public static All<QCM> rechercheQCM(){
		try{
			String path = "QCM/qcm";
			All<QCM> newQCM = new All<QCM>();
			return (All<QCM>) newQCM.relecture(path);
		}catch(FileNotFoundException e){
			return new All<QCM>();
		}
	}
	
	/**
	 * Retourne la liste des Session enregistrés sur le site
	 * @return All<Session>
	 */
	public static All<Session> rechercheSession(){
		try{
			String path = "QCM/session";
			All<Session> newSession = new All<Session>();
			return (All<Session>) newSession.relecture(path);
		}catch(FileNotFoundException e){
			return new All<Session>();
		}
	}
	
	/**
	 * Retourne la liste des Resultat de n° id enregistrés sur le site
	 * @return All<Session>
	 */
	public static All<Resultat> rechercheResultat(int id){
		try{
			String path = "Resultat/"+id+"/resultat";
			All<Resultat> newResultat = new All<Resultat>();
			return (All<Resultat>) newResultat.relecture(path);
		}catch(FileNotFoundException e){
			return new All<Resultat>();
		}
	}
}
