package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import database.DDBBConnection;
import view.AddMusicWindow;
import view.DeletedSongWindow;
import view.DeletedWindow;
import view.FollowedsWindow;
import view.FollowersWindow;
import view.MainWindow;
import view.PlaylistsWindow;
import view.StatisticsWindow;

public class PopUpController implements ActionListener{
	private FollowersWindow view;
	private MainWindow main;
	private DDBBConnection ddbbConnection; 

	public PopUpController(MainWindow main, DDBBConnection ddbbConnection) {
		this.main = main;
		this.ddbbConnection = ddbbConnection;
	}

	public void actionPerformed(ActionEvent event) {

		if (event.getActionCommand().equals("MainWindow.seguidoresActionCommand")) {
			FollowersWindow view = new FollowersWindow(ddbbConnection.getFollowersDates(main.getId()), ddbbConnection.getName(main.getId()));
			view.setVisible(true);
		}else if (event.getActionCommand().equals("MainWindow.seguidosActionCommand")){

			FollowedsWindow followeds = new  FollowedsWindow(ddbbConnection.getFollowedsDates(main.getId()), ddbbConnection.getName(main.getId()));
			followeds.setVisible(true);
		}else if (event.getActionCommand().equals("MainWindow.listasActionCommand")){

			PlaylistsWindow playlits = new PlaylistsWindow (ddbbConnection.getPlaylistsDates(main.getId()), ddbbConnection.getName(main.getId()));
			playlits.setVisible(true);
		}else if (event.getActionCommand().equals("MainWindow.eliminarActionCommand")){

			if(ddbbConnection.deleteUser(ddbbConnection.getName(main.getId())).equals("Deleted")){
				DeletedWindow deletedwindow = new DeletedWindow();
				deletedwindow.setVisible(true);
			}
		}else if (event.getActionCommand().equals("MainWindow.eliminar2ActionCommand")){
			if(ddbbConnection.deleteSong(main.getIdSong()).equals("Deleted")){
				DeletedSongWindow deletedsongwindow = new DeletedSongWindow();
				deletedsongwindow.setVisible(true);
			}
		}

	}
}

