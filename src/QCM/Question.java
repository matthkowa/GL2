package QCM;

public class Question {

	private int id;
	private String libelle;
	private QCM corps;
	
	/**
	 * @param id
	 * @param libelle
	 */
	public Question(int id, String libelle, QCM corps) {
		this.id = id;
		this.libelle = libelle;
		this.corps = corps;
	}
	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}
	/**
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	public QCM getCorps() {
		return corps;
	}
	
	
}
