package provaConfigurationServer;

import java.util.Scanner;

import controller.ButtonsController;
import view.AddMusicWindow;
import view.MainWindow;
import view.StatisticsWindow;

public class Main {
	
	public static void main(String[] args ){
		
		ManagementConfiguration mc = new ManagementConfiguration();
		mc.runConfiguration();
		
		// Creem la VISTA
		MainWindow mainWindow = new MainWindow();
		ButtonsController controller = new ButtonsController(mainWindow);
		mainWindow.registerController(controller);
		mainWindow.setVisible(true);
		
		//Creem la vista temporal de adici�
		AddMusicWindow addView = new AddMusicWindow();
		addView.setVisible(true);
		
		StatisticsWindow statisticsWindow = new StatisticsWindow();
		statisticsWindow.setVisible(true);
		
	}
	
}
