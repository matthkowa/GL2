package helpClass;

import java.io.IOException;
import java.util.*;


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
				s2 = DonneeUtil.DemandeString(s);
				while (day==0 || month==0 || year==0){				
					while ((s2.charAt(0)!='/') || (s2!="")){
						s3 += s2.charAt(0);
						s2 = s2.substring(1, s2.length()-1);
					}
					if (day==0 && month==0 && year==0)
					{
						day = Integer.parseInt(s3);
					}
					else
					{
						if (day!=0 && month==0 && year==0)
						{
							month = Integer.parseInt(s3);
						}
						else
						{
							if (day!=0 && month!=0 && year==0)
							{
								year = Integer.parseInt(s3);
							}
						}
					}
					if (s2!=""){
					s2 = s2.substring(1, s2.length()-1);
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
		Scanner sc2 = new Scanner(System.in);
		int num = 0;
		while(num<1 || num>liste.size()){
			System.out.println("Entrer le numéro d'un des objet ci-dessus : ");
			num = sc2.nextInt();
		}
		return liste.get(num-1);
	}
	
}

