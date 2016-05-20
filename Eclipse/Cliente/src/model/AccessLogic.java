package model;

import java.util.LinkedList;

import javax.swing.JOptionPane;

import controller.NetworkController;
import network.ServerCommunication;

public class AccessLogic {
	
	
	//BUSCA EL USUARI Y SI LO ENCUENTRA MUESTRA SU PERFIL
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

