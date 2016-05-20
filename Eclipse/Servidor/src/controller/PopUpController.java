package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.DDBBConnection;
import view.AddMusicWindow;
import view.DeletedSongWindow;
import view.DeletedWindow;
import view.FollowedsWindow;
import view.FollowersWindow;
import view.MainWindow;
import view.PlaylistsWindow;
import view.StatisticsWindow;

public class PopUpController implements ActionListener{
	private MainWindow main;
	private DDBBConnection model; 
		
	public PopUpController(MainWindow main, DDBBConnection model) {
		this.main = main;
		this.model =model;
	}

	public void actionPerformed(ActionEvent event) {
		
		if (event.getActionCommand().equals("MainWindow.seguidoresActionCommand")) {
			FollowersWindow followers = new  FollowersWindow(model.getFollowersDates(main.getId()), model.getName(main.getId()));
			 followers.setVisible(true);
		}else if (event.getActionCommand().equals("MainWindow.seguidosActionCommand")){
			FollowedsWindow followeds = new  FollowedsWindow(model.getFollowedsDates(main.getId()), model.getName(main.getId()));
			followeds.setVisible(true);
		}else if (event.getActionCommand().equals("MainWindow.listasActionCommand")){
			PlaylistsWindow playlits = new PlaylistsWindow (model.getPlaylistsDates(main.getId()), model.getName(main.getId()));
			playlits.setVisible(true);
		}else if (event.getActionCommand().equals("MainWindow.eliminarActionCommand")){
			if(model.deleteUser(model.getName(main.getId())).equals("Deleted")){
				DeletedWindow deletedwindow = new DeletedWindow();
				deletedwindow.setVisible(true);
			}
		}else if (event.getActionCommand().equals("MainWindow.eliminar2ActionCommand")){
			if(model.deleteSong(main.getIdSong()).equals("Deleted")){
				DeletedSongWindow deletedsongwindow = new DeletedSongWindow();
				deletedsongwindow.setVisible(true);
			}
		}
		
	}
}
