package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import model.DDBBConnection;

public class NetworkController {
	
	private DDBBConnection ddbbconnection;
	
	
	
	public NetworkController(DDBBConnection ddbbconnection) {
		super();
		this.ddbbconnection = ddbbconnection;
	}



	public String manageInput (String request) {
		
		GsonBuilder gsonBuilder = new GsonBuilder();
	    Gson gson = gsonBuilder.create();
		
	    System.out.println(request);
	    String s[] = request.split(":");
	    System.out.println(s[0]);
	    System.out.println(s[1]);
	    String args[] = s[1].split("/");
	    
	    String response = "Invalid request";
	    
	    try {
		switch (s[0]) {
		
		case "validateLogin" :
			response = ddbbconnection.userConnection(args[0], args[1]);
			break;
		case "addUser":
			response = ddbbconnection.addUser(args[0], args[1]);
			/*if (args[0].equals("username")) response = "Username already exists";
			else {
				response = "Added";
			}*/
			break;
		case "deleteUser":
			response = ddbbconnection.deleteUser(args[0]);
			break;
		case "addSong":
			//extreure dades de la request
			response = ddbbconnection.addSong(args[0], args[1], args[2], args[3], args[4], Integer.parseInt(args[5]));
			break;
		case "getUsers":
			response = gson.toJson(ddbbconnection.showUsers());
			break;
		case "getSongs":
			response = gson.toJson(ddbbconnection.showSongs());
			break; 
		case "deleteSong":
			response = ddbbconnection.deleteSong(Integer.parseInt(args[0]));
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
