package network;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

import controller.NetworkController;

/**
 * @version 0.1
 * @author Alex Vogel, Marta Zapatero
 *
 */
public class FileServer extends Thread {
	
	private boolean isOn;
	private ServerSocket sServer;
	private Socket sClient;
	private FileInputStream fis;
	private BufferedInputStream bis;
	private OutputStream os;
	private String filePath;
	
	public FileServer() {
		try {
			sServer = new ServerSocket(50001);
			isOn = false;
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Aquest port esta ocupat.\nPotser ja estas executant el servidor.", " ", JOptionPane.ERROR_MESSAGE);
			System.exit(MIN_PRIORITY);
		}
	}
	
	public void startServer() {
		isOn = true;
		super.start();
	}
	
	public void stopServer() {
		isOn = false;
	}
	
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	
	public void run() {

		while (isOn) {
			try {
				//connexió entrant
				sClient = sServer.accept();
				
				//eines
				os = sClient.getOutputStream();
				fis = new FileInputStream(new File(filePath));
				bis = new BufferedInputStream(fis);
				
				//preparem buffer
				byte[] buffer = new byte[8192];
				
				//ho "transforma" a bytes
				int bytesRead = bis.read(buffer,0,buffer.length);
				while (bytesRead > -1) {
					//ho envia
					os.write(buffer, 0, bytesRead);
					bytesRead = bis.read(buffer,0,buffer.length);
				}
				
				//buida al final
				os.flush();
				

			} catch (IOException e) {
				e.printStackTrace();
			}finally{
					try {
						//bis.close();
						//os.close();
						sClient.close();
						//sServer.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

			}
		}	
	}
	
	
	
	/*public void listen() throws IOException{
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		OutputStream os = null;
		ServerSocket ss = null;
		Socket s = null;
		try{
			ss = new ServerSocket(socketPort);
			while(true){
			}
		}finally{
			if(ss != null) ss.close();
		}
	}*/
	
	
	public void send()throws IOException{
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		OutputStream os = null;
		ServerSocket ss = null;
		Socket s = null;
		try{
			ss = new ServerSocket(50001);
			while(true){
				//Waiting...
				try{
					System.out.println("Hemos entrado en SEND");
					s = ss.accept();
					System.out.println("Cliente aceptado... enviando");
					//Accepted connection
					//Send file
					File fileToSend = new File(filePath);
					byte[] buffer = new byte[(int)fileToSend.length()];
					fis = new FileInputStream(fileToSend);
					bis = new BufferedInputStream(fis);
					bis.read(buffer,0,buffer.length);
					os = s.getOutputStream();
					//Enviando...
					os.write(buffer, 0, buffer.length);
					os.flush();
					System.out.println("Enviado!");
					//Enviado
				}
				finally{
					if(bis != null) bis.close();
					if(os != null) os.close();
					if(s != null) s.close();
				}
			}			
		}
		finally{
			if(ss != null) ss.close();
		}
	}
}
