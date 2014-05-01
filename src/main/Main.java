package main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Date;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;



import initialNode.*;


public class Main {
	
	
	public static void main(String[] args) throws NoSuchAlgorithmException{
		Administrateur Jean = new Administrateur("Jean", "Dupont", new Date(1,1,1), null, 0, null, null, 0);
		Jean.addAdmin();
		System.out.println("----Relecture----");
		AllAdmin admin = new AllAdmin();
		admin = (AllAdmin) admin.relecture("Administrateur");
		for (Administrateur A : admin.administrateurs){
			System.out.println(A.getNom()+" / "+A.getPrenom());
		}
		
		
		
	}
}
