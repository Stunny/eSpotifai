package model;

import java.util.ArrayList;

public class Playlist {
	private int id;
	private String name; 
	private String username;
	private ArrayList<Song> songs;
	
	public Playlist(int id, String name, String username, ArrayList<Song> songs) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.songs = songs;
	}

	public Playlist(int id, String name, String username) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.songs = new ArrayList<Song>();
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public ArrayList<Song> getSongs() {
		return songs;
	}

	public void setSongs(ArrayList<Song> songs) {
		this.songs = songs;
	} 
	
	public void addSong(Song song) {
		this.songs.add(song);
	}
	
	
	
}
