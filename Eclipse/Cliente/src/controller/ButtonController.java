package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JOptionPane;

import model.AccessLogic;
import network.ServerCommunication;
import view.LoginWindow;
import view.MainWindow;
import view.NewListDialog;
import view.RegisterWindow;
import view.SelectedUserWindow;
import view.UserWindow;

public class ButtonController implements ActionListener {
	private LoginWindow loginWindow;
	private MainWindow mainWindow;
	private ServerCommunication serverCommunication;
	private SelectedUserWindow selecteduserwindow;
	private RegisterWindow registerWindow;

	
	public ButtonController(LoginWindow loginWindow, RegisterWindow registerWindow, MainWindow mainWindow, SelectedUserWindow selecteduserwindow){
		
		this.loginWindow = loginWindow;
		this.mainWindow = mainWindow;
		this.registerWindow= registerWindow;
		this.selecteduserwindow = selecteduserwindow;
	}
	
	public void actionPerformed(ActionEvent event){
		
		//PANTALLA ACCEDIR (ACCEDIR)
		if (event.getActionCommand().equals("LoginWindow.loginActionCommand")){
			if (loginWindow.getTypedUsername().equals("") || loginWindow.getTypedPassword().equals("")) {
				JOptionPane.showMessageDialog(null, "Please fill in all the blanks.", " ", JOptionPane.ERROR_MESSAGE);
			} else {
				if (loginWindow.getTypedPassword().contains("/") || loginWindow.getTypedUsername().contains("/")) {
					JOptionPane.showMessageDialog(null, "'/' is an invalid character.", " ", JOptionPane.ERROR_MESSAGE);
				} else {
					if (AccessLogic.Login(loginWindow.getTypedUsername(), loginWindow.getTypedPassword())) {
						mainWindow.setVisible(true);
						loginWindow.setVisible(false);
					}
				}
			}
		}

			//PANTALLA ACCEDIR (REGISTRET)
		if(event.getActionCommand().equals("LoginWindow.registerActionCommand")){
			registerWindow.setVisible(true);
			loginWindow.setVisible(false);
		}
		
		//PANTALLA REGISTRO TIRAR ATRÁS
		if(event.getActionCommand().equals("RegisterWindow.atrasActionCommand")){
			loginWindow.setVisible(true);
			registerWindow.setVisible(false);
		}
		
		//PANTALLA registerWindowSTRE
		if(event.getActionCommand().equals("registerWindowSTRE")){
			
			if (AccessLogic.Register(registerWindow.getTypedUsername(), registerWindow.getTypedPassword())) {
				mainWindow.setVisible(true);
				registerWindow.setVisible(false);

			}
		}
		
		
		
		//PANTALLA ACCEDIR
		if(event.getActionCommand().equals("LoginWindow.registerActionCommand")){
			registerWindow.setVisible(true);
			loginWindow.setVisible(false);
		}
		
		
		//PANTALLA registerWindowSTRE
		if(event.getActionCommand().equals("RegisterWindow.registerActionCommand")){

			if (registerWindow.getTypedUsername().equals("") || registerWindow.getTypedPassword().equals("")) {
				JOptionPane.showMessageDialog(null, "Please fill in all the blanks.", " ", JOptionPane.ERROR_MESSAGE);
			} else {
				if (registerWindow.getTypedPassword().contains("/") || registerWindow.getTypedUsername().contains("/")) {
					JOptionPane.showMessageDialog(null, "'/' is an invalid character.", " ", JOptionPane.ERROR_MESSAGE);
				} else {
					if (AccessLogic.Register(registerWindow.getTypedUsername(), registerWindow.getTypedPassword())) {
						mainWindow.setVisible(true);
						registerWindow.setVisible(false);
					}
				}
			}
		}
		
		// MAINWINDOW ( NEW PLAYLIST)
		if(event.getActionCommand().equals("MainWindow.addActionCommand")){

			NewListDialog NewListDialogDialog = new NewListDialog(); 
			NewListDialogDialog.setVisible(true);
		} 
		
		//PANTALLA INICIO (USUARI)
		if(event.getActionCommand().equals("MainWindow.profileActionCommand")){
			UserWindow userWindow = new UserWindow(); 
			userWindow.setVisible(true);
		}
		
		

		//PANTALLA registerWindowSTRE (CERRAR SESION)
		if(event.getActionCommand().equals("MainWindow.closeActionCommand")){
			mainWindow.setVisible(false);
			loginWindow.setVisible(true);
			
		}
		
		//PANTALLA MAIN (CERCAR USUARI)
		if(event.getActionCommand().equals("MainWindow.searchActionCommand")){
			if(AccessLogic.searchUser(mainWindow.getTypedSearch())){
				selecteduserwindow.refreshUser(mainWindow.getTypedSearch());
				selecteduserwindow.setVisible(true);
				
			}
		}
		
		//PANTALLA SEARCH USUARIO
		if(event.getActionCommand().equals("FOLLOW")){
			String p = "Following";
			selecteduserwindow.refreshFollowing(p);
		}
		
		//PANTALLA SEARCH USUARI
		if(event.getActionCommand().equals("UNFOLLOW")){
			String s = new String();
			s = "Unfollow";
			selecteduserwindow.refreshFollowing(s);
		}
		
		
		
		
		
		
	}
	
}
