package model;

import javax.swing.JOptionPane;

public class AccessLogic {
	
	public static boolean Login (String username, String password) {
		if (username.equals("username")) {
			if (password.equals("password")) return true;
			else {
				JOptionPane.showMessageDialog(null, "Incorrect password!", " ", JOptionPane.ERROR_MESSAGE);
				return false;
				}
		}
		else {
			JOptionPane.showMessageDialog(null, "Incorrect username!", " ", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
	
	public static boolean Register (String username, String password) {
		if (username.equals("username")) {
			JOptionPane.showMessageDialog(null, "Username already in use.", " ", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else {
			if (password.length() >= 6 && password.matches(".*[A-Z].*") && password.matches(".*[0-9].*")) {
				JOptionPane.showMessageDialog(null, "Welcome to eSpotifai, " + username + "!", " ", JOptionPane.PLAIN_MESSAGE);
				return true;
			}
			else {
				JOptionPane.showMessageDialog(null, "Invalid password!", " ", JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}
	}

}
