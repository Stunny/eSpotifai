
package model;

import javax.swing.SwingUtilities;

import controller.ButtonController;
import view.LoginWindow;
import view.MainWindow;
import view.RegisterWindow;
import view.SelectedUserWindow;
import view.UserWindow;

public class Main {
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				
				//Creamos las pantallas
				LoginWindow loginWindow = new LoginWindow();
				RegisterWindow registerWindow = new RegisterWindow();
				MainWindow mainWindow = new MainWindow();
				UserWindow userWindow = new UserWindow();
				SelectedUserWindow selecteduserwindow = new SelectedUserWindow();
				
				//Creamos el controlador
				ButtonController controller = new ButtonController(loginWindow, registerWindow, mainWindow, selecteduserwindow);
				
				//Juntamos las pantallas y el controlador
				loginWindow.registerController(controller);
				registerWindow.registerController(controller);
				mainWindow.registerController(controller);
				selecteduserwindow.registerController(controller);
				
				//iniciamos la pantalla de login
				loginWindow.setVisible(true);
				mainWindow.setVisible(false);

			
				
			
			}
		});
	}
}

