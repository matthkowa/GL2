package main;



import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.NoSuchElementException;

//import view.IHM.IHMMenu;

import model.RechercheDonnees;
import model.utilisateur.*;
import view.menu.*;
import model.QCM.*;

import controller.MenuController;


public class Main {
	
	//.
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws NoSuchAlgorithmException, IOException{
		/*Administrateur a = new Administrateur();
		a.addMo();*/
		
//		Professeur p = new Professeur();
//		p.creerSession();
//		p.creerQCM();
	
//		MenuController m=new MenuController();
		//new IHMMenu();
				
		All<Etudiant> etu = RechercheDonnees.rechercheEtudiant();
		Etudiant e = (Etudiant) View.choix(etu.set);
		e.choisirSession();
		
				
		// Prof = géneeric mdp EISTI
		// Admin vos log de l'eisti + mdp EISTI
		// eleve : 09agent mdp EISTI
	}
}
