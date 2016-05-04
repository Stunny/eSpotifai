package provaConfigurationServer;

//import network;
//import database;

public class LoginManager {
	
	public LoginManager () {}
	
	public boolean login (String username, String password) {
			
		if (username.equals("username")) {
			System.out.println("username ok");
			if (password.equals("password")) {System.out.println("pass ok"); return true; }
			else { System.out.println("pass ko"); return false; }
		}
		else {System.out.println("username ko"); return false; }
		
		//if database.exists(username)
			//if database.contains(username, password)
				//return true;
			//else
				//network.sendMessage("incorrect password");
				//return false;
		// else
			//network.sendMessage("incorrect username");
			//return false;
	}
	
	public boolean register (String username, String password) {
		
		
		if (username.equals("username")) {System.out.println("user already exists"); return false; }
		else {
			if (password.length() >= 6 && password.matches(".*[A-Z].*") && password.matches(".*[0-9].*")) {
				System.out.println("register ok");
				return true;
			}
			else { System.out.println("invalid password"); return false; }
		}
		//if !database.exists(username)
			//if (password.length() >= 6 && password.matches(".*[A-Z].*") && password.matches(".*[0-9].*")) {}
				//database.update(username, password)
				//return true;
			//else 
				//network.sendMessage("invalid password");
				//return false;
		//else
			//network.sendMessage("invalid username");
			//return false;
	}

}
