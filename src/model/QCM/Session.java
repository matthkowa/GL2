package model.QCM;

import java.util.*;
import view.menu.*;

public class Session {

	int idSession;
	Date dateDebut;
	Date dateFin;
	int repetition;
	
	public Session(int idSession, Date dateDebut, Date dateFin, int repetition) {
		super();
		this.idSession = idSession;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.repetition = repetition;
	}

	public int getIdSession() {
		return idSession;
	}

	public void setIdSession(int idSession) {
		this.idSession = idSession;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public java.util.Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public int getRepetition() {
		return repetition;
	}

	public void setRepetition(int repetition) {
		this.repetition = repetition;
	}
	
	public String toString(){
		return "La session num�ro " + this.idSession + " d�bute le " + View.affichageDate(dateDebut) + " et se termine le " + View.affichageDate(dateFin) + ".\nL'�tudiant peut y r�pondre " + this.repetition + " fois.";
	}
	
}
