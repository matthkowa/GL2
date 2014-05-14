package initialNode;

import view.menu.*;

import java.io.*;
import java.util.*;

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
	
	public void creerQCM(){
		
		try{
			String titre = View.demandeString("Bienvenue dans l'assistant de création de QCM !\nVeuillez entrer le titre du QCM :\n");
			QCM qcm = new QCM(titre,this);
		}catch(IOException e){
			System.out.println("Terror 404");
		}
		
	}
	
	public void creerSession(){
		int id=0;
		int repetition=1;
		try{
			Date dateDebut = View.demandeDate("Veuillez entrer une date de début de session (DD/MM/YYYY)");
			Date dateFin = View.demandeDate("Veuillez entrer une date de fin de session (DD/MM/YYYY)");
			repetition = View.demandeInt("Combien de fois autorisez vous les étudiants à répondre à ce QCM?");
			System.out.println(dateDebut);
			Session sess = new Session(id, dateDebut, dateFin, repetition);
			System.out.println(sess);
		}
		catch(IOException e)
		{
			System.out.println("Erreur lors de la création de la session, veuillez recommencer.");
		}

		/*File maSession = new File("QCM/");
		String name = maSession.getName();
		maSession.mkdir();*/
		
		
	}
	
}
