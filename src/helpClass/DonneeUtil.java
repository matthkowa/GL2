package helpClass;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DonneeUtil {

	//m�thode � utiliser lors de l'utilisation d'un scanner pour r�cup�rer un String
	public static String DemandeString(String s){
		String res="";
		Scanner sc = new Scanner(System.in);
		System.out.println(s);
		res = sc.nextLine();
		return res;
	}
	
	//m�thode � utiliser lors de l'utilisation d'un scanner pour r�cup�rer un int
	public static int DemandeInt(String s){
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
	
	public static Date DemandeDate(String s){
		Boolean temp;
		String s2;
		Date d = new Date();
		do{
			temp=true;
			try{
				s2 = DonneeUtil.DemandeString(s);
				d = new Date(s2);
			}
			catch(IllegalArgumentException e){
				System.out.println("Erreur, veuillez entrer la date correctement!");
				temp=false;
			}
		}while(!temp);
		return d;
	}
	
}

