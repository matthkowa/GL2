package QCM;

import java.util.HashSet;
import java.util.Set;

public class Resultat {

	private Set<Reponse> tableauDeReponse;

	public Resultat(Set<Reponse> tableauDeReponse) {
		super();
		this.tableauDeReponse = new HashSet<Reponse>();
		this.tableauDeReponse = tableauDeReponse;
	}

	public Set<Reponse> getTableauDeReponse() {
		return tableauDeReponse;
	}

	public void setTableauDeReponse(Set<Reponse> tableauDeReponse) {
		this.tableauDeReponse = tableauDeReponse;
	}
	

}
