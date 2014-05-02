package initialNode;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Promotion {

	private Set<Etudiant> setEtudiant;
	private String promo;
	
	public Promotion(Set<Etudiant> setEtudiant, String promo) {
		super();
		this.setEtudiant = setEtudiant;
		this.promo = promo;
	}

	public Set<Etudiant> getSetEtudiant() {
		return setEtudiant;
	}

	public void setSetEtudiant(Set<Etudiant> setEtudiant) {
		this.setEtudiant = setEtudiant;
	}

	public String getPromo() {
		return promo;
	}

	public void setPromo(String promo) {
		this.promo = promo;
	}
	

}
