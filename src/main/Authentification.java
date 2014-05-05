package main;

import initialNode.Administrateur;
import initialNode.AllAdmin;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Authentification {
	private Boolean autReussi;
	public Authentification(){
		System.out.println("Entrez votre pseudo :");
		Scanner sc = new Scanner(System.in);
		String pseudo = sc.next();
		System.out.println("Entrez votre mot de passe :");
		String mdp = sc.next();
		ArrayList<String[]> liste = recherchePseudo();
		this.autReussi = verifier(liste,pseudo,mdp);
		}
	
	public Boolean getAutReussi() {
		return autReussi;
	}

	private ArrayList<String[]> recherchePseudo(){
		
		ArrayList<String[]> liste = new ArrayList<String[]>();
		String path = "Administrateur";
		AllAdmin newAdmin = new AllAdmin();
		newAdmin = (AllAdmin) newAdmin.relecture(path);
		String str[] = new String[2];
		for(Administrateur a : newAdmin.getAdministrateurs()){
			str[0]=a.getPseudo();
			str[1]=a.getMotDePasse();
			System.out.println(str[0]+" mdp :"+str[1]);
			liste.add(str);
		}
		return liste;
	}
	
	private Boolean verifier(ArrayList<String[]> liste,String pseudo,String mdp){
		int i =0;
		Boolean b = true;
		
		while(i<liste.size() && b ){
			if(liste.get(i)[0].compareTo(pseudo) == 0){
				b=false;
				
				if (liste.get(i)[1].compareTo(mdp)==0){
					System.out.println("Authentification réalisé");
					return true;
				}
			}
			i++;
		}
		if(b){
			System.out.println("Echec Essayez Encore");
			
		}
		return false;
		
			
		
	}
	
}
