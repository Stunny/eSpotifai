package network;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

public class FileServerCommunication {
	
	/**
	 * Socket de conexió amb el servidor
	 * @see Socket
	 */
	private Socket sServer;
	
	/**
	 * Direcció IP del servidor.
	 * @see Socket
	 */
	private final String SOCKET_IP = "127.0.0.1";
	/**
	 * Port de conexió al servidor.
	 * @see Socket
	 */
	private final int SOCKET_PORT = 50001;
	/**
	 * Construeix el comunicador amb el servidor.
	 * 
	 */
	
	private InputStream is;
	
	private FileOutputStream fos;
	
	private BufferedOutputStream bos;
	
	
	
	public FileServerCommunication() {
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
	public boolean askForFile() {
		try {
			//connexió cap al server
			sServer = new Socket(SOCKET_IP, SOCKET_PORT);
			
			//eines
			is = sServer.getInputStream();
			fos = new FileOutputStream("Resources/song.mp3");
			bos = new BufferedOutputStream(fos);
			
			//preparem buffer
			byte[] buffer = new byte[8192];
		    
			//ho rep
		    
			int bytesRead = is.read(buffer, 0, buffer.length);	
			while (bytesRead > -1) {
		    //ho "transforma" en arxiu
				bos.write(buffer, 0, bytesRead);
				bytesRead = is.read(buffer, 0, buffer.length);
			}
		    //tanca la conexio
		    bos.close();
		    sServer.close();
		   
		    return true;
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, "Problema descarregant el fitxer", " ", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}

	

}
