package initialNode;

import java.io.File;
import java.util.*;

import QCM.Session;

public class Professeur extends Utilisateur {
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
	
	public Session CreerSession(){
		Scanner sc = new Scanner(System.in);
		String debutSess="";
		String finSess="";
		int i=0;
		int repetition=1;
		System.out.println("Veuillez entrer une date de début de session (MM/DD/YYYY)");
		debutSess = sc.nextLine();
		Date dateDebut = new Date(debutSess);
		System.out.println("Veuillez entrer une date de fin de session (MM/DD/YYYY)");
		finSess = sc.nextLine();
		Date dateFin = new Date(finSess);
		System.out.println("Combien de fois autorisez vous les étudiants à répondre à ce QCM?");
		repetition = sc.nextInt();
		Session sess = new Session(i, dateDebut, dateFin, repetition);
		return sess;
		/*File maSession = new File("QCM/");
		String name = maSession.getName();
		maSession.mkdir();*/
		
		
	}
}
