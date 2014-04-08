package main;

import java.util.Calendar;
import java.util.Date;

import initialNode.*;


public class Main {

	/**
	 * @param args
	 */
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		Date k = cal.getTime();
		int k1= Calendar.DAY_OF_MONTH;
		int k2 = Calendar.YEAR;
	
		System.out.println(k.getDate());
		System.out.println(k1);
		System.out.println(k2);
		Utilisateur Jean = new Utilisateur("Jean","Dupont");
		

	}

}
