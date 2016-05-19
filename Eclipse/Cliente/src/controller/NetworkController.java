package controller;

import java.util.Arrays;
import java.util.LinkedList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import model.Song;
import model.User;
import network.ServerCommunication;

public class NetworkController {
	 
	
	public static LinkedList<User> getUserList() {
		
		String request = "getUsers:";
		
		ServerCommunication servercommunication = new ServerCommunication();
		String resposta = servercommunication.sendData(request);
		
		
		GsonBuilder gsonBuilder = new GsonBuilder();
	    Gson gson = gsonBuilder.create();
		User[] u = gson.fromJson(resposta, User[].class);

		LinkedList<User> userlist = new LinkedList<User>(Arrays.asList(u));
			
		return userlist;

	}
	
	public static LinkedList<Song> getSongList() {
		
		String request = "getSongs:";
		
		ServerCommunication servercommunication = new ServerCommunication();
		String resposta = servercommunication.sendData(request);
		
		
		GsonBuilder gsonBuilder = new GsonBuilder();
	    Gson gson = gsonBuilder.create();
		Song[] s = gson.fromJson(resposta, Song[].class);

		LinkedList<Song> songlist = new LinkedList<Song>(Arrays.asList(s));
			
		return songlist;
	}

}
