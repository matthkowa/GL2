package initialNode;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;


public class Administrateur extends Utilisateur implements Serializable{
	private static final long serialVersionUID = 1160533610734006110L;
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
	
	public void addAdmin() throws IOException{
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
		int tel = Integer.parseInt(telS);

		@SuppressWarnings("deprecation")
		Date naissance = new Date(annee,moi-1,jour);
		String pseudoA=(nom+prenom).toLowerCase();
		if (pseudoA.length()>10){
			pseudoA = pseudoA.substring(0,9);
		}
		String mdp = "EISTI";
		String s = "Utilisateur/Administrateur/Administrateur";

		AllAdmin newAdmin = new AllAdmin();
		//newAdmin = (AllAdmin) newAdmin.relecture(s);
		newAdmin.addAdmin(new Administrateur(nom, prenom, naissance, adresse, tel, pseudoA, mdp, newAdmin.administrateurs.size()));
		newAdmin.sauvegarder(s);
	}
	
	
	public <T> Object choix(Set<T> set){
		int i=1;
		List<Object> liste = new ArrayList<Object>();
		for (Object A : set){
			liste.add(A);
		};
		for (Object A : liste){
			System.out.println(" - "+i+" => "+A);
			i++;			
		}
		Scanner sc2 = new Scanner(System.in);
		int num = 0;
		while(num<1 || num>liste.size()){
			System.out.println("Entrer le numéro de l'Administrateur a supprimer : ");
			num = sc2.nextInt();
		}
		return liste.get(num-1);
	}
	

	public void supAdmin() throws NoSuchElementException{
		String s = "Utilisateur/Administrateur/Administrateur";
		AllAdmin newAdmin = new AllAdmin();
		newAdmin = (AllAdmin) newAdmin.relecture(s);
		Administrateur a = (Administrateur)choix(newAdmin.administrateurs);
		System.out.println("Voulez-vous vraiment supprimer (oui/non) : "+a);
		Scanner sc2 = new Scanner(System.in);
		String rep = sc2.next();
		switch(rep){
			case "oui" : newAdmin.administrateurs.remove(a);System.out.println("Well done");newAdmin.sauvegarder(s);break;
			default : System.out.println("tant pis");break;
		}
	}
	
	public void modifAdmin() throws NoSuchElementException,IOException{
		String s = "Utilisateur/Administrateur/Administrateur";
		AllAdmin newAdmin = new AllAdmin();
		newAdmin = (AllAdmin) newAdmin.relecture(s);
		Administrateur a = (Administrateur)choix(newAdmin.administrateurs);
		System.out.println("Voulez-vous vraiment modifier (oui/non) : "+a);
		Scanner sc2 = new Scanner(System.in);
		String rep = sc2.next();
		switch(rep){
			case "oui" : 
				newAdmin.administrateurs.remove(a);
				int rep2 = 0;
				System.out.println("Que voulez-vous modifier ?");
				System.out.println("1 / Nom");
				System.out.println("2 / Prenom");
				System.out.println("3 / Date de naissance");
				System.out.println("4 / Adresse");
				System.out.println("5 / Telephone");
				System.out.println("6 / Mot de Passe");
				rep2 = sc2.nextInt();
				switch(rep2){
					case 1 : 
						a.setNom(sc2.nextLine());
						break;
					case 2 : 
						a.setPrenom(sc2.nextLine());
						break;
					case 3 : 
						System.out.println(" jour : ");
						int jour = sc2.nextInt();
						System.out.println("moi : ");
						int moi = sc2.nextInt();
						System.out.println("Année : ");
						int annee = sc2.nextInt();
						Date naissance = new Date(annee,moi-1,jour);
						a.setDateNaissance(naissance);
						break;
					case 4 : 
						a.setAdresse(sc2.nextLine());
						break;
					case 5 : 
						a.setTel(sc2.nextInt());
						break;
					case 6 : 
						a.setMotDePasse(sc2.nextLine());
						break;
				}
				newAdmin.administrateurs.add(a);
				System.out.println("Well done");
				newAdmin.sauvegarder(s);
				break;
			default : System.out.println("tant pis");break;
		}
	}
	
