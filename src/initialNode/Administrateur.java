package initialNode;

import helpClass.DonneeUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;


public class Administrateur extends Utilisateur implements Serializable{
	/* Attributs*/
	private static final long serialVersionUID = 1160533610734006110L;
	private int id;

	/**
	 * Constructeur complet utilisant le super-constructeur de Utilisateur
	 * @param nom chaine de caractères
	 * @param prenom chaine de caractères
	 * @param dateNaissance date de naissance sous forme d'objet de type date
	 * @param adresse chaine de caractères
	 * @param tel numéro de teléphone sous forme d'entier
	 * @param pseudo chaine de caractères
	 * @param motDePasse mot de passe sous forme de chaine de caractères
	 * @param id identifiant spécifique de l'administrateur (entier)
	 */
	public Administrateur(String nom, String prenom, Date dateNaissance, String adresse, int tel, String pseudo, String motDePasse,int id) {
		super(nom, prenom, dateNaissance, adresse, tel, pseudo, motDePasse);
		this.id=id;
	}
	
	/**
	 * Constructeur vide
	 */
	public Administrateur() {
		super();
	}
	
	

	 /**
	  * Getter pour id
	  * @return id entier spécifique à chaque administrateur
	  */
	public int getId() {
		return id;
	}
	
	/**
	 * Setter pour id
	  * @param id entier spécifique à chaque administrateur
	  */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Demande d'entrer des données au clavier et créé un objet Administrateur et l'enregistre dans un fichier
	 * @throws IOExectpion
	 */
	public void addAdmin() throws IOException{
		String nom = DonneeUtil.DemandeString("Entrer le nom du nouvel Administrateur : ");
		String prenom = DonneeUtil.DemandeString("Entrer le prenom du nouvel Administrateur : ");
		Date naissance = DonneeUtil.DemandeDate("Entrer la date de naissance du nouvel Administrateur (JJ/MM/YY) : ");
		String adresse = DonneeUtil.DemandeString("Entrer l'adresse du nouvel Administrateur : ");
		int telS = DonneeUtil.DemandeInt("Entrer le tel du nouvel Administrateur : ");
		String pseudoA=(nom+prenom).toLowerCase();
		if (pseudoA.length()>10){
			pseudoA = pseudoA.substring(0,10);
		}
		String mdp = "EISTI";
		
		
		String s = "Utilisateur/Administrateur/Administrateur";
		All<Administrateur> newSet = new All<Administrateur>();
		newSet = (All<Administrateur>) newSet.relecture(s);
		newSet.add(new Administrateur(nom, prenom, naissance, adresse, telS, pseudoA, mdp, newSet.set.size()));
		newSet.sauvegarder(s);
	}
	
