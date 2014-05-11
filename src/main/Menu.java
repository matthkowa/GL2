package main;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import initialNode.*;

public class Menu {
	
	private void authentification(){
		/*A ecrire */
		Authentification aut = new Authentification();/*Creer un constructeur dans authentification */
		
		
			boolean b = true;
			while(b)
			{
				System.out.println("_______MENU 1______\n 1- Administrateur \n 2- Professeur \n 3- Etudiant \n 4- Quitter \n \n Choix :");
				Scanner sc = new Scanner(System.in);
				String str = sc.nextLine();
				char carac = str.charAt(0);
				switch (carac){
				case '1' :	
					Administrateur a =aut.authentificationAdmin(); 
					if (aut.getAutReussi()){
						administrateur();
					}else{
						System.out.println("Retour");
						
					}
					b=false;
				break;
				case '2' :
					/*Professeur p = aut.authentificationProf(); if (aut.getAutReussi()){}else{
			System.out.println("Retour");b=false;
		}*/professeur();b=false;break;
				case '3' :/* Etudiant e = aut.authentificationEtudiant(); if(aut.getAutReussi()){}else{	System.out.println("Retour ");b=false;}
		}*/ etudiant();b=false;break;
				case '4' : b=false; break;
		
				
				default : break;
			}
		}
	}
	
	private void administrateur2(char choix){
		boolean b = true;
		while(b){
			System.out.println("_______MENU ______\n 1- Ajouter \n 2- Modifier \n 3- Supprimer \n 4- Quitter \n \n Choix :");
			Scanner sc = new Scanner(System.in);
			String str = sc.nextLine();
			char carac = str.charAt(0);
			if(carac=='4') b= false; 
			else{
				switch(choix) {
					case '1' : /*Administrateur*/
						switch(carac) { 
						case '1' : /*Ajouter admin*/ 	break;
						case '2' : /*Modifier admin*/  	break;
						case '3' : /*Supprimer admin*/  break;
						}
					break;
					
					case '2' : /*Professeur*/
						switch(carac) { 
						case '1' : /*Ajouter Prof*/ 	break;
						case '2' : /*Modifier Prof*/  	break;
						case '3' : /*Supprimer Prof*/ 	break;
						}
					break;
					case '3' :/*Etudiant*/
						switch(carac) { 
						case '1' : /*Ajouter Etudiant*/ 	break;
						case '2' : /*Modifier Etudiant*/  	break;
						case '3' : /*Supprimer Etudiant*/  	break;
						}
					break;
					case '4' :/*Promotion*/
						switch(carac) { 
						case '1' : /*Ajouter Promo*/ 		break;
						case '2' : /*Modifier Promo*/  		break;
						case '3' : /*Supprimer Promo*/  	break;
						}
					break;
					case '5' :/*Modules*/
						switch(carac) { 
						case '1' : /*Ajouter Modules*/ 		break;
						case '2' : /*Modifier Modules*/  	break;
						case '3' : /*Supprimer Modules*/  	break;
						}
					break;
					default : System.out.println("Erreur veuillez contacter le support"); break;
				}
			}
		}
	}
	
	private void administrateur(){
		Administrateur a = new Administrateur();
		boolean b = true;
		while(b){
			System.out.println("_______MENU 1______\n 1- Gérer les administrateur \n 2- Gérer les professeurs \n 3- Gérer les étudiants \n 4- Gérer les promotions \n 5- Gérer les modules \n 6- Deconnexion \n \n Choix :");
			Scanner sc = new Scanner(System.in);
			String str = sc.nextLine();
			char carac = str.charAt(0);
			if(carac == '1' || carac == '2' || carac == '3' || carac == '4' || carac == '5'){
				administrateur2(carac);
			}
			else{ 
				if(carac == '6') b=false;
			}
			
			
		}
	}
		
		/*Administrateur Jean = new Administrateur();
		try {
//			Jean.addAdmin();
			System.out.println("----Relecture----");
			AllAdmin admin = new AllAdmin();
			admin = (AllAdmin) admin.relecture("Administrateur");
			for (Administrateur A : admin.administrateurs){
				System.out.println(A.getPseudo()+" / "+A.getMin();
		}
		catch (NoSuchElementException e){
			System.err.println("mauvaise entrée");
		}*/
//		catch (IOException e){
//			System.err.println("mauvaise entrée");
//		}
		
		
	
	private void professeur(){
		boolean b = true;
		while(b)
		{
			System.out.println("_______MENU 1______\n 1- Gérer les QCM \n 2- Visualiser les résultats \n 3- Deconnexion \n \n Choix :");
			Scanner sc = new Scanner(System.in);
			String str = sc.nextLine();
			char carac = str.charAt(0);
			switch (carac){
			case '1' : break;
			case '2' : break;			
			case '3' : b=false; break;
	
			
			default : break;
		}
		}
	}
	private void etudiant(){
		boolean b = true;
		while(b)
		{
			System.out.println("_______MENU 1______\n 1- Répondre aux QCM \n 2- Visualiser les résultats \n 3- Deconnexion \n \n Choix :");
			Scanner sc = new Scanner(System.in);
			String str = sc.nextLine();
			char carac = str.charAt(0);
			switch (carac){
			case '1' : break;
			case '2' : break;
			case '3' : b=false; break;
	
			
			default : break;
		}
		}
	}
	public Menu(){
		boolean b = true;
		while(b)
		{
			System.out.println("_______MENU 1______\n 1- S'authentifier \n 2- Quitter \n \n Choix :");
			Scanner sc = new Scanner(System.in);
			String str = sc.nextLine();
			char carac = str.charAt(0);
			switch (carac){
			case '1' : authentification(); break;
			case '2' :b=false; break;
	
			
			default : break;
		}
	}
}
}
