package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BBDDconnection {
	DataBase conn;
	
	/*
	 * Contructor que crea la clase DataBase que permite la conexión y modificación con la base de datos.
	 */
	public BBDDconnection (String user, String password, String DateBase, int port){
		conn = new DataBase(user, password, DateBase, port);
	}
	
	/*
	 * Conexión con el servidor 
	 */
	public void startConnection (){
		conn.connect();
	}
	
	/*
	 * Desconexion con el servidor 
	 */
	public void stopConnection (){
		conn.disconnect();	
	}
	
	/*
	 * Busca si el usuario existe en la base de datos y comprueba si la contraseña es correcta.
	 * Posibilidades: 
	 * 		"Dont Exit" -> Usuario no encontrado 
	 * 		"Correct" -> Usuario enncontrado y la contraseña coincide
	 * 		"Fail" -> Usuario encontrado pero la contraseá no coincide
	 */
	public String userConnection(String user, String password){
		try {
			ResultSet consulta = conn.selectQuery("SELECT count(user_name) FROM users WHERE user_name like '"+ user +"'");
			consulta.next();
			int dontExist = consulta.getInt(1);
			if (dontExist == 0){
				return "Dont Exist";
			}
			
			else {
				consulta= conn.selectQuery("SELECT user_name, password FROM users WHERE user_name like '"+ user +"'");
				consulta.next();
				if (password.equals(consulta.getObject("password"))){
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
	 * Formato: Name/Fecha de registro/Fecha de la última conexión/contraseña
	 */
	public String showUsers(){
		ResultSet consulta = conn.selectQuery("SELECT * FROM users");
		String text = "";
		
		try {
			//Recorrem el ResultSet que ens retorna el selectQuery i agafem els paràmetres desitjats
			while (consulta.next())
			{
			    //Per recuperar el valor utilitzem la funció .getObject() amb el nom del camp a recuperar
				text = text + consulta.getObject("user_name") + "/" + consulta.getObject("date_reg")+ "/" + consulta.getObject("date_last_acces")+"/"+ consulta.getObject("password")+"\n";
			}
			return text;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return ("Problema al recuperar les dades...");
		}
	}
	
	public String showSongs(){
		ResultSet consulta = conn.selectQuery("SELECT * FROM songs");
		String text = "";
		
		try{
			while (consulta.next())
			{
				text = text + consulta.getObject("name") + "/" + consulta.getObject("genre")+ "/" + consulta.getObject("album")+"/"
			+ consulta.getObject("location")+"/"+ consulta.getObject("artist")+"/"+ consulta.getObject("stars")
			+"/"+ consulta.getObject("reproducciones")+"\n";
			}	
				return text;
		} catch (SQLException e) {
				// TODO Auto-generated catch block
			return ("Problema al recuperar les dades...");
		}
	}
	
	public void updateLastAcces (String user){
		conn.updateQuery("UPDATE users SET date_last_acces = now() WHERE user_name='"+user+"'");
	}
	
	public String addUser (String user, String password){
		try {
			ResultSet consulta = conn.selectQuery("SELECT count(user_name) FROM users WHERE user_name like '"+ user +"'");
			consulta.next();
			int dontExist = consulta.getInt(1);
			
			if (dontExist == 0){
				conn.insertQuery("INSERT INTO users (user_name,password) VALUES ('"+user+"','"+password+"')");
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
	
	public String deleteUser (String user){
		try {
			ResultSet consulta = conn.selectQuery("SELECT count(user_name) FROM users WHERE user_name like '"+ user +"'");
			consulta.next();
			int dontExist = consulta.getInt(1);
			//Eliminar
			System.out.println("Eliminar->dontExit: "+dontExist);
			
			if (dontExist == 0){
				return ("Fail");
			}
			
			else {
				ResultSet consulta2 = conn.selectQuery("SELECT id_user FROM users WHERE user_name like '"+ user +"'");
				consulta2.next();
				int id = consulta2.getInt(1);
				//Eliminar
				System.out.println("Eliminar->id: "+id);
				conn.deleteQuery("DELETE FROM users WHERE user_name='"+user+"'");
				conn.deleteQuery("DELETE FROM followers WHERE user_follower="+id);
				
				ResultSet consulta3 = conn.selectQuery("SELECT id_playlist FROM playlists WHERE creator_user ="+id);
				while (consulta3.next())
					{
					int list = consulta3.getInt(1);
					conn.deleteQuery("DELETE FROM playlist_songs WHERE cf_playlist="+list);
					}
				conn.deleteQuery("DELETE FROM playlists WHERE creator_user ="+id);
				return ("Deleted");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return "Problems";
		}
	}
	
	public String addSong(String name, String genre, String artist, String album, String location, int stars){
		try {
			ResultSet consulta = conn.selectQuery("SELECT count(name) FROM songs WHERE name like '"+ name +"' AND artist like '"+ artist+"'");
			consulta.next();
			int dontExist = consulta.getInt(1);
			
			if (dontExist == 0){
				conn.insertQuery("INSERT INTO songs (name, genre, album, location, artist, stars) VALUES ('"+name+"','"+genre+"','"+album+"','"+location+"','"+artist+"','"+stars+"')");
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
			ResultSet consulta = conn.selectQuery("SELECT count(name) FROM songs WHERE id_song = "+idDelete);
			consulta.next();
			int dontExist = consulta.getInt(1);
			
			if (dontExist == 0){
				return ("Fail");
			}
			
			else {
				//Eliminar
				System.out.println("Eliminar->id: "+idDelete);
				conn.deleteQuery("DELETE FROM playlists_songs WHERE cf_song="+idDelete);
				conn.deleteQuery("DELETE FROM songs WHERE id_song = "+idDelete);
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
			ResultSet consulta = conn.selectQuery("SELECT u.user_name as user, p.name as name FROM followers as fol, users as u, playlists as p "
					+ "WHERE u.id_user = fol.user_follower and p.id_playlist = fol.list_followed");
			while (consulta.next())
				{
					text = text + "Name: " + consulta.getObject("name") + "/" +"Seguidor: "+ consulta.getObject("user")+"\n";
				}	
					return text;
		} catch (SQLException e) {
					// TODO Auto-generated catch block
			return ("Problema al recuperar les dades...");
		}
	}
}
