package initialNode;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
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
		String s = "Administrateur";

		AllAdmin newAdmin = new AllAdmin();
		newAdmin = (AllAdmin) newAdmin.relecture(s);
		newAdmin.addAdmin(new Administrateur(nom, prenom, naissance, adresse, tel, pseudoA, mdp, newAdmin.administrateurs.size()));
		newAdmin.sauvegarder(s);
	}
	

	public void supAdmin() throws NoSuchElementException{
		String s = "Administrateur";
		AllAdmin newAdmin = new AllAdmin();
		newAdmin = (AllAdmin) newAdmin.relecture(s);
		int i=1;
		List<Administrateur> listeAdmin = new ArrayList<Administrateur>();
		for (Administrateur A : newAdmin.administrateurs){
			listeAdmin.add(A);
		};
		for (Administrateur A : listeAdmin){
			System.out.println(" - "+i+" => "+A);
			i++;			
		}
		Scanner sc2 = new Scanner(System.in);
		System.out.println("Entrer le numéro de l'Administrateur a supprimer : ");
		int num = sc2.nextInt();
		System.out.println("choisi : "+listeAdmin.get(num-1));
		System.out.println("Voulez-vous vraiment supprimer (oui/non) : "+listeAdmin.get(num-1));
		String rep = sc2.next();
		switch(rep){
			case "oui" : newAdmin.administrateurs.remove(listeAdmin.get(num-1));System.out.println("Well done");newAdmin.sauvegarder(s);break;
			default : System.out.println("tant pis");break;
		}
	}
	
	public void addEleve() throws IOException{
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
		switch(promo){
			case 1 :
				promoInit = (Promotion) promoInit.relecture("ING1");
				promoInit.getSetEtudiant().add(new Etudiant(nom, prenom, naissance, adresse, tel, pseudoA, mdp, promoInit.getSetEtudiant().size()));
				promoInit.sauvegarder("ING1");
				break;
			case 2 :
				promoInit = (Promotion) promoInit.relecture("ING2");
				promoInit.getSetEtudiant().add(new Etudiant(nom, prenom, naissance, adresse, tel, pseudoA, mdp, promoInit.getSetEtudiant().size()));
				promoInit.sauvegarder("ING2");
				break;
			case 3 :
				promoInit = (Promotion) promoInit.relecture("ING3");
				promoInit.getSetEtudiant().add(new Etudiant(nom, prenom, naissance, adresse, tel, pseudoA, mdp, promoInit.getSetEtudiant().size()));
				promoInit.sauvegarder("ING3");
				break;
		}
	}

	@Override
	public String toString(){
		String s="";
		s+=this.getNom()+" / ";
		s+=this.getPrenom()+" / ";
		s+=this.getDateNaissance()+" / ";
		s+=this.getAdresse()+" / ";
		s+=this.getTel()+" / ";
		s+=this.getPseudo()+" / ";
		s+=this.getMotDePasse()+" \n ";
		return s;
	}
 



	

}
