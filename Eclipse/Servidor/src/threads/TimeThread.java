package threads;

import controller.GeneralController;

public class TimeThread extends Thread {
	
	private GeneralController controller;

	public TimeThread(GeneralController controller) {
		super();
		this.controller = controller;
	}
	
	public void run() {

		while (true) {
				controller.trackTime();
		}
	}
}
