package provaConfigurationServer;

import controller.ButtonsController;
import view.AddMusicWindow;
import view.MainWindow;;

public class Main {
	
	public static void main(String[] args ){
		ManagementConfiguration mc = new ManagementConfiguration();
		mc.runConfiguration();
		
		// Creem la VISTA
		MainWindow mainView = new MainWindow();
		mainView.setVisible(true);
		
		// Establim la relacio CONTROLADOR->VISTA
		ButtonsController controller = new ButtonsController(mainView);
		// Establim la "relacio" VISTA->CONTROLADOR
		mainView.registerController(controller);
		controller.run();
		
		/*
		//Creem la vista temporal de adició
		ManagementMusicAddView addView = new ManagementMusicAddView();
		addView.setVisible(true);
		*/
	}
}
