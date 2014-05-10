package helpClass;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DonneeUtil {

	//méthode à utiliser lors de l'utilisation d'un scanner pour récupérer un String
	public static String DemandeString(String s){
		String res="";
		Scanner sc = new Scanner(System.in);
		System.out.println(s);
		res = sc.nextLine();
		return res;
	}
	
	//méthode à utiliser lors de l'utilisation d'un scanner pour récupérer un int
	public static int DemandeInt(String s){
		int res=1;
		Boolean test=true;
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
	
}

