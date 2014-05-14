package serializable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.crypto.Cipher;
import javax.crypto.SealedObject;
import javax.crypto.SecretKey;

public class Serialiser implements Serializable{
	private static final long serialVersionUID = 7112754214151288557L;

	/**
	 * Consructeur vide
	 */
	public Serialiser(){}
	
	/**
	 * Crypte et Sauvegarde un Objet d'une classe fille de Serializer dans un fichier
	 * @param s chemin vers le fichier de sauvegarde
	 */
	public void sauvegarder(String s){
		try	{
			Cipher cipher = Cipher.getInstance("DES");
			SecretKey key = null;
			try	{
				FileInputStream f = new FileInputStream(new File("secretkey"));
				ObjectInputStream ois = new ObjectInputStream(f);
				key = ((SecretKey) ois.readObject());
				ois.close();
				f.close();
			}
			catch (Exception e){
				System.out.println("Erreur"+e);
			}
			cipher.init(Cipher.ENCRYPT_MODE, key);
			SealedObject sealedObject = new SealedObject(this, cipher);
			
			FileOutputStream f = new FileOutputStream(new File(s));
			ObjectOutputStream oos = new ObjectOutputStream(f);
			oos.writeObject(sealedObject);
			oos.close();
			f.close();
			}
			catch (Exception e){
				System.out.println("Erreur "+e);
			}
	}
	
	/**
	 * Charge et décrypte un Objet d'une classe fille de Serializer dans un fichier
	 * @param s chemin vers le fichier de chargement
	 */
	public Object relecture(String s) {
		try	{

			SecretKey key = null;
			try	{
				FileInputStream f = new FileInputStream(new File("secretkey"));
				ObjectInputStream ois = new ObjectInputStream(f);
				key = ((SecretKey) ois.readObject());
				ois.close();
				f.close();
			}
			catch (Exception e){
				System.out.println("Erreur "+e);
			}
			
			FileInputStream f = new FileInputStream(new File(s));
			ObjectInputStream ois = new ObjectInputStream(f);
			Object o = ((Object) ois.readObject());			
			SealedObject sealedObject = ((SealedObject) o);
			String algorithmName = sealedObject.getAlgorithm();
	        Cipher cipher = Cipher.getInstance(algorithmName);
	        cipher.init(Cipher.DECRYPT_MODE, key);
			ois.close();
			f.close();
			o = (Object) sealedObject.getObject(cipher);
			return o;
			
		}
		catch (Exception e){
			System.out.println("Erreur h "+e);
		}
		return null;	
	}
	
	
}
