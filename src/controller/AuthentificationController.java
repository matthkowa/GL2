package controller;

import java.io.IOException;

import initialNode.*;

import model.RechercheDonnees;

import view.menu.View;

public class AuthentificationController {
	private Boolean autReussi;

	public Boolean getAutReussi() {
		return autReussi;
	}
	
	public Utilisateur authentification(){
		try{
		String pseudo = View.demandeString("Entrez votre pseudo :");
		String mdp = View.demandeString("Entrez votre mot de passe :");
		All<Utilisateur> utilisateurs = new All<Utilisateur>();
		All<Administrateur> listeA = RechercheDonnees.rechercheAdmin();
		All<Professeur> listeP = RechercheDonnees.rechercheProf();
		All<Etudiant> listeE = RechercheDonnees.rechercheEtudiant();
		for(Etudiant e : listeE.getSet()){
			utilisateurs.add((Utilisateur) e);
		
		}
		for(Professeur p : listeP.getSet()){
			utilisateurs.add((Utilisateur) p);
		}
		for(Administrateur a : listeA.getSet()){
			utilisateurs.add((Utilisateur) a);
			System.out.println(a.getPseudo());
		}
		
		return verifierPseudoMdp(utilisateurs,pseudo,mdp);
		}
		catch(IOException e){
			System.out.println("Erreur connexion");
			this.autReussi=false;
		}
		return (new Administrateur());
	}
	
	private Utilisateur verifierPseudoMdp(All<Utilisateur> liste,String pseudo,String mdp){
		int i =0;		
		Boolean b = true;
		for(Utilisateur u : liste.getSet()){
			if(u.getPseudo().compareTo(pseudo) == 0){
				if (u.getMotDePasse().compareTo(mdp)==0){
					System.out.println("Authentification réalisé");
					this.autReussi=true;
					return u;					
				}
			}
			i++;
		}
		if(b){
			System.out.println("Echec Essayez Encore");
			this.autReussi=false;
		}
		return new Utilisateur();
		
			
		
	}
}
