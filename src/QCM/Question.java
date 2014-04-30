package QCM;

public class Question {

	private int idQuestion;
	private String libelle;
	private QCM corps;
	
	/**
	 * @param idQuestion
	 * @param libelle
	 */
	public Question(int idQuestion, String libelle, QCM corps) {
		this.idQuestion = idQuestion;
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
	 * @return the idQuestion
	 */
	public int getIdQuestion() {
		return idQuestion;
	}
	
	public QCM getCorps() {
		return corps;
	}
	
	
}
