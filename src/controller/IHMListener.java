package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class IHMListener implements ActionListener, MouseListener, MenuListener {
	private JPanel l;
	
	public IHMListener(JPanel l){
		this.l=l;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if ( ( (JMenu) ( e.getSource() ) ).getText().equals("Authentification") ){
    		System.out.println("Authentifie toi");    		
    	}
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void menuCanceled(MenuEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void menuDeselected(MenuEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void menuSelected(MenuEvent e) {
		if ( ( (JMenu) ( e.getSource() ) ).getText().equals("Authentification") ){
			JLabel jl = new JLabel("Coucou");
			l.removeAll();
			l.add(jl);
			
    		System.out.println("coucou");
    	}
		
	}
	
}
