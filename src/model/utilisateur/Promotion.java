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
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((promo == null) ? 0 : promo.hashCode());
		result = prime * result
				+ ((setEtudiant == null) ? 0 : setEtudiant.hashCode());
		return result;
	}
	
	@Override
	public String toString(){
		return promo + " : \n" + setEtudiant.toString();
	}

	public void add(Etudiant etu) {
		this.setEtudiant.add(etu);
	}

	public void remove(Etudiant etu) {
		this.setEtudiant.remove(etu);
	}
	

}
