package provaConfigurationServer;

import java.util.Scanner;

import controller.ButtonsController;
import controller.NetworkController;
import model.ManagementConfiguration;
import network.Server;
import controller.GeneralController;
import controller.PopUpController;
import view.AddMusicWindow;
import view.FollowersWindow;
import view.MainWindow;
import view.StatisticsWindow;

public class Main {
	
	public static void main(String[] args ){
		
		ManagementConfiguration mc = new ManagementConfiguration();
		mc.runConfiguration();
		
		// Creem la VISTA
		AddMusicWindow addView = new AddMusicWindow();
		MainWindow mainWindow = new MainWindow();
		//FollowersWindow followerswindow = new FollowersWindow(null);


		mainWindow.setVisible(true);
		
		//Creem la vista temporal de adició
		
		//addView.setVisible(true);
		
		StatisticsWindow statisticsWindow = new StatisticsWindow();
		//statisticsWindow.setVisible(true);
		
		//controller.run();
		
		Server server = new Server(new NetworkController(null));
		server.startServer();
		
	}
	
}
