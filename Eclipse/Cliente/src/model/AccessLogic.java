package model;

import javax.swing.JOptionPane;

import network.ServerCommunication;
/**
 * 
 * @author Elna Cabot, Miguel D�az, Marc Mill�n, Alejandro Vogel, Marta Zapatero
 * @version 1.0
 * @see ServerCommunication
 * @see JOptionPane
 *
 */
public class AccessLogic {
	
	
	/**
	 * 
	 * @param username
	 * @return
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
	 * 
	 * @param username
	 * @param password
	 * @return
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
	 * 
	 * @param username
	 * @param password
	 * @return
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