	public void modifEleve() throws NoSuchElementException,IOException{
		String s = "";
		Scanner sc2 = new Scanner(System.in);
		int num = 0;
		while(num<1 || num>3){
			System.out.println("A quelle promo appartient-il ?");
			System.out.println("1 / ING1");
			System.out.println("2 / ING2");
			System.out.println("3 / ING3");
			num = sc2.nextInt();
		}
		switch(num){
		case 1 : s +="Utilisateur/Etudiant/ING1";break;
		case 2 : s +="Utilisateur/Etudiant/ING2";break;
		case 3 : s +="Utilisateur/Etudiant/ING3";break;
		}
		Promotion promo = new Promotion();
		promo = (Promotion) promo.relecture(s);
		Etudiant etu = (Etudiant) choix(promo.getSetEtudiant());
		System.out.println("Voulez-vous vraiment modifier (oui/non) : "+etu);
		String rep = sc2.next();
		switch(rep){
			case "oui" : 
				promo.setEtudiant.remove(etu);
				int rep2 = 0;
				System.out.println("Que voulez-vous modifier ?");
				System.out.println("1 / Nom");
				System.out.println("2 / Prenom");
				System.out.println("3 / Date de naissance");
				System.out.println("4 / Adresse");
				System.out.println("5 / Telephone");
				System.out.println("6 / Mot de Passe");
				rep2 = sc2.nextInt();
				switch(rep2){
					case 1 : 
						etu.setNom(sc2.nextLine());
						break;
					case 2 : 
						etu.setPrenom(sc2.nextLine());
						break;
					case 3 : 
						System.out.println(" jour : ");
						int jour = sc2.nextInt();
						System.out.println("mois : ");
						int moi = sc2.nextInt();
						System.out.println("Année : ");
						int annee = sc2.nextInt();
						Date naissance = new Date(annee,moi-1,jour);
						etu.setDateNaissance(naissance);
						break;
					case 4 : 
						etu.setAdresse(sc2.nextLine());
						break;
					case 5 : 
						etu.setTel(sc2.nextInt());
						break;
					case 6 : 
						etu.setMotDePasse(sc2.nextLine());
						break;
				}
				promo.setEtudiant.add(etu);
				System.out.println("Well done");
				promo.sauvegarder(s);
				break;
			default : System.out.println("tant pis");break;
		}
	}
	
	public void supEleve() throws NoSuchElementException,IOException{
		String s = "";
		Scanner sc2 = new Scanner(System.in);
		int num = 0;
		while(num<1 || num>3){
			System.out.println("A quelle promo appartient-il ?");
			System.out.println("1 / ING1");
			System.out.println("2 / ING2");
			System.out.println("3 / ING3");
			num = sc2.nextInt();
		}
		switch(num){
		case 1 : s +="Utilisateur/Etudiant/ING1";break;
		case 2 : s +="Utilisateur/Etudiant/ING2";break;
		case 3 : s +="Utilisateur/Etudiant/ING3";break;
		}
		Promotion promo = new Promotion();
		promo = (Promotion) promo.relecture(s);
		Etudiant etu = (Etudiant) choix(promo.getSetEtudiant());
		System.out.println("Voulez-vous vraiment modifier (oui/non) : "+etu);
		String rep = sc2.next();
		switch(rep){
			case "oui" : 
				promo.setEtudiant.remove(etu);
				break;
			default : 
				System.out.println("tant pis");
				break;
		}
	}
	
	
	public void addEleve() throws NoSuchElementException,IOException{
		Scanner sc = new Scanner(System.in);
		System.out.println("Entrer le nom du nouvel élève : ");
		String nom = sc.nextLine();
		System.out.println("Entrer le prenom du nouvel élève : ");
		String prenom = sc.nextLine();
		System.out.println("Entrer la date de naissance du nouvel élève (en chiffre) : ");
		System.out.println(" jour : ");
		int jour = sc.nextInt();
		System.out.println("moi : ");
		int moi = sc.nextInt();
		System.out.println("Année : ");
		int annee = sc.nextInt();
		System.out.println("Entrer l'adresse du nouvel élève : ");
		String adresse = sc.next();
		System.out.println("Entrer le tel du nouvel élève : ");
		String telS = sc.next();
		int tel = Integer.parseInt(telS);

		@SuppressWarnings("deprecation")
		Date naissance = new Date(annee,moi-1,jour);
		String pseudoA=(nom+prenom).toLowerCase();
		if (pseudoA.length()>10){
			pseudoA = pseudoA.substring(0,9);
		}
		String mdp = "EISTI";
		String s = "Administrateur";

		System.out.println("Entrer la promo du nouvel élève : ");
		System.out.println("1 / ING1");
		System.out.println("2 / ING2");
		System.out.println("3 / ING3");
		int promo = 0;
		while (promo<1 || promo>3){
			promo = sc.nextInt();
		}
		Promotion promoInit = new Promotion();
		String path = "Utilisateur/Etudiant/";
		switch(promo){
			case 1 : path+="ING1";break;
			case 2 : path+="ING2";break;
			case 3 : path+="ING3";break;
		}
		promoInit = (Promotion) promoInit.relecture(s);
		promoInit.getSetEtudiant().add(new Etudiant(nom, prenom, naissance, adresse, tel, pseudoA, mdp, promoInit.getSetEtudiant().size()));
		promoInit.sauvegarder(s);
	}
 



	

}
