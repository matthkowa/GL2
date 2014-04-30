package initialNode;

import java.util.Date;

public class Professeur extends Utilisateur {

	private int id;
	
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
			String adresse, int[] tel, String pseudo, String motDePasse,int id) {
		super(nom, prenom, dateNaissance, adresse, tel, pseudo, motDePasse);
		this.id = id;
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}

}
