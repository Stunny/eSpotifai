package model;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @version 0.1
 * @author Alex Vogel
 *
 */
public class FileServer {
	private int SOCKET_PORT_DESTI;
	private String fileRoute;
	
	public FileServer(){
		this.SOCKET_PORT_DESTI = 00000;
		this.fileRoute = new String("");
	}
	public FileServer(int socketPort, String fileRoute){
		this.SOCKET_PORT_DESTI = socketPort;
		this.fileRoute = new String(fileRoute);
	}
	
	public int getSocketPort(){
		return this.SOCKET_PORT_DESTI;
	}
	public String getFileRoute(){
		return this.fileRoute;
	}
	
	public void setSocketPort(int socketPort){
		this.SOCKET_PORT_DESTI = socketPort;
	}
	public void setFileRoute(String fileRoute){
		this.fileRoute = fileRoute;
	}
	
	public void send()throws IOException{
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		OutputStream os = null;
		ServerSocket ss = null;
		Socket s = null;
		try{
			ss = new ServerSocket(SOCKET_PORT_DESTI);
			while(true){
				//Waiting...
				try{
					s = ss.accept();
					//Accepted connection
					//Send file
					File fileToSend = new File(fileRoute);
					byte[] ba = new byte[(int)fileToSend.length()];
					fis = new FileInputStream(fileToSend);
					bis = new BufferedInputStream(fis);
					bis.read(ba,0,ba.length);
					os = s.getOutputStream();
					//Enviando...
					os.write(ba, 0, ba.length);
					os.flush();
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
