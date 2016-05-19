package customExceptions;

public class ServerNotFoundException extends Exception {
	
	public ServerNotFoundException() {
		super("La connexio amb el servidor ha fallat.");
	}

}
