package model.utilisateur;

import java.io.Serializable;
import java.util.Date;

import view.menu.View;

public class Utilisateur implements Serializable{
	private String nom;
	private String prenom;
	private Date dateNaissance;
	private String adresse;
	private int tel;
	protected String pseudo;
	protected String motDePasse;
	
	
	
	public Utilisateur(String nom, String prenom, Date dateNaissance,
			String adresse, int tel, String pseudo, String motDePasse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
		this.tel = tel;
		this.pseudo = pseudo;
		this.motDePasse = motDePasse;
	}	
	public Utilisateur() {
		super();
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	
	@Override
	public String toString(){
		String s="";
		s+=this.getNom()+" / ";
		s+=this.getPrenom()+" / ";
		s+=View.affichageDate(getDateNaissance())+" / ";
		s+=this.getAdresse()+" / ";
		s+=this.getTel()+" / ";
		s+=this.getPseudo()+" / ";
		s+=this.getMotDePasse()+" \n ";
		return s;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
		result = prime * result
				+ ((dateNaissance == null) ? 0 : dateNaissance.hashCode());
		result = prime * result
				+ ((motDePasse == null) ? 0 : motDePasse.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		result = prime * result + ((pseudo == null) ? 0 : pseudo.hashCode());
		result = prime * result + tel;
		return result;
	}
}