package model;

import java.util.ArrayList;

public class User {
	private int id;
	private String username; 
	private String registre;
	private String lastAccess;
	private String password;
	private ArrayList<Playlist> playlist; 
	private ArrayList<User> following;
	
	public User(int id, String username, String registre, String lastAccess, String password, ArrayList<Playlist> playlist, ArrayList<User> following){
		this.id = id;
		this.username = username; 
		this.registre = registre;
		this.lastAccess = lastAccess;
		this.password = password;
		this.playlist = playlist;
		this.following = following;
	}
	
	

	public User(int id, String username) {
		super();
		this.id = id;
		this.username = username;
		this.playlist = new ArrayList<Playlist>();
		this.following = new ArrayList<User>();
	}
	
	public User(int id, String username, String registre, String lastAccess, String password) {
		super();
		this.id = id;
		this.username = username;
		this.registre = registre;
		this.lastAccess = lastAccess;
		this.password = password;
		this.playlist = new ArrayList<Playlist>();
		this.following = new ArrayList<User>();
	}



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public ArrayList<Playlist> getPlaylist() {
		return playlist;
	}

	public void setPlaylist(ArrayList<Playlist> playlist) {
		this.playlist = playlist;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<User> getFollowing() {
		return following;
	}

	public void setFollowing(ArrayList<User> following) {
		this.following = following;
	}
	
	public void addPlaylist(Playlist playlist) {
		this.playlist.add(playlist);
	}
	
	public void addFollowing(User following) {
		this.following.add(following);
	}



	public String getRegistre() {
		return registre;
	}



	public void setRegistre(String registre) {
		this.registre = registre;
	}



	public String getLastAccess() {
		return lastAccess;
	}



	public void setLastAccess(String lastAccess) {
		this.lastAccess = lastAccess;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
