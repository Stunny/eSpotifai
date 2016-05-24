package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import network.database.DDBBConnection;
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

			int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this user?", "", JOptionPane.YES_NO_OPTION);
			if (reply == JOptionPane.YES_OPTION) {
				if(ddbbConnection.deleteUser(ddbbConnection.getName(main.getId())).equals("Deleted")){
					/*DeletedWindow deletedwindow = new DeletedWindow();
					deletedwindow.setVisible(true);*/
					JOptionPane.showMessageDialog(null, "User deleted succesfully.");
				} else {
					JOptionPane.showMessageDialog(null, "The user couldn't be deleted.");
				}
			} else {
				JOptionPane.showMessageDialog(null, "The user wasn't deleted.");
			}
		}
		else if (event.getActionCommand().equals("MainWindow.eliminar2ActionCommand")){

			int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this song?", "", JOptionPane.YES_NO_OPTION);
			if (reply == JOptionPane.YES_OPTION) {
				if(ddbbConnection.deleteSong(main.getIdSong()).equals("Deleted")){
					/*DeletedSongWindow deletedsongwindow = new DeletedSongWindow();
				deletedsongwindow.setVisible(true);*/
					JOptionPane.showMessageDialog(null, "Song deleted successfully.");
				} else {
					JOptionPane.showMessageDialog(null, "The song couldn't be deleted.");
				}
			} else {
				JOptionPane.showMessageDialog(null, "The song wasn't deleted.");
			}
		}



	}
}

