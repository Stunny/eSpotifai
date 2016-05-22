package controller;

import java.util.LinkedList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import database.DDBBConnection;
import main.Main;
import model.Song;

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
				response = gson.toJson(ddbbconnection.getUsers());
				break;
			case "getSongs":
				response = gson.toJson(ddbbconnection.getSongs());
				break; 
			case "deleteSong":
				response = ddbbconnection.deleteSong(Integer.parseInt(s[1]));
				break;
			case "getPlaylists":
				response  = gson.toJson(ddbbconnection.getPlaylists());
				break;
			case "getFollowings":
				break;

			case "deletePlaylist": 
				response  = ddbbconnection.deletePlaylist(Integer.parseInt(s[1]));
				break;

			case "Follow":
				args = s[1].split("/");
				response  = ddbbconnection.follow(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
				break;
			case "UnFollow":
				args = s[1].split("/");
				response  = ddbbconnection.unFollow(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
				break;
			case "getPublicPlaylists":
				response  = gson.toJson(ddbbconnection.getPublicPlaylists(Integer.parseInt(s[1])));
				break;
			case "getSongFile":
				LinkedList<Song> list = ddbbconnection.getSongs();
				for (Song song : list) {
					if (song.getId() == Integer.parseInt(s[1])) {
						response = "ok";
						Main.setFilePath(song.getLocation());
					}
				}

				break;
			case "Songs From":
				response  = gson.toJson(ddbbconnection.getSongsList(Integer.parseInt(s[1])));
				break;
			case "Add Playlist":
				args = s[1].split("/");
				//System.out.println(args[0]+ Integer.parseInt(args[1])+Integer.parseInt(args[2]));
				//System.out.println("String: "+ddbbconnection.addPlaylist(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2])));
				//System.out.println("String: "+ddbbconnection.addPlaylist(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2])));
				//System.out.println("String: "+ddbbconnection.addPlaylist(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2])));
				response  = gson.toJson(ddbbconnection.addPlaylist(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2])));

			default: 
				response = "Invalid request";

			}

		} catch (Exception e) {
			response = "Invalid request";
			//System.out.println(e);
		}

		return response;
	}


}
