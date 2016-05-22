package threads;

import controller.GeneralController;
/**
 * Actualitza un thread
 * @author Elna Cabot, Miguel D�az, Marc Mill�n, Alejandro Vogel, Marta Zapatero
 * @version 1.0
 * @see GeneralController
 * @see Thread
 * 
 *
 */
public class RefreshThread extends Thread {
	/**
	 * Controlador general
	 * @see GeneralController
	 */
	private GeneralController controller;
	/**
	 * Actualitza un thread
	 * @param controller
	 */
	public RefreshThread(GeneralController controller) {
		super();
		this.controller = controller;
	}
	/**
	 * 
	 */
	public void run() {

		while (true) {
			try {
				Thread.sleep(3000);
				controller.refreshLists2();
				//controller.trackTime();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
	}
}
