package model;

import java.sql.ResultSet;
import java.sql.SQLException;

import customExceptions.DatabaseNotLoadedException;

public class DDBBConnection {
	DataBase ddbb;
	
	/*
	 * Contructor que crea la clase DataBase que permite la conexi�n y modificaci�n con la base de datos.
	 */
	public DDBBConnection (String username, String password, String ddbbName, int port){
		ddbb = new DataBase(username, password, ddbbName, port);
	}
	
	/*
	 * Conexi�n con el servidor 
	 */
	public void startConnection() throws DatabaseNotLoadedException {
		ddbb.connect();
	}
	
	/*
	 * Desconexion con el servidor 
	 */
	public void stopConnection (){
		ddbb.disconnect();	
	}
	
	/*
	 * Busca si el usuario existe en la base de datos y comprueba si la contrase�a es correcta.
	 * Posibilidades: 
	 * 		"Dont Exit" -> Usuario no encontrado 
	 * 		"Correct" -> Usuario enncontrado y la contrase�a coincide
	 * 		"Fail" -> Usuario encontrado pero la contrase� no coincide
	 */
	public String userConnection(String username, String password){
		try {
			ResultSet resultSet = ddbb.selectQuery("SELECT count(user_name) FROM users WHERE user_name like '"+ username +"'");
			resultSet.next();
			int dontExist = resultSet.getInt(1);
			if (dontExist == 0){
				return "Dont Exist";
			}
			
			else {
				resultSet= ddbb.selectQuery("SELECT user_name, password FROM users WHERE user_name like '"+ username +"'");
				resultSet.next();
				if (password.equals(resultSet.getObject("password"))){
					return "Correct";
				}
				else {
					return "Fail";
				}
			}
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				return "Problems";
		}
		
	}
	
	/*
	 * Devuelve un String que todos los usuarios con sus respectivos datos
	 * Formato: Name/Fecha de registro/Fecha de la �ltima conexi�n/contrase�a
	 */
	public String showUsers(){
		ResultSet resultSet = ddbb.selectQuery("SELECT * FROM users");
		String text = "";
		
		try {
			//Recorrem el ResultSet que ens retorna el selectQuery i agafem els par�metres desitjats
			while (resultSet.next())
			{
			    //Per recuperar el valor utilitzem la funci� .getObject() amb el nom del camp a recuperar
				text = text + resultSet.getObject("user_name") + "/" + resultSet.getObject("date_reg")+ "/" + resultSet.getObject("date_last_acces")+"/"+ resultSet.getObject("password")+"\n";
			}
			return text;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return ("Problema al recuperar les dades...");
		}
	}
	
	public String showSongs(){
		ResultSet resultSet = ddbb.selectQuery("SELECT * FROM songs");
		String text = "";
		
		try{
			while (resultSet.next())
			{
				text = text + resultSet.getObject("name") + "/" + resultSet.getObject("genre")+ "/" + resultSet.getObject("album")+"/"
			+ resultSet.getObject("location")+"/"+ resultSet.getObject("artist")+"/"+ resultSet.getObject("stars")
			+"/"+ resultSet.getObject("reproducciones")+"\n";
			}	
				return text;
		} catch (SQLException e) {
				// TODO Auto-generated catch block
			return ("Problema al recuperar les dades...");
		}
	}
	
	public void updateLastAcces (String username){
		ddbb.updateQuery("UPDATE users SET date_last_acces = now() WHERE user_name='"+username+"'");
	}
	
	public String addUser (String username, String password){
		try {
			ResultSet resultSet = ddbb.selectQuery("SELECT count(user_name) FROM users WHERE user_name like '"+ username +"'");
			resultSet.next();
			int dontExist = resultSet.getInt(1);
			
			if (dontExist == 0){
				ddbb.insertQuery("INSERT INTO users (user_name,password) VALUES ('"+username+"','"+password+"')");
				return ("Add");
			}
			
			else {
				return ("Exists");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return "Problems";
		}
	}
	
	public String deleteUser (String username){
		try {
			ResultSet resultSet = ddbb.selectQuery("SELECT count(user_name) FROM users WHERE user_name like '"+ username +"'");
			resultSet.next();
			int dontExist = resultSet.getInt(1);
			//Eliminar
			System.out.println("Eliminar->dontExit: "+dontExist);
			
			if (dontExist == 0){
				return ("Fail");
			}
			
			else {
				ResultSet consulta2 = ddbb.selectQuery("SELECT id_user FROM users WHERE user_name like '"+ username +"'");
				consulta2.next();
				int id = consulta2.getInt(1);
				//Eliminar
				System.out.println("Eliminar->id: "+id);
				ddbb.deleteQuery("DELETE FROM users WHERE user_name='"+username+"'");
				ddbb.deleteQuery("DELETE FROM followers WHERE user_follower="+id);
				
				ResultSet consulta3 = ddbb.selectQuery("SELECT id_playlist FROM playlists WHERE creator_user ="+id);
				while (consulta3.next())
					{
					int list = consulta3.getInt(1);
					ddbb.deleteQuery("DELETE FROM playlist_songs WHERE cf_playlist="+list);
					}
				ddbb.deleteQuery("DELETE FROM playlists WHERE creator_user ="+id);
				return ("Deleted");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return "Problems";
		}
	}
	
	public String addSong(String name, String genre, String artist, String album, String location, int stars){
		try {
			ResultSet resultSet = ddbb.selectQuery("SELECT count(name) FROM songs WHERE name like '"+ name +"' AND artist like '"+ artist+"'");
			resultSet.next();
			int dontExist = resultSet.getInt(1);
			
			if (dontExist == 0){
				ddbb.insertQuery("INSERT INTO songs (name, genre, album, location, artist, stars) VALUES ('"+name+"','"+genre+"','"+album+"','"+location+"','"+artist+"','"+stars+"')");
				return ("Add");
			}
			
			else {
				return ("Exists");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return "Problems";
		}
	}
	
	public String deleteSong (int idDelete){
		try {
			ResultSet resultSet = ddbb.selectQuery("SELECT count(name) FROM songs WHERE id_song = "+idDelete);
			resultSet.next();
			int dontExist = resultSet.getInt(1);
			
			if (dontExist == 0){
				return ("Fail");
			}
			
			else {
				//Eliminar
				System.out.println("Eliminar->id: "+idDelete);
				ddbb.deleteQuery("DELETE FROM playlists_songs WHERE cf_song="+idDelete);
				ddbb.deleteQuery("DELETE FROM songs WHERE id_song = "+idDelete);
				return ("Deleted");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return "Problems";
		}
	}
	
	public String showFollows(){
		String text = "";
		try {
			ResultSet resultSet = ddbb.selectQuery("SELECT u.user_name as username, p.name as name FROM followers as fol, users as u, playlists as p "
					+ "WHERE u.id_user = fol.user_follower and p.id_playlist = fol.list_followed");
			while (resultSet.next())
				{
					text = text + "Name: " + resultSet.getObject("name") + "/" +"Seguidor: "+ resultSet.getObject("username")+"\n";
				}	
					return text;
		} catch (SQLException e) {
					// TODO Auto-generated catch block
			return "Problems";
		}
	}
}
