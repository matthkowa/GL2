package model.utilisateur;

import java.io.IOException;
import java.util.*;
import model.RechercheDonnees;
import model.QCM.*;
import view.menu.View;;


public class Etudiant extends Utilisateur{
	private static final long serialVersionUID = -3499573138679375552L;
	private int idEtudiant;

	public Etudiant(String nom, String prenom, Date dateNaissance, String adresse, int tel, String pseudo, String motDePasse,int idEtudiant){
		super(nom, prenom, dateNaissance, adresse, tel, pseudo, motDePasse);
		this.idEtudiant=idEtudiant;
	}
	
	public Etudiant(){
		super();
	}
	
	public void setIdEtudiant(int idEtudiant){
		this.idEtudiant=idEtudiant;
	}
	
	public int getIdEtudiant(){
		return this.idEtudiant;
	}
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + idEtudiant;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
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
	
	public void choisirSession(){
		All<Promotion> promoList = RechercheDonnees.recherchePromo();
		Iterator itPromo = promoList.set.iterator();
		Promotion promotion = new Promotion();
		
		while (itPromo.hasNext() || !(promotion.getSetEtudiant().contains((Etudiant) this)) ){
			promotion = (Promotion) itPromo.next();
			
		}
		
		All<Session> sessionList = RechercheDonnees.rechercheSession();
		Iterator itSession = sessionList.set.iterator();
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

	public void consulterResultat(Etudiant etu, Session sess){
		Date currentDate = new Date();
		if (currentDate.compareTo(sess.getDateFin())==1){
//			TODO			
//			res = (Resultat) res.relecture("QCM/" + sess.hashCode() + "/" + etu.idEtudiant);
//			System.out.println(res);
		}
		else {
			System.out.println("Vous n'êtes pas autorisé à consulter les résultats. Veuillez réessayer une fois la session terminée. ");
		}
		
	}
	
//	public void consulterResultat(Etudiant etu){
//		Date currentDate = new Date();
//		if (currentDate.compareTo(sess.getDateFin())==1){
//			Resultat res = new Resultat();
//			res = (Resultat) res.relecture("QCM/*/" + etu.idEtudiant);
//			System.out.println(res);
//		}
//		else {
//			System.out.println("Vous n'êtes pas autorisé à consulter les résultats. Veuillez réessayer une fois la session terminée.");
//		}
//		
//	}

}
