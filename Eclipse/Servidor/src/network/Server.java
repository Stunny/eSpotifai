package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

import controller.NetworkController;

/**
 * Conecta amb el client per a l'intercanvi de dades
 * @author Elna Cabot, Miguel D�az, Marc Mill�n, Alejandro Vogel, Marta Zapatero
 * @version 1.0
 * @see Thread
 * @see ServerSocket
 * @see Socket
 * @see DataInputStream
 * @see DataOutputStream
 * @see NetworkController
 *
 */
public class Server extends Thread {
	/**
	 * Indica si la conexi� est� habilitada
	 */
	private boolean isOn;
	/**
	 * Punt de conexi� del servidor
	 * @see ServerSocket
	 */
	private ServerSocket sServer;
	/**
	 * Punt de conexi� del client
	 * @see Socket
	 */
	private Socket sClient;
	/**
	 * Input de dades
	 * @see DataInputStream
	 */
	private DataInputStream dataIn;
	/**
	 * Output de dades
	 * @see DataOutputStream
	 */
	private DataOutputStream dataOut;
	/**
	 * Controlador de la conexi�
	 * @see NetworkController
	 */
	private NetworkController controller;
	/**
	 * Construeix i prepara el servidor per a poder establir-hi conexions
	 * @param controller Controlador de la conexi�
	 */
	public Server(NetworkController controller) {
		try {
			sServer = new ServerSocket(50000);
			isOn = false;
			this.controller = controller;
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Aquest port esta ocupat.\nPotser ja estas executant el servidor.", " ", JOptionPane.ERROR_MESSAGE);
			System.exit(MIN_PRIORITY);
		}
	}
	/**
	 * Inicia el servidor
	 * @see Thread
	 */
	public void startServer() {
		isOn = true;
		super.start();
	}
	/**
	 * Atura el servidor
	 * @see Thread
	 */
	public void stopServer() {
		isOn = false;
	}
	/**
	 * 
	 */
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
