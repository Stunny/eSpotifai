package model;

import java.util.LinkedList;

public class User {
	private int id;
	private String username; 
	private String registre;
	private String lastAccess;
	private String password;
	private LinkedList<Playlist> playlist; 
	private LinkedList<User> following;

	public User(int id, String username, String registre, String lastAccess, String password, LinkedList<Playlist> playlist, LinkedList<User> following){
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
		this.playlist = new LinkedList<Playlist>();
		this.following = new LinkedList<User>();
	}

	public User(int id, String username, String registre, String lastAccess, String password) {
		super();
		this.id = id;
		this.username = username;
		this.registre = registre;
		this.lastAccess = lastAccess;
		this.password = password;
		this.playlist = new LinkedList<Playlist>();
		this.following = new LinkedList<User>();
	}



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public LinkedList<Playlist> getPlaylist() {
		return playlist;
	}

	public void setPlaylist(LinkedList<Playlist> playlist) {
		this.playlist = playlist;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LinkedList<User> getFollowing() {
		return following;
	}

	public void setFollowing(LinkedList<User> following) {
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

