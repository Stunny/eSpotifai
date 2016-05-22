
package main;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import controller.ButtonController;
import controller.NetworkController;
import controller.PopUpController;
import model.AccessLogic;
import controller.MouseActions;
import model.Playlist;
import model.Song;
import model.User;
import threads.RefreshThread;
import threads.TimeThread;
import view.AddList;
import view.LoginWindow;
import view.MainWindow;
import view.ModifyNameList;
import view.NewListDialog;
import view.PlaylistSearchUser;
import view.RegisterWindow;
import view.SelectedUserWindow;
import view.UserWindow;
import view.Vots;
/**
 * 
 * @author Elna Cabot, Miguel D�az, Marc Mill�n, Alejandro Vogel, Marta Zapatero
 * @version 1.0
 * @see AccesLogic
 * @see MouseActions
 * @see Playlist
 * @see Song
 * @see User
 *
 */
public class Main {

	//MAIN DEL CLIENTE

	/**
	 * Main del <i style="color:indigo;">Model</i>.
	 * @param args
	 */

	public static RefreshThread refreshThread;
	public static TimeThread timeThread;
	public static boolean wantToLeave = false;

	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {

				try {
					//Creamos las pantallas
					LoginWindow loginWindow = new LoginWindow();
					RegisterWindow registerWindow = new RegisterWindow();
					MainWindow mainWindow = new MainWindow();
					AddList addlist  = new AddList();
					SelectedUserWindow selecteduserwindow = new SelectedUserWindow();
					NetworkController networkcontroller = new NetworkController();
					Vots vots = new Vots();
					PlaylistSearchUser playlistsearchuser = new PlaylistSearchUser();
					UserWindow userWindow = new UserWindow();

					ModifyNameList modifynamelist = new ModifyNameList();

					NewListDialog NewListDialogDialog = new NewListDialog();
					AccessLogic accesslogic = new AccessLogic();
					PopUpController controller2 = new PopUpController(mainWindow, addlist, vots, selecteduserwindow, playlistsearchuser, userWindow, networkcontroller, modifynamelist);
					ButtonController controller = new ButtonController(NewListDialogDialog, loginWindow, registerWindow, mainWindow, selecteduserwindow, networkcontroller, userWindow, accesslogic);

				


					//Juntamos las pantallas y el controlador
					loginWindow.registerController(controller);
					registerWindow.registerController(controller);
					mainWindow.registerController(controller);
					selecteduserwindow.registerController(controller);
					mainWindow.registerController1(controller2);
					addlist.registerController1(controller2);
					vots.registerController(controller2);
					userWindow.registerController1(controller2);
					selecteduserwindow.registerController1(controller2);
					playlistsearchuser.registerController(controller2);
					modifynamelist.registerController(controller2);

					




					//iniciamos la pantalla de login
					loginWindow.setVisible(true);
					mainWindow.setVisible(false);


				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "There has been a problem.", " ", JOptionPane.ERROR_MESSAGE);
				}


			}
		});
	}
}

