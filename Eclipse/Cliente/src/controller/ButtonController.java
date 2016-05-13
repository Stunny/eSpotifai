package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.AccessLogic;
import network.ServerCommunication;
import view.LoginWindow;
import view.MainWindow;
import view.NewListDialog;
import view.OK;
import view.RegisterWindow;
import view.UserWindow;

public class ButtonController implements ActionListener {
	private LoginWindow loginWindow;
	private MainWindow mainWindow;
	private RegisterWindow registerWindow;
	private ServerCommunication serverCommunication;
	
	public ButtonController(LoginWindow loginWindow, RegisterWindow registerWindow, MainWindow mainWindow){
		this.loginWindow = loginWindow;
		this.mainWindow = mainWindow;
		this.registerWindow = registerWindow;
		this.serverCommunication = new ServerCommunication();
	}
	
	public void actionPerformed(ActionEvent event){

		//PANTALLA ACCEDIR
		if (event.getActionCommand().equals("LoginWindow.loginActionCommand")){
			
			if (AccessLogic.Login(loginWindow.getTypedUsername(), loginWindow.getTypedPassword())) {
				mainWindow.setVisible(true);
				loginWindow.setVisible(false);
			}
			
			
		}
		
		//PANTALLA ACCEDIR
		if(event.getActionCommand().equals("LoginWindow.registerActionCommand")){
			registerWindow.setVisible(true);
			loginWindow.setVisible(false);
		}
		
		
		//PANTALLA REGISTRE
		if(event.getActionCommand().equals("RegisterWindow.registerActionCommand")){
			
			if (AccessLogic.Register(registerWindow.getTypedUsername(), registerWindow.getTypedPassword())) {
				mainWindow.setVisible(true);
				registerWindow.setVisible(false);
			}
			
		}
		
		 	//PANTALLA INICI
		if(event.getActionCommand().equals("MainWindow.addActionCommand")){

			NewListDialog newListDialog = new NewListDialog(); 
			newListDialog.setVisible(true);
			
			String resposta = serverCommunication.sendData("Prova");
			JOptionPane.showMessageDialog(newListDialog, this, resposta, 0, null);
		} 
			//PANTALLA INICIO
		if(event.getActionCommand().equals("MainWindow.profileActionCommand")){
			UserWindow userWindow = new UserWindow(); 
			userWindow.setVisible(true);
			
		}
		
		// PANTALLA INICI
		if(event.getActionCommand().equals("MainWindow.closeActionCommand")){
			mainWindow.setVisible(false);
			loginWindow.setVisible(true);
			
		}
		
		
		
	}
}
