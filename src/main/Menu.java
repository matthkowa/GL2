package main;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import initialNode.*;

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
		Administrateur a = new Administrateur();
		boolean b = true;
		while(b){
			System.out.println("_______MENU 1______\n 1- Ajouter un utilisateur/modules/promo \n 2- Modifier un utilisateur/modules/promo \n 3- Supprimer \n 4- Quitter \n \n Choix :");
			Scanner sc = new Scanner(System.in);
			String str = sc.nextLine();
			char carac = str.charAt(0);
			switch (carac){
			case '1' : 
				try {
					a.addAdmin();
				}
				catch (NoSuchElementException e){
					System.err.println("mauvaise entr�e");
				}
				catch (IOException e){
					System.err.println("mauvaise entr�e");
					}
				System.out.println("Done!");
				break;
			case '2' : break;
			case '3' :
				try {
					a.supAdmin();
				}
				catch (NoSuchElementException e){
					System.err.println("mauvaise entr�e");
				}
				System.out.println("Done!");
				break;
			case '4' : b=false; break;
			default : break;
			}
		}
		
		/*Administrateur Jean = new Administrateur();
		try {
//			Jean.addAdmin();
			System.out.println("----Relecture----");
			AllAdmin admin = new AllAdmin();
			admin = (AllAdmin) admin.relecture("Administrateur");
			for (Administrateur A : admin.administrateurs){
				System.out.println(A.getNom()+" / "+A.getPrenom());
			}
			Jean.supAdmin();
		}
		catch (NoSuchElementException e){
			System.err.println("mauvaise entr�e");
		}*/
//		catch (IOException e){
//			System.err.println("mauvaise entr�e");
//		}
		
		
	}
	private void Professeur(){
		boolean b = true;
		while(b)
		{
			System.out.println("_______MENU 1______\n 1- G�rer les QCM \n 2- Visualiser les r�sultats \n 3- Quitter \n \n Choix :");
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
			System.out.println("_______MENU 1______\n 1- R�pondre aux QCM \n 2- Visualiser les r�sultats \n 3- Quitter \n \n Choix :");
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
