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
	 * Getter del nom d'usuari
	 * @return User name
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * Setter del nom d'usuari
	 * @param username User name
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * Getter del conjunt de <i>playlists</i> de l'usuari
	 * @return User <i>playlists</i>
	 */
	public LinkedList<Playlist> getPlaylist() {
		return playlist;
	}
	/**
	 * Setter del conjunt de <i>playlists</i> de l'usuari
	 * @param playlist User <i>playlists</i>
	 */
	public void setPlaylist(LinkedList<Playlist> playlist) {
		this.playlist = playlist;
	}
	/**
	 * Getter de l'IDentificador de l'usuari
	 * @return User ID
	 */
	public int getId() {
		return id;
	}
	/**
	 * Setter de l'IDentificador de l'usuari
	 * @param id User ID
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Getter de la llista d'usuaris als que segueix el seleccionat
	 * @return Followed Users List
	 * @see model.User
	 */
	public LinkedList<User> getFollowing() {
		return following;
	}
	/**
	 * Setter de la llista d'usuaris als que segueix el seleccionat
	 * @param following Followed Users List
	 * @see model.User
	 */
	public void setFollowing(LinkedList<User> following) {
		this.following = following;
	}
	/**
	 * Afegeix una nova <i>playlist</i> a la llista de <i>playlists</i> de l'usuari
	 * @param playlist <i>Playlist</i>
	 */
	public void addPlaylist(Playlist playlist) {
		this.playlist.add(playlist);
	}
	/**
	 * Afegeix un altre usuari a la llista d'usuaris seguits
	 * @param following New followed user
	 */
	public void addFollowing(User following) {
		this.following.add(following);
	}


	/**
	 * Getter de la data de registre de l'usuari
	 * @return Register date
	 */
	public String getRegistre() {
		return registre;
	}


	/**
	 * Setter de la data de registre de l'usuari
	 * @param registre Register date
	 */
	public void setRegistre(String registre) {
		this.registre = registre;
	}


	/**
	 * Getter de la data de l'�ltima conexi� de l'usuari a l'aplicaci�
	 * @return Last access date
	 */
	public String getLastAccess() {
		return lastAccess;
	}


	/**
	 * Setter de la data de l'�ltima conexi� de l'usuari a l'aplicaci�
	 * @param lastAccess Last access date
	 */
	public void setLastAccess(String lastAccess) {
		this.lastAccess = lastAccess;
	}


	/**
	 * Getter de la contrassenya de l'usuari
	 * @return User password
	 */
	public String getPassword() {
		return password;
	}


	/**
	 * Setter de la contrassenya de l'usuari
	 * @param password User password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
