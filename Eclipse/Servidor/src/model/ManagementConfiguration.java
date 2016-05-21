package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class ManagementConfiguration {

	private ServerConfiguration serverConfiguration;
	
	public ManagementConfiguration(){
		serverConfiguration = new ServerConfiguration();
	}

	public void runConfiguration(){
		boolean error = false;
		error = readJSON();
		
		if (error != false){
			
		}
	}
	
	public ServerConfiguration getServerConfiguration() {
		return serverConfiguration;
	}

	public void setServerConfiguration(ServerConfiguration serverConfiguration) {
		this.serverConfiguration = serverConfiguration;
	}

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
			System.out.println("Fitxer de dades del servidor no existeix");
			error = true;
		
		} catch (IOException e) {
			e.printStackTrace();
			error = true;
			System.out.println("Fitxer de dades del servidor amb error/s sintactics");
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
