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

	public int getIdProf() {
		return idProf;
	}

	public void setIdProf(int idProf) {
		this.idProf = idProf;
	}
	
	public Set<Module> getModules(){
		return this.modules;
	}
	
	public void setModules(Set<Module> modulesInit){
		this.modules=modulesInit;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + idProf;
		result = prime * result + ((modules == null) ? 0 : modules.hashCode());
		return result;
	}
	
	public void creerQCM(){
		
		try{
			int compteur = 0;
			String titre = View.demandeString("Bienvenue dans l'assistant de cr�ation de QCM !\nVeuillez entrer le titre du QCM :\n");
			Boolean estPrive = View.demandeBoolean("Ce questionnaire est-il priv� ?");
			
			QCM qcm = new QCM(titre, estPrive, this);
			
			Boolean finQCM = true;
			Boolean ajoutQuestion = false;
			
			while (finQCM){
				
				System.out.println("Cr�ation de la question n�"+ (compteur+1));
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
			
			System.out.println("Votre questionnaire a bien �t� enregistr�. Retour au menu.");

			
		}catch(IOException e){
			System.out.println("Erreur d'entr�e sortie");
		}
		
	}
	
	public void creerSession(){
		int id=0;
		int repetition=1;
		Date dateDebut;
		Date dateFin;
		try{
			dateDebut = View.demandeDate("Veuillez entrer une date de d�but de session (DD/MM/YYYY)");
			
			do{
				dateFin = View.demandeDate("Veuillez entrer une date de fin de session (DD/MM/YYYY)");
			}while(dateFin.getTime()<=dateDebut.getTime());
			
			do{
				repetition = View.demandeInt("Combien de fois autorisez vous les �tudiants � r�pondre � ce QCM?");
			}while (repetition<1);
			
			Session sess = new Session(id, dateDebut, dateFin, repetition);
			System.out.println(sess);
			
			String path = "QCM/Session";

			All<Session> setSession = RechercheDonnees.rechercheSession();
			setSession.add(sess);
			setSession.sauvegarder(path);
			
			System.out.println("Votre Session a bien �t� enregistr�. Retour au menu.");

			
		}
		catch(IOException e)
		{
			System.out.println("Erreur lors de la cr�ation de la session, veuillez recommencer.");
		}

		/*File maSession = new File("QCM/");
		String name = maSession.getName();
		maSession.mkdir();*/
		
		
	}
}
