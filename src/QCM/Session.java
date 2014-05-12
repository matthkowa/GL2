package QCM;

import java.util.*;
import helpClass.*;

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
		return this.idSession + " " + this.toString(dateDebut) + " " + this.toString(dateFin) + " " + this.repetition;
	}
	
	public String toString(Date d){
		String day="";
		String month="";
		String year="";
		switch (d.getDay()){
		case 0 :
			day = "Dimanche";
			break;
		case 1 :
			day = "Lundi";
			break;
		case 2 :
			day = "Mardi";
			break;
		case 3 :
			day = "Mercredi";
			break;
		case 4 :
			day = "Jeudi";
			break;
		case 5 :
			day = "Vendredi";
			break;
		case 6 :
			day = "Samedi";
			break;
		}
		
		switch (d.getMonth()){
		case 0 :
			month = "Janvier";
			break;
		case 1 :
			month = "Fevrier";
			break;
		case 2 :
			month = "Mars";
			break;
		case 3 :
			month = "Avril";
			break;
		case 4 :
			month = "Mai";
			break;
		case 5 :
			month = "Juin";
			break;
		case 6 :
			month = "Juillet";
			break;
		case 7 :
			month = "Août";
			break;
		case 8 :
			month = "Septembre";
			break;
		case 9 :
			month = "Octobre";
			break;
		case 10 :
			month = "Novembre";
			break;
		case 11 :
			month = "Decembre";
			break;
		}
		if (d.getYear()<100){
			if (d.getYear()<10){
				year = "190"+ d.getYear();
			}
			else
			{
				year = "19" + d.getYear();
			}
		}
		else
		{
			year = String.valueOf(d.getYear());
		}
		
		return day + " " + d.getDate() + " " + month + " " + year;
	}
}
