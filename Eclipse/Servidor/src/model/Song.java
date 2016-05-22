package model;
/**
 * Can��
 * @author Elna Cabot, Miguel D�az, Marc Mill�n, Alejandro Vogel, Marta Zapatero
 * @version 1.0
 * @see Playlist
 *
 */
public class Song {
	/**
	 * IDentificador de la can��.
	 */
	private int id;
	/**
	 * Nom de la can��.
	 */
	private String name; 
	/**
	 * G�nere al que pertany la can��.
	 */
	private String genre; 
	/**
	 * �lbum al que pertany la can��.
	 */
	private String album; 
	/**
	 * Ruta de l'arxiu (.mp3) de la can��
	 */
	private String location; 
	/**
	 * Nom de l'artista int�rpret de la can��.
	 */
	private String artist; 
	/**
	 * Rating: Popularitat de la can��.
	 */
	private int stars;
	/**
	 * Quantitat de reproduccions que t� la can��.
	 */
	private int reproductions;
	/**
	 * Construeix una nova can��
	 * @param id IDentificador de la can��
	 * @param name Nom de la can��
	 * @param genre G�nere al que pertany la can��
	 * @param album �lbum al que pertany la can��
	 * @param location Ruta de l'arxiu (.mp3) de la can��
	 * @param artist Nom de l'artista int�rpret de la can��
	 * @param stars Popularitat de la can��
	 * @param reproductions Quantitat de reproduccions que t� la can��
	 */
	public Song(int id, String name, String genre, String album, String location, String artist, int stars, int reproductions){
		this.id = id;
		this.name = name; 
		this.genre = genre; 
		this.album = album; 
		this.location = location; 
		this.artist = artist; 
		this.stars = stars; 
		this.reproductions = reproductions;
	}
	/**
	 * Getter del nom de la can��
	 * @return Song name
	 */
	public String getName() {
		return name;
	}
	/**
	 * Setter del nom de la can��
	 * @param name Song name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Getter del g�nere al que pertany la can��. 
	 * @return Song genre
	 */
	public String getGenre() {
		return genre;
	}
	/**
	 * Setter del g�nere al que pertany la can��
	 * @param genre Song genre
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}
	/**
	 * Getter del nom de l'�lbum al que pertany la can��.
	 * @return Song album
	 */
	public String getAlbum() {
		return album;
	}
	/**
	 * Setter del nom del album al que pertany la can��
	 * @param album Song album
	 */
	public void setAlbum(String album) {
		this.album = album;
	}
	/**
	 * Getter de la ruta de l'arxiu (.mp3) de la can��
	 * @return
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * Setter de la ruta de l'arxiu (.mp3) de la can��
	 * @param location
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * Getter del nom de l'artista int�rpret de la can��
	 * @return Song artist
	 */
	public String getArtist() {
		return artist;
	}
	/**
	 * Setter de l'artista int�rpret de la can��
	 * @param artist Song Artist
	 */
	public void setArtist(String artist) {
		this.artist = artist;
	}
	/**
	 * Getter de la popularitat (<i>rating</i>) de la can��
	 * @return Song rating
	 */
	public int getStars() {
		return stars;
	}
	/**
	 * Setter de la popularitat (<i>rating</i>) de la can��
	 * @param stars Song rating
	 */
	public void setStars(int stars) {
		this.stars = stars;
	}
	/**
	 * Getter de l'IDentificador de la can��
	 * @return Song ID
	 */
	public int getId() {
		return id;
	}
	/**
	 * Setter de l'IDentificador de la can��
	 * @param id Song ID
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Getter de la quantitat de reproduccions que t� una can��.
	 * @return Reproduccions totals
	 */
	public int getReproductions() {
		return reproductions;
	}
	/**
	 * Setter de la quantitat de reproduccions que t� un can��
	 * @param reproductions Repreoduccions totals
	 */
	public void setReproductions(int reproductions) {
		this.reproductions = reproductions;
	}
	
	
	
	
	
}
