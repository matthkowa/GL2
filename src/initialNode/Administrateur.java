package initialNode;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;


public class Administrateur extends Utilisateur implements Serializable{
	private int id;

	public Administrateur(String nom, String prenom, Date dateNaissance, String adresse, int tel, String pseudo, String motDePasse,int id) {
		super(nom, prenom, dateNaissance, adresse, tel, pseudo, motDePasse);
		this.id=id;
	}
	
	public Administrateur() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void addAdmin(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Entrer le nom du nouvel Administrateur : ");
		String nom = sc.nextLine();
		System.out.println("Entrer le prenom du nouvel Administrateur : ");
		String prenom = sc.nextLine();
		System.out.println("Entrer la date de naissance du nouvel Administrateur (en chiffre) : ");
		System.out.println(" jour : ");
		int jour = sc.nextInt();
		System.out.println("moi : ");
		int moi = sc.nextInt();
		System.out.println("Année : ");
		int annee = sc.nextInt();
		System.out.println("Entrer l'adresse du nouvel Administrateur : ");
		String adresse = sc.next();
		System.out.println("Entrer le tel du nouvel Administrateur : ");
		String telS = sc.next();
		sc.close();
		int tel = Integer.parseInt(telS);
		@SuppressWarnings("deprecation")
		Date naissance = new Date(jour,moi,annee);
		String pseudoA=(nom+prenom).toLowerCase();
		if (pseudoA.length()>10){
			pseudoA = pseudoA.substring(0,9);
		}
		String mdp = "EISTI";
		String s = "Administrateur";

		AllAdmin newAdmin = new AllAdmin();
		newAdmin = (AllAdmin) newAdmin.relecture(s);
		newAdmin.addAdmin(new Administrateur(nom, prenom, naissance, adresse, tel, pseudoA, mdp, newAdmin.administrateurs.size()));
		newAdmin.sauvegarder(s);
	}
	

/*	public void modifAdmin(){
		String s = "Administrateur";
		AllAdmin newAdmin = new AllAdmin();
		newAdmin = (AllAdmin) newAdmin.relecture(s);
		for (Administrateur A : newAdmin.administrateurs){
			System.out.println("coucou");
		}
	}
 */



	

}
