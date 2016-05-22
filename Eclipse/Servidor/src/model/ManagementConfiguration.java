package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
/**
 * Gestiona la configuraci� del servidor
 * @author Elna Cabot, Miguel D�az, Marc Mill�n, Alejandro Vogel, Marta Zapatero
 * @version 1.0
 * @see ServerConfiguration
 * @see Gson
 * @see JsonObject
 * @see BufferedReader
 *
 */
public class ManagementConfiguration {
	/**
	 * Configuraci� de servidor
	 * @see ServerConfiguration
	 */
	private ServerConfiguration serverConfiguration;
	/**
	 * Construeix un gestor de configuraci� de servidor buida
	 */
	public ManagementConfiguration(){
		serverConfiguration = new ServerConfiguration();
	}
	/**
	 * Executa la configuracio del servidor
	 * @see ServerConfiguration
	 * @see model.ResultSetToJSON
	 */
	public void runConfiguration(){
		boolean error = false;
		error = readJSON();
		
		if (error != false){
			
		}
	}
	/**
	 * Getter de la configuracio del servidor
	 * @return Server Configuration
	 */
	public ServerConfiguration getServerConfiguration() {
		return serverConfiguration;
	}
	/**
	 * Setter de la configuraci� de servidor
	 * @param serverConfiguration Server Configuration
	 */
	public void setServerConfiguration(ServerConfiguration serverConfiguration) {
		this.serverConfiguration = serverConfiguration;
	}
	/**
	 * Llegeix la configuraci� predeterminada al fitxer <i style="color:indigo">config.json</i>.
	 * @return <i style="color:indigo">TRUE</i> en cas de que es llegeixi correctament el fitxer. En cas contrari es retorna <i style="color:indigo">FALSE</i>.
	 */
	public boolean readJSON(){
		boolean error = false;
		Gson gson = new Gson();
		String file = new String();
		String totalFiles = new String();

		BufferedReader bffr;

		try {
			
			//Obrim el fitxer JSON on es troben les dades necesaries per al servidor
			bffr = new BufferedReader(new FileReader("config.json"));
			
			//Carreguem tot el fitxer a la variable filesTotals
			while( (file = bffr.readLine()) != null){
				totalFiles = totalFiles + file;	
			}
			//Tanquem el fitxer JSON
			bffr.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Server data file doesn't exist.");
			error = true;
		
		} catch (IOException e) {
			e.printStackTrace();
			error = true;
			System.out.println("Server data file has syntax errors.");
		}
		
		//Si el fitxer no est� creat o hi ha alg�n error en la seva estructura,
		//no petar�, pero si que executarem aquest control d'error
		if (error != true){
			//Parsejem els camps
			JsonObject object = (JsonObject)gson.fromJson(totalFiles, JsonObject.class);
			JsonObject information = object.get("configuration").getAsJsonObject();
			//Omplim les dades del servidor
			serverConfiguration.setPortConexionBBDD(information.get("portConexionBBDD").getAsInt());
			serverConfiguration.setIPBBDD(information.get("IPBBDD").getAsString());
			serverConfiguration.setNameBBDD(information.get("nameBBDD").getAsString());
			serverConfiguration.setUserBBDD(information.get("userBBDD").getAsString());
			serverConfiguration.setPasswordBBDD(information.get("passwordBBDD").getAsString());
			serverConfiguration.setPortClientComunication(information.get("portClientComunication").getAsInt());
		}
		return error;
	}	
}
