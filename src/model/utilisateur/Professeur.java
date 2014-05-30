package model.utilisateur;

import view.menu.*;

import java.io.*;
import java.util.*;

import model.RechercheDonnees;
import model.QCM.*;


public class Professeur extends Utilisateur implements Serializable{
	private static final long serialVersionUID = -5845845607959841888L;
	private int idProf;
	private Set<Module> modules;
	
	/**
	 * Constructeur vide de Professeur
	 */
	public Professeur() {
		super();	
	}
	
	/**
	 * Constructeur complet de la classe Professeur
	 * @param nom chaine de caract�res
	 * @param prenom chaine de caract�res
	 * @param dateNaissance date de naissance sous forme d'objet de type date
	 * @param adresse chaine de caract�res
	 * @param tel num�ro de tel�phone sous forme d'entier
	 * @param pseudo chaine de caract�res
	 * @param motDePasse mot de passe sous forme de chaine de caract�res
	 * @param id identifiant sp�cifique de l'administrateur (entier)
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
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Professeur other = (Professeur) obj;
		if (idProf != other.idProf)
			return false;
		if (modules == null) {
			if (other.modules != null)
				return false;
		} else if (!modules.equals(other.modules))
			return false;
		return true;
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
		if(listeQCM.isEmpty()){
			return new HashSet<QCM>();
		}
		All<QCM> listeQCMProf = new All<QCM>();
		QCM q = null;
		Iterator<QCM> it = listeQCM.set.iterator();
		while (it.hasNext()){
			q = (QCM) it.next();
			if ((!q.getEstPrive())||(this.hashCode() == q.getCreateur().hashCode())){
				listeQCMProf.add(q);
			}
		}
		
		return listeQCMProf.set;
		
	}
	
	/**
	 * Renvoie le set des Sessions cr��es par le professeur
	 */
	public Set<Session> getSessions() {
		All<Session> listeSession = RechercheDonnees.rechercheSession();
		if (listeSession.isEmpty()){
			System.out.println("Il' n'y a pas de session");
			return new HashSet<Session>();
		}
		All<Session> listeSessionProf = new All<Session>();
		Session s = null;
		Iterator<Session> it = listeSession.set.iterator();
		
		while (it.hasNext()){
			s = (Session) it.next();
			if (this.hashCode() == s.getCreateur().hashCode()){
				listeSessionProf.add(s);
			}
		}
		
		return listeSessionProf.set;
	}
	
	/**
	 * Permet au professeur de cr�er un QCM 
	 */
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
			
			String path = "dataSave/QCM/qcm";

			All<QCM> setQCM = RechercheDonnees.rechercheQCM();
			setQCM.add(qcm);
			setQCM.sauvegarder(path);
			
