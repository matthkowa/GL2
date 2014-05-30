package model.utilisateur;

import view.menu.*;
import java.util.Date;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.io.IOException;
import java.io.Serializable;
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
			rep2 = View.demandeInt("Entrer un des numéros ci-dessus");
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
					All<Module> modules = RechercheDonnees.rechercheModule();
					Module mod = new Module();
					boolean rep=true;
					while (rep){
						System.out.println("Entrer un nouveau module pour le professeur");
						if (modules.isEmpty()){
							System.out.println("Il n'y a pas d'autres modules");
							break;
						}
						mod = (Module)View.choix(modules.getSet());
						if (mod==null){
							System.out.println("Annulation");
							newSet.add(util);
							return newSet;
						}
						modprof.add(mod);
						modules.remove(mod);
						if (modules.isEmpty()){
							System.out.println("Il n'y a pas d'autres modules");
							rep=false;
						}
						else{
							rep = View.demandeBoolean("Voulez vous-entrer d'autres modules (oui/non)");
						}
					}
					((Professeur) util).setModules(modprof);
				}
				else{
					newSet.add(util);
					newSet = this.modifdonnees(newSet, util, path);
				}
		}
		newSet.add(util);
		if (util instanceof Professeur){
			System.out.println("Le professeur : "+(Professeur)util+" a bien été modifié");
		}
		if (util instanceof Etudiant){
			System.out.println("L'étudiant : "+(Etudiant)util+" a bien été modifié");
		}
		if (util instanceof Administrateur){
			System.out.println("L'administrateur : "+util+" a bien été modifié");
		}
		return newSet;
	}
	
	
	
	/**
	 * Supprime un administrateur parmi un set d'administrateurs.
	 * @throws NoSuchElementException
	 * @throws IOException
	 */
	public void supAdmin() throws NoSuchElementException,IOException{
		String s = "dataSave/Utilisateur/Administrateur/Administrateur";
		All<Administrateur> newSet = RechercheDonnees.rechercheAdmin();
		if (newSet.isEmpty()){
			System.out.println("Il n'y a pas d'administrateurs");
			return;
		}
		newSet.remove(this);
		Administrateur a = (Administrateur)View.choix(newSet.getSet());
		if (a==null){
			System.out.println("Annulation");
			return;
		}
		boolean rep = View.demandeBoolean("Voulez-vous vraiment supprimer (oui/non) : "+a);
		if (rep){ 
			newSet.remove(a);
			newSet.add(this);
			newSet.sauvegarder(s);
			System.out.println("L'administrateur : "+a+" a bien été supprimé");
		}else{
			System.out.println("Annulation");
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
		
		
		String s = "dataSave/Utilisateur/Administrateur/Administrateur";
		All<Administrateur> newSet = RechercheDonnees.rechercheAdmin();
		Administrateur a = new Administrateur(nom, prenom, naissance, adresse, telS, pseudoA, mdp, newSet.set.size());
		newSet.add(a);
		System.out.println("L'administrateur : "+a+" a bien été ajouté");
		newSet.sauvegarder(s);
	}	
		
	/**
	 * Modifie un administrateur parmi un set d'administrateurs.
	 * @throws NoSuchElementException
	 * @throws IOException
	 */
	public void modifAdmin() throws NoSuchElementException,IOException{
		String s = "dataSave/Utilisateur/Administrateur/Administrateur";
		All<Administrateur> newSet = RechercheDonnees.rechercheAdmin();
		if (newSet.isEmpty()){
			System.out.println("Il n'y a pas d'administrateurs");
			return;
		}
		Administrateur a = (Administrateur)View.choix(newSet.set);
		if (a==null){
			System.out.println("Annulation");
			return;
		}
		boolean rep = View.demandeBoolean("Voulez-vous vraiment modifier (oui/non) : "+a);
		if (rep){ 
			newSet.set = this.modifdonnees(newSet.set, a, s);
			newSet.sauvegarder(s);
		}else{
			System.out.println("Annulation");
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
		Set<Module> modprof = new HashSet<Module>();
		All<Module> modules = RechercheDonnees.rechercheModule();
		Module mod = new Module();
		while (rep){
			System.out.println("Entrer un module pour le professeur");
			if (modules.isEmpty()){
				System.out.println("Il n'y a pas d'autres modules");
				return;
			}
			mod = (Module)View.choix(modules.getSet());
			if (mod==null){
				break;
			}
			modprof.add(mod);
			rep = View.demandeBoolean("Voulez vous-entrer d'autres modules");
		}
		String s = "dataSave/Utilisateur/Professeur/Professeur";

		All<Professeur> newSet = RechercheDonnees.rechercheProf();
		Professeur a = new Professeur(nom, prenom, naissance, adresse, telS, pseudoA, mdp, newSet.set.size(), modprof);
		newSet.add(a);
		System.out.println("Le professeur : "+a+" a bien été ajouté.");
		newSet.sauvegarder(s);
	}
	
	/**
	 * Supprime un professeur parmi un set de professeurs.
	 * @throws NoSuchElementException
	 * @throws IOException
	 */
	public void supProf() throws NoSuchElementException,IOException{
		String s = "dataSave/Utilisateur/Professeur/Professeur";
		All<Professeur> newSet = RechercheDonnees.rechercheProf();
		if (newSet.isEmpty()){
			System.out.println("Il n'y a pas de professeurs");
			return;
		}
		Professeur a = (Professeur)View.choix(newSet.set);
		if (a==null){
			System.out.println("Annulation");
			return;
		}
		boolean rep = View.demandeBoolean("Voulez-vous vraiment supprimer (oui/non) : "+a);
		if (rep){
			newSet.set.remove(a);
			newSet.sauvegarder(s);
			System.out.println("Le professeur : "+a+" a bien été supprimé.");
		}else{
			System.out.println("Annulation");
		}
	}
	
	/**
	 * Modifie un professeur parmi un set de professeurs.
	 * @throws NoSuchElementException
	 * @throws IOException
	 */
	public void modifProf() throws NoSuchElementException,IOException{
		String s = "dataSave/Utilisateur/Professeur/Professeur";
		All<Professeur> newSet = RechercheDonnees.rechercheProf();
		if (newSet.isEmpty()){
			System.out.println("Il n'y a pas de professeurs");
			return;
		}
		Professeur p = (Professeur)View.choix(newSet.set);
		if (p==null){
			System.out.println("Annulation");
			return;
		}
		boolean rep = View.demandeBoolean("Voulez-vous vraiment modifier (oui/non) : "+p);
		if (rep){
			newSet.set = this.modifdonnees(newSet.set, p, s);
			newSet.sauvegarder(s);
		}else {
			System.out.println("tant pis");
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
		System.out.println("Entrer la promotion de l'étudiant :");
		String path = "dataSave/Utilisateur/Etudiant/promotion";
		All<Promotion> newPromo = RechercheDonnees.recherchePromo();
		if (newPromo.isEmpty()){
			System.out.println("Il n'y a pas de promotions");
			return;
		}
		Promotion promo = (Promotion)View.choix(newPromo.getSet());
		if (promo==null){
			System.out.println("Annulation");
			return;
		}
		newPromo.remove(promo);
		Etudiant etu = new Etudiant(nom, prenom, naissance, adresse, telS, pseudoA, mdp, promo.getSetEtudiant().size());
		promo.getSetEtudiant().add(etu);
		newPromo.add(promo);
		newPromo.sauvegarder(path);
		System.out.println("L'étudiant : "+etu+" a bien été ajouté.");
	}
	
	/**
	 * Supprime un étudiant parmi un set d'étudiants.
	 * @throws NoSuchElementException
	 * @throws IOException
	 */
	public void supEleve() throws NoSuchElementException,IOException{
		String path = "dataSave/Utilisateur/Etudiant/promotion";
		All<Promotion> newPromo = RechercheDonnees.recherchePromo();
		if (newPromo.isEmpty()){
			System.out.println("Il n'y a pas de promotions");
			return;
		}
		Promotion promo = (Promotion)View.choix(newPromo.getSet());
		if (promo==null){
			System.out.println("Annulation");
			return;
		}
		if (promo.getSetEtudiant().isEmpty()){
			System.out.println("Il n'y a pas d'étudiant dans cette promotion");
			return;
		}
		Etudiant etu = (Etudiant) View.choix(promo.getSetEtudiant());
		if (etu==null){
			System.out.println("Annulation");
			return;
		}
		boolean rep = View.demandeBoolean("Voulez-vous vraiment supprimer (oui/non) : "+etu);
		if (rep){
			newPromo.remove(promo);
			promo.getSetEtudiant().remove(etu);
			newPromo.add(promo);
			newPromo.sauvegarder(path);
			System.out.println("L'étudiant : "+etu+" a bien été supprimé.");
		}else{
			System.out.println("Annulation");
		}
	}
 
	
	/**
	 * Modifie un étudiant parmi un set d'étudiants.
	 * @throws IOException
	 */
	public void modifEleve() throws IOException{
		String path = "dataSave/Utilisateur/Etudiant/promotion";
		All<Promotion> newPromo = RechercheDonnees.recherchePromo();
		if (newPromo.isEmpty()){
			System.out.println("Il n'y a pas de promotions");
			return;
		}
		Promotion promo = (Promotion) View.choix(newPromo.getSet());
		if (promo==null){
			System.out.println("Annulation");
			return;
		}
		if (promo.getSetEtudiant().isEmpty()){
			System.out.println("Il n'y a pas d'étudiant dans cette promotion");
			return;
		}
		Etudiant etu = (Etudiant) View.choix(promo.getSetEtudiant());
		if (etu==null){
			System.out.println("Annulation");
			return;
		}
		boolean rep = View.demandeBoolean("Voulez-vous vraiment modifier (oui/non) : "+etu);
		if (rep){ 
			promo.setSetEtudiant(this.modifdonnees(promo.getSetEtudiant(), etu, path));
			promo.sauvegarder(path);
		}else{
			System.out.println("Annulation");
		}
	}
	
	/**
	 * Fonction qui demande à l'utilisateur de rentrer les données d'un module et l'enregistre dans un fichier
	 */
	public void addModule(){
		try
		{
			String nom = View.demandeString("Entrer le nom du nouveau module : ");
			String path = "dataSave/Module/Module";
			All<Module> modules = RechercheDonnees.rechercheModule();
			Module mod = new Module(modules.getSet().size(), nom);
			modules.set.add(mod);
			modules.sauvegarder(path);
			System.out.println("Le module : "+mod+" a bien été ajouté.");
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
		String path = "dataSave/Module/Module";
		All<Module> modules = RechercheDonnees.rechercheModule();
		if (modules.isEmpty()){
			System.out.println("Il n'y a pas de modules");
			return;
		}
		Module mod = (Module) View.choix(modules.getSet());
		if (mod==null){
			System.out.println("Annulation");
			return;
		}
		boolean rep = View.demandeBoolean("Voulez-vous vraiment supprimer (oui/non) : "+mod);
		if (rep){
			modules.set.remove(mod);
			modules.sauvegarder(path);
			All<Professeur> professeurs = RechercheDonnees.rechercheProf();
			for (Professeur P : professeurs.getSet()){
				for (Module M : P.getModules()){
					if (mod.equals(M)){
						P.supprimerModule(M);
					}
				}
			}
			professeurs.sauvegarder("Utilisateur/Professeur/Professeur");
			System.out.println("Le module : "+mod+" a bien été supprimé.");
		}else{
			System.out.println("Annulation");
		}
	}
	
	/**
	 * Modifie un module parmi un set de modules.
	 * @throws IOException
	 */
	public void modifModule() throws IOException{
		String path = "dataSave/Module/Module";
		All<Module> modules = RechercheDonnees.rechercheModule();
		if (modules.isEmpty()){
			System.out.println("Il n'y a pas de modules");
			return;
		}
		Module mod = (Module) View.choix(modules.getSet());
		if (mod==null){
			System.out.println("Annulation");
			return;
		}
		boolean rep = View.demandeBoolean("Voulez-vous vraiment modifier (oui/non) : "+mod);
		if (rep){
			modules.set.remove(mod);
			mod.setNom(View.demandeString("Entrer le nouveau nom du module : "+mod.getNom()));
			modules.add(mod);
			modules.sauvegarder(path);
			System.out.println("Le module : "+mod+" a bien été modifié.");
		}else{
			System.out.println("Annulation");
		}
	}
	
	/**
	 * Fonction qui demande à l'utilisateur d'entrer des données pour créer et enregistrer une promotion
	 */
	public void addPromo(){
		try
		{
			String nomPromo = View.demandeString("Entrer le nom de la nouvelle promo : ");
			String path = "dataSave/Utilisateur/Etudiant/promotion";
			Promotion promoInit = new Promotion(new HashSet<Etudiant>(),nomPromo);
			All<Promotion> newPromo = RechercheDonnees.recherchePromo();
			newPromo.add(promoInit);
			newPromo.sauvegarder(path);
			System.out.println("La promo : "+promoInit+" a bien été ajoutée.");
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
		if (newPromo.isEmpty()){
			System.out.println("Il n'y a pas de promotions");
			return;
		}
		Promotion promo = (Promotion)View.choix(newPromo.getSet());
		if (promo==null){
			System.out.println("Annulation");
			return;
		}
		boolean rep = View.demandeBoolean("Voulez-vous vraiment supprimer (oui/non) : "+promo);
		if (rep){
			newPromo.set.remove(promo);
			newPromo.sauvegarder("dataSave/Utilisateur/Etudiant/promotion");
			System.out.println("La promo : "+promo+" a bien été supprimée.");
		}
		else{
			System.out.println("Annulation");
		}
	}
	
	/**
	 * Fonction qui modifie une promotion parmi une liste de promotion.
	 * @throws IOException 
	 */
	public void modifPromo() throws IOException{
		All<Promotion> newPromo = RechercheDonnees.recherchePromo();
		if (newPromo.isEmpty()){
			System.out.println("Il n'y a pas de promotions");
			return;
		}
		Promotion promo = (Promotion)View.choix(newPromo.getSet());
		if (promo==null){
			System.out.println("Annulation");
			return;
		}
		newPromo.remove(promo);
		int rep = -1;
		while ((rep<0)||(rep>2)){
			System.out.println("0 - Annuler\n1 - modifier nom\n2 - Modifier élèves");
			rep = View.demandeInt("Entrer un des nombres ci-dessus");
		}
		switch(rep){
			case 0 :
				System.out.println("Annulation");
				break;
			case 1 :
				promo.setPromo(View.demandeString("Entrer le nouveau nom de la promotion"));
				System.out.println("la promo "+promo+" a bien été mise à jour");
				break;
			case 2 :
				if (promo.getSetEtudiant().isEmpty()){
					System.out.println("Il n'y a pas d'étudiant dans cette promotion");
					return;
				}
				Etudiant etu = (Etudiant) View.choix(promo.getSetEtudiant());
				if (etu==null){
					System.out.println("Annulation");
					return;
				}
				if (newPromo.isEmpty()){
					System.out.println("Il n'y a pas d'autre promotions");
					promo.add(etu);
					break;
				}
				Promotion promo1 = (Promotion)View.choix(newPromo.getSet());
				if (promo1==null){
					System.out.println("Annulation");
					promo.add(etu);
					break;
				}
				newPromo.remove(promo1);
				promo1.add(etu);
				promo.remove(etu);
				newPromo.add(promo1);
				System.out.println("L'etudiant "+etu+" a bien été transférer en "+promo1.getPromo());
				break;
		}
		newPromo.add(promo);
		newPromo.sauvegarder("dataSave/Utilisateur/Etudiant/promotion");
	}
	
	public String toString(){
		return super.toString() + ")\n";
	}
	
}
