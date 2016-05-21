package controller;

import java.util.Arrays;
import java.util.LinkedList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import model.Playlist;
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
		
		for(int i = 0; i < userlist.size(); i++){
			System.out.println(userlist.get(i).getUsername());
		}
			
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
		/*for(int  i = 0; i < songlist.size(); i++){
			System.out.println(songlist.get(i).getName());
		}*/
			
		return songlist;
	}
	


	
	public static LinkedList<Playlist> getPlaylists() {
		String request = "getPlaylists:";
		
		ServerCommunication servercommunication = new ServerCommunication();
		String resposta = servercommunication.sendData(request);
		
		
		GsonBuilder gsonBuilder = new GsonBuilder();
	    Gson gson = gsonBuilder.create();
		Playlist[] p = gson.fromJson(resposta, Playlist[].class);
		
	
		LinkedList<Playlist> playlistlist = new LinkedList<Playlist>(Arrays.asList(p));
		/*for(int  i = 0; i < songlist.size(); i++){
			System.out.println(songlist.get(i).getName());
		}*/
			
		return playlistlist;
	}


}
