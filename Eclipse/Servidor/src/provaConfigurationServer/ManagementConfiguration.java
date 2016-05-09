package provaConfigurationServer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class ManagementConfiguration {

	private Server server;
	
	public ManagementConfiguration(){
		server = new Server();
	}

	public void runConfiguration(){
		boolean error = false;
		error = readJSON();
		
		if (error != false){
			
		}
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
		
		//Si el fitxer no està creat o hi ha algún error en la seva estructura,
		//no petará, pero si que executarem aquest control d'error
		if (error != true){
			//Parsejem els camps
			JsonObject object = (JsonObject)gson.fromJson(totalFiles, JsonObject.class);
			JsonObject information = object.get("configuration").getAsJsonObject();
			//Omplim les dades del servidor
			server.setPortConexionBBDD(information.get("portConexionBBDD").getAsInt());
			server.setIPBBDD(information.get("IPBBDD").getAsString());
			server.setNameBBDD(information.get("nameBBDD").getAsString());
			server.setUserBBDD(information.get("userBBDD").getAsString());
			server.setPasswordBBDD(information.get("passwordBBDD").getAsString());
			server.setPortClientComunication(information.get("portClientComunication").getAsInt());
		}
		return error;
	}	
}
