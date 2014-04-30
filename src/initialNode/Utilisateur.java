package initialNode;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Utilisateur {
private String nom;
private String prenom;
private Date dateNaissance;
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
public Utilisateur(String nom,String prenom,Date dateNaissance)
{
	this.nom = nom;
	this.prenom=prenom;
	this.dateNaissance=dateNaissance;
}



}
