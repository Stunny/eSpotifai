package controller;

import java.util.Arrays;
import java.util.LinkedList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Playlist;
import model.Song;
import model.User;
import network.ServerCommunication;
/**
 * Controlador de comunicació amb el servidor. 
 * @author Elna Cabot, Miguel Díaz, Marc Millán, Alejandro Vogel, Marta Zapatero
 * @version 1.0
 * @see ServerCommunication
 * @see GsonBuilder
 * @see Gson
 * @see User
 * @see Song
 *
 */
 
public class NetworkController {
	 
	/**
	 * Du a terme una <i>request</i> de <strong>getUserList</strong> al servidor
	 * @return Server response: List of users
	 * @see User
	 */
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
	/**
	 * Du a terme una <i>request</i> de <strong>getSongs</strong> al servidor
	 * @return Server response: List of songs
	 * @see Song
	 */
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
