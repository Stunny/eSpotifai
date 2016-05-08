package model;

import javax.swing.JOptionPane;

public class AccessLogic {
	
	public static boolean Login (String username, String password) {
		if (username.equals("username")) {
			if (password.equals("password")) return true;
			else {
				JOptionPane.showMessageDialog(null, "Incorrect password!");
				return false;
				}
		}
		else {
			JOptionPane.showMessageDialog(null, "Incorrect username!");
			return false;
		}
	}

}
