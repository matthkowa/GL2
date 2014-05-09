package QCM;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import serializable.Serialiser;

public class Resultat extends Serialiser implements Serializable{

	private Set<Reponse> tableauDeReponse;

	public Resultat(Set<Reponse> tableauDeReponse) {
		super();
		this.tableauDeReponse = new HashSet<Reponse>();
		this.tableauDeReponse = tableauDeReponse;
	}

	public Resultat() {
		super();
		this.tableauDeReponse = new HashSet<Reponse>();
	}
	
	public Set<Reponse> getTableauDeReponse() {
		return tableauDeReponse;
	}

	public void setTableauDeReponse(Set<Reponse> tableauDeReponse) {
		this.tableauDeReponse = tableauDeReponse;
	}
	
	public String toString(){
		String temp="";
		for (Reponse R : tableauDeReponse){
			temp = temp + R;
		}
		return temp;
	}

}
