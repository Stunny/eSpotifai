package main;

import provaConfigurationServer.ManagementConfiguration;
import provaConfigurationServer.ServerConfiguration;
import view.AddMusicWindow;
import view.MainWindow;
import view.StatisticsWindow;

import javax.swing.SwingUtilities;

import controller.ButtonsController;
import controller.GeneralController;
import controller.NetworkController;
import customExceptions.DatabaseNotLoadedException;
import model.DDBBConnection;
import controller.RefreshThread;
import network.Server;

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
			
		
		
		ManagementConfiguration mc = new ManagementConfiguration();
		mc.runConfiguration();
		ServerConfiguration sc = mc.getServerConfiguration();
		
		DDBBConnection ddbbConnection = new DDBBConnection(sc.getUserBBDD(), sc.getPasswordBBDD(), sc.getNameBBDD(), sc.getPortConexionBBDD());
		
		try {
			
			ddbbConnection.startConnection();
			
			
			// Creem la VISTA
			
			MainWindow mainWindow = new MainWindow();
			ButtonsController buttonscontroller = new ButtonsController(mainWindow);
			GeneralController controller = new GeneralController (ddbbConnection, mainWindow);
			mainWindow.registerController(buttonscontroller);
			mainWindow.setVisible(true);
			
			//Creem la vista temporal de adició
			AddMusicWindow addView = new AddMusicWindow();
			//addView.setVisible(true);
			
			StatisticsWindow statisticsWindow = new StatisticsWindow();
			//statisticsWindow.setVisible(true);
			
			(new RefreshThread(controller)).start();
			//controller.run();
			Server server = new Server(new NetworkController(ddbbConnection));
			server.startServer();
			
			
			//ddbbConnection.stopConnection();
			
			
		} catch (DatabaseNotLoadedException e) {
			System.out.println(e.getMessage());
		}
			}
		});
		
	}
}
