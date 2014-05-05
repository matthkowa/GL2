package initialNode;

import java.io.Serializable;
import java.util.Date;

import serializable.Serialiser;

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


}