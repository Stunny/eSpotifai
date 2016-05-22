package model;

import java.util.ArrayList;
/**
 * Llista de reproducci�.
 * @author Elna Cabot, Miguel D�az, Marc Mill�n, Alejandro Vogel, Marta Zapatero
 * @version 1.0
 * @see Song
 * @see User
 *
 */
public class Playlist {
	/**
	 * ID de la llista de reproducci�.
	 */
	private int id;
	/**
	 * Nom de la llista de reproducci�.
	 */
	private String name; 
	/**
	 * Nom de l'usuari que ha creat la llista de reproducci�.
	 */
	private String username;
	/**
	 * Conjunt de totes les can�ons que inclou la llista de reproducci�.
	 */
	private ArrayList<Song> songs;
	/**
	 * Construeix una nova <i>playlist</i> amb un conjunt de can�ons inicials.
	 * @param id IDentificador de la llista.
	 * @param name Nom de la llista.
	 * @param username Usuari que ha creat la llista.
	 * @param songs Conjunt de can�ons que inclou la llista.
	 */
	public Playlist(int id, String name, String username, ArrayList<Song> songs) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.songs = songs;
	}
	/**
	 * Construeix una nova <i>playlist</i> buida.
	 * @param id ID de la llista.
	 * @param name Nom de la llista.
	 * @param username Nom de l'usuari que ha creat la llista.
	 */
	public Playlist(int id, String name, String username) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.songs = new ArrayList<Song>();
	}
	/**
	 * Getter de l'IDentificador de la <i>playlist</i>.
	 * @return IDentificador
	 */
	public int getId() {
		return id;
	}
	/**
	 * Setter de l'IDentificador de la <i>playlist</i>.
	 * @param id IDentificador
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Getter del nom de la <i>playlist</i>.
	 * @return Playlist name.
	 */
	public String getName() {
		return name;
	}
	/**
	 * Setter del nom de la <i>playlist</i>.
	 * @param name Playlist name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Getter del nom de l'usuari creador de la <i>playlist</i>.
	 * @return User name
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * Setter del nom del creador de la llista.
	 * @param username User name
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * Getter del conjunt de can�ons que inclou la <i>playlist</i>.
	 * @return Song array.
	 * @see Song
	 */
	public ArrayList<Song> getSongs() {
		return songs;
	}
	/**
	 * Setter del conjunt de can�ons que inclou la <i>playlist</i>.
	 * @param songs Song Array
	 * @see Song
	 */
	public void setSongs(ArrayList<Song> songs) {
		this.songs = songs;
	} 
	/**
	 * Afegeix una nova can�� a la <i>playlist</i>.
	 * @param song Nova can�� a afegir.
	 * @see Song
	 */
	public void addSong(Song song) {
		this.songs.add(song);
	}



}
