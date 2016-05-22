package controller;
/**
 * Actualitza les llistes amb un període determinat
 * @author Elna Cabot, Miguel Díaz, Marc Millán, Alejandro Vogel, Marta Zapatero
 * @version 1.0
 * @see Thread
 * @see GeneralController
 * @see InterruptedException
 *
 */
public class RefreshThread extends Thread {
	/**
	 * Controlador global
	 */
	private GeneralController controller;
	/**
	 * Construeix el Thread
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
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			controller.refreshLists2();
		}

	}

}
