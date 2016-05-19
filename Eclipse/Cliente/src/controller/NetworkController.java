package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import model.User;
import network.ServerCommunication;

public class NetworkController {
	 
	
	public static void showUserList() {
		
		String request = "getUsers:";
		
		ServerCommunication servercommunication = new ServerCommunication();
		String resposta = servercommunication.sendData(request);
		
		System.out.println(resposta);
		
		GsonBuilder gsonBuilder = new GsonBuilder();
	    Gson gson = gsonBuilder.create();
		User[] u = gson.fromJson(resposta, User[].class);

	}

}
