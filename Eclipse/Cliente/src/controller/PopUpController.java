
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.AccessLogic;
import view.AddList;
import view.MainWindow;
import view.ModifyNameList;
import view.PlaylistSearchUser;
import view.SelectedUserWindow;
import view.UserWindow;
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
	private SelectedUserWindow selecteduserwindow;
	private PlaylistSearchUser playlistsearchuser;
	private UserWindow userwindow;

	private NetworkController networkcontroller;
	private ModifyNameList modifynamelist;
	
		
	public PopUpController(MainWindow mainwindow, AddList addlist, Vots vots, SelectedUserWindow selecteduserwindow,PlaylistSearchUser playlistsearchuser, UserWindow userwindow, NetworkController networkcontroller, ModifyNameList modifynamelist ){

	/**
	 * 	Construeix un nou controlador de menu emergent
	 * @param mainwindow Pantalla principal de l'aplicaci�
	 * @param addlist Menu emergent d'afegir llista
	 * @param vots Menu emergent per puntuar una can��
	 * @see MainWindow
	 * @see AddList
	 * @see Vots
	 */
	
		this.mainwindow = mainwindow;
		this.addlist = addlist;
		this.vots = vots;
		this.selecteduserwindow = selecteduserwindow;
		this.playlistsearchuser = playlistsearchuser;
		this.userwindow = userwindow;
		this.networkcontroller = networkcontroller;
		this.modifynamelist = modifynamelist;
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
			int reply = JOptionPane.showConfirmDialog(null, "Seguro que quieres eliminar la playlist?", "", JOptionPane.YES_NO_OPTION);
			if (reply == JOptionPane.YES_OPTION) {
				//String resposta = networkcontroller.deletePlaylist(mainwindow.getId2());
				if(networkcontroller.deletePlaylist(Integer.valueOf(mainwindow.getId())).equals("Deleted")){
					JOptionPane.showMessageDialog(null, "La lista se ha eliminado correctamente", " ", JOptionPane.INFORMATION_MESSAGE);
				};
			}else{
				JOptionPane.showMessageDialog(null, "No se ha podido eliminar la canción.");
			}
			 
			
			
		}
		
		if(event.getActionCommand().equals("MainWindow.visualitzarActionCommand")){
			mainwindow.setMode(mainwindow.getId());
		}
		
		if(event.getActionCommand().equals("MainWindow.visualitzarPlaylitsActionCommand")){
			mainwindow.setMode(mainwindow.getId());
		}
		
		if(event.getActionCommand().equals("MainWindow.votActionCommand")){
			vots.setVisible(true);
		}
		
		if(event.getActionCommand().equals("PlaylistSearchUser.visualitzarActionCommand")){
			mainwindow.setMode(playlistsearchuser.getId());
		}
		
		if(event.getActionCommand().equals("SelectedUserWindow.visualitzarActionCommand")){
			mainwindow.setMode(selecteduserwindow.getId());
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
		
		
		
		
		if(event.getActionCommand().equals("UserWindow.visualitzarActionCommand")){
			/*selecteduserwindow.refreshUser(mainWindow.getTypedSearch());
				selecteduserwindow.refreshPlaylists(AccessLogic.getPlaylists(mainWindow.getTypedSearch(), networkcontroller.getPlaylists()));
				selecteduserwindow.setVisible(true); 
			 * */
			
			
			playlistsearchuser.refreshPlaylists(AccessLogic.getPlaylists(userwindow.getNombre(), networkcontroller.getPlaylists()));
			playlistsearchuser.setVisible(true);
			userwindow.setVisible(false);
		}
		
		if(event.getActionCommand().equals("PlaylistSearchUser.beforeActionCommand")){
			userwindow.setVisible(true);
			playlistsearchuser.setVisible(false);
		}
		
	}

}