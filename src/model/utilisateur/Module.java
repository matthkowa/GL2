package model.utilisateur;

import java.io.Serializable;

public class Module implements Serializable{

	private static final long serialVersionUID = -2755830623587653849L;
	private int id;
	private String nom;
	/**
	 * Constructeur complet de L'objet Module
	 * @param id
	 * @param nom
	 */
	public Module(int id, String nom) {
		this.id = id;
		this.nom = nom;
	}
	
	/**
	 * Constructeur vide de L'objet Module
	 */
	public Module() {
	}
	
	/**
	 * getter de l'attribut nom
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * setter de l'attribut nom
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * getter de l'attribut id
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		return result;
	}
	
	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Module other = (Module) obj;
		if (id != other.id)
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}
	
	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		return nom;
	}


}
