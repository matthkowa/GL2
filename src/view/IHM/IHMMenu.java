//package view.IHM;
//
//import javax.swing.*;
//
//import controller.IHMListener;
//
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//
//public class IHMMenu extends JFrame {
//	private JPanel panneau1 = new JPanel();
//	private JPanel fond = new JPanel();
//	private JLabel texte = new JLabel("Bienvenue");
//	private IHMListener l = new IHMListener(fond);
//	
//	public IHMMenu(){
//		this.setPreferredSize(new Dimension(800,500));
//		this.pack();
//		this.setLayout(new BorderLayout());
//		this.add(new IHMBarreMenu(fond),BorderLayout.NORTH);
//        add(fond,BorderLayout.CENTER);
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setVisible(true);
//		
//	}
//
//	
//}
