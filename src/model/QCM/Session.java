package model.QCM;

import java.io.*;
import java.util.*;

import model.RechercheDonnees;
import model.utilisateur.*;
import model.QCM.*;

import view.menu.*;

public class Session implements Serializable {

	private Date dateDebut;
	private Date dateFin;
	private int repetition;
	private Professeur createur;
	private QCM qcm;
	private Promotion promotion;
	private Module module;
	
	/**
	 * Constructeur complet de Session
	 * @param idSession
	 * @param dateDebut
	 * @param dateFin
	 * @param repetition
	 * @param createur
	 * @param qcm
	 * @param promotion
	 * @param module
	 */
	public Session(Date dateDebut, Date dateFin, int repetition,
			Professeur createur, QCM qcm, Promotion promotion, Module module) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.repetition = repetition;
		this.createur = createur;
		this.qcm = qcm;
		this.promotion = promotion;
		this.module = module;
	}
	
	/**
	 * Constructeur vide de Session
	 */
	public Session() {
	}

	/**
	 * @return the dateDebut
	 */
	public Date getDateDebut() {
		return dateDebut;
	}

	/**
	 * @param dateDebut the dateDebut to set
	 */
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	/**
	 * @return the dateFin
	 */
	public Date getDateFin() {
		return dateFin;
	}

	/**
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	/**
	 * @return the repetition
	 */
	public int getRepetition() {
		return repetition;
	}

	/**
	 * @param repetition the repetition to set
	 */
	public void setRepetition(int repetition) {
		this.repetition = repetition;
	}

	/**
	 * @return the createur
	 */
	public Professeur getCreateur() {
		return createur;
	}

	/**
	 * @param createur the createur to set
	 */
	public void setCreateur(Professeur createur) {
		this.createur = createur;
	}
	/**
	 * @return the qcm
	 */
	public QCM getQcm() {
		return qcm;
	}

	/**
	 * @param qcm the qcm to set
	 */
	public void setQcm(QCM qcm) {
		this.qcm = qcm;
	}

	/**
	 * @return the promotion
	 */
	public Promotion getPromotion() {
		return promotion;
	}

	/**
	 * @param promotion the promotion to set
	 */
	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}

	/**
	 * @return the module
	 */
	public Module getModule() {
		return module;
	}

	/**
	 * @param module the module to set
	 */
	public void setModule(Module module) {
		this.module = module;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((createur == null) ? 0 : createur.hashCode());
		result = prime * result
				+ ((dateDebut == null) ? 0 : dateDebut.hashCode());
		result = prime * result + ((dateFin == null) ? 0 : dateFin.hashCode());
		result = prime * result + ((module == null) ? 0 : module.hashCode());
		result = prime * result
				+ ((promotion == null) ? 0 : promotion.hashCode());
		result = prime * result + ((qcm == null) ? 0 : qcm.hashCode());
		result = prime * result + repetition;
		return result;
	}

	
	@Override
	public String toString(){
		return this.qcm.getLibelle() + " : " + View.affichageDate(dateDebut) + " " + View.affichageDate(dateFin);
	}
	
	public String description(){
		return "La session numéro " + this.hashCode() + " débute le " + View.affichageDate(dateDebut) + " et se termine le " + View.affichageDate(dateFin) + ".\nL'étudiant peut y répondre " + this.repetition + " fois.";
	}
	
	public void repondreQCM(Etudiant e){
		
		All<Resultat> resultatSession = RechercheDonnees.rechercheResultat(this.hashCode());
			
		Iterator itRes = resultatSession.set.iterator();
		Resultat resultat = new Resultat();
		int iterations = 0;	
		
		while (itRes.hasNext()){

			resultat = (Resultat) itRes.next();
			
			if (resultat.getEleve().equals(e)){
					iterations = resultat.getIterations();
				}
			
		}

		if (iterations < this.repetition){
			
			Date currentDate = new Date();
			if (currentDate.compareTo(this.dateDebut)==1 && currentDate.compareTo(this.dateFin)==-1){
				
				int compteurQuestion = 0;
				int compteurReponse = 0;
				int reponseChoisie;
				float note = 0;
				ArrayList<Reponse> listeReponse = new ArrayList<Reponse>();
				Iterator itQuestion = this.qcm.getQuestions().iterator();
	
				while(itQuestion.hasNext()){
					
					compteurQuestion ++;
					compteurReponse = 0;
					Question question = (Question) itQuestion.next();
					System.out.println("Question n°" + compteurQuestion + " : " + question.getLibelle());
					Iterator itReponse = question.getReponses().iterator();
					
					
					while(itReponse.hasNext()){
						
						compteurReponse ++;
						Reponse reponse = (Reponse) itReponse.next();
						System.out.println(compteurReponse + " - " + reponse.getLibelle());
						
					}
					
					try{
					
						reponseChoisie = View.demandeInt("Entrez le numéro de la réponse choisie :");
						listeReponse.add((question.getReponses().get(reponseChoisie - 1)));
						
						if ((question.getReponses().get(reponseChoisie - 1)).getEstVraie() ){
							note ++;
						}
						
					}catch (IOException ioe) {
						System.out.println("Erreur d'entrée sortie");
					}
					
					
				}
				
				note = (note/compteurQuestion)*20;
				
				Resultat nouveauResultat = new Resultat(note, e, (iterations+1),listeReponse);
				
				
				if (iterations != 0){
					resultatSession.set.remove(resultat);
				}
				
				String path = "Resultat/"+this.hashCode()+"/resultat";
				
				resultatSession.add(nouveauResultat);
				resultatSession.sauvegarder(path);
				
				System.out.println("Merci d'avoir répondu au questionnaire !");
				
			}else{
				if(currentDate.compareTo(this.dateDebut)==-1){
					System.out.println("La session n'est pas encore commencée, veuillez retenter à partir du "+ View.affichageDate(this.dateDebut));
				}else{
					System.out.println("La session est terminée, il n'est plus possible de répondre au questionnaire.");
				}
			}
			
		}else{
			System.out.println("Vous avez déjà répondu "+ this.repetition + " fois au questionnaire, vous ne pouvez plus y répondre.");
		}
	}
	
	public void visualiserResultat(Utilisateur u){
		
		if (u instanceof Professeur){
			try{
				System.out.println("Veuillez choisir l'étudiant dont vous voulez consulter les résultats");
				Etudiant eleve = (Etudiant) View.choix(this.promotion.getSetEtudiant());
				
				All<Resultat> listeResultat = RechercheDonnees.rechercheResultat(this.hashCode());
				Iterator itListeRes = listeResultat.set.iterator();
				Boolean finBoucle = true;
				Resultat resultat = new Resultat();
				Reponse reponse;
				
				while(itListeRes.hasNext() || finBoucle){
					resultat = (Resultat) itListeRes.next();
					
					if (resultat.getEleve().equals(eleve)){
						finBoucle = false;
					}
				}
				
				if (finBoucle){
					System.out.println("L'étudiant en question n'a pas encore participé à la session.");
				}else{
					resultat.afficherResultats();	
				}
				
			
			} catch (IOException ioe){
				System.out.println("Erreur d'entrée sortie");
			}
			
		}else{
			if (u instanceof Etudiant){
				Date currentDate = new Date();
				
				if (currentDate.compareTo(this.dateFin)==1){
					All<Resultat> listeResultat = RechercheDonnees.rechercheResultat(this.hashCode());
					Iterator itListeRes = listeResultat.set.iterator();
					Boolean finBoucle = true;
					Resultat resultat = new Resultat();
					
					while(itListeRes.hasNext() || finBoucle){
						resultat = (Resultat) itListeRes.next();
						
						if (resultat.getEleve().equals((Etudiant) u)){
							finBoucle = false;
						}
					}
					
					if (finBoucle){
						System.out.println("Vous n'avez pas encore participé à la session.");
					}else{
						System.out.println("Note : " + resultat.getNote());	
					}	
				}else{
					System.out.println("La session n'est pas encore terminée, veuillez réessayer après le "+ View.affichageDate(this.dateFin)+".");
				}
							
				
			}else{
				System.out.println("Erreur d'accès");
			}
		}
		
	}
	
	public void statistiques() {
		System.out.println("Moyenne = " + this.moyenne());
		System.out.println("Ecart-type = " + this.ecartType() + "\n");
		this.afficherFrequences();
	}
	
	private double moyenne() {
		
		All<Resultat> listeRes = RechercheDonnees.rechercheResultat(this.hashCode());
		Iterator it = listeRes.set.iterator();
		double moyenne = 0;
		
		while(it.hasNext()){
			Resultat res = (Resultat) it.next();
			moyenne += res.getNote();
			
		}
		
		return ( moyenne / listeRes.set.size() );
		
	}
	
	private double ecartType(){
		
		double moyenne = this.moyenne();
		double ecartType = 0;
		
		All<Resultat> listeRes = RechercheDonnees.rechercheResultat(this.hashCode());
		Iterator it = listeRes.set.iterator();
		
		while(it.hasNext()){
			
			Resultat res = (Resultat) it.next();
			ecartType += ( (res.getNote())- moyenne ) * ( (res.getNote())- moyenne );
			
		}
		
		ecartType = Math.sqrt(ecartType / listeRes.set.size());
		
		return ecartType;
	}
	
	private void afficherFrequences() {
		
		All<Resultat> listeRes = RechercheDonnees.rechercheResultat(this.hashCode());
		Iterator it = listeRes.set.iterator();
		double compteur = 0;
		ArrayList<Double> effectifs = new ArrayList<Double>();
		
		
		while(it.hasNext()){
			
			compteur = 0;
			Resultat res = (Resultat) it.next();
			Iterator itRes = res.getListeReponse().iterator();
			
			if (effectifs.isEmpty()){
				for (int i = 1; i <= res.getListeReponse().size(); i++){
					effectifs.add(0.0);
				}
				
			}
			
			while(itRes.hasNext()){
				Reponse r = (Reponse) itRes.next();
				if (r.getEstVraie()){
					effectifs.set((int) compteur,(effectifs.get((int) compteur))+1);
				}
				compteur ++;
			}
			
			
		}
		
		Iterator itEffectifs = effectifs.iterator();
		System.out.println("Fréquences de bonnes réponses : ");
		
		int compteur2 = 1;
		
		while(itEffectifs.hasNext()){
			double effectif = (double) itEffectifs.next();
			double frequence =  effectif/compteur;
			System.out.println("Question n°"+ compteur2 +" : " + frequence);
			compteur2 ++;
		}
	}
	
}
