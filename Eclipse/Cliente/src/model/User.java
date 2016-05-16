package model;

public class User {
	private String nickname; 
	private Playlist playlist; 
	
	public void User(String nickname, Playlist playlist){
		this.nickname = nickname; 
		this.playlist = playlist;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Playlist getPlaylist() {
		return playlist;
	}

	public void setPlaylist(Playlist playlist) {
		this.playlist = playlist;
	}
	
}
