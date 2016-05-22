package threads;

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
	/**
	 * Construeix el thread
	 * @param threadController Controlador de thread
	 */
	public RefreshThread(ThreadController threadController) {
		super();
		this.threadController = threadController;
	}


	

	/**
	 * 
	 */
	public void run() {
		while (true) {
			try {
				Thread.sleep(3000);
				System.out.println(threadController.getmainWindow().getMode());
				switch(threadController.getmainWindow().getMode()){
				case "all":
					threadController.refreshSongList();
				break;
				
				case "user lists":
					
				break;
				default:
					threadController.refreshSongListPlaylist();
				break;
			}
				threadController.refresUserPlaylistList();
				threadController.refresPublicPlaylistList();
				
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
			
		}

	}

}
