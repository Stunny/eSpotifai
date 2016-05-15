package model;

public class Songs {
	private String name; 
	private String genre; 
	private String album; 
	private String location; 
	private String artist; 
	private int starts;
	
	public Songs(String name, String genre, String album, String location, String artist, int starts){
		this.name = name; 
		this.genre = genre; 
		this.album = album; 
		this.location = location; 
		this.artist = artist; 
		this.starts = starts; 
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public int getStarts() {
		return starts;
	}

	public void setStarts(int starts) {
		this.starts = starts;
	}
	
	
	
}
