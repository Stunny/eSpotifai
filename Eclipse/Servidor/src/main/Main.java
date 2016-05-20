package main;

import provaConfigurationServer.ManagementConfiguration;
import view.AddMusicWindow;
import view.FollowersWindow;
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
			//Creem la DDBB
			ddbbConnection.startConnection();
			ManagementConfiguration mc = new ManagementConfiguration();
			mc.runConfiguration();
			
			// Creem la VISTA
			MainWindow mainWindow = new MainWindow();
			AddMusicWindow addView = new AddMusicWindow();
			
			//Creem el CONTROLADOR
			ButtonsController buttonscontroller = new ButtonsController(mainWindow, ddbbConnection, addView);
			PopUpController popupcontroller = new PopUpController (mainWindow,ddbbConnection);
			GeneralController controller = new GeneralController (ddbbConnection, mainWindow);
			
			addView.registerControllerAdd(buttonscontroller);
			mainWindow.registerController(buttonscontroller, popupcontroller);
			mainWindow.setVisible(true);
			controller.run();
			
			
			/*
			 	StatisticsWindow statisticsWindow = new StatisticsWindow();
			 	statisticsWindow.setVisible(true);
			*/
			
			ddbbConnection.stopConnection();
			
		} catch (DatabaseNotLoadedException e) {
			System.out.println(e.getMessage());
		}
		
		
	}
}
