package main;

import java.util.Calendar;
import java.util.Date;

import initialNode.*;


public class Main {
	public static void main(String[] args) {
		Administrateur Jean = new Administrateur("Jean", "Dupont", new Date(1,1,1), null, 0, null, null, 0);
		Jean.addAdmin();
		System.out.println("----Relecture----");
		AllAdmin admin = new AllAdmin();
		admin.relecture("Administrateur");
		for (Administrateur A : admin.administrateurs){
			System.out.println(A.getNom()+" / "+A.getPrenom());
		}

	}

}
