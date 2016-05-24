package controller.threads;

import java.util.LinkedList;

import controller.NetworkController;
import controller.ThreadController;
import model.Song;
import view.MainWindow;
/**
 * Thread que actualitza la informaci� mostrada cada 3 segons
 * @author Elna Cabot, Miguel Diaz, Marc Mill�n, Alejandro Vogel, Marta Zapatero
 *
 */
public class RefreshThread extends Thread {
	/**
	 * Controlador de Thread
	 * @see ThreadController
	 */
	private ThreadController threadController;
	
	private NetworkController networkcontroller;
	/**
	 * Construeix el thread
	 * @param threadController Controlador de thread
	 */
	public RefreshThread(ThreadController threadController, NetworkController networkcontroller) {
		super();
		this.threadController = threadController;
		this.networkcontroller = networkcontroller;
	}




	/**
	 * 
	 */
	public void run() {

		int i=0;
		while (true) {
			try {
				Thread.sleep(1000);
				switch(threadController.getmainWindow().getMode()){
				case "all":
					threadController.refreshSongList();
					break;
				default:
					threadController.refreshSongListPlaylist();
					break;
				}

				threadController.refreshUserPlaylistList();
				threadController.refreshPublicPlaylistList();
				

			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}

		}

	}

}
