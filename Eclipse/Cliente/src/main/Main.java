
package main;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import controller.ButtonController;
import controller.NetworkController;
import controller.PopUpController;
import model.User;
import threads.RefreshThread;
import view.AddList;
import view.LoginWindow;
import view.MainWindow;
import view.NewListDialog;
import view.RegisterWindow;
import view.SelectedUserWindow;
import view.UserWindow;

public class Main {
	
	//MAIN DEL CLIENTE
	
	public static RefreshThread refreshThread;
	
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				
				try {
				//Creamos las pantallas
				LoginWindow loginWindow = new LoginWindow();
				RegisterWindow registerWindow = new RegisterWindow();
				MainWindow mainWindow = new MainWindow();
				//UserWindow userWindow = new UserWindow();
				AddList addlist  = new AddList();
				SelectedUserWindow selecteduserwindow = new SelectedUserWindow();
				NetworkController networkcontroller = new NetworkController();
				//nwc.getUserList();
				//nwc.getSongList();
				
				//Creamos el controlador
				ButtonController controller = new ButtonController(loginWindow, registerWindow, mainWindow, selecteduserwindow, networkcontroller);
				PopUpController controller2 = new PopUpController(mainWindow, addlist);
				
				//Juntamos las pantallas y el controlador
				loginWindow.registerController(controller);
				registerWindow.registerController(controller);
				mainWindow.registerController(controller);
				selecteduserwindow.registerController(controller);
				mainWindow.registerController1(controller2);
				addlist.registerController1(controller2);
				
				
				//iniciamos la pantalla de login
				loginWindow.setVisible(true);
				mainWindow.setVisible(false);
				
				

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Hi ha hagut un problema.", " ", JOptionPane.ERROR_MESSAGE);
				}
				
			
			}
		});
	}
}

