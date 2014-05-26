package model.utilisateur;

import view.menu.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

import model.RechercheDonnees;


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
	 * Fonction qui demande ce qui doit être modifier chez un utilisateur quelconque
	 * @param newSet set d'administrateur, de professeur ou d'étudiants
	 * @param util administrateur, professeur ou étudiant
	 * @param path chemin vers le fichier de sauvegarde
	 * @throws IOException 
	 */
	public <T extends Utilisateur> Set<T> modifdonnees(Set<T> newSet,T util,String path) throws IOException{
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
		if (util instanceof Professeur){
			System.out.println("7 / Module");
		}
		while ((rep2<1) ||(rep2>7)){
			rep2 = sc2.nextInt();
		}
		switch(rep2){
			case 1 : 
				util.setNom(View.demandeString("Nom : "));
				break;
			case 2 : 
				util.setPrenom(View.demandeString("Prenom : "));
				break;
			case 3 : 
				util.setDateNaissance(View.demandeDate("Date de naissance : "));
				break;
			case 4 : 
				util.setAdresse(View.demandeString("Adresse : "));
				break;
			case 5 : 
				util.setTel(View.demandeInt("Telephone : "));
				break;
			case 6 : 
				util.setMotDePasse(View.demandeString("Mot de passe : "));
				break;
			case 7 :
				if (util instanceof Professeur){
					System.out.println("Les modules ont été supprimés.");
					Set<Module> modprof = new HashSet<Module>();
					Module mod = new Module();
					boolean rep=true;
					while (rep){
						System.out.println("Entrer un module nouveau pour le professeur");
						All<Module> modules = new All<Module>();
						modules = (All<Module>) modules.relecture("Module/Module");
						mod = (Module)View.choix(modules.getSet());
						if (mod==null){
							newSet.add(util);
							return newSet;
						}
						modprof.add(mod);
						rep = View.demandeBoolean("Voulez vous-entrer d'autres modules (oui/non)");
					}
					((Professeur) util).setModules(modprof);
				}
				else{
					newSet.add(util);
					newSet = this.modifdonnees(newSet, util, path);
				}
		}
		newSet.add(util);
		System.out.println("Well done");
		return newSet;
	}
	
	
	
	/**
	 * Supprime un administrateur parmi un set d'administrateurs.
	 * @throws NoSuchElementException
	 * @throws IOException
	 */
	public void supAdmin() throws NoSuchElementException,IOException{
		String s = "Utilisateur/Administrateur/Administrateur";
		All<Administrateur> newSet = RechercheDonnees.rechercheAdmin();
		Administrateur a = (Administrateur)View.choix(newSet.set);
		if (a==null){
			return;
		}
		System.out.println("Voulez-vous vraiment supprimer (oui/non) : "+a);
		Scanner sc2 = new Scanner(System.in);
		String rep = sc2.next();
		switch(rep){
			case "oui" : newSet.set.remove(a);System.out.println("Well done");newSet.sauvegarder(s);break;
			default : System.out.println("tant pis");break;
		}
	}
	
	
	/**
	 * Demande d'entrer des données au clavier et créé un objet Administrateur et l'enregistre dans un fichier
	 * @throws IOExectpion
	 */
	public void addAdmin() throws IOException{
		String nom = View.demandeString("Entrer le nom du nouvel Administrateur : ");
		String prenom = View.demandeString("Entrer le prenom du nouvel Administrateur : ");
		Date naissance = View.demandeDate("Entrer la date de naissance du nouvel Administrateur (JJ/MM/YY) : ");
		String adresse = View.demandeString("Entrer l'adresse du nouvel Administrateur : ");
		int telS = View.demandeInt("Entrer le tel du nouvel Administrateur : ");
		String pseudoA=(nom+prenom).toLowerCase();
		if (pseudoA.length()>10){
			pseudoA = pseudoA.substring(0,10);
		}
		String mdp = "EISTI";
		
		
		String s = "Utilisateur/Administrateur/Administrateur";
		All<Administrateur> newSet = RechercheDonnees.rechercheAdmin();
		newSet.add(new Administrateur(nom, prenom, naissance, adresse, telS, pseudoA, mdp, newSet.set.size()));
		newSet.sauvegarder(s);
	}	
		
	/**
	 * Modifie un administrateur parmi un set d'administrateurs.
	 * @throws NoSuchElementException
	 * @throws IOException
	 */
	public void modifAdmin() throws NoSuchElementException,IOException{
		String s = "Utilisateur/Administrateur/Administrateur";
		All<Administrateur> newSet = RechercheDonnees.rechercheAdmin();
		Administrateur a = (Administrateur)View.choix(newSet.set);
		if (a==null){
			return;
		}
		String rep = View.demandeString("Voulez-vous vraiment modifier (oui/non) : "+a);
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
		String nom = View.demandeString("Entrer le nom du nouveau professeur : ");
		String prenom = View.demandeString("Entrer le prenom du nouveau professeur : ");
		Date naissance = View.demandeDate("Entrer la date de naissance du nouveau professeur (JJ/MM/YY) : ");
		String adresse = View.demandeString("Entrer l'adresse du nouveau professeur : ");
		int telS = View.demandeInt("Entrer le tel du nouveau professeur : ");
		String pseudoA=(nom+prenom).toLowerCase();
		if (pseudoA.length()>10){
			pseudoA = pseudoA.substring(0,10);
		}
		String mdp = "EISTI";
		boolean rep = true;
		Set<Module> modprof = new HashSet();
		Module mod = new Module();
		while (rep){
			System.out.println("Entrer un module pour le professeur");
			All<Module> modules = RechercheDonnees.rechercheModule();
			mod = (Module)View.choix(modules.getSet());
			if (mod==null){
				return;
			}
			modprof.add(mod);
			rep = View.demandeBoolean("Voulez vous-entrer d'autres modules");
		}
		String s = "Utilisateur/Professeur/Professeur";

		All<Professeur> newSet = RechercheDonnees.rechercheProf();
		newSet.add(new Professeur(nom, prenom, naissance, adresse, telS, pseudoA, mdp, newSet.set.size(), modprof));
		newSet.sauvegarder(s);
	}
	
	/**
	 * Supprime un professeur parmi un set de professeurs.
	 * @throws NoSuchElementException
	 * @throws IOException
	 */
	public void supProf() throws NoSuchElementException,IOException{
		String s = "Utilisateur/Professeur/Professeur";
		All<Professeur> newSet = RechercheDonnees.rechercheProf();
		Professeur a = (Professeur)View.choix(newSet.set);
		if (a==null){
			return;
		}
		String rep = View.demandeString("Voulez-vous vraiment supprimer (oui/non) : "+a);
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
		All<Professeur> newSet = RechercheDonnees.rechercheProf();
		Professeur p = (Professeur)View.choix(newSet.set);
		if (p==null){
			return;
		}
		System.out.println("Voulez-vous vraiment modifier (oui/non) : "+p);
		String rep = (new Scanner(System.in)).next();
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
		String nom = View.demandeString("Entrer le nom du nouvel étudiant : ");
		String prenom = View.demandeString("Entrer le prenom du nouvel étudiant : ");
		Date naissance = View.demandeDate("Entrer la date de naissance du nouvel étudiant (JJ/MM/YY) : ");
		String adresse = View.demandeString("Entrer l'adresse du nouvel étudiant : ");
		int telS = View.demandeInt("Entrer le tel du nouvel étudiant : ");
		String pseudoA=(nom+prenom).toLowerCase();
		if (pseudoA.length()>10){
			pseudoA = pseudoA.substring(0,10);
		}
		String mdp = "EISTI";

		String path = "Utilisateur/Etudiant/promotion";
		All<Promotion> newPromo = RechercheDonnees.recherchePromo();
		if(newPromo==null){
		System.out.println("Aucune promotion créée");
		}else{
		Promotion promo = (Promotion)View.choix(newPromo.getSet());
		if (promo==null){
			return;
		}
		newPromo.remove(promo);
		promo.getSetEtudiant().add(new Etudiant(nom, prenom, naissance, adresse, telS, pseudoA, mdp, promo.getSetEtudiant().size()));
		newPromo.add(promo);
		newPromo.sauvegarder(path);
		}
	}
	
	/**
	 * Supprime un étudiant parmi un set d'étudiants.
	 * @throws NoSuchElementException
	 * @throws IOException
	 */
	public void supEleve() throws NoSuchElementException,IOException{
		String s = "";
		String path = "Utilisateur/Etudiant/promotion";
		All<Promotion> newPromo = RechercheDonnees.recherchePromo();
		Promotion promo = (Promotion)View.choix(newPromo.getSet());
		if (promo==null){
			return;
		}
		Etudiant etu = (Etudiant) View.choix(promo.getSetEtudiant());
		if (etu==null){
			return;
		}
		System.out.println("Voulez-vous vraiment supprimer (oui/non) : "+etu);
		String rep = (new Scanner(System.in)).next();
		switch(rep){
			case "oui" : 
				newPromo.remove(promo);
				promo.getSetEtudiant().remove(etu);
				newPromo.add(promo);
				newPromo.sauvegarder(s);
				break;
			default : 
				System.out.println("tant pis");
				break;
		}
	}
 
	
	/**
	 * Modifie un étudiant parmi un set d'étudiants.
	 * @throws IOException
	 */
	public void modifEleve() throws IOException{
		String path = "Utilisateur/Etudiant/promotion";
		All<Promotion> newPromo = RechercheDonnees.recherchePromo();
		Promotion promo = (Promotion) View.choix(newPromo.getSet());
		if (promo==null){
			return;
		}
		Etudiant etu = (Etudiant) View.choix(promo.getSetEtudiant());
		if (etu==null){
			return;
		}
		System.out.println("Voulez-vous vraiment modifier (oui/non) : "+etu);
		String rep = (new Scanner(System.in)).next();
		switch(rep){
			case "oui" : 
				promo.setSetEtudiant(this.modifdonnees(promo.getSetEtudiant(), etu, path));
				promo.sauvegarder(path);
				break;
			default : System.out.println("tant pis");break;
		}
	}
	
	/**
	 * Fonction qui demande à l'utilisateur de rentrer les données d'un module et l'enregistre dans un fichier
	 */
	public void addModule(){
		try
		{
			String nom = View.demandeString("Entrer le nom du nouveau module : ");
			String path = "Module/Module";
			All<Module> modules = RechercheDonnees.rechercheModule();
			modules.set.add(new Module(modules.getSet().size(), nom));
			modules.sauvegarder(path);
		}
		catch(IOException e)
		{
			System.out.println("Erreur lors de la création du module.");
		}
	}
	
	/**
	 * Supprime un module parmi un set de modules.
	 * @throws IOException
	 */
	public void supModule() throws IOException{
		String path = "Module/Module";
		All<Module> modules = RechercheDonnees.rechercheModule();
		Module mod = (Module) View.choix(modules.getSet());
		if (mod==null){
			return;
		}
		System.out.println("Voulez-vous vraiment supprimer (oui/non) : "+mod);
		String rep = (new Scanner(System.in)).next();
		switch(rep){
			case "oui" : 
				modules.set.remove(mod);
				modules.sauvegarder(path);
				break;
			default : System.out.println("tant pis");break;
		}
	}
	
	/**
	 * Modifie un module parmi un set de modules.
	 * @throws IOException
	 */
	public void modifModule() throws IOException{
		String path = "Module/Module";
		All<Module> modules = RechercheDonnees.rechercheModule();
		Module mod = (Module) View.choix(modules.getSet());
		if (mod==null){
			return;
		}
		System.out.println("Voulez-vous vraiment modifier (oui/non) : "+mod);
		String rep = (new Scanner(System.in)).next();
		switch(rep){
			case "oui" :
				modules.set.remove(mod);
				mod.setNom(View.demandeString("Entrer le nouveau nom du module : "+mod.getNom()));
				modules.add(mod);
				modules.sauvegarder(path);
				break;
			default : System.out.println("tant pis");break;
		}
	}
	
	/**
	 * Fonction qui demande à l'utilisateur d'entrer des données pour créer et enregistrer une promotion
	 */
	public void addPromo(){
		try
		{
			String nomPromo = View.demandeString("Entrer le nom de la nouvelle promo : ");
			String path = "Utilisateur/Etudiant/promotion";
			Promotion promoInit = new Promotion(new HashSet<Etudiant>(),nomPromo);
			All<Promotion> newPromo = RechercheDonnees.recherchePromo();
			newPromo.add(promoInit);
			newPromo.sauvegarder(path);
		}
		catch(IOException e)
		{
			System.out.println("Erreur lors de la création de la promotion.");
		}
	}
	
	/**
	 * Fonction qui supprime une promotion parmi une liste de promotion.
	 * @throws IOException
	 */
	public void supPromo() throws IOException{
		All<Promotion> newPromo = RechercheDonnees.recherchePromo();
		Promotion promo = (Promotion)View.choix(newPromo.getSet());
		if (promo==null){
			return;
		}
		System.out.println("Voulez-vous vraiment supprimer (oui/non) : "+promo);
		String rep = (new Scanner(System.in)).next();
		switch(rep){
			case "oui" : 
				newPromo.set.remove(promo);
				newPromo.sauvegarder("Utilisateur/Etudiant/promotion");
				System.out.println("Well Done!");
				break;
			default : System.out.println("tant pis");break;
		}
	}
	
}
