package controller;

import java.util.LinkedList;

import view.MainWindow;
import customExceptions.DatabaseNotLoadedException;
import database.DDBBConnection;
import model.Song;
import model.User;
/**
 * 
 * @author Elna Cabot, Miguel D�az, Marc Mill�n, Alejandro Vogel, Marta Zapatero
 * @version 1.0
 * @see DDBBConnection
 * @see MainWindow
 * @see DatabaseNotLoadedException
 *
 */
public class GeneralController {
	//DDBB
	/**
	 * Conexi� amb la base de dades
	 * @see DDBBConnection
	 */
	private DDBBConnection ddbbConnection;
	
	//VIEW
	/**
	 * Pantalla principal de l'aplicaci�
	 * @see MainWindow
	 */
	private MainWindow view;
	/**
	 * 
	 */
	private LinkedList<User> ArrayUtils;
	/**
	 * 
	 * @param ddbbConnection Conexi� amb la base de dades
	 * @param view Pantalla principal de l'aplicaci�
	 * @see DDBBConnection
	 * @see MainWindow
	 */
	public GeneralController(DDBBConnection ddbbConnection, MainWindow view){
		this.ddbbConnection = ddbbConnection;
		this.view = view;
	}
	/**
	 * Executa les conexions pertinents per inicialitzar el servidor amb la base de dades.
	 * @see DatabaseNotLoadedException
	 */
	public void startConnections (){
		try{
			ddbbConnection.startConnection();
		} catch (DatabaseNotLoadedException e) {
			System.out.println(e.getMessage());
		}
	}
	/**
	 * Actualitza continuament les llistes de la pantalla principal
	 * @see User
	 */
	public void refreshLists(){
		LinkedList<User> userList = ddbbConnection.getUsers();
		LinkedList<Object[]> list =new LinkedList<Object[]>();
		for (int i = 0; i < userList.size(); i++){
			Object[] user = {userList.get(i).getId(), userList.get(i).getUsername(), userList.get(i).getRegistre(),

							userList.get(i).getLastAccess(), "", "", "", ""};
			list.add(user);
		}
		view.refreshUsers(list);
	}
	
	/**
	 * Actualitza continuament les llistes de la pantalla principal
	 * @see User
	 */
	public void refreshLists2(){
		LinkedList<Object[]> list = new LinkedList<Object[]>();
		view.refreshUsers(ddbbConnection.getUsersDates());
		
		LinkedList<Song> songList =  ddbbConnection.getSongs();
		list = new LinkedList<Object[]>();
		for (int i = 0; i < songList.size(); i++){
			Object[] objs = {songList.get(i).getId(), songList.get(i).getName(), songList.get(i).getGenre(),
							songList.get(i).getAlbum(), songList.get(i).getArtist(), songList.get(i).getLocation(), 
							songList.get(i).getStars(), songList.get(i).getReproductions()};
			list.add(objs);
		}
		view.refreshSongs(list);
	}
	/**
	 * Segueix el temps d'execuci�
	 */
	public void trackTime() {
		view.refreshTime();
	}

	}