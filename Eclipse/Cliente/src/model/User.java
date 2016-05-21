package model;

import java.util.LinkedList;
/**
 * 
 * @author Elna Cabot, Miguel D�az, Marc Mill�n, Alejandro Vogel, Marta Zapatero
 * @version 1.0
 * @see Playlist
 *
 */
public class User {
	/**
	 * 
	 */
	private int id;
	/**
	 * 
	 */
	private String username; 
	/**
	 * 
	 */
	private String registre;
	/**
	 * 
	 */
	private String lastAccess;
	/**
	 * 
	 */
	private String password;
	/**
	 * 
	 */
	private LinkedList<Playlist> playlist; 
	/**
	 * 
	 */
	private LinkedList<User> following;
	/**
	 * 
	 * @param id
	 * @param username
	 * @param registre
	 * @param lastAccess
	 * @param password
	 * @param playlist
	 * @param following
	 */
	public User(int id, String username, String registre, String lastAccess, String password, LinkedList<Playlist> playlist, LinkedList<User> following){
		this.id = id;
		this.username = username; 
		this.registre = registre;
		this.lastAccess = lastAccess;
		this.password = password;
		this.playlist = playlist;
		this.following = following;
	}
	
	
	/**
	 * 
	 * @param id
	 * @param username
	 */
	public User(int id, String username) {
		super();
		this.id = id;
		this.username = username;
		this.playlist = new LinkedList<Playlist>();
		this.following = new LinkedList<User>();
	}
	/**
	 * 
	 * @param id
	 * @param username
	 * @param registre
	 * @param lastAccess
	 * @param password
	 */
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


	/**
	 * 
	 * @return
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * 
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 
	 * @return
	 */
	public LinkedList<Playlist> getPlaylist() {
		return playlist;
	}
	/**
	 * 
	 * @param playlist
	 */
	public void setPlaylist(LinkedList<Playlist> playlist) {
		this.playlist = playlist;
	}
	/**
	 * 
	 * @return
	 */
	public int getId() {
		return id;
	}
	/**
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * 
	 * @return
	 */
	public LinkedList<User> getFollowing() {
		return following;
	}
	/**
	 * 
	 * @param following
	 */
	public void setFollowing(LinkedList<User> following) {
		this.following = following;
	}
	/**
	 * 
	 * @param playlist
	 */
	public void addPlaylist(Playlist playlist) {
		this.playlist.add(playlist);
	}
	/**
	 * 
	 * @param following
	 */
	public void addFollowing(User following) {
		this.following.add(following);
	}


	/**
	 * 
	 * @return
	 */
	public String getRegistre() {
		return registre;
	}


	/**
	 * 
	 * @param registre
	 */
	public void setRegistre(String registre) {
		this.registre = registre;
	}


	/**
	 * 
	 * @return
	 */
	public String getLastAccess() {
		return lastAccess;
	}


	/**
	 * 
	 * @param lastAccess
	 */
	public void setLastAccess(String lastAccess) {
		this.lastAccess = lastAccess;
	}


	/**
	 * 
	 * @return
	 */
	public String getPassword() {
		return password;
	}


	/**
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
