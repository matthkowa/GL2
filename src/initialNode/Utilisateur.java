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
public  int getAge() {
	Date date = new Date();
	
	int age = date.getYear() -  this.dateNaissance.getYear() ;
	return age;
	
	
	
}
public Date getDateNaissance() {
	return dateNaissance;
}
public void setDateNaissance(Date dateNaissance) {
	this.dateNaissance = dateNaissance;
}
public Utilisateur(String nom,String prenom)
{
	this.nom = nom;
	this.prenom=prenom;
	
}



}
