package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

import controller.NetworkController;

/**
 * S'encarrega d'enviar dades al servidor de música.
 * @author Elna Cabot, Miguel Diaz, Marc Millan, Alejandro Vogel, Marta Zapatero
 * @version 1.0
 * @see Socket
 *
 */
public class ServerCommunication {
	/**
	 * Socket de conexió amb el servidor
	 * @see Socket
	 */
	private Socket sServer;
	/**
	 * Flux de sortida de dades cap al servidor
	 * @see DataOutputStream
	 */
	private DataOutputStream dataOut;
	/**
	 * Flux d'entrada de dades des del servidor
	 * @see DataInputStream
	 */
	private DataInputStream dataIn;
	
	/**
	 * Direcció IP del servidor.
	 * @see Socket
	 */
	private final String SOCKET_IP = "127.0.0.1";
	/**
	 * Port de conexió al servidor.
	 * @see Socket
	 */
	private final int SOCKET_PORT = 50000;
	/**
	 * Construeix el comunicador amb el servidor.
	 * 
	 */
	public ServerCommunication() {
		super();
	}

	/**
	 * Envia les dades al servidor socket especif
	 * @param s Dades que s'enviaran al servidor en forma de String
	 * @return La resposta del servidor o, en cas de que no hi hagi hagut conexió, un missatge de error local.
	 * @see DataOutputStream
	 * @see DataInputStream
	 * @see Socket
	 * @see JOptionPane
	 */
	public String sendData(String s) {
		try {
			// establim comunicacio amb el servidor
			sServer = new Socket(SOCKET_IP, SOCKET_PORT);
			// enviem l'alumne
			dataOut = new DataOutputStream(sServer.getOutputStream());
			dataOut.writeUTF(s);
			dataIn = new DataInputStream(sServer.getInputStream());
			String resposta = dataIn.readUTF();
			// tanquem la connexio
			sServer.close();
			return resposta;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Problema connectant-se amb el servidor", " ", JOptionPane.ERROR_MESSAGE);
			return new String("ERROR");
		}
	}

}