	/**
	 * choisi un objet parmi un set d'objets du même type.
	 * @param  set un set d'objet de type T
	 * @return Object un objet de type T
	 * @throws IOException
	 */
	public <T> Object choix(Set<T> set) throws IOException{
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
	
	/**
	 * Supprime un administrateur parmi un set d'administrateurs.
	 * @throws NoSuchElementException
	 * @throws IOException
	 */
	public void supAdmin() throws NoSuchElementException,IOException{
		String s = "Utilisateur/Administrateur/Administrateur";
		All<Administrateur> newSet = new All<Administrateur>();
		newSet = (All<Administrateur>) newSet.relecture(s);
		Administrateur a = (Administrateur)choix(newSet.set);
		System.out.println("Voulez-vous vraiment supprimer (oui/non) : "+a);
		Scanner sc2 = new Scanner(System.in);
		String rep = sc2.next();
		switch(rep){
			case "oui" : newSet.set.remove(a);System.out.println("Well done");newSet.sauvegarder(s);break;
			default : System.out.println("tant pis");break;
		}
	}
	
	/**
	 * Fonction qui demande ce qui doit être modifier chez un utilisateur quelconque
	 * @param newSet set d'administrateur, de professeur ou d'étudiants
	 * @param util administrateur, professeur ou étudiant
	 * @param path chemin vers le fichier de sauvegarde
	 */
	public <T extends Utilisateur> Set<T> modifdonnees(Set<T> newSet,T util,String path){
		Scanner sc2 =  new Scanner(System.in);
		newSet.remove(util);
		int rep2 = 0;
		System.out.println("Que voulez-vous modifier ?");
		System.out.println("1 / Nom");
		System.out.println("2 / Prenom");
		System.out.println("3 / Date de naissance");
		System.out.println("4 / Adresse");
		System.out.println("5 / Telephone");
		System.out.println("6 / Mot de Passe");
		while ((rep2<1) ||(rep2>6)){
			rep2 = sc2.nextInt();
		}
		switch(rep2){
			case 1 : 
				util.setNom(DonneeUtil.DemandeString("Nom : "));
				break;
			case 2 : 
				util.setPrenom(DonneeUtil.DemandeString("Prenom : "));
				break;
			case 3 : 
				util.setDateNaissance(DonneeUtil.DemandeDate("Date de naissance : "));
				break;
			case 4 : 
				util.setAdresse(DonneeUtil.DemandeString("Adresse : "));
				break;
			case 5 : 
				util.setTel(DonneeUtil.DemandeInt("Telephone : "));
				break;
			case 6 : 
				util.setMotDePasse(DonneeUtil.DemandeString("Mot de passe : "));
				break;
		}
		newSet.add(util);
		System.out.println("Well done");
		return newSet;
	}
	
	/**
	 * Modifie un administrateur parmi un set d'administrateurs.
	 * @throws NoSuchElementException
	 * @throws IOException
	 */
	public void modifAdmin() throws NoSuchElementException,IOException{
		String s = "Utilisateur/Administrateur/Administrateur";
		All<Administrateur> newSet = new All<Administrateur>();
		newSet = (All<Administrateur>) newSet.relecture(s);
		Administrateur a = (Administrateur)choix(newSet.set);
		System.out.println("Voulez-vous vraiment modifier (oui/non) : "+a);
		Scanner sc2 = new Scanner(System.in);
		String rep = sc2.next();
		switch(rep){
			case "oui" : 
				newSet.set = this.modifdonnees(newSet.set, a, s);
				newSet.sauvegarder(s);
				break;
			default : System.out.println("tant pis");break;
		}
	}
	
	
	/**
	 * Demande d'entrer des données au clavier et créé un objet Professeur et l'enregistre dans un fichier
	 * @throws IOExectpion
	 */
	public void addProf() throws IOException{
		String nom = DonneeUtil.DemandeString("Entrer le nom du nouveau professeur : ");
		String prenom = DonneeUtil.DemandeString("Entrer le prenom du nouveau professeur : ");
		Date naissance = DonneeUtil.DemandeDate("Entrer la date de naissance du nouveau professeur (JJ/MM/YY) : ");
		String adresse = DonneeUtil.DemandeString("Entrer l'adresse du nouveau professeur : ");
		int telS = DonneeUtil.DemandeInt("Entrer le tel du nouveau professeur : ");
		String pseudoA=(nom+prenom).toLowerCase();
		if (pseudoA.length()>10){
			pseudoA = pseudoA.substring(0,10);
		}
		String mdp = "EISTI";
		String s = "Utilisateur/Professeur/Professeur";

		All<Professeur> newSet = new All<Professeur>();
		//newSet = (All<Professeur>) newSet.relecture(s);
		newSet.add(new Professeur(nom, prenom, naissance, adresse, telS, pseudoA, mdp, newSet.set.size(), null));
		newSet.sauvegarder(s);
	}
	
	/**
	 * Supprime un professeur parmi un set de professeurs.
	 * @throws NoSuchElementException
	 * @throws IOException
	 */
	public void supProf() throws NoSuchElementException,IOException{
		String s = "Utilisateur/Professeur/Professeur";
		All<Professeur> newSet = new All<Professeur>();
		newSet = (All<Professeur>) newSet.relecture(s);
		Professeur a = (Professeur)choix(newSet.set);
		System.out.println("Voulez-vous vraiment supprimer (oui/non) : "+a);
		Scanner sc2 = new Scanner(System.in);
		String rep = sc2.next();
		switch(rep){
			case "oui" : newSet.set.remove(a);System.out.println("Well done");newSet.sauvegarder(s);break;
			default : System.out.println("tant pis");break;
		}
	}
	
	/**
	 * Modifie un professeur parmi un set de professeurs.
	 * @throws NoSuchElementException
	 * @throws IOException
	 */
	public void modifProf() throws NoSuchElementException,IOException{
		String s = "Utilisateur/Professeur/Professeur";
		All<Professeur> newSet = new All<Professeur>();
		newSet = (All<Professeur>) newSet.relecture(s);
		Professeur p = (Professeur)choix(newSet.set);
		System.out.println("Voulez-vous vraiment modifier (oui/non) : "+p);
		Scanner sc2 = new Scanner(System.in);
		String rep = sc2.next();
		switch(rep){
			case "oui" : 
				newSet.set = this.modifdonnees(newSet.set, p, s);
				newSet.sauvegarder(s);
				break;
			default : System.out.println("tant pis");break;
		}
	}
	
	/**
	 * Demande d'entrer des données au clavier et créé un objet étudiant et l'enregistre dans un fichier
	 * @throws IOException
	 */
	public void addEleve() throws NoSuchElementException,IOException{
		String nom = DonneeUtil.DemandeString("Entrer le nom du nouvel étudiant : ");
		String prenom = DonneeUtil.DemandeString("Entrer le prenom du nouvel étudiant : ");
		Date naissance = DonneeUtil.DemandeDate("Entrer la date de naissance du nouvel étudiant (JJ/MM/YY) : ");
		String adresse = DonneeUtil.DemandeString("Entrer l'adresse du nouvel étudiant : ");
		int telS = DonneeUtil.DemandeInt("Entrer le tel du nouvel étudiant : ");
		String pseudoA=(nom+prenom).toLowerCase();
		if (pseudoA.length()>10){
			pseudoA = pseudoA.substring(0,10);
		}
		String mdp = "EISTI";

		Scanner sc = new Scanner(System.in);
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
		promoInit = (Promotion) promoInit.relecture(path);
		promoInit.getSetEtudiant().add(new Etudiant(nom, prenom, naissance, adresse, telS, pseudoA, mdp, promoInit.getSetEtudiant().size()));
		promoInit.sauvegarder(path);
	}
	
	/**
	 * Supprime un étudiant parmi un set d'étudiants.
	 * @throws NoSuchElementException
	 * @throws IOException
	 */
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
 
	
	/**
	 * Modifie un étudiant parmi un set d'étudiants.
	 * @throws NoSuchElementException
	 * @throws IOException
	 */
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
				promo.setSetEtudiant(this.modifdonnees(promo.getSetEtudiant(), etu, s));
				promo.sauvegarder(s);
				break;
			default : System.out.println("tant pis");break;
		}
	}
	
}
