package model.main;

import java.util.LinkedList;

import view.AddMusicWindow;
import view.MainWindow;
import view.StatisticsWindow;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import controller.ButtonsController;
import controller.GeneralController;
import controller.NetworkController;
import controller.PopUpController;
import controller.threads.RefreshThread;
import controller.threads.TimeThread;
import model.ManagementConfiguration;
import model.ServerConfiguration;
import model.Song;
import model.customExceptions.DatabaseNotLoadedException;
import network.FileServer;
import network.Server;
import network.database.DDBBConnection;

public class Main {

	//MAIN DEL SERVIDOR

	private static FileServer fileServer;

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
					LinkedList<Song> song = ddbbConnection.getPlaylistSongs(1);

					// Creem la VISTA
					AddMusicWindow addView = new AddMusicWindow();
					MainWindow mainWindow = new MainWindow();
					ButtonsController buttonscontroller = new ButtonsController(mainWindow, ddbbConnection, addView);
					PopUpController popupcontroller = new PopUpController (mainWindow, ddbbConnection);
					//MouseController mouseController = new MouseController(mainWindow, ddbbConnection);
					GeneralController controller = new GeneralController (ddbbConnection, mainWindow);

					mainWindow.registerController(buttonscontroller, popupcontroller);
					addView.registerControllerAdd(buttonscontroller);
					mainWindow.setVisible(true);



					//StatisticsWindow statisticsWindow = new StatisticsWindow();

					(new RefreshThread(controller)).start();
					(new TimeThread(controller)).start();
					Server server = new Server(new NetworkController(ddbbConnection));
					server.startServer();
					fileServer = new FileServer();
					fileServer.startServer();




				} catch (DatabaseNotLoadedException e) {
					JOptionPane.showMessageDialog(null, "Couldn't reach database.", " ", JOptionPane.ERROR_MESSAGE);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "There's been an error.", " ", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

	public static void setFilePath(String path) {
		//System.out.println(path);
		fileServer.setFilePath(path);
	}
}
