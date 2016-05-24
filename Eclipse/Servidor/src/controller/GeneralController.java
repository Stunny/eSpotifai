package controller;

import java.util.LinkedList;

import view.MainWindow;
import model.Song;
import model.User;
import model.customExceptions.DatabaseNotLoadedException;
import network.database.DDBBConnection;

public class GeneralController {
	//DDBB
	private DDBBConnection ddbbConnection;

	//VIEW
	private MainWindow view;

	private LinkedList<User> ArrayUtils;

	public GeneralController(DDBBConnection ddbbConnection, MainWindow view){
		this.ddbbConnection = ddbbConnection;
		this.view = view;
	}

	public void startConnections (){
		try{
			ddbbConnection.startConnection();
		} catch (DatabaseNotLoadedException e) {
			//System.out.println(e.getMessage());
		}
	}

	public void refreshLists(){
		LinkedList<User> userList = ddbbConnection.getUsers();
		LinkedList<Object[]> list = new LinkedList<Object[]>();
		for (int i = 0; i < userList.size(); i++){
			Object[] user = {userList.get(i).getId(), userList.get(i).getUsername(), userList.get(i).getRegistre(),

					userList.get(i).getLastAccess(), "", "", "", ""};
			list.add(user);
		}
		view.refreshUsers(list);
	}


	public void refreshLists2(){
		LinkedList<Object[]> list = new LinkedList<Object[]>();
		view.refreshUsers(ddbbConnection.getUsersDates());

		LinkedList<Song> songList =  ddbbConnection.getSongs();
		list = new LinkedList<Object[]>();
		for (int i = 0; i < songList.size(); i++){
			Object[] objs = {songList.get(i).getId(), songList.get(i).getName(), songList.get(i).getGenre(),
					songList.get(i).getAlbum(), songList.get(i).getArtist(), songList.get(i).getLocation(), 
					songList.get(i).getStars(), songList.get(i).getReproducciones()};
			list.add(objs);
		}
		view.refreshSongs(list);
	}

	public void trackTime() {
		view.refreshTime();
	}

}