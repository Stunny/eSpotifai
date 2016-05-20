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
		MainWindow mainWindow = new MainWindow();
/*<<<<<<< HEAD
		//FollowersWindow followerswindow = new FollowersWindow();
		ButtonsController controller = new ButtonsController(mainWindow);
		//PopUpController popupcontroller = new PopUpController (followerswindow);
		//mainWindow.registerController(controller, popupcontroller);
=======
		FollowersWindow followerswindow = new FollowersWindow(null);
		ButtonsController controller = new ButtonsController(mainWindow);
		PopUpController popupcontroller = new PopUpController(mainWindow, null);
		mainWindow.registerController(controller, popupcontroller);
>>>>>>> cbc1e0d816a6c726ec7db5d9b7bdbb0a77ce6231
*/
		mainWindow.setVisible(true);
		
		//Creem la vista temporal de adici�
		AddMusicWindow addView = new AddMusicWindow();
		//addView.setVisible(true);
		
		StatisticsWindow statisticsWindow = new StatisticsWindow();
		//statisticsWindow.setVisible(true);
		
		Server server = new Server(new NetworkController(null));
		server.startServer();
		
	}
	
}
