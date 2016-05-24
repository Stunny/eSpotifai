package model.customExceptions;
/**
 * Excepci� que avisa de un error a l'hora de efectuar la conexi� amb el servidor.
 * @author Elna Cabot, Miguel D�az, Marc Mill�n, Alejandro Vogel, Marta Zapatero
 * @version 1.0
 * @see Exception
 *
 */
public class ServerNotFoundException extends Exception {
	
	public ServerNotFoundException() {
		super("Server Connection failed.");
	}

}
