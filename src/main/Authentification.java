package main;

import initialNode.Administrateur;
import initialNode.All;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Authentification {
	private Boolean autReussi;
	
	public Authentification(){
	}
	
	public Boolean getAutReussi() {
		return autReussi;
	}
	/*public Professeur authentificationProf(){
		System.out.println("Entrez votre pseudo :");
		Scanner sc = new Scanner(System.in);
		String pseudo = sc.next();
		System.out.println("Entrez votre mot de passe :");
		String mdp = sc.next();
		AllProf liste = recherchePseudoProf();
		return verifierAdmin(liste,pseudo,mdp);
	}*/
	
	public Administrateur authentificationAdmin(){
		System.out.println("Entrez votre pseudo :");
		Scanner sc = new Scanner(System.in);
		String pseudo = sc.next();
		System.out.println("Entrez votre mot de passe :");
		String mdp = sc.next();
		All<Administrateur> liste = recherchePseudoAdmin();
		return verifierAdmin(liste,pseudo,mdp);
	}
	
	private All<Administrateur> recherchePseudoAdmin(){
		String path = "Utilisateur/Administrateur/Administrateur";
		All<Administrateur> newAdmin = new All<Administrateur>();
		return (All<Administrateur>) newAdmin.relecture(path);
	}
	
	private Administrateur verifierAdmin(All<Administrateur> liste,String pseudo,String mdp){
		int i =0;
		
		Boolean b = true;
		for(Administrateur a : liste.getSet()){
			if(a.getPseudo().compareTo(pseudo) == 0){
				
				
				if (a.getMotDePasse().compareTo(mdp)==0){
					System.out.println("Authentification réalisé");
					this.autReussi=true;
					return a;
					
				}
			}
			i++;
		}
		if(b){
			System.out.println("Echec Essayez Encore");
			this.autReussi=false;
		}
		return new Administrateur();
		
			
		
	}
	
}
