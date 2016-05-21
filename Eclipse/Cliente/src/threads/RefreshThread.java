package threads;

import java.util.LinkedList;

import controller.NetworkController;
import model.Song;

public class RefreshThread extends Thread {

	public RefreshThread() {
		super();
	}
	
	public void run() {
		
		int i=0;
		while (true) {
			try {
				Thread.sleep(3000);
				System.out.println("Dummy");
				LinkedList<Song> songsList = NetworkController.getSongList();
				
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
			
		}

	}

}
