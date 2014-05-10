package initialNode;

import helpClass.DonneeUtil;

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
		debutSess = DonneeUtil.DemandeString("Veuillez entrer une date de début de session (MM/DD/YYYY)");
		Date dateDebut = new Date(debutSess);
		finSess = DonneeUtil.DemandeString("Veuillez entrer une date de fin de session (MM/DD/YYYY)");
		Date dateFin = new Date(finSess);
		repetition = DonneeUtil.DemandeInt("Combien de fois autorisez vous les étudiants à répondre à ce QCM?");
		Session sess = new Session(i, dateDebut, dateFin, repetition);
		return sess;
		/*File maSession = new File("QCM/");
		String name = maSession.getName();
		maSession.mkdir();*/
		
		
	}
	
	public String DonnéeUtil(String s){
		String res="";
		Scanner sc = new Scanner(System.in);
		System.out.println(s);
		res = sc.nextLine();
		return res;
	}
}
