package initialNode;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

import serializable.Serialiser;

public class AllAdmin extends Serialiser implements Serializable{
	public Set<Administrateur> administrateurs;

	public AllAdmin(Set<Administrateur> administrateur) {
		super();
		this.administrateurs = new HashSet();
		this.administrateurs = administrateur;
	}
	
	public AllAdmin() {
		super();
		this.administrateurs=new HashSet();
	}

	public Set<Administrateur> getAdministrateurs() {
		return administrateurs;
	}

	public void setAdministrateurs(Set<Administrateur> administrateur) {
		this.administrateurs= administrateur;
	}
	
	public void addAdmin(Administrateur admin){
		this.administrateurs.add(admin);
	}
	
}
