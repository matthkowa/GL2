package initialNode;


import java.io.Serializable;
import java.util.*;

import serializable.Serialiser;

public class All<T> extends Serialiser implements Serializable{
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
	
}
