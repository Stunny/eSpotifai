package controller;

import java.util.LinkedList;

import view.MainWindow;
import customExceptions.DatabaseNotLoadedException;
import model.DDBBConnection;
import model.User;

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
			System.out.println(e.getMessage());
		}
	}
	
	public void refreshLists(){
		LinkedList<User> userList = ddbbConnection.showUsers();
		Object[][] users = new Object[][]{};
		for (int i = 0; i < userList.size(); i++){
			System.out.println(userList.get(i).getId()+" "+ userList.get(i).getName()+" "+ userList.get(i).getRegistre()+" "+
					userList.get(i).getLastAcces()+" "+ ""+" "+ ""+" "+ ""+" "+ "");
			Object[] user = {userList.get(i).getId(), userList.get(i).getName(), userList.get(i).getRegistre(),
							userList.get(i).getLastAcces(), "", "", "", ""};
			users = new Object[][]{user, user};
			System.out.println(users.length);
		}
		view.refreshUsers(users);
	}
	
	public void run() {
		while (true){
			try {
				Thread.sleep(5000);
				refreshLists();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
