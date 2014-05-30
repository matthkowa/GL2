package model.utilisateur;

import java.io.Serializable;
import java.util.Date;

import view.menu.View;

public class Utilisateur implements Serializable{
	private static final long serialVersionUID = -3976221059597373244L;
	private String nom;
	private String prenom;
	private Date dateNaissance;
	private String adresse;
	private int tel;
	protected String pseudo;
	protected String motDePasse;
	
	
	/**
	 * Constructeur complet de Utilisateur
	 * @param nom chaine de caractères
	 * @param prenom chaine de caractères
	 * @param dateNaissance date de naissance sous forme d'objet de type date
	 * @param adresse chaine de caractères
	 * @param tel numéro de teléphone sous forme d'entier
	 * @param pseudo chaine de caractères
	 * @param motDePasse mot de passe sous forme de chaine de caractères
	 */
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
	
	/** 
	 * Constructeur vide de Utilisateur
	 */
	public Utilisateur() {
		super();
	}
	
	/**
	 * getter de l'attribut adresse
	 * @return adresse l'adresse de l'utilisateur
	 */
	public String getAdresse() {
		return adresse;
	}
	
	/**
	 * setter de l'attribut adresse
	 * @param adresse l'adresse de l'utilisateur
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	/**
	 * getter de l'attribut tel
	 * @return tel le telephone de l'utilisateur
	 */
	public int getTel() {
		return tel;
	}
	
	/**
	 * setter de l'attribut tel
	 * @param tel le telephone de l'utilisateur
	 */
	public void setTel(int tel) {
		this.tel = tel;
	}
	
	/**
	 * getter de l'attribut pseudo
	 * @return pseudo le pseudo de l'utilisateur
	 */
	public String getPseudo() {
		return pseudo;
	}
	
	/**
	 * getter de l'attribut motDePasse
	 * @return motDePasse le mot de passe de l'utilisateur
	 */
	public String getMotDePasse() {
		return motDePasse;
	}
	
	/**
	 * setter de l'attribut motDePasse
	 * @param motDePasse le mot de passe de l'utilisateur
	 */
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	
	/**
	 * setter de l'attribut nom
	 * @return nom le nom de l'utilisateur
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * setter de l'attribut nom
	 * @param nom le nom de l'utilisateur
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * getter de l'attribut adresse
	 * @return prenom le prénom de l'utilisateur
	 */
	public String getPrenom() {
		return prenom;
	}
	
	/**
	 * setter de l'attribut prenom
	 * @param prenom le prénom de l'utilisateur
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	/**
	 * getter de l'attribut DateNaissance
	 * @return dateNaissance la date de naissance de l'utilisateur
	 */
	public Date getDateNaissance() {
		return dateNaissance;
	}
	
	/**
	 * setter de l'attribut DateDeNaissance
	 * @param dateNaissance la date de naissance de l'utilisateur
	 */
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	
	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		String s="";
		s+=this.getNom()+" / ";
		s+=this.getPrenom()+" / ";
		s+=View.affichageDate(getDateNaissance())+" / ";
		s+=this.getAdresse()+" / ";
		s+="0" + this.getTel()+" / ";
		s+=this.getPseudo()+" / ";
		s+=this.getMotDePasse()+" \n ";
		return s;
	}
	
	/**
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
	
	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utilisateur other = (Utilisateur) obj;
		if (adresse == null) {
			if (other.adresse != null)
				return false;
		} else if (!adresse.equals(other.adresse))
			return false;
		if (dateNaissance == null) {
			if (other.dateNaissance != null)
				return false;
		} else if (!dateNaissance.equals(other.dateNaissance))
			return false;
		if (motDePasse == null) {
			if (other.motDePasse != null)
				return false;
		} else if (!motDePasse.equals(other.motDePasse))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		if (pseudo == null) {
			if (other.pseudo != null)
				return false;
		} else if (!pseudo.equals(other.pseudo))
			return false;
		if (tel != other.tel)
			return false;
		return true;
	}
}