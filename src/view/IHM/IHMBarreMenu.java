package view.IHM;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;

import controller.IHMListener;


public class IHMBarreMenu  extends JMenuBar{
	
	
	

	private static final long serialVersionUID = -2342025907211862489L;
	private JMenu test1 = new JMenu("Fichier");
	  private JMenu test1_2 = new JMenu("Sous ficher");
	  private JMenu test2 = new JMenu("Edition");
	  private JMenu authentification = new JMenu("Authentification");

	  private JMenuItem item1 = new JMenuItem("Ouvrir");
	  private JMenuItem item2 = new JMenuItem("Fermer");
	  private JMenuItem item3 = new JMenuItem("Lancer");
	  private JMenuItem item4 = new JMenuItem("Arr�ter");

	  private JCheckBoxMenuItem jcmi1 = new JCheckBoxMenuItem("Choix 1");
	  private JCheckBoxMenuItem jcmi2 = new JCheckBoxMenuItem("Choix 2");

	  private JRadioButtonMenuItem jrmi1 = new JRadioButtonMenuItem("Radio 1");
	  private JRadioButtonMenuItem jrmi2 = new JRadioButtonMenuItem("Radio 2");
	 
	  


	 

	  public IHMBarreMenu(JPanel fond){
		
		  
		IHMListener l =new IHMListener(fond);
	    //On initialise nos menus      
	    this.test1.add(item1);

	    //On ajoute les �l�ments dans notre sous-menu
	    this.test1_2.add(jcmi1);
	    this.test1_2.add(jcmi2);
	    //Ajout d'un s�parateur
	    this.test1_2.addSeparator();
	    //On met nos radios dans un ButtonGroup
	    ButtonGroup bg = new ButtonGroup();
	    bg.add(jrmi1);
	    bg.add(jrmi1);
	    //On pr�s�lectionne la premi�re radio
	    jrmi1.setSelected(true);

	    this.test1_2.add(jrmi1);
	    this.test1_2.add(jrmi2);

	    //Ajout du sous-menu dans notre menu
	    this.test1.add(this.test1_2);
	    //Ajout d'un s�parateur
	    this.test1.addSeparator();
	    item2.addActionListener(new ActionListener(){
	      public void actionPerformed(ActionEvent arg0) {
	        System.exit(0);
	      }        
	    });
	    this.test1.add(item2);  
	    this.test2.add(item3);
	    this.test2.add(item4);
	    authentification.addMenuListener(l);
	    //L'ordre d'ajout va d�terminer l'ordre d'apparition dans le menu de gauche � droite
	    //Le premier ajout� sera tout � gauche de la barre de menu et inversement pour le dernier
	    add(test1);
	    this.add(test2);
	    add(authentification);
	    
	    
	   
	  
	}
}

