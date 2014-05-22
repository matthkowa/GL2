package main;



import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.NoSuchElementException;

//import view.IHM.IHMMenu;

import model.utilisateur.Professeur;

import controller.MenuController;


public class Main {
	
	//.
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws NoSuchAlgorithmException, IOException{
		/*Administrateur a = new Administrateur();
		a.addMo();*/
		Professeur p = new Professeur();
		p.creerQCM();
	//	MenuController m=new MenuController();
		//new IHMMenu();
				
		
	}
}
