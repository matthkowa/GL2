package model.utilisateur;

import java.io.Serializable;

public class Module implements Serializable{

	private static final long serialVersionUID = -2755830623587653849L;
	private int id;
	private String nom;
	/**
	 * @param id
	 * @param nom
	 */
	public Module(int id, String nom) {
		this.id = id;
		this.nom = nom;
	}
	
	public Module() {
	}
	
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/* (non-Javadoc)
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
	
	@Override
	public String toString(){
		return nom;
	}


}
