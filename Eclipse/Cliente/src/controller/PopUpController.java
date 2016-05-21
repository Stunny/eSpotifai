
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


public class PopUpController implements ActionListener{
	private MainWindow mainwindow;
	private AddList addlist;
	private Vots vots;
	private SelectedUserWindow selecteduserwindow;
	private PlaylistSearchUser playlistsearchuser;
	private UserWindow userwindow;
		
	public PopUpController(MainWindow mainwindow, AddList addlist, Vots vots, SelectedUserWindow selecteduserwindow,PlaylistSearchUser playlistsearchuser, UserWindow userwindow ){
		this.mainwindow = mainwindow;
		this.addlist = addlist;
		this.vots = vots;
		this.selecteduserwindow = selecteduserwindow;
		this.playlistsearchuser = playlistsearchuser;
		this.userwindow = userwindow;
	}

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
		
		// VISUALITZEM LES CANÇONS EN EL PANELL GRAN
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