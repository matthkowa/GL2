package initialNode;

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
	
	


}
