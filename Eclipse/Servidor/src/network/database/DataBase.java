package network.database;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import model.customExceptions.DatabaseNotLoadedException;
/**
 * 
 * @author Elna Cabot, Miguel D�az, Marc Mill�n, Alejandro Vogel, Marta Zapatero
 * @versio 1.0
 * @see DDBBConnection
 * @see DatabaseNotLoadedException
 * @see DriverManager
 * @see SQLException
 * @see Connection
 *
 */
public class DataBase {
	/**
	 * Nom de l'usuari de la base de dades
	 */
	static String username;
	/**
	 * Contrassenya de l'usuari de la base de dades
	 */
	static String password;
	/**
	 * Nom de la base de dades
	 */
	static String ddbbName;
	/**
	 * Port de conexi� de la base de dades
	 */
	static int port;
	/**
	 * Direcci� URL de la base de dades
	 */
	static String url = "jdbc:mysql://localhost";
	/**
	 * Instanciaci� de conexi� amb la base de dades
	 */
	static Connection conn = null;
	/**
	 * Doble pas per executar les queries per tal d'evitar <i>Injection</i>
	 */
	static Statement s;
	/**
	 * Prepara les dades per a la conexio amb la base de dades
	 * @param username Nom d'usuari de la base de dades
	 * @param password Contrassenya de l'usuari de la base de dades
	 * @param ddbbName Nom de la base de dades
	 * @param port Port de conexi� de la base de dades
	 */
	public DataBase(String username, String password, String ddbbName, int port) {
		DataBase.username = username;
		DataBase.password = password;
		DataBase.ddbbName = ddbbName;
		DataBase.port = port;
		DataBase.url += ":"+port+"/";
		DataBase.url += ddbbName;
	}
	/**
	 * Executa la conexi� amb la base de dades mitjan�ant els atributs inicialitzats ateriorment.
	 * @throws DatabaseNotLoadedException En cas de error a l'hora de conectar.
	 */
	public void connect() throws DatabaseNotLoadedException{

		try {
			Class.forName("com.mysql.jdbc.Connection");
			conn = (Connection) DriverManager.getConnection(url, username, password);
			if (conn != null) {
				//System.out.println("Conexi� a base de dades "+url+" ... Ok");
			}
		}
		catch(SQLException ex) {
			//System.out.println("Problema al connecta-nos a la BBDD --> "+ url);
			//System.out.println(ex);
			throw new DatabaseNotLoadedException("Database not loaded.");
		}
		catch(ClassNotFoundException ex2) {
			//System.out.println(ex2);
			throw new DatabaseNotLoadedException("Database not loaded.");
		}
		catch (Exception e) {
			throw new DatabaseNotLoadedException("Database not loaded.");
		}

	}

	public void insertQuery(String query){
		try {
			s =(Statement) conn.createStatement();
			s.executeUpdate(query);

		} catch (SQLException ex) {
			//System.out.println("Problema al Inserir --> " + ex.getSQLState());
		}
	}

	public void updateQuery(String query){
		try {
			s =(Statement) conn.createStatement();
			s.executeUpdate(query);

		} catch (SQLException ex) {
			//System.out.println("Problema al Modificar --> " + ex.getSQLState());
		}
	}

	public void deleteQuery(String query){
		try {
			s =(Statement) conn.createStatement();
			s.executeUpdate(query);

		} catch (SQLException ex) {
			//System.out.println("Problema al Eliminar --> " + ex.getSQLState());
		}

	}

	public ResultSet selectQuery(String query){
		ResultSet rs = null;
		try {
			s =(Statement) conn.createStatement();
			rs = s.executeQuery (query);

		} catch (SQLException ex) {
			//System.out.println("Problem when fetching data --> " + ex.getSQLState());
		}
		return rs;
	}

	public void disconnect(){
		try {
			conn.close();
		} catch (SQLException e) {
			//System.out.println("Issue when logging out --> " + e.getSQLState());
		}
	}
}
