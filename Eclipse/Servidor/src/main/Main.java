package main;

import view.AddMusicWindow;
import view.FollowersWindow;
import view.MainWindow;
import view.StatisticsWindow;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import controller.ButtonsController;
import controller.GeneralController;
import controller.NetworkController;
import controller.PopUpController;
import customExceptions.DatabaseNotLoadedException;
import database.DDBBConnection;
import model.ManagementConfiguration;
import model.ServerConfiguration;
import network.Server;
import threads.RefreshThread;

public class Main {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					ManagementConfiguration mc = new ManagementConfiguration();
					mc.runConfiguration();
					ServerConfiguration sc = mc.getServerConfiguration();

					DDBBConnection ddbbConnection = new DDBBConnection(sc.getUserBBDD(), sc.getPasswordBBDD(), sc.getNameBBDD(), sc.getPortConexionBBDD());
					ddbbConnection.startConnection();

					// Creem la VISTA

					MainWindow mainWindow = new MainWindow();
					ButtonsController buttonscontroller = new ButtonsController(mainWindow);
					//PopUpController popupcontroller = new PopUpController (mainWindow);
					GeneralController controller = new GeneralController (ddbbConnection, mainWindow);
					
					mainWindow.registerController(buttonscontroller, /*popupcontroller*/null);
					
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
					JOptionPane.showMessageDialog(null, "No s'ha pogut accedir a la base de dades.", " ", JOptionPane.ERROR_MESSAGE);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Hi ha hagut un error.", " ", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

	}
}
