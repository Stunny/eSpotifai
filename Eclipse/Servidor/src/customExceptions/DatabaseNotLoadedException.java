package customExceptions;
/**
 * Excepcio activada quan no es troba la base de dades
 * @author Elna Cabot, Miguel D�az, Marc Mill�n, Alejandro Vogel, Marta Zapatero
 * @version 1.0
 * @see Exception
 *
 */
public class DatabaseNotLoadedException extends Exception {
	/**
	 * Construeix l'excepci�
	 * @param message
	 * @see Exception
	 */
	public DatabaseNotLoadedException(String message) {
		super(message);
	}

}
