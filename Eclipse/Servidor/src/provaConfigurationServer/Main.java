package provaConfigurationServer;

import java.util.Scanner;

import controller.ButtonsController;
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
		//FollowersWindow followerswindow = new FollowersWindow();
		ButtonsController controller = new ButtonsController(mainWindow);
		//PopUpController popupcontroller = new PopUpController (followerswindow);
		//mainWindow.registerController(controller, popupcontroller);
		mainWindow.setVisible(true);
		
		//Creem la vista temporal de adici�
		AddMusicWindow addView = new AddMusicWindow();
		//addView.setVisible(true);
		
		StatisticsWindow statisticsWindow = new StatisticsWindow();
		//statisticsWindow.setVisible(true);
		
	}
	
}
