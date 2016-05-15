package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import controller.NetworkController;


public class ServerCommunication {
	
	private Socket sServer;
	private DataOutputStream dataOut;
	private DataInputStream dataIn;
	
	
	public ServerCommunication() {
		super();
	}


	public String sendData(String s) {
		try {
			// establim comunicacio amb el servidor
			sServer = new Socket("127.0.0.1", 50000);
			// enviem l'alumne
			dataOut = new DataOutputStream(sServer.getOutputStream());
			dataOut.writeUTF(s);
			dataIn = new DataInputStream(sServer.getInputStream());
			String resposta = dataIn.readUTF();
			// tanquem la connexio
			sServer.close();
			return resposta;
		} catch (UnknownHostException e) {
			e.printStackTrace();
			return new String("ERROR");
		} catch (IOException e) {
			e.printStackTrace();
			return new String("ERROR");
		}
	}

}
