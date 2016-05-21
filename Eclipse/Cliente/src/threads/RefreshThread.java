package threads;

import java.util.LinkedList;

import controller.NetworkController;
import controller.ThreadController;
import model.Song;
import view.MainWindow;

public class RefreshThread extends Thread {
	
	private ThreadController threadController;

	public RefreshThread(ThreadController threadController) {
		super();
		this.threadController = threadController;
	}


	
	public void run() {
		
		int i=0;
		while (true) {
			try {
				Thread.sleep(3000);
				threadController.refreshSongList();
				threadController.refresUserPlaylistList();
				
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
			
		}

	}

}
