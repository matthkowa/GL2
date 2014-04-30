package QCM;

public class QCM {
	
	private int id;
	private String libelle;
	private Boolean estPrive;
	
	/**
	 * @param id
	 * @param libelle
	 * @param estPrive
	 */
	public QCM(int id, String libelle, Boolean estPrive) {
		this.id = id;
		this.libelle = libelle;
		this.estPrive = estPrive;
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

	/**
	 * @return the estPrive
	 */
	public Boolean getEstPrive() {
		return estPrive;
	}
	
	
	
	

}
