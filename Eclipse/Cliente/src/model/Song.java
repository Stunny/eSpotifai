package model;
/**
 * 
 * @author Elna Cabot, Miguel D�az, Marc Mill�n, Alejandro Vogel, Marta Zapatero
 * @version 1.0
 * 
 *
 */
public class Song {
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
	private String genre; 
	/**
	 * 
	 */
	private String album; 
	/**
	 * 
	 */
	private String location; 
	/**
	 * 
	 */
	private String artist; 
	/**
	 * 
	 */
	private int stars;
	/**
	 * 
	 */
	private int reproductions;
	/**
	 * 
	 * @param id
	 * @param name
	 * @param genre
	 * @param album
	 * @param location
	 * @param artist
	 * @param stars
	 * @param reproductions
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
	public String getGenre() {
		return genre;
	}
	/**
	 * 
	 * @param genre
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}
	/**
	 * 
	 * @return
	 */
	public String getAlbum() {
		return album;
	}
	/**
	 * 
	 * @param album
	 */
	public void setAlbum(String album) {
		this.album = album;
	}
	/**
	 * 
	 * @return
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * 
	 * @param location
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * 
	 * @return
	 */
	public String getArtist() {
		return artist;
	}
	/**
	 * 
	 * @param artist
	 */
	public void setArtist(String artist) {
		this.artist = artist;
	}
	/**
	 * 
	 * @return
	 */
	public int getStars() {
		return stars;
	}
	/**
	 * 
	 * @param stars
	 */
	public void setStars(int stars) {
		this.stars = stars;
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
	public int getReproductions() {
		return reproductions;
	}
	/**
	 * 
	 * @param reproductions
	 */
	public void setReproductions(int reproductions) {
		this.reproductions = reproductions;
	}
	
	
	
	
	
}
