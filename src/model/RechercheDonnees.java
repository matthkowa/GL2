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
			String path = "dataSave/Utilisateur/Administrateur/Administrateur";
			All<Administrateur> newAdmin = new All<Administrateur>();
			newAdmin = (All<Administrateur>) newAdmin.relecture(path);
			if (newAdmin==null){
				return (new All<Administrateur>());
			}
			else{
				return newAdmin;
			}
	}
	
	/**
	 * Retourne la liste des Professeurs enregistrés sur le site
	 * @return All<Professeur>
	 */
	public static All<Professeur> rechercheProf(){
		String path = "dataSave/Utilisateur/Professeur/Professeur";
		All<Professeur> newProf = new All<Professeur>();
		newProf = (All<Professeur>) newProf.relecture(path);
		if (newProf==null){
			return (new All<Professeur>());
		}
		else{
			return newProf;
		}
	}
	
	/**
	 * Retourne la liste des Etudiants enregistrés sur le site
	 * @return All<Etudiant>
	 */
	
	public static All<Etudiant> rechercheEtudiant(){
			String path = "dataSave/Utilisateur/Etudiant/promotion";
			All<Etudiant> newEtudiant = new All<Etudiant>();
			All<Promotion> p = (All<Promotion>) newEtudiant.relecture(path);
			if (p==null){
				return (new All<Etudiant>());
			}
			else{
				for(Promotion p1 : p.getSet()){
					newEtudiant.addAll(p1.getSetEtudiant());
				}
				return newEtudiant;
			}
	}
	
	/**
	 * Retourne la liste des Modules enregistrés sur le site
	 * @return All<Module>
	 */
	public static All<Module> rechercheModule(){
		String path = "dataSave/Module/module";
		All<Module> newModule = new All<Module>();
		All<Module> modules = (All<Module>) newModule.relecture(path);
		if (modules==null){
			return (new All<Module>());
		}
		else{
			return modules;
		}
	}
	
	/**
	 * Retourne la liste des promotions enregistrés sur le site
	 * @return All<Promotion>
	 */
	public static All<Promotion> recherchePromo(){
		String path = "dataSave/Utilisateur/Etudiant/promotion";
		All<Promotion> newPromo = new All<Promotion>();
		newPromo = (All<Promotion>) newPromo.relecture(path);
		if (newPromo==null){
			return (new All<Promotion>());
		}
		else{
			return newPromo;
		}
	}
	
	/**
	 * Retourne la liste des QCM enregistrés sur le site
	 * @return All<QCM>
	 */
	public static All<QCM> rechercheQCM(){
			String path = "dataSave/QCM/qcm";
			All<QCM> newQCM = new All<QCM>();
			newQCM = (All<QCM>) newQCM.relecture(path);
			if (newQCM==null){
				return (new All<QCM>());
			}
			else{
				return newQCM;
			}
	}
	
	/**
	 * Retourne la liste des Session enregistrés sur le site
	 * @return All<Session>
	 */
	public static All<Session> rechercheSession(){
		String path = "dataSave/QCM/session";
		All<Session> newSession = new All<Session>();
		newSession = (All<Session>) newSession.relecture(path);
		if (newSession==null){
			return (new All<Session>());
		}
		else{
			return newSession;
		}
	}
	
	/**
	 * Retourne la liste des Resultat de n° id enregistrés sur le site
	 * @return All<Session>
	 */
	public static All<Resultat> rechercheResultat(int id){
		String path = "dataSave/Resultat/"+id+"/resultat";
		All<Resultat> newResultat = new All<Resultat>();
		newResultat = (All<Resultat>) newResultat.relecture(path);
		if (newResultat==null){
			return (new All<Resultat>());
		}
		else{
			return newResultat;
		}
	}
}
