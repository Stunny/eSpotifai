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
			System.out.println("Dummy0");
			sServer = new Socket("127.0.0.1", 50000);
			System.out.println("Dummy1");
			// enviem l'alumne
			dataOut = new DataOutputStream(sServer.getOutputStream());
			System.out.println("Dummy2");
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
