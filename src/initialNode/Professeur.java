package initialNode;

import java.util.Date;

public class Professeur extends Utilisateur {
	private int idProf;
	
	public Professeur() {
		super();
	}

	public int getIdProf() {
		return idProf;
	}

	public void setIdProf(int idProf) {
		this.idProf = idProf;
	}
	
	/**
	 * @param nom
	 * @param prenom
	 * @param dateNaissance
	 * @param adresse
	 * @param tel
	 * @param pseudo
	 * @param motDePasse
	 */
	public Professeur(String nom, String prenom, Date dateNaissance,
			String adresse, int tel, String pseudo, String motDePasse,int id) {
		super(nom, prenom, dateNaissance, adresse, tel, pseudo, motDePasse);
		this.idProf = id;
	}


}
