package QCM;

public class QCM {
	
	private int idQCM;
	private String libelle;
	private Boolean estPrive;
	
	/**
	 * @param idQCM
	 * @param libelle
	 * @param estPrive
	 */
	public QCM(int idQCM, String libelle, Boolean estPrive) {
		this.idQCM = idQCM;
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
	 * @return the idQCM
	 */
	public int getIdQCM() {
		return idQCM;
	}

	/**
	 * @return the estPrive
	 */
	public Boolean getEstPrive() {
		return estPrive;
	}
	
	
	
	

}
