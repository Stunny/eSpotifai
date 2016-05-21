package model;

import javax.swing.JOptionPane;

import network.ServerCommunication;
/**
 * Implementa la l�gica d'acc�s a l'aplicaci�.
 * @author Elna Cabot, Miguel D�az, Marc Mill�n, Alejandro Vogel, Marta Zapatero
 * @version 1.0
 * @see ServerCommunication
 * @see JOptionPane
 *
 */
public class AccessLogic {
	
	
	/**
	 * Cerca nom d'usuari. En cas de no trobar-lo, mostrar� un missatge d'error.
	 * @param username Nom d'usuari introduit.
	 * @return En cas de trobar l'usuari retorna <i style="color:indigo;">TRUE</i>. En cas contrari retorna <i style="color:indigo;">FALSE</i>.
	 * @see JOptionPane
	 */
	public static boolean searchUser(String username){
		
		if(username.equalsIgnoreCase("elna")){
			return true;
		}else{
			JOptionPane.showMessageDialog(null, "User not found!", " ", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
	
	/**
	 * Realitza l'acc�s d'usuari a l'aplicaci�. En cas de que no es dugui a terme mostrar� un missatge d'error.
	 * @param username Nom d'usuari
	 * @param password Contrassenya d'usuari
	 * @return En cas de dur a terme el login retornar� <i style="color:indigo;">TRUE</i>. En cas contrari retornar� <i style="color:indigo;">FALSE</i>.
	 * @see ServerCommunication
	 * @see JOptionPane
	 * 
	 */
	public static boolean Login (String username, String password) {
		
		String request = new String("validateLogin:" + username + "/" + password);
		
		ServerCommunication servercommunication = new ServerCommunication();
		String resposta = servercommunication.sendData(request);
		
		if (resposta.equals("Welcome")) {
			JOptionPane.showMessageDialog(null, "Welcome to eSpotyfai, " + username + "!", " ", JOptionPane.ERROR_MESSAGE);
			return true;
		} else {
			if (resposta.equals("Incorrect username")) {
				JOptionPane.showMessageDialog(null, resposta + "!", " ", JOptionPane.ERROR_MESSAGE);
				return false;
			} else if (resposta.equals("Incorrect password")){
				JOptionPane.showMessageDialog(null, resposta + "!", " ", JOptionPane.ERROR_MESSAGE);
				return false;
			} else {
				JOptionPane.showMessageDialog(null, resposta + ".", " ", JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}
	}
	/**
	 * Realitza el registre d'un nou usuari. Mostrar� missatges d'error en cas de no complir els requeriments a l'hora de introduir les dades per al registre.
	 * @param username Nom d'usuari.
	 * @param password Contrassenya d'usuari.
	 * @return En cas d'un registre satisfactori retornar� <i style="color:indigo;">TRUE</i>. En cas contrari retornar� <i style="color:indigo;">FALSE</i>.
	 * @see JOptionPane
	 * @see ServerCommunication
	 */
	public static boolean Register (String username, String password) {
		
		if (password.length() < 6 || !password.matches(".*[A-Z].*") || !password.matches(".*[0-9].*")) {
			JOptionPane.showMessageDialog(null, "Invalid password!", " ", JOptionPane.PLAIN_MESSAGE);
			return false;
		} else {
			
			String request = new String("addUser:" + username + "/" + password);
			
			ServerCommunication servercommunication = new ServerCommunication();
			String resposta = servercommunication.sendData(request);
			
			if (resposta.equals("Added")) {
				JOptionPane.showMessageDialog(null, "Welcome to eSpotyfai, " + username + "!", " ", JOptionPane.PLAIN_MESSAGE);
				return true;
			} else if (resposta.equals("Username already in use")){
				JOptionPane.showMessageDialog(null, "Username already in use!", " ", JOptionPane.PLAIN_MESSAGE);
				return false;
			} else {
				JOptionPane.showMessageDialog(null, resposta + ".", " ", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			
		}
	
	}
	
	

}

