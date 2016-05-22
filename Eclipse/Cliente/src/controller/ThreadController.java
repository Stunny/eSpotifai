package controller;

import java.util.LinkedList;

import model.AccessLogic;
import model.Playlist;
import model.Song;
import view.MainWindow;
/**
 * Controlador de threads de l'aplicaci�
 * @author Elna Cabot, Miguel D�az, Marc Mill�n, Alejandro Vogel, Marta Zapatero
 * @version 1.0
 * @see MainWindow
 * @see NetworkController
 * @see Thread
 * @see Song
 * 
 *
 */
public class ThreadController {
	/**
	 * Pantalla principal de l'aplicaci�
	 * 
	 */
	private MainWindow mainWindow;
	/**
	 * Construeix un nou controlador de threads
	 * @param mainWindow Pantalla principal de l'aplicaci�
	 */
	public ThreadController(MainWindow mainWindow) {
		super();
		this.mainWindow = mainWindow;
	}

	/**
	 * Actualitza la llista de can�ons segons el contingut del servidor
	 */
	public void refreshSongList() {
		LinkedList<Song> songsList = NetworkController.getSongList();
		mainWindow.refreshSongs(songsList);
	}

	public void refreshSongListPlaylist(){
		LinkedList<Song> songsList = NetworkController.getSongList();
		//System.out.println("Mode: ");
		//System.out.println(mainWindow.getMode());
		//System.out.println(Integer.valueOf(mainWindow.getMode()));
		int[] array = NetworkController.getSongsPlaylistList(Integer.valueOf(mainWindow.getMode()));
		mainWindow.refreshSongs(AccessLogic.getSongsFromPlaylist(songsList, array));
	}

	public void refresUserPlaylistList() {
		LinkedList<Playlist> playlistList = NetworkController.getPlaylists();
		mainWindow.refreshPlaylists(playlistList);
	}

	public void refresPublicPlaylistList() {
		LinkedList<Playlist> playlistList = NetworkController.getPublicPlaylists(mainWindow.getUserId());
		mainWindow.refreshPublicPlaylists(playlistList);
	}

	public void trackTime() {
		mainWindow.refreshTime();
	}


	public MainWindow getmainWindow(){
		return mainWindow;
	}


}
