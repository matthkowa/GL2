package initialNode;

import helpClass.DonneeUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
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
	 * @param nom chaine de caract�res
	 * @param prenom chaine de caract�res
	 * @param dateNaissance date de naissance sous forme d'objet de type date
	 * @param adresse chaine de caract�res
	 * @param tel num�ro de tel�phone sous forme d'entier
	 * @param pseudo chaine de caract�res
	 * @param motDePasse mot de passe sous forme de chaine de caract�res
	 * @param id identifiant sp�cifique de l'administrateur (entier)
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
	  * @return id entier sp�cifique � chaque administrateur
	  */
	public int getId() {
		return id;
	}
	
	/**
	 * Setter pour id
	  * @param id entier sp�cifique � chaque administrateur
	  */
	public void setId(int id) {
		this.id = id;
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
		Administrateur a = (Administrateur)DonneeUtil.choix(newSet.set);
		System.out.println("Voulez-vous vraiment supprimer (oui/non) : "+a);
		Scanner sc2 = new Scanner(System.in);
		String rep = sc2.next();
		switch(rep){
			case "oui" : newSet.set.remove(a);System.out.println("Well done");newSet.sauvegarder(s);break;
			default : System.out.println("tant pis");break;
		}
	}
	
	/**
	 * Fonction qui demande ce qui doit �tre modifier chez un utilisateur quelconque
	 * @param newSet set d'administrateur, de professeur ou d'�tudiants
	 * @param util administrateur, professeur ou �tudiant
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
				util.setNom(DonneeUtil.demandeString("Nom : "));
				break;
			case 2 : 
				util.setPrenom(DonneeUtil.demandeString("Prenom : "));
				break;
			case 3 : 
				util.setDateNaissance(DonneeUtil.demandeDate("Date de naissance : "));
				break;
			case 4 : 
				util.setAdresse(DonneeUtil.demandeString("Adresse : "));
				break;
			case 5 : 
				util.setTel(DonneeUtil.demandeInt("Telephone : "));
				break;
			case 6 : 
				util.setMotDePasse(DonneeUtil.demandeString("Mot de passe : "));
				break;
			case 7 :
				if (util instanceof Professeur){
					Set<Module> modprof = new HashSet<Module>();
					Module mod = new Module();
					String rep = "oui";
					while (rep=="oui"){
						System.out.println("Entrer un module pour le professeur");
						All<Module> modules = new All<Module>();
						modules = (All<Module>) modules.relecture("Module/Module");
						mod = (Module)DonneeUtil.choix(modules.getSet());
						modprof.add(mod);
						System.out.println("Voulez vous-entrer d'autres modules (oui/non)");
						rep = (new Scanner(System.in)).nextLine();
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
	 * Demande d'entrer des donn�es au clavier et cr�� un objet Administrateur et l'enregistre dans un fichier
	 * @throws IOExectpion
	 */
	public void addAdmin() throws IOException{
		String nom = DonneeUtil.demandeString("Entrer le nom du nouvel Administrateur : ");
		String prenom = DonneeUtil.demandeString("Entrer le prenom du nouvel Administrateur : ");
		Date naissance = DonneeUtil.demandeDate("Entrer la date de naissance du nouvel Administrateur (JJ/MM/YY) : ");
		String adresse = DonneeUtil.demandeString("Entrer l'adresse du nouvel Administrateur : ");
		int telS = DonneeUtil.demandeInt("Entrer le tel du nouvel Administrateur : ");
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
	 * Modifie un administrateur parmi un set d'administrateurs.
	 * @throws NoSuchElementException
	 * @throws IOException
	 */
	public void modifAdmin() throws NoSuchElementException,IOException{
		String s = "Utilisateur/Administrateur/Administrateur";
		All<Administrateur> newSet = new All<Administrateur>();
		newSet = (All<Administrateur>) newSet.relecture(s);
		Administrateur a = (Administrateur)DonneeUtil.choix(newSet.set);
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
	 * Demande d'entrer des donn�es au clavier et cr�� un objet Professeur et l'enregistre dans un fichier
	 * @throws IOExectpion
	 */
	public void addProf() throws IOException{
		String nom = DonneeUtil.demandeString("Entrer le nom du nouveau professeur : ");
		String prenom = DonneeUtil.demandeString("Entrer le prenom du nouveau professeur : ");
		Date naissance = DonneeUtil.demandeDate("Entrer la date de naissance du nouveau professeur (JJ/MM/YY) : ");
		String adresse = DonneeUtil.demandeString("Entrer l'adresse du nouveau professeur : ");
		int telS = DonneeUtil.demandeInt("Entrer le tel du nouveau professeur : ");
		String pseudoA=(nom+prenom).toLowerCase();
		if (pseudoA.length()>10){
			pseudoA = pseudoA.substring(0,10);
		}
		String mdp = "EISTI";
		String rep = "oui";
		Set<Module> modprof = new HashSet();
		Module mod = new Module();
		while (rep=="oui"){
			System.out.println("Entrer un module pour le professeur");
			All<Module> modules = new All<Module>();
			modules = (All<Module>) modules.relecture("Module/Module");
			mod = (Module)DonneeUtil.choix(modules.getSet());
			modprof.add(mod);
			System.out.println("Voulez vous-entrer d'autres modules");
		}
		String s = "Utilisateur/Professeur/Professeur";

		All<Professeur> newSet = new All<Professeur>();
		newSet = (All<Professeur>) newSet.relecture(s);
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
		All<Professeur> newSet = new All<Professeur>();
		newSet = (All<Professeur>) newSet.relecture(s);
		Professeur a = (Professeur)DonneeUtil.choix(newSet.set);
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
		Professeur p = (Professeur)DonneeUtil.choix(newSet.set);
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
	 * Demande d'entrer des donn�es au clavier et cr�� un objet �tudiant et l'enregistre dans un fichier
	 * @throws IOException
	 */
	public void addEleve() throws NoSuchElementException,IOException{
		String nom = DonneeUtil.demandeString("Entrer le nom du nouvel �tudiant : ");
		String prenom = DonneeUtil.demandeString("Entrer le prenom du nouvel �tudiant : ");
		Date naissance = DonneeUtil.demandeDate("Entrer la date de naissance du nouvel �tudiant (JJ/MM/YY) : ");
		String adresse = DonneeUtil.demandeString("Entrer l'adresse du nouvel �tudiant : ");
		int telS = DonneeUtil.demandeInt("Entrer le tel du nouvel �tudiant : ");
		String pseudoA=(nom+prenom).toLowerCase();
		if (pseudoA.length()>10){
			pseudoA = pseudoA.substring(0,10);
		}
		String mdp = "EISTI";

		Scanner sc = new Scanner(System.in);
		System.out.println("Entrer la promo du nouvel �l�ve : ");
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
	 * Supprime un �tudiant parmi un set d'�tudiants.
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
		Etudiant etu = (Etudiant) DonneeUtil.choix(promo.getSetEtudiant());
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
	 * Modifie un �tudiant parmi un set d'�tudiants.
	 * @throws IOException
	 */
	public void modifEleve() throws IOException{
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
		Etudiant etu = (Etudiant) DonneeUtil.choix(promo.getSetEtudiant());
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
	
	/**
	 * Fonction qui demande � l'utilisateur de rentrer les donn�es d'un module et l'enregistre dans un fichier
	 */
	public void addModule(){
		String nom = DonneeUtil.demandeString("Entrer le nom du nouveau module : ");
		String path = "Module/Module";
		All<Module> modules = new All<Module>();
		//modules = (All<Module>) modules.relecture(path);
		modules.set.add(new Module(modules.getSet().size(), nom));
		modules.sauvegarder(path);
	}
	
	/**
	 * Supprime un module parmi un set de modules.
	 * @throws IOException
	 */
	public void supModule() throws IOException{
		Scanner sc2 = new Scanner(System.in);
		String path = "Module/Module";
		All<Module> modules = new All<Module>();
		modules = (All<Module>) modules.relecture(path);
		Module mod = (Module) DonneeUtil.choix(modules.getSet());
		System.out.println("Voulez-vous vraiment supprimer (oui/non) : "+mod);
		String rep = sc2.next();
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
		Scanner sc2 = new Scanner(System.in);
		String path = "Module/Module";
		All<Module> modules = new All<Module>();
		modules = (All<Module>) modules.relecture(path);
		Module mod = (Module) DonneeUtil.choix(modules.getSet());
		System.out.println("Voulez-vous vraiment modifier (oui/non) : "+mod);
		String rep = sc2.next();
		switch(rep){
			case "oui" :
				modules.set.remove(mod);
				mod.setNom(DonneeUtil.demandeString("Entrer le nouveau nom du module : "+mod.getNom()));
				modules.add(mod);
				modules.sauvegarder(path);
				break;
			default : System.out.println("tant pis");break;
		}
	}
	
	/**
	 * Fonction qui demande � l'utilisateur d'entrer des donn�es pour cr�er et enregistrer une promotion
	 */
	public void addPromo(){
		String nomPromo = DonneeUtil.demandeString("Entrer le nom de la nouvelle promo : ");
		String path = "Utilisateur/promotion";
		Promotion promoInit = new Promotion(new HashSet<Etudiant>(),nomPromo);
		All<Promotion> newPromo = new All<Promotion>();
		newPromo = (All<Promotion>) newPromo.relecture(path);
		newPromo.add(promoInit);
		newPromo.sauvegarder(path);
	}
	
	/**
	 * Fonction qui supprime une promotion parmi une liste de promotion.
	 * @throws IOException
	 */
	public void supPromo() throws IOException{
		String path = "Utilisateur/promotion";
		All<Promotion> newPromo = new All<Promotion>();
		newPromo = (All<Promotion>) newPromo.relecture(path);
		Promotion promo = (Promotion)DonneeUtil.choix(newPromo.getSet());
		System.out.println("Voulez-vous vraiment supprimer (oui/non) : "+promo);
		String rep = (new Scanner(System.in)).next();
		switch(rep){
			case "oui" : 
				newPromo.set.remove(promo);
				newPromo.sauvegarder(path);
				System.out.println("Well Done!");
				break;
			default : System.out.println("tant pis");break;
		}
	}
	
}
