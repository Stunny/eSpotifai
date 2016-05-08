package model;

import javax.swing.SwingUtilities;

import controller.ButtonController;
import view.LoginWindow;
import view.MainWindow;
import view.RegisterWindow;
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
				
				//Creamos el ontrolador
				ButtonController controller = new ButtonController(loginWindow, registerWindow, mainWindow);
				
				//Juntamos las pantallas y el controlador
				loginWindow.registerController(controller);
				registerWindow.registerController(controller);
				mainWindow.registerController(controller);
				
				//iniciamos la pantalla de login
				loginWindow.setVisible(true);
				
			
			}
		});
	}
}
