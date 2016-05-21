package model;

import java.util.ArrayList;
/**
 * 
 * @author Elna Cabot, Miguel D�az, Marc Mill�n, Alejandro Vogel, Marta Zapatero
 * @version 1.0
 * @see Song
 * @see User
 *
 */
public class Playlist {
	/**
	 * 
	 */
	private int id;
	/**
	 * 
	 */
	private String name; 
	/**
	 * 
	 */
	private String username;
	/**
	 * 
	 */
	private ArrayList<Song> songs;
	/**
	 * 
	 * @param id
	 * @param name
	 * @param username
	 * @param songs
	 */
	public Playlist(int id, String name, String username, ArrayList<Song> songs) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.songs = songs;
	}
	/**
	 * 
	 * @param id
	 * @param name
	 * @param username
	 */
	public Playlist(int id, String name, String username) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.songs = new ArrayList<Song>();
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
	public String getName() {
		return name;
	}
	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
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
	public ArrayList<Song> getSongs() {
		return songs;
	}
	/**
	 * 
	 * @param songs
	 */
	public void setSongs(ArrayList<Song> songs) {
		this.songs = songs;
	} 
	/**
	 * 
	 * @param song
	 */
	public void addSong(Song song) {
		this.songs.add(song);
	}
	
	
	
}
