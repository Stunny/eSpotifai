package model;
/**
 * 
 * @author Elna Cabot, Miguel D�az, Marc Mill�n, Alejandro Vogel, Marta Zapatero
 * @version 1.0
 * @see ManagementConfiguration
 * @see network.Server
 *
 */
public class ServerConfiguration {
	/**
	 * Port de conexi� a la base de dades.
	 * @see database.DDBBConnection
	 */
	private int portConexionBBDD;
	/**
	 * Direcci� IP de la base de dades
	 * @see database.DDBBConnection
	 */
	private String IPBBDD;
	/**
	 * Nom de la base de dades
	 * @see database.DataBase
	 */
	private String nameBBDD;
	/**
	 * Nom d'usuari de la base de dades
	 * @see database.DataBase
	 */
	private String userBBDD;
	/**
	 * Contrassenya de la base de dades
	 * @see database.DataBase
	 */
	private String passwordBBDD;
	/**
	 * Port de comunicaci� amb el client
	 * @see network.Server
	 */
	private int portClientComunication;
	
	/**
	 * Construeix una configuraci� de servidor
	 * @param portConexionBBDD Port de conexi� a la base de dades.
	 * @param iPBBDD Direcci� IP de la base de dades
	 * @param nameBBDD Nom de la base de dades
	 * @param userBBDD Nom d'usuari de la base de dades
	 * @param passwordBBDD Contrassenya de la base de dades
	 * @param portClientComunication Port de comunicaci� amb el client
	 */
	public ServerConfiguration(int portConexionBBDD, String iPBBDD, String nameBBDD,
			String userBBDD, String passwordBBDD, int portClientComunication) {
		super();
		this.portConexionBBDD = portConexionBBDD;
		this.IPBBDD = iPBBDD;
		this.nameBBDD = nameBBDD;
		this.userBBDD = userBBDD;
		this.passwordBBDD = passwordBBDD;
		this.portClientComunication = portClientComunication;
	}
	/**
	 * Constructor buit de una configuraci� buida de servidor.
	 */
	public ServerConfiguration(){
	}
	/**
	 * Getter del port de conexi� a la base de dades
	 * @return Database Connection Port
	 */
	public int getPortConexionBBDD() {
		return portConexionBBDD;
	}
	/**
	 * Setter del port de conexi� amb la base de dades
	 * @param portConexionBBDD Database Connection Port
	 */
	public void setPortConexionBBDD(int portConexionBBDD) {
		this.portConexionBBDD = portConexionBBDD;
	}
	/**
	 * Getter de la direcci� IP del host de la base de dades
	 * @return Database IP address
	 */
	public String getIPBBDD() {
		return IPBBDD;
	}
	/**
	 * Setter de la direcci� IP del host de la base de dades
	 * @param iPBBDD
	 */
	public void setIPBBDD(String iPBBDD) {
		IPBBDD = iPBBDD;
	}
	/**
	 * Getter del nom de la base de dades
	 * @return Database name
	 */
	public String getNameBBDD() {
		return nameBBDD;
	}
	/**
	 * Setter del nom de la base de dades
	 * @param nameBBDD Database name
	 */
	public void setNameBBDD(String nameBBDD) {
		this.nameBBDD = nameBBDD;
	}
	/**
	 * Getter del nom d'usuari de la base de dades
	 * @return Database user name
	 */
	public String getUserBBDD() {
		return userBBDD;
	}
	/**
	 * Setter del nom d'usuari de la base de dades
	 * @param userBBDD Database user name
	 */
	public void setUserBBDD(String userBBDD) {
		this.userBBDD = userBBDD;
	}
	/**
	 * Getter de la contrassenya de la base de dades
	 * @return Database password
	 */
	public String getPasswordBBDD() {
		return passwordBBDD;
	}
	/**
	 * Setter de la contrassenya de la base de dades
	 * @param passwordBBDD Database password
	 */
	public void setPasswordBBDD(String passwordBBDD) {
		this.passwordBBDD = passwordBBDD;
	}
	/**
	 * Getter del port de comunicaci� amb el client
	 * @return Client port
	 */
	public int getPortClientComunication() {
		return portClientComunication;
	}
	/**
	 * Setter del port de comunicaci� amb el client
	 * @param portClientComunication
	 */
	public void setPortClientComunication(int portClientComunication) {
		this.portClientComunication = portClientComunication;
	}
}
