package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import database.DDBBConnection;
import view.AddMusicWindow;
import view.FollowersWindow;
import view.MainWindow;
import view.StatisticsWindow;

public class PopUpController implements ActionListener{
	private FollowersWindow view;
	private MainWindow main;
	private DDBBConnection ddbbConnection; 
		
	public PopUpController(MainWindow main, DDBBConnection ddbbConnection) {
		this.main = main;
		this.ddbbConnection = ddbbConnection;
	}

	public void actionPerformed(ActionEvent event) {
		
		if (event.getActionCommand().equals("MainWindow.seguidoresActionCommand")) {
			 FollowersWindow view = new  FollowersWindow(ddbbConnection.getFollowersDates(main.getId()));
			 view.setVisible(true);
		}else if (event.getActionCommand().equals("MainWindow.seguidosActionCommand")){
	
		}else if (event.getActionCommand().equals("MainWindow.listasActionCommand")){
		
		}else if (event.getActionCommand().equals("MainWindow.eliminarActionCommand")){
	
		}
		
	}
}

