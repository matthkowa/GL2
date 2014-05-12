package view.menu;

import helpClass.DonneeUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class View {
	
	
	public static String demandeString(String s) throws IOException{
		String res="";
		Scanner sc = new Scanner(System.in);
		System.out.println(s);
		res = sc.nextLine();
		return res;
		
	}
	
	//m�thode � utiliser lors de l'utilisation d'un scanner pour r�cup�rer un int
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
	
	public static Date demandeDate(String s) throws IOException{
		Boolean test;
		String s2,s3;
		int day,month,year,i;
		Date d = new Date();
		do{
			test=true;
			s3="";
			day=0;
			month=0;
			year=0;
			i=0;
			try{
				s2 = DonneeUtil.DemandeString(s);
				while (day==0 || month==0 || year==0){	
					if (s2!="")
					{
						if (s2.charAt(0)=='/')
						{
							s2 = s2.substring(1, s2.length());
							while ((s2.charAt(0)!='/')){
								s3 += s2.charAt(0);
								s2 = s2.substring(1, s2.length());
							}
						}
					}
					System.out.println("coucou2");
					if ((day!=0) && (month!=0) && (year==0))
					{
						year = Integer.parseInt(s3);
						s3="";
					}
					else
					{
						System.out.println("coucou4");
						if ((day!=0) && (month==0) && (year==0))
						{
							month = Integer.parseInt(s3);
							s3="";
						}
						else
						{
							System.out.println("coucou6");
							if ((day==0) && (month==0) && (year==0))
							{
								System.out.println(s3+s2);
								day = Integer.parseInt(s3);
								s3="";
							}
						}
					}
				}
				d = new Date(day,month,year);
			}
			catch(IllegalArgumentException e){
				System.out.println("Erreur, veuillez entrer la date correctement!");
				test=false;
			}
		}while(!test);
		return d;
	}
	
	
	/**
	 * choisi un objet parmi un set d'objets du m�me type.
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
		Scanner sc2 = new Scanner(System.in);
		int num = 0;
		while(num<1 || num>liste.size()){
			System.out.println("Entrer le num�ro d'un des objet ci-dessus : ");
			num = sc2.nextInt();
		}
		return liste.get(num-1);
	}
	
	
	
}