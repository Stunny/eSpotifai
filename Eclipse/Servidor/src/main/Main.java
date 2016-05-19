package main;

import provaConfigurationServer.ManagementConfiguration;
import view.AddMusicWindow;
import view.MainWindow;
import view.StatisticsWindow;
import controller.ButtonsController;
import controller.GeneralController;
import controller.PopUpController;
import customExceptions.DatabaseNotLoadedException;
import model.DDBBConnection;

public class Main {

	public static void main(String[] args) {
		DDBBConnection ddbbConnection = new DDBBConnection ("root", "", "espotyfai", 3306);
		try {
			
			ddbbConnection.startConnection();
			ManagementConfiguration mc = new ManagementConfiguration();
			mc.runConfiguration();
			
			// Creem la VISTA
			
			MainWindow mainWindow = new MainWindow();
			ButtonsController buttonscontroller = new ButtonsController(mainWindow);
			PopUpController popupcontroller = new PopUpController (mainWindow);
			GeneralController controller = new GeneralController (ddbbConnection, mainWindow);
			mainWindow.registerController(buttonscontroller, popupcontroller);
			mainWindow.setVisible(true);
			controller.run();
			//Creem la vista temporal de adici�
			AddMusicWindow addView = new AddMusicWindow();
			//addView.setVisible(true);
			
			StatisticsWindow statisticsWindow = new StatisticsWindow();
			//statisticsWindow.setVisible(true);
			
			ddbbConnection.stopConnection();
			
		} catch (DatabaseNotLoadedException e) {
			System.out.println(e.getMessage());
		}
		
		
	}
}
