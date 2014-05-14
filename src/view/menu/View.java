package view.menu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class View {
	/**
	 * Met en forme les menus 
	 * @param s String à afficher sur la console
	 */
	public static void affichageEnteteMenu(String s){
		System.out.println("---  "+s+"  ---");
	}
	
	public static String affichageDate(Date d){
			String day="";
			String month="";
			String year="";
			switch (d.getDay()){
			case 0 : day = "Dimanche"; break;
			case 1 : day = "Lundi"; break;
			case 2 : day = "Mardi"; break;
			case 3 : day = "Mercredi"; break;
			case 4 : day = "Jeudi"; break;
			case 5 : day = "Vendredi"; break;
			case 6 : day = "Samedi"; break;
			}
			switch (d.getMonth()){
			case 0 : month = "Janvier"; break;
			case 1 : month = "Fevrier"; break;
			case 2 : month = "Mars"; break;
			case 3 : month = "Avril"; break;
			case 4 : month = "Mai"; break;
			case 5 : month = "Juin"; break;
			case 6 : month = "Juillet"; break;
			case 7 : month = "Août"; break;
			case 8 : month = "Septembre"; break;
			case 9 : month = "Octobre"; break;
			case 10 : month = "Novembre"; break;
			case 11 : month = "Decembre"; break;
			}
			year = String.valueOf(1900 + d.getYear());
			return day + " " + d.getDate() + " " + month + " " + year;
	}
	/**
	 * Permet d'obtenir un boolean pour une question ayant une réponse dichotomique 
	 * @param s String à afficher sur la console
	 * @return Boolean retourne True si l'utilisateur saisie O ou Oui et retour false sinon
	 * @throws IOException
	 */
	public static Boolean demandeBoolean(String s) throws IOException{
		String res ="";
		Scanner sc = new Scanner(System.in);
		System.out.println(s);
		res = sc.nextLine();
		
		return ((res.toLowerCase()=="o")||(res.toLowerCase()=="oui"));
	}
	
	/**
	 * Permet d'obtenir une chaine de caractère entrée par l'utilisateur
	 * @param s String à afficher sur la console
	 * @return String saisie par l'utilisateur
	 * @throws IOException
	 */
	public static String demandeString(String s) throws IOException{
		String res="";
		Scanner sc = new Scanner(System.in);
		System.out.println(s);
		res = sc.nextLine();
		return res;
		
	}
	
	/**
	 * Permet la saisie d'un entier par l'utilisateur
	 * @param s String à afficher sur la console
	 * @return int Valeur entrée par l'utilisateur
	 * @throws IOException
	 */
	//méthode à utiliser lors de l'utilisation d'un scanner pour récupérer un int
	public static int demandeInt(String s) throws IOException{

		int res=1;
		Boolean test;
		do{
			test=true;
			Scanner sc = new Scanner(System.in);
			System.out.println(s);
			try{
				res = sc.nextInt();
			}
			catch(InputMismatchException e){
				System.out.println("Erreur, veuillez entrer un nombre entier!");
				test=false;
			}
		}
		while(!test);
		return res;
	}
	
	/**
	 * Permet la saisie d'une date par l'utilisateur
	 * @param s String à afficher à l'ecran
	 * @return Date valeur de la date entrée par l'utilisateur
	 * @throws IOException
	 */
	public static Date demandeDate(String s) throws IOException{
		Boolean test;
		String s2,s3;
		int day,month,year;
		Date d = new Date();
		do{
			test=true;
			s3="";
			day=0;
			month=0;
			year=0;
			try{
				s2 = demandeString(s);
				while ( day==0 || month==0 || year==0){	
					try
					{
						if (s2.charAt(0)=='/')
						{
							s2 = s2.substring(1, s2.length());
						}
							while ((s2.charAt(0)!='/')){
									s3 += s2.charAt(0);
									s2 = s2.substring(1, s2.length());
							}
						}catch(StringIndexOutOfBoundsException e){}
					if ((day!=0) && (month!=0) && (year==0))
					{
						year = Integer.parseInt(s3);
						if (year>100){
							year = year-1900;
						}
						
						s3="";
					}
					else
					{
						if ((day!=0) && (month==0) && (year==0))
						{
							month = Integer.parseInt(s3);
							s3="";
						}
						else
						{
							if ((day==0) && (month==0) && (year==0))
							{
								day = Integer.parseInt(s3);
								s3="";
							}
						}
					}
				}
				d = new Date(year,month-1,day);
			}
			catch(IllegalArgumentException e){
				System.out.println("Erreur, veuillez entrer la date correctement!");
				test=false;
			}
		}while(!test);
		return d;
	}
	
	
	/**
	 * choisi un objet parmi un set d'objets du même type.
	 * @param  set un set d'objet de type T
	 * @return Object un objet de type T
	 * @throws IOException
	 */
	public static <T> Object choix(Set<T> set) throws IOException{
		int i=1;
		List<Object> liste = new ArrayList<Object>();
		for (Object A : set){
			liste.add(A);
		};
		for (Object A : liste){
			System.out.println(" - "+i+" => "+A);
			i++;			
		}
		int num = 0;
		while(num<1 || num>liste.size()){
			num = demandeInt("Entrer le numéro d'un des objet ci-dessus : ");
		}
		return liste.get(num-1);
	}
	
}
