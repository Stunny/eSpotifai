package provaConfigurationServer;

import java.util.Scanner;

import view.AddMusicWindow;
import view.MainWindow;

public class Main {
	
	public static void main(String[] args ){
		
		ManagementConfiguration mc = new ManagementConfiguration();
		mc.runConfiguration();
		
		// Creem la VISTA
		MainWindow mainWindow = new MainWindow();
		mainWindow.setVisible(true);
		
	
		
		//Creem la vista temporal de adició
		AddMusicWindow addView = new AddMusicWindow();
		addView.setVisible(true);
		
	}
	
}
