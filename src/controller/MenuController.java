package controller;
import initialNode.Administrateur;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import view.menu.View;

public class MenuController {
	
	
	
		
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
		
		private void administrateur2(char choix,Administrateur a){
			try{
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
								case '1' : a.addAdmin(); 	break;
								case '2' : a.modifAdmin();  	break;
								case '3' : a.supAdmin();  break;
								}
							break;
							
							case '2' : /*Professeur*/
								switch(carac) { 
								case '1' : a.addProf(); 	break;
								case '2' : a.modifProf();  	break;
								case '3' : a.supProf(); 	break;
								}
							break;
							case '3' :/*Etudiant*/
								switch(carac) { 
								case '1' : a.addEleve(); 	break;
								case '2' : a.modifEleve();  	break;
								case '3' : a.supEleve();  	break;
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
								case '1' : a.addModule(); 		break;
								case '2' : a.modifModule();  	break;
								case '3' : a.supModule();  	break;
								}
							break;
							default : System.out.println("Erreur veuillez contacter le support"); break;
						}
					}
				}
		}catch(IOException e){
				System.err.println("Probl�me : " + e);
			}
		}
		
		private void administrateur(){
			Administrateur a = new Administrateur();
			boolean b = true;
			while(b){
				System.out.println("_______MENU 1______\n 1- G�rer les administrateur \n 2- G�rer les professeurs \n 3- G�rer les �tudiants \n 4- G�rer les promotions \n 5- G�rer les modules \n 6- Deconnexion \n \n Choix :");
				Scanner sc = new Scanner(System.in);
				String str = sc.nextLine();
				char carac = str.charAt(0);
				if(carac == '1' || carac == '2' || carac == '3' || carac == '4' || carac == '5'){
					administrateur2(carac,a);
				}
				else{ 
					if(carac == '6') b=false;
				}
				
				
			}
		}
			
			
		
		private void professeur(){
			boolean b = true;
			while(b)
			{
				System.out.println("_______MENU 1______\n 1- G�rer les QCM \n 2- Visualiser les r�sultats \n 3- Deconnexion \n \n Choix :");
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
				System.out.println("_______MENU 1______\n 1- R�pondre aux QCM \n 2- Visualiser les r�sultats \n 3- Deconnexion \n \n Choix :");
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
	

