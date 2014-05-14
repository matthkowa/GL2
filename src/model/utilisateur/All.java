package model.utilisateur;


import java.io.Serializable;
import java.util.*;

import model.serializable.Serialiser;


public class All<T> extends Serialiser implements Serializable{
	private static final long serialVersionUID = -4255886924773838605L;
	public Set<T> set;
	
	/**
	 * Constructeur complet 
	 * @param set ensemble d'objet de type T (set)
	 */
	public All(Set<T> set) {
		super();
		this.set = new HashSet<T>();
		this.set = set;
	}
	
	/**
	 * Constructeur vide
	 */
	public All() {
		super();
		this.set=new HashSet<T>();
	}

	/**
	 * Setter de set
	 * @return set ensemble d'objet de type T (set)
	 */
	public Set<T> getSet() {
		return this.set;
	}
	
	/**
	 * Getter de set (set d'objet de type T)
	 * @param set ensemble d'objet de type T (set)
	 */
	public void setSet(Set<T> set) {
		this.set= set;
	}
	
	/**
	 * Ajoute un objet T à l'attribut set (set d'objet T)
	 * @param objet objet de type T
	 */
	public void add(T objet){
		this.set.add(objet);
	}
	
	/**
	 * Ajoute un set d'objets T à l'attribut set (set d'objet T)
	 * @param c set d'objet de type T
	 */
	public void addAll(Collection<T> c){
		this.set.addAll(c);
	}
	
	/**
	 * supprime un objet T à l'attribut set (set d'objet T)
	 * @param objet objet de type T
	 */
	public void remove(T objet){
		this.set.remove(objet);
	}
	
}
