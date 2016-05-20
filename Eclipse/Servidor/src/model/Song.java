package model;

public class Song {
	private int id;
	private String name;
	private String genre;
	private String album;
	private String artist;
	private String location;
	private int stars; 
	private int reproducciones;
	
	public Song (int id, String name, String genre, String album, String artist, String URL, int stars, int reproducciones){
		this.id = id;
		this.name = name;
		this.genre = genre;
		this.album = album;
		this.artist = artist; 
		location  = URL;
		this.stars = stars;
		this.reproducciones = reproducciones;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public int getStars() {
		return stars;
	}
	public void setStars(int stars) {
		this.stars = stars;
	}
	
	public int getReproducciones() {
		return reproducciones;
	}
	public void setReproducciones(int reproducciones) {
		this.reproducciones = reproducciones;
	}
	
	
}
