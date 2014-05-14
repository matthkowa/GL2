package model.utilisateur;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import model.serializable.Serialiser;


public class Promotion extends Serialiser implements Serializable{
	private static final long serialVersionUID = 383244048373251545L;
	protected Set<Etudiant> setEtudiant;
	private String promo;
	
	public Promotion(Set<Etudiant> setEtudiant, String promo) {
		super();
		this.setEtudiant = new HashSet<Etudiant>();
		this.setEtudiant = setEtudiant;
		this.promo = promo;
	}

	public Promotion() {
		super();
		this.setEtudiant = new HashSet<Etudiant>();
	}
	
	public Set<Etudiant> getSetEtudiant() {
		return setEtudiant;
	}

	public void setSetEtudiant(Set<Etudiant> setEtudiant) {
		this.setEtudiant = setEtudiant;
	}

	public String getPromo() {
		return promo;
	}

	public void setPromo(String promo) {
		this.promo = promo;
	}
	
	@Override
	public String toString(){
		return promo + " : \n" + setEtudiant.toString();
	}
	

}
