
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.AddList;
import view.MainWindow;
import view.PlaylistSearchUser;
import view.SelectedUserWindow;
import view.UserWindow;
import view.Vots;

/**
 * Controlador de menu emergent
 * @author Elna Cabot, Miguel Díaz, Marc Millán, Alejandro Vogel, Marta Zapatero
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
	 * Pantalla principal de l'aplicació
	 */
	private MainWindow mainwindow;
	/**
	 * Menu emergent d'afegir llista
	 */
	private AddList addlist;
	/**
	 * Menu emergent per puntuar una cançó
	 */
	private Vots vots;
	private SelectedUserWindow selecteduserwindow;
	private PlaylistSearchUser playlistsearchuser;
	private UserWindow userwindow;
	/**
	 * 	Construeix un nou controlador de menu emergent
	 * @param mainwindow Pantalla principal de l'aplicació
	 * @param addlist Menu emergent d'afegir llista
	 * @param vots Menu emergent per puntuar una cançó
	 * @see MainWindow
	 * @see AddList
	 * @see Vots
	 */
	public PopUpController(MainWindow mainwindow, AddList addlist, Vots vots, SelectedUserWindow selecteduserwindow,PlaylistSearchUser playlistsearchuser, UserWindow userwindow ){
		this.mainwindow = mainwindow;
		this.addlist = addlist;
		this.vots = vots;
		this.selecteduserwindow = selecteduserwindow;
		this.playlistsearchuser = playlistsearchuser;
		this.userwindow = userwindow;
	}
	/**
	 * 
	 */
	public void actionPerformed(ActionEvent event) {
		
		if (event.getActionCommand().equals("MainWindow.reproducirActionCommand")) {
			
		}
		if (event.getActionCommand().equals("MainWindow.anadirActionCommand")){
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
		
		if(event.getActionCommand().equals("MainWindow.modificarActionCommand")){
			
		
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
		
		//-------------------------------------------
		
		// VISUALITZEM LES CANÃ‡ONS EN EL PANELL GRAN
		if( event.getActionCommand().equals("SelectedUserWindow.visualitzarActionCommand")){
			//System.out.println("hola");
			//playlistsearchuser.setVisible(true);
		}
		
		// -----------------------------------------
		
		if(event.getActionCommand().equals("UserWindow.visualitzarActionCommand")){
			playlistsearchuser.setVisible(true);
			userwindow.setVisible(false);
		}
		
		if(event.getActionCommand().equals("PlaylistSearchUser.beforeActionCommand")){
			userwindow.setVisible(true);
			playlistsearchuser.setVisible(false);
		}
		
	}

}