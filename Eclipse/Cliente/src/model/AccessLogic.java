package model;

import java.util.LinkedList;

import javax.swing.JOptionPane;

import controller.NetworkController;
import network.ServerCommunication;
/**
 * Implementa la lògica d'accés a l'aplicació.
 * @author Elna Cabot, Miguel Díaz, Marc Millán, Alejandro Vogel, Marta Zapatero
 * @version 1.0
 * @see ServerCommunication
 * @see JOptionPane
 *
 */
public class AccessLogic {
	
	
		/**
	 * Cerca nom d'usuari. En cas de no trobar-lo, mostrarà un missatge d'error.
	 * @param username Nom d'usuari introduit.
	 * @return En cas de trobar l'usuari retorna <i style="color:indigo;">TRUE</i>. En cas contrari retorna <i style="color:indigo;">FALSE</i>.
	 * @see JOptionPane
	 */
	public static boolean searchUser( String username, NetworkController networkcontroller){
		LinkedList<User>  userlist = new LinkedList<User>();
		boolean ok;
		ok = false;
		userlist = networkcontroller.getUserList();
		for(int i = 0; i < userlist.size(); i++){
			if(username.equals(userlist.get(i).getUsername())){
				ok = true;
			}
		}
		System.out.println("OK"+ok);
		if(ok == true){
			return true;
		}else{
			JOptionPane.showMessageDialog(null, "User not found!", " ", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
	
	public static int getId( String username, NetworkController networkcontroller){
		LinkedList<User>  userlist = new LinkedList<User>();
		userlist = networkcontroller.getUserList();
		for(int i = 0; i < userlist.size(); i++){
			if(username.equals(userlist.get(i).getUsername())){
				return userlist.get(i).getId();			}
		}
		return 0;
	}
	
	/**
	 * Realitza l'accés d'usuari a l'aplicació. En cas de que no es dugui a terme mostrarà un missatge d'error.
	 * @param username Nom d'usuari
	 * @param password Contrassenya d'usuari
	 * @return En cas de dur a terme el login retornarà <i style="color:indigo;">TRUE</i>. En cas contrari retornarà <i style="color:indigo;">FALSE</i>.
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
	 * Realitza el registre d'un nou usuari. Mostrarà missatges d'error en cas de no complir els requeriments a l'hora de introduir les dades per al registre.
	 * @param username Nom d'usuari.
	 * @param password Contrassenya d'usuari.
	 * @return En cas d'un registre satisfactori retornarà <i style="color:indigo;">TRUE</i>. En cas contrari retornarà <i style="color:indigo;">FALSE</i>.
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

