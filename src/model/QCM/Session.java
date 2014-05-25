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

	public String toString(){
		return "La session numéro " + this.hashCode() + " débute le " + View.affichageDate(dateDebut) + " et se termine le " + View.affichageDate(dateFin) + ".\nL'étudiant peut y répondre " + this.repetition + " fois.";
	}
	
	public void repondreQCM(Etudiant e){
		
		All<Resultat> resultatSession = RechercheDonnees.rechercheResultat(this.hashCode());
		
		Iterator itRes = resultatSession.set.iterator();
		Resultat resultat = new Resultat();
		Boolean entreeExistante = true;
		int iterations = 0;	
		
		while (itRes.hasNext() || entreeExistante){
			
			resultat = (Resultat) itRes.next();
			
			if (resultat.getEleve().equals(e)){
				
				entreeExistante = false;
				iterations = resultat.getIterations();
				
			}
			
		}
		
		if (iterations < this.repetition){
			
			Date currentDate = new Date();
			if (currentDate.compareTo(this.dateDebut)==1 && currentDate.compareTo(this.dateFin)==-1){
				
				int compteurQuestion = 0;
				int compteurReponse = 0;
				int reponseChoisie;
				int note = 0;
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
						
						if ((question.getReponses().get(reponseChoisie - 1)).getEstVraie() ){
							note ++;
						}
						
					}catch (IOException ioe) {
						System.out.println("Erreur d'entrée sortie");
					}
					
					
				}
				
				Resultat nouveauResultat = new Resultat(note, e, iterations++);
				
				if (iterations != 0){
					resultatSession.set.remove(resultat);
				}
				
				String path = "Resultat/"+this.hashCode()+"resultat";
				
				resultatSession.add(nouveauResultat);
				resultatSession.sauvegarder(path);
				
				System.out.println("Merci d'avoir répondu au questionnaire !");
				
			}else{
				if(currentDate.compareTo(this.dateDebut)==-1){
					System.out.println("La session n'est pas encore commencée, veuillez retenter à partir du "+ View.affichageDate(this.dateDebut));
				}else{
					System.out.println("la session est terminée, il n'est plus possible de répondre au questionnaire.");
				}
			}
			
		}else{
			System.out.println("Vous avez déjà répondu "+ this.repetition + " fois au questionnaire, vous ne pouvez plus y répondre.");
		}
	}
	
}
