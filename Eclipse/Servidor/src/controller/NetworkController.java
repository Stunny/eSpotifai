package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import database.DDBBConnection;

public class NetworkController {
	
	private DDBBConnection ddbbconnection;
	
	
	
	public NetworkController(DDBBConnection ddbbconnection) {
		super();
		this.ddbbconnection = ddbbconnection;
	}



	public String manageInput (String request) {
		
		GsonBuilder gsonBuilder = new GsonBuilder();
	    Gson gson = gsonBuilder.create();
	    String args[] = null;
		
	    System.out.println(request);
	    String s[] = request.split(":");
	    
	    String response = "Invalid request";
	    
	    try {
		switch (s[0]) {
		
		case "validateLogin" :
			args = s[1].split("/");
			response = ddbbconnection.userConnection(args[0], args[1]);
			break;
		case "addUser":
			args = s[1].split("/");
			response = ddbbconnection.addUser(args[0], args[1]);
			/*if (args[0].equals("username")) response = "Username already exists";
			else {
				response = "Added";
			}*/
			break;
		case "deleteUser":
			response = ddbbconnection.deleteUser(s[1]);
			break;
		case "addSong":
			//extreure dades de la request
			args = s[1].split("/");
			response = ddbbconnection.addSong(args[0], args[1], args[2], args[3], args[4], Integer.parseInt(args[5]));
			break;
		case "getUsers":
			response = gson.toJson(ddbbconnection.showUsers());
			break;
		case "getSongs":
			response = gson.toJson(ddbbconnection.showSongs());
			break; 
		case "deleteSong":
			response = ddbbconnection.deleteSong(Integer.parseInt(s[1]));
			break;
		default: 
			response = "Invalid request";
		
		}
	    } catch (Exception e) {
	    	response = "Invalid request";
	    	System.out.println(e);
	    }
		
		return response;
	}
	
	

}
