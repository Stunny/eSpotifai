package model;

public class User {
	private int id;
	private String name;
	private String registre;
	private String lastAcces;
	private String password;
	
	public User (int id, String name, String registre, String lastAcces, String password){
		this.id = id; 
		this.name = name;
		this.registre = registre;
		this.lastAcces = lastAcces;
		this.password = password;
	}
	
	public String getLastAcces() {
		return lastAcces;
	}
	public void setLastAcces(String lastAcces) {
		this.lastAcces = lastAcces;
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
