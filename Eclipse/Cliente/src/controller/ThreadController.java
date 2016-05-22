package controller;

import java.util.LinkedList;

import model.Playlist;
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
	
	public void refresUserPlaylistList() {
		LinkedList<Playlist> playlistList = NetworkController.getPlaylists();
		mainWindow.refreshPlaylists(playlistList);
	}
	
	public void trackTime() {
		mainWindow.refreshTime();
	}
	
	

}
