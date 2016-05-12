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
	private int socketPort;
	private String fileRoute;
	
	public FileServer(){
		this.socketPort = 00000;
		this.fileRoute = new String("");
	}
	public FileServer(int socketPort, String fileRoute){
		this.socketPort = socketPort;
		this.fileRoute = new String(fileRoute);
	}
	
	public int getSocketPort(){
		return this.socketPort;
	}
	public String getFileRoute(){
		return this.fileRoute;
	}
	
	public void setSocketPort(int socketPort){
		this.socketPort = socketPort;
	}
	public void setFileRoute(String fileRoute){
		this.fileRoute = fileRoute;
	}
	
	
	public void listen() throws IOException{
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
	}
	
	
	public void send()throws IOException{
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		OutputStream os = null;
		ServerSocket ss = null;
		Socket s = null;
		try{
			ss = new ServerSocket(socketPort);
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
