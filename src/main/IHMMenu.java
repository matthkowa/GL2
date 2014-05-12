package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class IHMMenu extends JFrame implements ActionListener {
	private JPanel panneau1 = new JPanel();
	private JLabel texte = new JLabel("Bienvenue");
	private JButton aut = new JButton("S'authentifier");
	private JButton quit = new JButton("Quitter");
	
	public IHMMenu(){
		this.setPreferredSize(new Dimension(300,300));
		this.pack();
		setLayout(new GridLayout(2,0));
        panneau1.add(aut);
        panneau1.add(quit);
       
        add(texte);
        add(panneau1);
        quit.addActionListener(this);
        aut.addActionListener(this);
        this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==aut){
			
			
		}
		if(e.getSource()==quit){
			System.exit(0);
		}
		
	}
}
