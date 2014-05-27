package controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import model.RechercheDonnees;
import model.QCM.Session;
import model.utilisateur.*;
import view.menu.View;

public class MenuController {
	/**
	 * Crée un objet AuthentificationController puis lance la fonction d'identification associée
	 * Verifie ensuite si l'authentification a reussi 
	 * Verifie si l'utilisateur est un administrateur ou professeur ou etudiant et lance les fonctions associées 
	 */
	private void authentification(){		
		AuthentificationController aut = new AuthentificationController();
		Utilisateur util = aut.authentification();
	if(aut.getAutReussi()){
			System.out.println("Bonjour " + util.getNom() +" "+ util.getPrenom());
			if(util instanceof Administrateur){
				administrateur((Administrateur) util);}
			else { 
				if (util instanceof Professeur ){
					professeur((Professeur) util);}
				else { 
					if (util instanceof Etudiant ){
						etudiant((Etudiant) util);}
					else { 
						System.out.println("Erreur de connexion l'utilisateur n'appartient pas à une catégorie précise");
					}
				}
			}		
		}
	}
		
	/**
	 * Deuxieme sous menu de l'administrateur
	 * @param choix int Précédent choix de l'utilisateur ( administrateur,professeur ou etudiant)
	 * @param a Administrateur administrateur etant connecté
	 */
		
	private void administrateur2(int choix,Administrateur a){		
		boolean b = true;
		while(b){
			try{
				String str = "Gérer ";
				switch(choix){
				case 1 : str += "les administrateurs";  break;
				case 2 : str += "les professeurs"; break;
				case 3 : str += "les étudiants"; break;
				case 4 : str += "les promotions"; break;
				case 5 : str += "les modules"; break;
				}
				int carac = View.demandeInt("_______"+str+"______\n 1- Ajouter \n 2- Modifier \n 3- Supprimer \n 4- Retour au menu \n \n Choix :");
				if(carac==4) b= false; 
				else{
					switch(choix) {
						case 1 : /*Administrateur*/
							switch(carac) { 
							case 1 : a.addAdmin(); 		break;
							case 2 : a.modifAdmin();  	break;
							case 3 : a.supAdmin();  	break;
							}
						break;
						
						case 2 : /*Professeur*/
							switch(carac) { 
							case 1 : a.addProf(); 		break;
							case 2 : a.modifProf();  	break;
							case 3 : a.supProf(); 		break;
							}
						break;
						case 3 :/*Etudiant*/
							switch(carac) { 
							case 1 : a.addEleve(); 		break;
							case 2 : a.modifEleve();  	break;
							case 3 : a.supEleve();  	break;
							}
						break;
						case 4 :/*Promotion*/
							switch(carac) { 
							case 1 : a.addPromo();		break;
							case 2 : a.modifPromo();	break;
							case 3 : a.supPromo();  	break;
							}
						break;
						case 5 :/*Modules*/
							switch(carac) { 
							case 1 : a.addModule(); 	break;
							case 2 : a.modifModule();  	break;
							case 3 : a.supModule();  	break;
							}
						break;
						default : System.out.println("Erreur veuillez contacter le support"); break;
					}
				}
			}catch(IOException e){
				System.err.println("Problème : " + e);
			}
		}			
	}

	/**
	 * Premier menu d'administrateur 
	 */
	private void administrateur(Administrateur a){
		
		boolean b = true;
		while(b){
			try{
				int carac = View.demandeInt("_______MENU 1______\n 1- Gérer les administrateur \n 2- Gérer les professeurs \n 3- Gérer les étudiants \n 4- Gérer les promotions \n 5- Gérer les modules \n 6- Deconnexion \n \n Choix :");
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
	
	private void professeur(Professeur p){
		boolean b = true;
		try {		
			while(b){
				int carac = View.demandeInt("_______MENU professeur______\n 1- Gérer les QCMs \n 2- Gérer les sessions \n 3- Visualiser les résultats \n 4- Quitter \n \n Choix :");
				switch (carac){
					case 1 : professeur2(carac,p);
					case 2 : professeur2(carac,p);
					case 3 : professeur3(p); break;
					case 4 : b=false; break;				
				default : break;
				}
			}	
		} catch (IOException ioe){
			System.out.println("Erreur d'entrée sortie");
		}
		
	}
	
	/**
	 * Deuxieme sous menu du professeur
	 * @param choix int Précédent choix de l'utilisateur (QCM ou session)
	 * @param p Professer professeur étant connecté
	 */
		
	private void professeur2(int choix,Professeur p){		
		boolean b = true;
		while(b){
			try{
				String str = "Gérer ";
				switch(choix){
				case 1 : str +="des QCM"; break;
				case 2 : str +="des Sessions"; break;
				
				}
				int carac = View.demandeInt("_______MENU 1______\n 1- Ajouter \n 2- Supprimer \n 3- Retour au menu \n \n Choix :");
				if(carac==3) b= false; 
				else{
					switch(choix) {
						case 1 : /*QCM*/
							switch(carac) { 
							case 1 : p.creerQCM(); 	break;
							case 2 : p.supprimerQCM();  	break;
							}
						break;
						
						case 2 : /*Session*/
							switch(carac) { 
							case 1 : p.creerSession(); 	break;
							case 2 : p.supprimerSession();  	break;
							}
						break;
						default : System.out.println("Erreur veuillez contacter le support"); break;
					}
				}
			}catch(IOException e){
				System.err.println("Problème : " + e);
			}
		}			
	}
	
	/**
	 * Troisieme menu du professeur
	 */
	
	private void professeur3(Professeur p){
		boolean b = true;
		Set<Session> listeSessionProf = p.getSessions(); 
		Session s = null;
		
		System.out.println("Veuillez choisir la session dont vous voulez consulter les résultats : ");
		while(b)
		{
			try{
				s = (Session) View.choix(listeSessionProf);
				int carac = View.demandeInt("_______MENU 1______\n 1- Visualiser les résultats \n 2- Visualiser les statistiques \n 3- Deconnexion \n \n Choix :");
				switch (carac){
					case 1 : s.visualiserResultat(p); break;
					case 2 : s.statistiques();
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
	
	private void etudiant(Etudiant e){
		boolean b = true;
		while(b)
		{	
			try{
				int carac = View.demandeInt("_______MENU Etudiant______\n 1- Répondre aux QCM \n 2- Visualiser les résultats \n 3- Deconnexion \n \n Choix :");
				switch (carac){
					case 1 : e.choisirSession();break;
					case 2 :
						
						Promotion promo = e.getPromo();
						
						All<Session> listeSession = RechercheDonnees.rechercheSession();
						All<Session> listeSessionPromo = new All<Session>();
						Iterator itSession = listeSession.set.iterator();
						
						while(itSession.hasNext()){
							Session s = (Session) itSession.next();
							if (s.getPromotion().getPromo().equals(promo.getPromo())){
								listeSessionPromo.add(s);
							}
						}
						
						System.out.println("Veuillez choisir la session dont vous voulez consulter les résultats : ");
						Session s = (Session) View.choix(listeSessionPromo.set);
						
						s.visualiserResultat(e);
						break;
					case 3 : b=false; break;				
				default : break;
				}
			}
			catch(IOException ioe){
				System.out.println("Erreur");					
			}				
		}
	}
	
	/**
	 * Constructeur du menu lançant l'authentification ou la fermeture du programme
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
	

