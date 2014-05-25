package model.utilisateur;

import view.menu.*;

import java.io.*;
import java.util.*;

import model.RechercheDonnees;
import model.QCM.*;


public class Professeur extends Utilisateur {
	private static final long serialVersionUID = -5845845607959841888L;
	private int idProf;
	private Set<Module> modules;
	
	public Professeur() {
		super();	
	}
	
	/**
	 * Constructeur complet de la classe Professeur
	 * @param nom
	 * @param prenom
	 * @param dateNaissance
	 * @param adresse
	 * @param tel
	 * @param pseudo
	 * @param motDePasse
	 */
	public Professeur(String nom, String prenom, Date dateNaissance,
			String adresse, int tel, String pseudo, String motDePasse,int id, Set<Module> modules) {
		super(nom, prenom, dateNaissance, adresse, tel, pseudo, motDePasse);
		this.idProf = id;
		this.modules = new HashSet<Module>();
		this.modules = modules;
	}

	/**
	 * Renvoie l'idProf du professeur
	 * @return idProf
	 */
	public int getIdProf() {
		return idProf;
	}
	
	/**
	 * Modifie l'idProf du professeur
	 * @param idProf
	 */
	public void setIdProf(int idProf) {
		this.idProf = idProf;
	}
	
	/**
	 * Renvoie le set des Modules du Professeur
	 * @return modules
	 */
	public Set<Module> getModules(){
		return this.modules;
	}
	
	/**
	 * Modifie le set des Modules du professeur
	 * @param modulesInit
	 */
	public void setModules(Set<Module> modulesInit){
		this.modules=modulesInit;
	}
	
	/**
	 * renvoie le hashCode du Professeur
	 * @return hashCode identifiant de professeur
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + idProf;
		result = prime * result + ((modules == null) ? 0 : modules.hashCode());
		return result;
	}
	
	public Set<QCM> getQCM() {
		
		All<QCM> listeQCM = RechercheDonnees.rechercheQCM();
		All<QCM> listeQCMProf = new All<QCM>();
		QCM q = null;
		Iterator it = listeQCM.set.iterator();
		boolean rep = false;
		
		while (it.hasNext()){
			q = (QCM) it.next();
			if (this.hashCode() == q.getCreateur().hashCode()){
				listeQCMProf.add(q);
			}
		}
		
		return listeQCMProf.set;
		
	}
	
	/**
	 * Renvoie le set des Sessions créées par le professeur
	 */
	public Set<Session> getSessions() {
		All<Session> listeSession = RechercheDonnees.rechercheSession();
		All<Session> listeSessionProf = new All<Session>();
		Session s = null;
		Iterator it = listeSession.set.iterator();
		
		while (it.hasNext()){
			s = (Session) it.next();
			if (this.hashCode() == s.getCreateur().hashCode()){
				listeSessionProf.add(s);
			}
		}
		
		return listeSessionProf.set;
	}
	
	/**
	 * Permet au professeur de créer un QCM
	 */
	public void creerQCM(){
		
		try{
			int compteur = 0;
			String titre = View.demandeString("Bienvenue dans l'assistant de création de QCM !\nVeuillez entrer le titre du QCM :\n");
			Boolean estPrive = View.demandeBoolean("Ce questionnaire est-il privé ?");
			
			QCM qcm = new QCM(titre, estPrive, this);
			
			Boolean finQCM = true;
			Boolean ajoutQuestion = false;
			
			while (finQCM){
				
				System.out.println("Création de la question n°"+ (compteur+1));
				ajoutQuestion = qcm.creerQuestion();
				
				if (ajoutQuestion){	
					compteur ++;
					ajoutQuestion = false;
				}
				if (compteur > 0){
					finQCM = (View.demandeBoolean("Ajouter une autre question ?"));
				}
			}
			
			String path = "QCM/qcm";

			All<QCM> setQCM = RechercheDonnees.rechercheQCM();
			setQCM.add(qcm);
			setQCM.sauvegarder(path);
			
			System.out.println("Votre questionnaire a bien été enregistré. Retour au menu.");

			
		}catch(IOException e){
			System.out.println("Erreur d'entrée sortie");
		}
		
	}
	
