package main;

import java.util.Scanner;

public class Menu {
	
	private void authentification(){
		/*A ecrire */
		boolean b = true;
		while(b)
		{
			System.out.println("_______MENU 1______\n 1- Administrateur \n 2- Professeur \n 3- Etudiant \n 4- Quitter \n \n Choix :");
			Scanner sc = new Scanner(System.in);
			String str = sc.nextLine();
			char carac = str.charAt(0);
			switch (carac){
			case '1' : Administrateur();break;
			case '2' : Professeur();break;
			case '3' : Etudiant();break;
			case '4' : b=false; break;
	
			
			default : break;
		}
	}
	}
	private void Administrateur(){
		boolean b = true;
		while(b)
		{
			System.out.println("_______MENU 1______\n 1- Ajouter un utilisateur/modules/promo \n 2- Modifier un utilisateur/modules/promo \n 3- Supprimer \n 4- Quitter \n \n Choix :");
			Scanner sc = new Scanner(System.in);
			String str = sc.nextLine();
			char carac = str.charAt(0);
			switch (carac){
			case '1' : break;
			case '2' : break;
			case '3' : break;
			case '4' : b=false; break;
	
			
			default : break;
		}
	}
	}
	private void Professeur(){
		boolean b = true;
		while(b)
		{
			System.out.println("_______MENU 1______\n 1- Gérer les QCM \n 2- Visualiser les résultats \n 3- Quitter \n \n Choix :");
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
	private void Etudiant(){
		boolean b = true;
		while(b)
		{
			System.out.println("_______MENU 1______\n 1- Répondre aux QCM \n 2- Visualiser les résultats \n 3- Quitter \n \n Choix :");
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
