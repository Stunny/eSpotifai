package controller.threads;

import controller.ThreadController;

public class TimeThread extends Thread {

	private ThreadController controller;

	public TimeThread(ThreadController controller) {
		super();
		this.controller = controller;
	}

	public void run() {

		while (true) {
			controller.trackTime();
		}
	}
}
