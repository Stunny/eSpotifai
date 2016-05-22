package database;

import java.security.Timestamp;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;

import customExceptions.DatabaseNotLoadedException;
import model.ServerConfiguration;
import model.Song;
import model.User;
/**
 * 
 * @author Elna Cabot, Miguel D�az, Marc Mill�n, Alejandro Vogel, Marta Zapatero
 * @version 1.0
 * @see DataBase
 * @see ServerConfiguration
 * @see ResultSet
 * @see SQLException
 * @see SimpleDateFormat
 *@see java.sql.Timestamp
 */
public class DDBBConnection {
	DataBase ddbb;
	
	/**
	 * Prepara totes les dades necess�ries per a la conexi� amb la base de dades. 
	 * @see DataBase
	 */
	public DDBBConnection (String username, String password, String ddbbName, int port){
		ddbb = new DataBase(username, password, ddbbName, port);
	}
	
	/**
	 * Executa la conexi� amb la base de dades
	 * @throws DatabaseNotLoadedException En cas de que hagi hagut algun problema amb la conexi�
	 */
	public void startConnection() throws DatabaseNotLoadedException {
		ddbb.connect();
	}
	
	/**
	 * Atura la conexi� amb la base de dades.
	 * @see DataBase
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
	/**
	 * Cerca si l'usuari existeix a la base de dades i comprova si la contrassenya �s correcta.
	 * 
	 * @param username Nom d'usuari
	 * @param password Contrassenya d'usuari
	 * @return <p>En cas de l'usuari no es trobi a la base de dades, es retornara: <i>Incorrect username</i></p><p>En cas de la contrassenya sigui incorrecta: <i>Incorrect Password</i> </p>
	 * 			<p>Es mostrar�: <i>Welcome</i> quan l'usuari s'hagi trobat i la contrassenya sigui correcta.</p>
	 * @see ResultSet
	 * @see SQLException
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
	/**
	 * <i>Request</i> d'usuaris.
	 * @return Llista d'usuaris en forma d'String cadascun, seguint el format: <i>Nom/Data de registre/Data d'ultima conexi�/Contrassenya</i>
	 * @see ResultSet
	 * @see LinkedList
	 * @see SQLException
	 */
	public LinkedList<User> getUsers(){
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
	/**
	 * <i>Rquest</i> de dades d'usuari
	 * @return Llista d'object amb cadascun dels camps de l'Object corresponent a una data d'usuari
	 */
	public LinkedList<Object[]> getUsersDates(){
		LinkedList<User> userList = getUsers();
		LinkedList<Object[]> list = new LinkedList<Object[]>();
		for (int i = 0; i < userList.size(); i++){
			Object[] objs = {userList.get(i).getId(), userList.get(i).getUsername(), userList.get(i).getRegistre(),
							userList.get(i).getLastAccess(), nPlaylists(userList.get(i).getId()),
							totalSongs(userList.get(i).getId()),
							nFollowers(userList.get(i).getId()), nFolloweds(userList.get(i).getId())};
			list.add(objs);
		}
		return list;
	}
	/**
	 * <i>Request</i> de nom d'usuari
	 * @param id IDentificador de l'usuari
	 * @return En cas de que existeixi l'ID d'usuari tornar� el nom del mateix. En cas contrari tornar� <i>"Desconegut"</i>.
	 */
	public String getName(int id){
		LinkedList<User> userList = getUsers();
		for (int i = 0; i<userList.size(); i++){
			if (userList.get(i).getId()== id){
				return userList.get(i).getUsername();
			}
		}
		return "Desconocido";
	}
	/**
	 * <i>Request</i> de les dades dels seguidors de l'usuari al que pertany la ID passada per par�metre.
	 * @param id IDentificador de l'usuari
	 * @return Llista de Object amb les dades dels seguidors de l'usuari
	 * @see ResultSet
	 * @see SQLException
	 */
	public LinkedList<Object[]> getFollowersDates(int id){
		LinkedList<User> userList = getUsers();
		LinkedList<Object[]> list =new LinkedList<Object[]>();
	
		try {
			ResultSet resultSet = ddbb.selectQuery("SELECT user_follower FROM followers WHERE user_followed="+id);
			while (resultSet.next())
				{
					for (int i = 0; i < userList.size(); i++){
						if (userList.get(i).getId() == resultSet.getInt(1)){
							Object[] obj = {userList.get(i).getId(), userList.get(i).getUsername(), userList.get(i).getRegistre(),
									userList.get(i).getLastAccess(), nPlaylists(userList.get(i).getId()),
									totalSongs(userList.get(i).getId()),
									nFollowers(userList.get(i).getId()), nFolloweds(userList.get(i).getId())};
							list.add(obj);
						}
		
					}
				}
				
			return list;

		} catch (SQLException e) {
					// TODO Auto-generated catch block
			return list;
		}
	}
	/**
	 * <i>Request</i> de les dades de les llistes de reproducci� que pertanyen a l'usuari al qual pertany l'ID passat per par�metre.
	 * @param id IDentificador del creador de les llistes de reproducci�
	 * @return Llista d'Object amb les dades de les playlists creades per l'usuari
	 * @see ResultSet
	 * @see SQLException
	 */
	public LinkedList<Object[]> getPlaylistDates(int id){
		LinkedList<Object[]> list =new LinkedList<Object[]>();
	
		try {
			ResultSet resultSet = ddbb.selectQuery("SELECT (*) FROM playlists WHERE creato_user="+id);
			while (resultSet.next())
				{
						Object[] obj = {resultSet.getObject("id_playlist"), resultSet.getObject("name")};
						list.add(obj);
		
				}
				
			return list;

		} catch (SQLException e) {
					// TODO Auto-generated catch block
			return list;
		}
	}
	/**
	 * <i>Request</i> de les dades dels usuaris als que segueix l'especificat mitjan�ant l'ID per par�metre.
	 * @param id IDentificador d'usuari.
	 * @return Llista d'object amb les dades dels usuaris als que segueix l'especificat.
	 * @see ResultSet
	 * @see SQLException
	 */
	public LinkedList<Object[]> getFollowedsDates(int id){
		LinkedList<User> userList = getUsers();
		LinkedList<Object[]> list =new LinkedList<Object[]>();
	
		try {
			ResultSet resultSet = ddbb.selectQuery("SELECT user_follower FROM followers WHERE user_follower="+id);
			while (resultSet.next())
				{
					for (int i = 0; i < userList.size(); i++){
						if (userList.get(i).getId() == resultSet.getInt(1)){
							Object[] obj = {userList.get(i).getId(), userList.get(i).getUsername(), userList.get(i).getRegistre(),
									userList.get(i).getLastAccess(), nPlaylists(userList.get(i).getId()),
									totalSongs(userList.get(i).getId()),
									nFollowers(userList.get(i).getId()), nFolloweds(userList.get(i).getId())};
							list.add(obj);
						}
		
					}
				}
				
			return list;

		} catch (SQLException e) {
					// TODO Auto-generated catch block
			return list;
		}
	}
	
	/**
	 * <i>Request de totes les can�ons de la base de dades</i>
	 * @return LinkedList de Song amb totes les can�ons que poseeix el servidor en el moment.
	 * @see ResultSet
	 * @see SQLException
	 */
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
			System.out.println("Error al recuperar las canciones de la base de datos");
		}
		return list;
	}
	/**
	 * <i>Request</i> de les can�ons que s'inclouen en una <i>playlist</i>
	 * @param id IDentificador de la <i>playlist</i>
	 * @return LinkedList de Song amb totes les can�ons que s'inclouen a la llista especificada.
	 * @see ResultSet
	 * @see SQLException
	 */
	public LinkedList<Song> getPlaylistSongs (int id){
		ResultSet resultSet = ddbb.selectQuery("SELECT cf_song FROM playlists_songs WHERE cf_playlist="+id);
		LinkedList<Song> list = new LinkedList<Song> (); 
		ResultSet resultSet1;
		
		try{
			while (resultSet.next())
			{
				resultSet1 = ddbb.selectQuery("SELECT * FROM songs WHERE id_song="+resultSet.getInt(1));
				while (resultSet1.next()){
					list.add(new Song ((int)resultSet1.getObject("id_Song"), (String)resultSet1.getObject("name"), 
						(String)resultSet1.getObject("genre"), (String)resultSet1.getObject("album"), (String)resultSet1.getObject("artist"),
						(String)resultSet1.getObject("location"), (int)resultSet1.getObject("Stars"), (int)resultSet1.getObject("reproducciones")));
				}
			}	
			
		} catch (SQLException e) {
				// TODO Auto-generated catch block
			System.out.println("Error al reperar las canciones de una playlist de la base de datos");
		}
		return list;
	}
	/**
	 * <i>Request</i> dels noms de les <i>playlists</i> que ha creat un usuari determinat.
	 * @param id IDentificador de l'usuari creador de les playlists.
	 * @return String amb els noms de totes les llistes de l'usuari.
	 */
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
	/**
	 * Actualitza la data de l'ultim acc�s de un usuari a l'aplicaci�
	 * @param username
	 */
	public void updateLastAccess (String username){
		ddbb.updateQuery("UPDATE users SET date_last_acces = now() WHERE user_name='"+username+"'");
	}
	
	/**
	 * Solicita el registre d'un usuari a la base de dades
	 * @param username Nom d'usuari
	 * @param password Contrassenya d'usuari
	 * @return En cas de registre satisfactori retornar� <i>Added</i>. En cas contrari (que el nom d'usuari ja existeix), retornar� <i>Username already exists</i>.
	 * @see SQLException
	 * @see ResultSet
	 */
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
	/**
	 * Solicita la eliminaci� d'un usuari a la base de dades
	 * @param username Nom d'usuari
	 * @return Si l'usuari no existeix, tornar�: <i>Fail</i>. Si la solicitud es correcta i acceptada, retornar� un <i>Deleted</i>. En cas d'excepci� retonar�: <i>Problems</i>.
	 * @see ResultSet
	 * @see SQLException
	 */
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
				ddbb.deleteQuery("DELETE FROM followers WHERE user_followed="+id);
				
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
	/**
	 * <i>Request</i> per a afegir una nova can�� al servidor
	 * @param name Nom de la can��
	 * @param genre G�nere al que pertany la can��
	 * @param artist Artista int�rpret de la can��
	 * @param album Album en el qual s'inclou la can��
	 * @param location Ruta de l'arxiu d'audio que cont� la can��
	 * @param stars Puntuaci�
	 * @return En cas de no existir al servidor, es retornar�: <i>Added</i>. En cas contrari: <i>Exists</i>. En cas d'excepci� es retornar� <i>Problems</i>
	 * @see ResultSet
	 * @see SQLException
	 */
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
	/**
	 * Solicita l'eliminaci� d'una can�� a la base de dades.
	 * @param idDelete IDentificador de la can�� que es vol eliminar
	 * @return En cas de no existir al servidor, es retornar�: <i>Fail</i>. En cas contrari: <i>Deleted</i>. En cas d'excepci� es retornar� <i>Problems</i>
	 * @see ResultSet
	 * @see SQLException
	 */
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

	/**
	 * Solicita el nombre de seguidors que t� un usuari
	 * @param id IDentificador de l'usuari del que es vol saber la quantitat de seguidors
	 * @return En cas d'excepci� es tornar� 0. En els altres casos es retornar� el valor emmagatzemat.
	 */
	public int nFollowers(int id){
		try{
			ResultSet resultSet = ddbb.selectQuery("SELECT count(*) FROM followers WHERE user_followed="+id);
			resultSet.next();
			return  resultSet.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Problemas al obtener el numero de seguidores");
			return 0;
		}
	}
	/**
	 * Solicita el nomrbe de gent a la que segueix un usuari determinat
	 * @param id IDentificador de usuari
	 * @return En cas d'excepci� es tornar� 0. En els altres casos es retornar� el valor emmagatzemat.
	 * @see SQLException
	 * @see ResultSet
	 */
	public int nFolloweds(int id){
		try{
			ResultSet resultSet = ddbb.selectQuery("SELECT count(*) FROM followers WHERE user_follower="+id);
			resultSet.next();
			return  resultSet.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Problemas al obtener el numero de usuarios seguidos");
			return 0;
		}
	}
	/**
	 * Solicita el nombre de playlists que ha creat un usuari.
	 * @param id IDentificador de usuari
	 * @return En cas d'excepci� es tornar� 0. En els altres casos es retornar� el valor emmagatzemat.
	 * @see ResultSet
	 * @see SQLException
	 */
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
	/**
	 * Solicita el nombre de can�ons d'una <i>playlist</i>
	 * @param id IDentificador de la playlist
	 * @return En cas d'excepci� es tornar� 0. En els altres casos es retornar� el valor emmagatzemat.
	 * @see ResultSet
	 * @see SQLException
	 */
	public int nSongs (int id){
		try{
			ResultSet resultSet = ddbb.selectQuery("SELECT count(*) FROM playlists_songs WHERE cf_playlist="+id);
			resultSet.next();
			return  resultSet.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Problemas al obtener el numero de canciones");
			return 0;
		}
	}
	/**
	 * Solicita les dades de la playlist especificada
	 * @param id IDentificador de la playlist.
	 * @return LinkedList d'Object on, en cas d'�xit, emmagatzemar� les dades de la playlist. En cas contrari es mantendr� a null.
	 * @see SQLException
	 * @see ResultSet
	 */
	public LinkedList<Object[]> getPlaylistsDates(int id){
		LinkedList<Object[]> list =new LinkedList<Object[]>();
	
		try {
			ResultSet resultSet = ddbb.selectQuery("SELECT * FROM playlists WHERE creator_user="+id);
			while (resultSet.next())
				{
					String publica ="Publica";
					if ((int)resultSet.getObject("id_playlist") != 1){
						publica ="Privada";
					}
					Object[] obj = {(int)resultSet.getObject("id_playlist"),(String)resultSet.getObject("name"), nSongs((int)resultSet.getObject("id_playlist")), publica};
					list.add(obj);
				}
				
			return list;

		} catch (SQLException e) {
					// TODO Auto-generated catch block
			return list;
		}
	}
	/**
	 * Solicita una instancia de User de la base de dades.
	 * @param id IDentificador de l'usuari que es demana
	 * @return Instancia de model.User
	 * @see model.User
	 */
	public User getUser (int id){
		LinkedList<User> userList = getUsers();
		for (int i = 0; i<userList.size(); i++){
			if (userList.get(i).getId()==id){
				return userList.get(i);
			}
		}
		return null;
	}
	/**
	 * Solicita la quantitat de can�ons que inclou una llista de reproducci�
	 * @param id IDentificador de la llista de reproducci�
	 * @return En cas de solicitud satisfactoria, retornar� el nombre de can�ons que inclou la llista especificada. En cas contrari es tornar� sempre 0.
	 * @see ResultSet
	 * @see SQLException
	 * @see NullPointerException
	 */
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
