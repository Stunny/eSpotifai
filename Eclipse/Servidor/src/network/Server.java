package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import controller.NetworkController;


public class Server extends Thread {
	private boolean isOn;
	private ServerSocket sServer;
	private Socket sClient;
	private DataInputStream dataIn;
	private DataOutputStream dataOut;
	private NetworkController controller;
	
	public Server(NetworkController controller) {
		try {
			sServer = new ServerSocket(50000);
			isOn = false;
			this.controller = controller;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void startServer() {
		isOn = true;
		super.start();
	}
	
	public void stopServer() {
		isOn = false;
	}
	
	public void run() {
		String s;
		while (isOn) {
			try {
				// esperem peticions de connexio, esperem clients
				// BLOQUEJA
				sClient = sServer.accept();
				// llegim un objecte
				dataIn = new DataInputStream(sClient.getInputStream());
				s = dataIn.readUTF();
				String resposta = controller.manageInput(s);
				dataOut = new DataOutputStream(sClient.getOutputStream());
				dataOut.writeUTF(resposta);
				// tanquem la connexio amb el client
				sClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
	}

}
