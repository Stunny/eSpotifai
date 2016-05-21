package model;

import java.util.LinkedList;
/**
 * Usuari
 * @author Elna Cabot, Miguel D�az, Marc Mill�n, Alejandro Vogel, Marta Zapatero
 * @version 1.0
 * @see Playlist
 *
 */
public class User {
	/**
	 * IDentificador de l'usuari
	 */
	private int id;
	/**
	 * Nom d'usuari
	 */
	private String username; 
	/**
	 * Data de registre de l'usuari
	 */
	private String registre;
	/**
	 * Data de l'ultim acc�s de l'usuari a l'aplicaci�
	 */
	private String lastAccess;
	/**
	 * Contrassenya a l'usuari
	 */
	private String password;
	/**
	 * Conjunt de playlist
	 */
	private LinkedList<Playlist> playlist; 
	/**
	 * Conjunt d'usuaris als que segueix l'usuari
	 */
	private LinkedList<User> following;
	/**
	 * Construeix un usuari amb un conjunt de <i>playlists</i> inicialitzat.
	 * @param id IDentificador de l'usuari
	 * @param username Nom d'usuari
	 * @param registre Data de registre de l'usuari
	 * @param lastAccess Data de l'ultim acc�s de l'usuari a l'aplicaci�
	 * @param password Contrassenya a l'usuari
	 * @param playlist Conjunt de playlist
	 * @param following Conjunt d'usuaris als que segueix l'usuari
	 * @see Playlist
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
	 * Construeix un usuari amb la llista d'usuaris als que segueix buida. La llista de <i>playlists</i> tamb� s'inicialitzar� buida.
	 * @param id IDentificador de l'usuari
	 * @param username Nom d'usuari
	 */
	public User(int id, String username) {
		super();
		this.id = id;
		this.username = username;
		this.playlist = new LinkedList<Playlist>();
		this.following = new LinkedList<User>();
	}
	/**
	 * Construeix un usuari amb data de registre i d'�ltim acc�s, la llista d'usuaris als que segueix buida, i la llista de <i>playlists</i> tamb� s'inicialitzar� buida.
	 * @param id IDentificador de l'usuari
	 * @param username Nom d'usuari
	 * @param registre Data de registre de l'usuari
	 * @param lastAccess Data de l'ultim acc�s de l'usuari a l'aplicaci�
	 * @param password Contrassenya a l'usuari
	 * @see Playlist
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
