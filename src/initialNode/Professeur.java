package initialNode;

import helpClass.DonneeUtil;

import java.io.File;
import java.util.*;

import QCM.Session;

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
	
	public Session CreerSession(){
		Scanner sc = new Scanner(System.in);
		int id=0;
		int repetition=1;
		Date dateDebut = DonneeUtil.DemandeDate("Veuillez entrer une date de début de session (MM/DD/YYYY)");
		Date dateFin = DonneeUtil.DemandeDate("Veuillez entrer une date de début de session (MM/DD/YYYY)");
		repetition = DonneeUtil.DemandeInt("Combien de fois autorisez vous les étudiants à répondre à ce QCM?");
		System.out.println(dateDebut);
		Session sess = new Session(id, dateDebut, dateFin, repetition);
		System.out.println(sess);
		return sess;

		/*File maSession = new File("QCM/");
		String name = maSession.getName();
		maSession.mkdir();*/
		
		
	}
	
}
