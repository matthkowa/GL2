package main;


import initialNode.Professeur;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.NoSuchElementException;


public class Main {
	
	//.
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws NoSuchAlgorithmException, IOException{
		/*Administrateur a = new Administrateur();
		a.addAdmin();*/
		Professeur p = new Professeur();
		p.creerSession();
		Menu m=new Menu();
		//new IHMMenu();
	}
}
