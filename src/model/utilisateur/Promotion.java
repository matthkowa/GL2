package model.utilisateur;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import model.serializable.Serialiser;


public class Promotion extends Serialiser implements Serializable{
	private static final long serialVersionUID = 383244048373251545L;
	protected Set<Etudiant> setEtudiant;
	private String promo;
	
	/**
	 * Constructeur complet de Pormotion
	 * @param setEtudiant
	 * @param promo
	 */
	public Promotion(Set<Etudiant> setEtudiant, String promo) {
		super();
		this.setEtudiant = new HashSet<Etudiant>();
		this.setEtudiant = setEtudiant;
		this.promo = promo;
	}
	
	/**
	 * Constructeur vide de Promotion
	 */
	public Promotion() {
		super();
		this.setEtudiant = new HashSet<Etudiant>();
	}
	
	/**
	 * getter du set d'étudiant de la promotion
	 * @return setEtudiant ensemble des étudiants de la promotion
	 */
	public Set<Etudiant> getSetEtudiant() {
		return setEtudiant;
	}

	/**
	 * setter du set d'étudiant de la promotion
	 * @param setEtudiant ensemble des étudiants de la promotion
	 */
	public void setSetEtudiant(Set<Etudiant> setEtudiant) {
		this.setEtudiant = setEtudiant;
	}

	/**
	 * getter du nom de la promotion
	 * @return promo nom de la promotion
	 */
	public String getPromo() {
		return promo;
	}
	
	/**
	 * setter du nom de la promotion
	 * @param promo nom de la promotion
	 */
	public void setPromo(String promo) {
		this.promo = promo;
	}
	
	/**
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
	
	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		return promo + " : \n" + setEtudiant.toString();
	}

	/**
	 * Permet d'ajouter un étudiant au set d'étudiant de la promotion
	 * @param etu un étudiant à ajouter à la promotion
	 */
	public void add(Etudiant etu) {
		this.setEtudiant.add(etu);
	}

	/**
	 * Permet de supprimer un étudiant au set d'étudiant de la promotion
	 * @param etu un étudiant à supprimer à la promotion
	 */
	public void remove(Etudiant etu) {
		this.setEtudiant.remove(etu);
	}
	

}
