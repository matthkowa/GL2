package main;


import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.NoSuchElementException;

import initialNode.*;


public class Main {
	
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws NoSuchAlgorithmException{
		Administrateur Jean = new Administrateur();
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
			System.err.println("mauvaise entrée");
		}
//		catch (IOException e){
//			System.err.println("mauvaise entrée");
//		}
		
	}
}
