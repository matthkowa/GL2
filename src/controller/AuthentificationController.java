package controller;

import java.io.IOException;
import model.RechercheDonnees;
import model.utilisateur.*;
import view.menu.View;

public class AuthentificationController {
	private Boolean autReussi;

	/**
	 * Retourne la valeur de l'authentification : True Authentification reussie; False Echec.
	 * @return Boolean pour verifier si l'authentification est correcte
	 */

	public Boolean getAutReussi() {
		return autReussi;
	}
	
	/**
	 * Recuperer tous les utilisateurs pour verifier leur authentification et change les valeurs de autReussi en cas d'echec (false) ou de reussite (True)
	 * @return Utilisateur dont le pseudo correspond ou vide si aucune identification
	 */
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
		}
		
		return verifierPseudoMdp(utilisateurs,pseudo,mdp);
		}
		catch(IOException e){
			System.out.println("Erreur connexion");
			this.autReussi=false;
		}
		return (new Administrateur());
	}
	
	
	/**
	 * Trouve une correspondance entre un couple pseudo/mdp dans une liste d'utilisateur
	 * @param liste All<Utilisateur> Liste des utilisateurs
	 * @param pseudo String pseudo de connexion
	 * @param mdp String mot de passe 
	 * @return utilisateur correspondant aux identifiants ou utilisateur vide
	 */
	private Utilisateur verifierPseudoMdp(All<Utilisateur> liste,String pseudo,String mdp){
		Boolean b = true;
		for(Utilisateur u : liste.getSet()){
			if(u.getPseudo().compareTo(pseudo) == 0){
				if (u.getMotDePasse().compareTo(mdp)==0){
					System.out.println("Authentification réalisé");
					this.autReussi=true;
					return u;					
				}
			}
		}
		if(b){
			System.out.println("Echec Essayez Encore");
			this.autReussi=false;
		}
		return new Utilisateur();
		
			
		
	}
}
