package model;

public class User {
	private int id;
	private String username;
	private String registre;
	private String lastAccess;
	private String password;
	
	public User (int id, String username, String registre, String lastAccess, String password){
		this.id = id; 
		this.username = username;
		this.registre = registre;
		this.lastAccess = lastAccess;
		this.password = password;
	}
	
	public String getLastAcces() {
		return lastAccess;
	}
	public void setLastAcces(String lastAccess) {
		this.lastAccess = lastAccess;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getRegistre() {
		return registre;
	}
	public void setRegistre(String registre) {
		this.registre = registre;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
