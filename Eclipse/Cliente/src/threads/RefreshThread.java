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
			//try {
				//Thread.sleep(1000);
			//	System.out.println("Dummy");
				threadController.refreshSongList();
				
			/*} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}*/
			
		}

	}

}
