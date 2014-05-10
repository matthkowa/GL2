package QCM;

import java.util.Date;

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
		return this.idSession + " " + this.dateDebut + " " + this.dateFin + " " + this.repetition;
	}
	
}
