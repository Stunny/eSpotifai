package controller;
/**
 * Actualitza les llistes amb un per�ode determinat
 * @author Elna Cabot, Miguel D�az, Marc Mill�n, Alejandro Vogel, Marta Zapatero
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
