package controller;

import java.util.Arrays;
import java.util.LinkedList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Playlist;
import model.Song;
import model.User;
import network.FileServerCommunication;
import network.ServerCommunication;
/**
 * Controlador de comunicaci� amb el servidor. 
 * @author Elna Cabot, Miguel D�az, Marc Mill�n, Alejandro Vogel, Marta Zapatero
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

		return songlist;
	}
	
	public static LinkedList<Integer> getFollowing(int id){
		String request =  "getFollowing:" + id;
		ServerCommunication servercommunication = new ServerCommunication();
		String resposta = servercommunication.sendData(request);
		
		
		GsonBuilder gsonBuilder = new GsonBuilder();
	    Gson gson = gsonBuilder.create();
	    Integer[] s = gson.fromJson(resposta, Integer[].class);
	    
	    LinkedList<Integer> idfollowing = new LinkedList<Integer>(Arrays.asList(s));
		return idfollowing;
		
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


	public static LinkedList<Playlist> getPublicPlaylists(int id) {
		String request = "getPublicPlaylists:"+id;

		ServerCommunication servercommunication = new ServerCommunication();
		String resposta = servercommunication.sendData(request);


		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.create();
		Playlist[] p = gson.fromJson(resposta, Playlist[].class);


		LinkedList<Playlist> playlistlist = new LinkedList<Playlist>(Arrays.asList(p));
		return playlistlist;
	}
	
	public static String updateVotacio(int id, int votacio){
		String request = "updateVotacio:"+id + "/" +votacio;

		ServerCommunication servercommunication = new ServerCommunication();
		String resposta = servercommunication.sendData(request);
		
		return resposta;
	}
	
	
	
	public static String deletePlaylist(int i){
		String request = "deletePlaylist:" +i;
		
		
		ServerCommunication servercommunication = new ServerCommunication();
		String resposta = servercommunication.sendData(request);

		return resposta;
		
	}
	
	public static String updatePlaylist(String name, int id){
		String request = "updatePlaylist:" + name+ "/" +id;
		
		ServerCommunication servercommunication = new ServerCommunication();
		String resposta = servercommunication.sendData(request);

		return resposta;
		

	}

	public static int[] getSongsPlaylistList(int id) {
	String request = "Songs From:"+id;
	
	ServerCommunication servercommunication = new ServerCommunication();
	String resposta = servercommunication.sendData(request);
	
	
	GsonBuilder gsonBuilder = new GsonBuilder();
    Gson gson = gsonBuilder.create();
	return gson.fromJson(resposta, int[].class);
	}
	
	
	
	public static String addPlaylist(String name, int id, int publica){
			String request = "Add Playlist:"+name+"/"+id+"/"+publica;
			ServerCommunication servercommunication = new ServerCommunication();
			String resposta = servercommunication.sendData(request);		
			GsonBuilder gsonBuilder = new GsonBuilder();
		    Gson gson = gsonBuilder.create();
			//return gson.fromJson(resposta, String.class);
		    return "add";
	}
	
	public static String getSongFile(int id) {
		
		String request = "getSongFile:"+id;

		System.out.println("Primero hablamos con el server");
		ServerCommunication servercommunication = new ServerCommunication();
		String resposta = servercommunication.sendData(request);
		System.out.println("Hemos hablado con el server");
		if (resposta.equals("ok")) {
			System.out.println("ha dicho que si!\nVamos a pedir el archivo");
			FileServerCommunication fileservercommunication = new FileServerCommunication();
			boolean ok = fileservercommunication.askForFile();
			if (ok) {
				System.out.println("Nos han dado el archivo");
				return "ok";
			}
			else {
				System.out.println("Nos hemos quedado sin archivo");
				return "ko";
			}
			//System.out.println("No hemos pedido archivo.");
			
		} else {System.out.println("Dice que no");return "ko";}
	}
	
	public static String getFollowingFile(int id){
		String request = "getFollowingFile:" + id;
		
		ServerCommunication servercommunication = new ServerCommunication();
		String resposta = servercommunication.sendData(request);
		if(resposta.equals("ok")){
			FileServerCommunication fileservercommunication = new FileServerCommunication();
			boolean ok = fileservercommunication.askForFile();
			if(ok){
				return "ok cliente";
			}else{
				return "ko cliente ";
				
			}
			
		}else{
			return "ko cliente 2";
		}
		
	}

	
	public static String AddSong(int idSong, int idPlaylist) {
		  String request = "AddSong:"+idSong+"/"+idPlaylist;
		  ServerCommunication servercommunication = new ServerCommunication();
		  String resposta = servercommunication.sendData(request);  
		  GsonBuilder gsonBuilder = new GsonBuilder();
		     Gson gson = gsonBuilder.create();
		     return gson.fromJson(resposta, String.class);
		  
	}
	
	
	
	
	

}
