package provaConfigurationServer;

public class Server {

	private int portConexionBBDD;
	private String IPBBDD;
	private String nameBBDD;
	private String userBBDD;
	private String passwordBBDD;
	private int portClientComunication;
	
	
	public Server(int portConexionBBDD, String iPBBDD, String nameBBDD,
			String userBBDD, String passwordBBDD, int portClientComunication) {
		super();
		this.portConexionBBDD = portConexionBBDD;
		this.IPBBDD = iPBBDD;
		this.nameBBDD = nameBBDD;
		this.userBBDD = userBBDD;
		this.passwordBBDD = passwordBBDD;
		this.portClientComunication = portClientComunication;
	}
	public Server(){
	}
	public int getPortConexionBBDD() {
		return portConexionBBDD;
	}
	public void setPortConexionBBDD(int portConexionBBDD) {
		this.portConexionBBDD = portConexionBBDD;
	}
	public String getIPBBDD() {
		return IPBBDD;
	}
	public void setIPBBDD(String iPBBDD) {
		IPBBDD = iPBBDD;
	}
	public String getNameBBDD() {
		return nameBBDD;
	}
	public void setNameBBDD(String nameBBDD) {
		this.nameBBDD = nameBBDD;
	}
	public String getUserBBDD() {
		return userBBDD;
	}
	public void setUserBBDD(String userBBDD) {
		this.userBBDD = userBBDD;
	}
	public String getPasswordBBDD() {
		return passwordBBDD;
	}
	public void setPasswordBBDD(String passwordBBDD) {
		this.passwordBBDD = passwordBBDD;
	}
	public int getPortClientComunication() {
		return portClientComunication;
	}
	public void setPortClientComunication(int portClientComunication) {
		this.portClientComunication = portClientComunication;
	}
}
