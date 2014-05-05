package initialNode;

public class Module {
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
