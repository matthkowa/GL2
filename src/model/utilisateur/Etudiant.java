package model.utilisateur;

import java.util.*;

import model.QCM.*;


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