	/**
	 * Permet au professeur de supprimer un QCM
	 */
	public void supprimerQCM(){
		String path = "QCM/qcm";
		All<QCM> listeQCM = RechercheDonnees.rechercheQCM();
		Set<QCM> listeQCMProf = this.getQCM();
		QCM q = null;
		Boolean rep = false;

		try {
			System.out.println("Veuillez choisir la session à supprimer : ");
			q = (QCM) View.choix(listeQCMProf);	
	
			rep = View.demandeBoolean("Voulez-vous vraiment supprimer (oui/non) : "+q.getLibelle());

			if(rep){
				listeQCM.set.remove(q);
				System.out.println("Supprimé.");
				listeQCM.sauvegarder(path);
			}else{ 
				System.out.println("Annulé.");
			}
		}catch (IOException ioe){
			System.out.println("Erreur d'entrée sortie");
		}

	}	
	
	/**
	 * Permet au professeur de créer une Session
	 */
	public void creerSession(){
		int repetition=1;
		Date dateDebut;
		Date dateFin;
		try{
			dateDebut = View.demandeDate("Veuillez entrer une date de début de session (DD/MM/YYYY)");
			
			do{
				dateFin = View.demandeDate("Veuillez entrer une date de fin de session (DD/MM/YYYY)");
			}while(dateFin.getTime()<=dateDebut.getTime());
			
			do{
				repetition = View.demandeInt("Combien de fois autorisez vous les étudiants à répondre à ce QCM?");
			}while (repetition<1);
			
			System.out.println("Veuillez choisir un QCM parmi ceux ci-dessous : ");
			All<QCM> qcmList = RechercheDonnees.rechercheQCM();
			QCM qcm = (QCM) View.choix(qcmList.set);
			
			System.out.println("Veuillez choisir une promotion parmi celles ci-dessous : ");
			All<Promotion> promoList = RechercheDonnees.recherchePromo();
			Promotion promotion = (Promotion) View.choix(promoList.set);
			
			System.out.println("Veuillez choisir un module parmi ceux ci-dessous : ");
			All<Module> moduleList = RechercheDonnees.rechercheModule();
			Module module = (Module) View.choix(moduleList.set);
//			Module module = (Module) View.choix(this.modules);
			
			Session sess = new Session(dateDebut, dateFin, repetition, this, qcm, promotion, module);
			System.out.println(sess.description());
			
			String path = "QCM/session";

			All<Session> setSession = RechercheDonnees.rechercheSession();
			setSession.add(sess);
			setSession.sauvegarder(path);
			
			new File("Resultat/"+sess.hashCode()).mkdir();
			All<Resultat> testList = new All<Resultat>();
			Resultat test = new Resultat(0,new Etudiant(),0, new ArrayList<Reponse>());
			testList.add(test);
			testList.sauvegarder("Resultat/"+ sess.hashCode() +"/resultat");
			
			System.out.println("Votre session a bien été enregistrée. Retour au menu.");

			
		}
		catch(IOException e)
		{
			System.out.println("Erreur lors de la création de la session, veuillez recommencer.");
		}
	}
	
	
	/**
	 * Permet au professeur de supprimer une Session
	 */
	public void supprimerSession(){
		String path = "QCM/session";
		All<Session> listeSession = RechercheDonnees.rechercheSession();
		Set<Session> listeSessionProf = this.getSessions();
		Session s = null;

		boolean rep = false;
		
		try {
			System.out.println("Veuillez choisir la session à supprimer : ");
			s = (Session) View.choix(listeSessionProf);
			rep = View.demandeBoolean("Voulez-vous vraiment supprimer (oui/non) : "+s);

			if(rep){
				listeSession.set.remove(s);
				System.out.println("Supprimé.");
				listeSession.sauvegarder(path);
			}else{ 
				System.out.println("Annulé.");
			}
		}catch (IOException ioe){
			System.out.println("Erreur d'entrée sortie");
		}

	}

}
