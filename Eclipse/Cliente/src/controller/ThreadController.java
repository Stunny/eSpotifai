package controller;

import java.util.LinkedList;

import model.Song;
import view.MainWindow;

public class ThreadController {
	
	private MainWindow mainWindow;
	
	public ThreadController(MainWindow mainWindow) {
		super();
		this.mainWindow = mainWindow;
	}
	
	
	public void refreshSongList() {
		LinkedList<Song> songsList = NetworkController.getSongList();
		mainWindow.refreshSongs(songsList);
	}
	
	public void trackTime() {
		mainWindow.refreshTime();
	}

}
