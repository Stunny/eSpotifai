package threads;

import controller.GeneralController;
/**
 * Thread que controla el temps durant la seva execuci�
 * @author Elna Cabot, Miguel D�az, Marc Mill�n, Alejandro Vogel, Marta Zapatero
 * @version 1.0
 * @see Thread
 * @see GeneralController
 *
 */
public class TimeThread extends Thread {
	/**
	 * Controlador general
	 * @see GeneralController
	 */
	private GeneralController controller;
	/**
	 * Inicialitza un TimeThread per a controlar temps.
	 * @param controller Controlador general
	 */
	public TimeThread(GeneralController controller) {
		super();
		this.controller = controller;
	}
	/**
	 * 
	 */
	public void run() {

		while (true) {
				controller.trackTime();
		}
	}
}
