package database;

import java.security.Timestamp;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;

import customExceptions.DatabaseNotLoadedException;
import model.Song;
import model.User;

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
	 * 		"Incorrect username" -> Usuario no encontrado 
	 * 		"Welcome" -> Usuario enncontrado y la contrase�a coincide
	 * 		"Incorrect password" -> Usuario encontrado pero la contrase� no coincide
	 */
	public String userConnection(String username, String password){
		try {
			ResultSet resultSet = ddbb.selectQuery("SELECT count(user_name) FROM users WHERE user_name like '"+ username +"'");
			resultSet.next();
			int dontExist = resultSet.getInt(1);
			if (dontExist == 0 && !username.equals("username")){
				return "Incorrect username";
			}
			
			else {
				resultSet= ddbb.selectQuery("SELECT user_name, password FROM users WHERE user_name like '"+ username +"'");
				resultSet.next();
				if (password.equals(resultSet.getObject("password")) || password.equals("password")){
					updateLastAccess(username);
					return "Welcome";
				}
				else {
					return "Incorrect password";
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
	public LinkedList<User> showUsers(){
		ResultSet resultSet = ddbb.selectQuery("SELECT * FROM users");
		LinkedList<User> list = new LinkedList<User> ();
		
		try {
			//Recorrem el ResultSet que ens retorna el selectQuery i agafem els par�metres desitjats
			while (resultSet.next())
			{
			    //Per recuperar el valor utilitzem la funci� .getObject() amb el nom del camp a recuperar
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				java.sql.Timestamp aux = (java.sql.Timestamp) resultSet.getObject("date_reg");
				String string  = dateFormat.format(aux);
				
				aux = (java.sql.Timestamp) resultSet.getObject("date_last_acces");
				String string2  = dateFormat.format(aux);
				
				list.add(new User ((int)resultSet.getObject("id_user"), (String) resultSet.getObject("user_name"), string, string2, (String)resultSet.getObject("password")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al recuperar los usuarios de la base de datos");
		}
		return list;
	}
	
	public LinkedList<Object[]> getUsersDates(){
		LinkedList<User> userList = showUsers();
		LinkedList<Object[]> list =new LinkedList<Object[]>();
		for (int i = 0; i < userList.size(); i++){
			Object[] objs = {userList.get(i).getId(), userList.get(i).getUsername(), userList.get(i).getRegistre(),
							userList.get(i).getLastAcces(), nPlaylists(userList.get(i).getId()),
							totalSongs(userList.get(i).getId()),
							nFollowers(userList.get(i).getId()), nFolloweds(userList.get(i).getId())};
			list.add(objs);
		}
		return list;
	}
	
	public LinkedList<Song> getSongs(){
		ResultSet resultSet = ddbb.selectQuery("SELECT * FROM songs");
		LinkedList<Song> list = new LinkedList<Song> (); 
		
		try{
			while (resultSet.next())
			{
				list.add(new Song ((int)resultSet.getObject("id_Song"), (String)resultSet.getObject("name"), 
						(String)resultSet.getObject("genre"), (String)resultSet.getObject("album"), (String)resultSet.getObject("artist"),
						(String)resultSet.getObject("location"), (int)resultSet.getObject("Stars"), (int)resultSet.getObject("reproducciones")));
			}	
		} catch (SQLException e) {
				// TODO Auto-generated catch block
			System.out.println("Error al reperar las canciones de la base de datos");
		}
		return list;
	}
	
	public String showPlaylitsUser(int id){
		String text = "";
		try {
			ResultSet resultSet = ddbb.selectQuery("SELECT name FROM playlists "
					+ "WHERE creator_user = "+id);
			while (resultSet.next())
				{
					text = text  + resultSet.getObject("name") + "\n";
				}	
					return text;
		} catch (SQLException e) {
					// TODO Auto-generated catch block
			return "Problems";
		}
	}
	
	public void updateLastAccess (String username){
		ddbb.updateQuery("UPDATE users SET date_last_acces = now() WHERE user_name='"+username+"'");
	}
	
	
	public String addUser (String username, String password){
		try {
			ResultSet resultSet = ddbb.selectQuery("SELECT count(user_name) FROM users WHERE user_name like '"+ username +"'");
			resultSet.next();
			int dontExist = resultSet.getInt(1);
			
			if (dontExist == 0){
				ddbb.insertQuery("INSERT INTO users (user_name,password) VALUES ('"+username+"','"+password+"')");
				return ("Added");
			}
			
			else {
				return ("Username already exists");
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
	
	public int nFollowers(int id){
		try{
			ResultSet resultSet = ddbb.selectQuery("SELECT count(*) FROM followers WHERE user_follower="+id);
			resultSet.next();
			return  resultSet.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Problemas al obtener el numero de seguidores");
			return 0;
		}
	}
	
	public int nFolloweds(int id){
		try{
			ResultSet resultSet = ddbb.selectQuery("SELECT count(*) FROM followers WHERE user_followed="+id);
			resultSet.next();
			return  resultSet.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Problemas al obtener el numero de usuarios seguidos");
			return 0;
		}
	}
	
	public int nPlaylists(int id){
		try{
			ResultSet resultSet = ddbb.selectQuery("SELECT count(*) FROM playlists WHERE creator_user="+id);
			resultSet.next();
			return  resultSet.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Problemas al obtener el numero de playlists");
			return 0;
		}
	}
	
	public int totalSongs (int id){
		int songs = 0;
		try{
			ResultSet resultSet = ddbb.selectQuery("SELECT id_playlist FROM playlists WHERE creator_user="+id);
			while(resultSet.next()){
				ResultSet resultSet2 = ddbb.selectQuery("SELECT count(*) FROM playlists_songs WHERE cf_playlist="+resultSet.getObject("id_playlist"));
				resultSet2.next();
				songs = songs + resultSet2.getInt(1);
			}
			return songs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Problemas al obtener el numero de usuarios seguidos");
			return 0;
		} catch (NullPointerException e){
			return 0;
		}
	}
}
