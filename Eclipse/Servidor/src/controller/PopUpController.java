package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import database.DDBBConnection;
import view.AddMusicWindow;
import view.FollowedsWindow;
import view.FollowersWindow;
import view.MainWindow;
import view.PlaylistsWindow;
import view.StatisticsWindow;

public class PopUpController implements ActionListener{
	private FollowersWindow followersWindow;
	private MainWindow main;
	private DDBBConnection ddbbConnection; 

	public PopUpController(MainWindow main, DDBBConnection ddbbConnection) {
		this.main = main;
		this.ddbbConnection = ddbbConnection;
	}

	public void actionPerformed(ActionEvent event) {

		if (event.getActionCommand().equals("MainWindow.seguidoresActionCommand")) {
			FollowersWindow followersWindow = new FollowersWindow(ddbbConnection.getFollowersDates(main.getId()), ddbbConnection.getName(main.getId()));
			followersWindow.setVisible(true);
		}
		else if (event.getActionCommand().equals("MainWindow.seguidosActionCommand")){

			FollowedsWindow followeds = new  FollowedsWindow(ddbbConnection.getFollowedsDates(main.getId()), ddbbConnection.getName(main.getId()));
			followeds.setVisible(true);
		}
		else if (event.getActionCommand().equals("MainWindow.listasActionCommand")){

			PlaylistsWindow playlits = new PlaylistsWindow (ddbbConnection.getPlaylistsDates(main.getId()), ddbbConnection.getName(main.getId()));
			playlits.setVisible(true);
		}
		else if (event.getActionCommand().equals("MainWindow.eliminarActionCommand")){

			int reply = JOptionPane.showConfirmDialog(null, "Seguro que quieres eliminar el usuario?", "", JOptionPane.YES_NO_OPTION);
			if (reply == JOptionPane.YES_OPTION) {
				if(ddbbConnection.deleteUser(ddbbConnection.getName(main.getId())).equals("Deleted")){
					/*DeletedWindow deletedwindow = new DeletedWindow();
					deletedwindow.setVisible(true);*/
					JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente.");
				} else {
					JOptionPane.showMessageDialog(null, "No se ha podido eliminar el usuario.");
				}
			} else {
				JOptionPane.showMessageDialog(null, "No se ha eliminado el usuario.");
			}
		}
		else if (event.getActionCommand().equals("MainWindow.eliminar2ActionCommand")){

			int reply = JOptionPane.showConfirmDialog(null, "Seguro que quieres eliminar la cancion?", "", JOptionPane.YES_NO_OPTION);
			if (reply == JOptionPane.YES_OPTION) {
				if(ddbbConnection.deleteSong(main.getIdSong()).equals("Deleted")){
					/*DeletedSongWindow deletedsongwindow = new DeletedSongWindow();
				deletedsongwindow.setVisible(true);*/
					JOptionPane.showMessageDialog(null, "Cancion eliminada correctamente.");
				} else {
					JOptionPane.showMessageDialog(null, "No se ha podido eliminar la cancion.");
				}
			} else {
				JOptionPane.showMessageDialog(null, "No se ha eliminado la cancion.");
			}
		}



	}
}

