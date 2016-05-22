
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.AddList;
import view.MainWindow;
import view.Vots;

/**
 * Controlador de menu emergent
 * @author Elna Cabot, Miguel D�az, Marc Mill�n, Alejandro Vogel, Marta Zapatero
 * @version 1.0
 * @see ActionListener
 * @see ActionEvent
 * @see MainWindow
 * @see AddList
 * @see Vots
 * @see JOptionPane
 *
 */
public class PopUpController implements ActionListener{
	/**
	 * Pantalla principal de l'aplicaci�
	 */
	private MainWindow mainwindow;
	/**
	 * Menu emergent d'afegir llista
	 */
	private AddList addlist;
	/**
	 * Menu emergent per puntuar una can��
	 */
	private Vots vots;
	/**
	 * 	Construeix un nou controlador de menu emergent
	 * @param mainwindow Pantalla principal de l'aplicaci�
	 * @param addlist Menu emergent d'afegir llista
	 * @param vots Menu emergent per puntuar una can��
	 * @see MainWindow
	 * @see AddList
	 * @see Vots
	 */
	public PopUpController(MainWindow mainwindow, AddList addlist, Vots vots){
		this.mainwindow = mainwindow;
		this.addlist = addlist;
		this.vots = vots;
	}
	/**
	 * 
	 */
	public void actionPerformed(ActionEvent event) {
		
		if (event.getActionCommand().equals("MainWindow.reproducirActionCommand")) {
			
		}
		if (event.getActionCommand().equals("MainWindow.anadirActionCommand")){
			AddList addlist = new AddList();
			addlist.setVisible(true);
		}
		if(event.getActionCommand().equals("MainWindow.delatePlaylistActionCommand")){
			int reply = JOptionPane.showConfirmDialog(null, "Seguro que quieres eliminar el usuario?", "", JOptionPane.YES_NO_OPTION);
			if (reply == JOptionPane.YES_OPTION) {
				
			}
			 
			
			
		}
		
		if(event.getActionCommand().equals("MainWindow.visualitzarActionCommand")){
			
		}
		
		if(event.getActionCommand().equals("MainWindow.votActionCommand")){
			vots.setVisible(true);
		}
	
		//--------- ACCION DE VOTAR ------------------
		
		if(event.getActionCommand().equals("Vots.jrb1")){
			JOptionPane.showMessageDialog(null, "puta");
		}
		if(event.getActionCommand().equals("Vots.jrb2")){
			JOptionPane.showMessageDialog(null, "puta2");
		}
		if(event.getActionCommand().equals("Vots.jrb3")){
			JOptionPane.showMessageDialog(null, "puta3");
		}
		if(event.getActionCommand().equals("Vots.jrb4")){
			JOptionPane.showMessageDialog(null, "puta4");
		}
		if(event.getActionCommand().equals("Vots.jrb5")){
			JOptionPane.showMessageDialog(null, "puta5");
		}
		
		
	}

}