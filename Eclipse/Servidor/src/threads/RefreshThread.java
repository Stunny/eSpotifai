package threads;

import controller.GeneralController;

public class RefreshThread extends Thread {
	
	private GeneralController controller;

	public RefreshThread(GeneralController controller) {
		super();
		this.controller = controller;
	}
	
	public void run() {

		while (true) {
			try {
				Thread.sleep(3000);
				controller.refreshLists();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
			
		}

	}

}
