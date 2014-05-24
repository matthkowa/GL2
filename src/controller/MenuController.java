package controller;

import java.io.IOException;

import model.utilisateur.*;
import view.menu.View;

public class MenuController {
	/**
	 * Cr�e un objet AuthentificationController puis lance la fonction d'identification associ�e
	 * Verifie ensuite si l'authentification a reussi 
	 * Verifie si l'utilisateur est un administrateur ou professeur ou etudiant et lance les fonctions associ�es 
	 */
	private void authentification(){		
		AuthentificationController aut = new AuthentificationController();
		Utilisateur util = aut.authentification();
	if(aut.getAutReussi()){
			if(util instanceof Administrateur){
				administrateur();}
			else { 
				if (util instanceof Professeur ){
					professeur();}
				else { 
					if (util instanceof Etudiant ){
						etudiant();}
					else { 
						System.out.println("Erreur");
					}
				}
			}		
		}
	}
		
	/**
	 * Deuxieme sous menu de l'administrateur
	 * @param choix int Pr�c�dent choix de l'utilisateur ( administrateur,professeur ou etudiant)
	 * @param a Administrateur administrateur etant connect�
	 */
		
	private void administrateur2(int choix,Administrateur a){		
		boolean b = true;
		while(b){
			try{
				int carac = View.demandeInt("_______MENU 1______\n 1- Ajouter \n 2- Modifier \n 3- Supprimer \n 4- Retour au menu \n \n Choix :");
				if(carac==4) b= false; 
				else{
					switch(choix) {
						case 1 : /*Administrateur*/
							switch(carac) { 
							case 1 : a.addAdmin(); 	break;
							case 2 : a.modifAdmin();  	break;
							case 3 : a.supAdmin();  break;
							}
						break;
						
						case 2 : /*Professeur*/
							switch(carac) { 
							case 1 : a.addProf(); 	break;
							case 2 : a.modifProf();  	break;
							case 3 : a.supProf(); 	break;
							}
						break;
						case 3 :/*Etudiant*/
							switch(carac) { 
							case 1 : a.addEleve(); 	break;
							case 2 : a.modifEleve();  	break;
							case 3 : a.supEleve();  	break;
							}
						break;
						case 4 :/*Promotion*/
							switch(carac) { 
							case 1 : a.addPromo();	break;
							case 2 : /*Modifier Promo*/  		break;
							case 3 : a.supPromo();  	break;
							}
						break;
						case 5 :/*Modules*/
							switch(carac) { 
							case 1 : a.addModule(); 		break;
							case 2 : a.modifModule();  	break;
							case 3 : a.supModule();  	break;
							}
						break;
						default : System.out.println("Erreur veuillez contacter le support"); break;
					}
				}
			}catch(IOException e){
				System.err.println("Probl�me : " + e);
			}
		}			
	}

	/**
	 * Premier menu d'administrateur 
	 */
	private void administrateur(){
		Administrateur a = new Administrateur();
		boolean b = true;
		while(b){
			try{
				int carac = View.demandeInt("_______MENU 1______\n 1- G�rer les administrateur \n 2- G�rer les professeurs \n 3- G�rer les �tudiants \n 4- G�rer les promotions \n 5- G�rer les modules \n 6- Deconnexion \n \n Choix :");
				if(carac == 1 || carac == 2 || carac == 3 || carac == 4 || carac == 5){
					administrateur2(carac,a);
				}
				else{ 
					if(carac == 6) b=false;
				}
			}
			catch(IOException e){
				System.out.println("Erreur");
				
			}
		}
	}		
	
	/**
	 * Premier menu du professeur
	 */
	
	private void professeur(){
		boolean b = true;
		while(b)
		{
			try{
				int carac = View.demandeInt("_______MENU 1______\n 1- G�rer les QCM \n 2- Visualiser les r�sultats \n 3- Deconnexion \n \n Choix :");
				switch (carac){
					case 1 : break;
					case 2 : break;
					case 3 : b=false; break;				
				default : break;
				}
			}
			catch(IOException e){
				System.out.println("Erreur");
			}
		}
	}
	
	/**
	 * Premier menu de l'etudiant
	 */
	
	private void etudiant(){
		boolean b = true;
		while(b)
		{	
			try{
				int carac = View.demandeInt("_______MENU 1______\n 1- R�pondre aux QCM \n 2- Visualiser les r�sultats \n 3- Deconnexion \n \n Choix :");
				switch (carac){
					case 1 : break;
					case 2 : break;
					case 3 : b=false; break;				
				default : break;
				}
			}
			catch(IOException e){
				System.out.println("Erreur");					
			}				
		}
	}
	
	/**
	 * Constructeur du menu lan�ant l'authentification ou la fermeture du programme
	 */
	
	public MenuController(){
		boolean b = true;
		while(b)
		{
			try{
				int carac = View.demandeInt("_______MENU 1______\n 1- S'authentifier \n 2- Quitter \n \n Choix :");
				switch (carac){
					case 1 : authentification(); break;
					case 2 :b=false; break;
					default : break;
				}
			}
			catch(IOException e){
				System.out.println("Erreur");					
			}				
		}
	}
}
	