			System.out.println("Votre questionnaire a bien �t� enregistr�. Retour au menu.");

			
		}catch(IOException e){
			System.out.println("Erreur d'entr�e sortie");
		}
		
	}
	
	/**
	 * Permet au professeur de supprimer un QCM
	 */
	public void supprimerQCM(){
		String path = "dataSave/QCM/qcm";
		All<QCM> listeQCM = RechercheDonnees.rechercheQCM();
		Set<QCM> listeQCMProf = this.getQCM();
		if(listeQCMProf.isEmpty()){
			System.out.println("Il n'y a pas de QCM");
			return;
		}
		Boolean rep = false;

		try {
			System.out.println("Veuillez choisir le QCM � supprimer : ");
			QCM q = (QCM) View.choix(listeQCMProf);
			if (q==null){
				System.out.println("Annulation");
				return;
			}
	
			rep = View.demandeBoolean("Voulez-vous vraiment supprimer (oui/non) : "+q.getLibelle());
			if(rep){
				for (QCM Q : listeQCM.getSet()){
					if (Q.equals(q)){
						q = Q;
					}
				}
				listeQCM.remove(q);
				System.out.println("Supprim�.");
				listeQCM.sauvegarder(path);
			}else{ 
				System.out.println("Annul�.");
			}
		}catch (IOException ioe){
			System.out.println("Erreur d'entr�e sortie");
		}

	}	
	
	/**
	 * Permet au professeur de cr�er une Session
	 */
	public void creerSession(){
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
			
			System.out.println("Veuillez choisir un QCM parmi ceux ci-dessous : ");
			All<QCM> qcmList = RechercheDonnees.rechercheQCM();
			if (qcmList.isEmpty()){
				System.out.println("Il n'y a pas de QCM");
				return;
			}
			All<QCM> qcmListPossible = new All<QCM>();
			for (QCM Q : qcmList.getSet()){
				if((!Q.getEstPrive())||(Q.getCreateur()==this)){
					qcmListPossible.add(Q);
				}
			}
			QCM qcm = (QCM) View.choix(qcmListPossible.set);
			if(qcm==null){
				System.out.println("Annulation");
				return;
			}
			
			System.out.println("Veuillez choisir une promotion parmi celles ci-dessous : ");
			All<Promotion> promoList = RechercheDonnees.recherchePromo();
			if (promoList.isEmpty()){
				System.out.println("Il n'y a pas de promotions");
				return;
			}
			Promotion promotion = (Promotion) View.choix(promoList.set);
			if(promotion==null){
				System.out.println("Annulation");
				return;
			}
			
			System.out.println("Veuillez choisir un module parmi ceux ci-dessous : ");
			Module module = (Module) View.choix(qcm.getCreateur().getModules());
			if(module==null){
				System.out.println("Annulation");
				return;
			}
			
			Session sess = new Session(dateDebut, dateFin, repetition, this, qcm, promotion, module);
			System.out.println(sess.description());
			
			String path = "dataSave/QCM/session";

			All<Session> setSession = RechercheDonnees.rechercheSession();
			setSession.add(sess);
			setSession.sauvegarder(path);
			
			new File("dataSave/Resultat/"+sess.hashCode()).mkdir();
			All<Resultat> testList = new All<Resultat>();
			Resultat test = new Resultat(0,new Etudiant(),0, new ArrayList<Reponse>());
			testList.add(test);
			testList.sauvegarder("dataSave/Resultat/"+ sess.hashCode() +"/resultat");
			
			System.out.println("Votre session a bien �t� enregistr�e. Retour au menu.");

			
		}
		catch(IOException e)
		{
			System.out.println("Erreur lors de la cr�ation de la session, veuillez recommencer.");
		}
	}
	
	
	/**
	 * Permet au professeur de supprimer une Session
	 */
	public void supprimerSession(){
		String path = "dataSave/QCM/session";
		All<Session> listeSession = RechercheDonnees.rechercheSession();
		Set<Session> listeSessionProf = this.getSessions();
		if (listeSessionProf.isEmpty()){
			System.out.println("Il n'y a pas de sessions");
			return;
		}
		Session s = null;

		boolean rep = false;
		
		try {
			System.out.println("Veuillez choisir la session � supprimer : ");
			s = (Session) View.choix(listeSessionProf);
			if (s==null){
				System.out.println("Annulation");
				return;
			}
			rep = View.demandeBoolean("Voulez-vous vraiment supprimer (oui/non) : "+s);

			if(rep){
				for (Session S : listeSession.getSet()){
					if (S.equals(s)){
						s = S;
					}
				}
				listeSession.remove(s);
				listeSession.set.remove(s);
				System.out.println("Supprim�.");
				listeSession.sauvegarder(path);
			}else{ 
				System.out.println("Annul�.");
			}
		}catch (IOException ioe){
			System.out.println("Erreur d'entr�e sortie");
		}

	}
	
	
	/**
	 * Permet de supprimer un module du professeur
	 * @param mod module � supprimer
	 */
	public void supprimerModule(Module mod){
		this.modules.remove(mod);
	}

		
	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return super.toString() + " modules=" + modules + ")\n";
	}
	

}
