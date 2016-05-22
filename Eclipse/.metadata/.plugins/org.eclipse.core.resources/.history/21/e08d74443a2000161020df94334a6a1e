package main;

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
import customExceptions.DatabaseNotLoadedException;
import database.DDBBConnection;
import model.ManagementConfiguration;
import model.ServerConfiguration;
import model.Song;
import network.Server;
import threads.RefreshThread;
import threads.TimeThread;
/**
 * Classe principal de l'aplicació del servidor.
 * @author Elna Cabot, Miguel Díaz, Marc Millán, Alejandro Vogel, Marta Zapatero
 * @version 1.0
 * 
 *
 */
public class Main {
	
	//MAIN DEL SERVIDOR
	/**
	 * Métode principal del servidor des del qual s'instancien les classes necessaries per fer funcionar aquesta versió de l'aplicació.
	 * @param args
	 */
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
					GeneralController controller = new GeneralController (ddbbConnection, mainWindow);
					
					mainWindow.registerController(buttonscontroller, popupcontroller);
					addView.registerControllerAdd(buttonscontroller);
					mainWindow.setVisible(true);


					StatisticsWindow statisticsWindow = new StatisticsWindow();

					(new RefreshThread(controller)).start();
					(new TimeThread(controller)).start();
					Server server = new Server(new NetworkController(ddbbConnection));
					server.startServer();

					



				} catch (DatabaseNotLoadedException e) {
					JOptionPane.showMessageDialog(null, "No s'ha pogut accedir a la base de dades.", " ", JOptionPane.ERROR_MESSAGE);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Hi ha hagut un error.", " ", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
}
