package model.utilisateur;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;

import model.RechercheDonnees;
import model.QCM.*;
import view.menu.View;;


public class Etudiant extends Utilisateur implements Serializable{
	private static final long serialVersionUID = -3499573138679375552L;
	private int idEtudiant;

	/**
	 * Constructeur complet de la classe Etudiant
	 * @param nom
	 * @param prenom
	 * @param dateNaissance
	 * @param adresse
	 * @param tel
	 * @param pseudo
	 * @param motDePasse
	 * @param idEtudiant
	 */
	public Etudiant(String nom, String prenom, Date dateNaissance, String adresse, int tel, String pseudo, String motDePasse,int idEtudiant){
		super(nom, prenom, dateNaissance, adresse, tel, pseudo, motDePasse);
		this.idEtudiant=idEtudiant;
	}
	
	/**
	 * Constructeur vide de la classe Etudiant
	 */
	public Etudiant(){
		super();
	}
	
	/**
	 * Modifie l'idEtudiant de Etudiant
	 * @param idEtudiant
	 */
	public void setIdEtudiant(int idEtudiant){
		this.idEtudiant=idEtudiant;
	}
	
	/**
	 * Renoie l'idEtudiant de Etudiant
	 * @return idEtudiant
	 */
	public int getIdEtudiant(){
		return this.idEtudiant;
	}
	
	/**
	 * Renvoie la promotion de l'étudiant
	 */
	public Promotion getPromo(){
		All<Promotion> listePromo = RechercheDonnees.recherchePromo();
		Iterator<Promotion> itPromo = listePromo.set.iterator();
		Boolean finBoucle = true;
		Promotion promo = null;
		
		while(itPromo.hasNext() || finBoucle){
			promo = (Promotion) itPromo.next();
			if (promo.getSetEtudiant().contains(this)){
				finBoucle = false;
			}
		}
		
		return promo;
	}
	
	
	
	/**
	 * Renvoie le hashCode de l'étudiant
	 **/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + idEtudiant;
		return result;
	}

	/**
	 * Compare l'étudiant à un autre objet
	 * Renvoie vrai si obj = Etudiant, faux sinon 
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;		
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Etudiant other = (Etudiant) obj;
		if (idEtudiant != other.idEtudiant)
			return false;
		return true;
	}
	
	/**
	 * Permet à l'étudiant de choisir une session à laquelle participer
	 */
	public void choisirSession(){

		Promotion promotion = this.getPromo();
		
		All<Session> sessionList = RechercheDonnees.rechercheSession();
		Iterator<Session> itSession = sessionList.set.iterator();
		Session sess = new Session();
		All<Session> sessionPossibles = new All<Session>();
		
		while(itSession.hasNext()){
			
			sess = (Session) itSession.next();
			
			if (sess.getPromotion().getPromo().equals(promotion.getPromo())){
				sessionPossibles.add(sess);
			}
			
		}
		
		try{
			System.out.println("Veuillez choisir la session à laquelle vous souhaitez participer : ");
			sess = (Session) View.choix(sessionPossibles.set);
			sess.repondreQCM(this);
		}catch (IOException ioe){
			System.out.println("Erreur d'entrée sortie");
		}
	}
}
