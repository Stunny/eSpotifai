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
	private RegisterWindow registerWindowsterWindow;
	private ServerCommunication serverCommunication;
	private SelectedUserWindow selecteduserwindow;
	
	public ButtonController(LoginWindow loginWindow, RegisterWindow registerWindowsterWindow, MainWindow mainWindow, SelectedUserWindow selecteduserwindow){
		this.loginWindow = loginWindow;
		this.mainWindow = mainWindow;
		this.registerWindowsterWindow= registerWindowsterWindow;
		this.serverCommunication = new ServerCommunication();
		this.selecteduserwindow = selecteduserwindow;
	}
	
	public void actionPerformed(ActionEvent event){

		

		//PANTALLA ACCEDIR (ACCEDIR)
		if (event.getActionCommand().equals("LoginWindow.loginActionCommand")){
			
			if (AccessLogic.Login(loginWindow.getTypedUsername(), loginWindow.getTypedPassword())) {
				mainWindow.setVisible(true);
				loginWindow.setVisible(false);
			}
		}

			//PANTALLA ACCEDIR (REGISTRET)
		if(event.getActionCommand().equals("LoginWindow.registerActionCommand")){
			registerWindowsterWindow.setVisible(true);
			loginWindow.setVisible(false);
		}
		
		//PANTALLA registerWindowSTRE
		if(event.getActionCommand().equals("registerWindowSTRE")){
			
			if (AccessLogic.Register(registerWindowsterWindow.getTypedUsername(), registerWindowsterWindow.getTypedPassword())) {
				mainWindow.setVisible(true);
				registerWindowsterWindow.setVisible(false);

			}
		}
		
		
		
		//PANTALLA ACCEDIR
		if(event.getActionCommand().equals("LoginWindow.registerWindowsterActionCommand")){
			registerWindowsterWindow.setVisible(true);
			loginWindow.setVisible(false);
		}
		
		
		//PANTALLA registerWindowSTRE
		if(event.getActionCommand().equals("registerWindowsterWindow.registerWindowsterActionCommand")){
			
			if (AccessLogic.Register(registerWindowsterWindow.getTypedUsername(), registerWindowsterWindow.getTypedPassword())) {
				mainWindow.setVisible(true);
				registerWindowsterWindow.setVisible(false);

			}
			
		}
		
		// MAINWINDOW ( NEW PLAYLIST)
		if(event.getActionCommand().equals("MainWindow.addActionCommand")){

			NewListDialog NewListDialogDialog = new NewListDialog(); 
			NewListDialogDialog.setVisible(true);
			
			String resposta = serverCommunication.sendData("Prova");
			JOptionPane.showMessageDialog(NewListDialogDialog, this, resposta, 0, null);
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
		
		if(event.getActionCommand().equals("FOLLOW")){
			String p = "Following";
			selecteduserwindow.refreshFollowing(p);
		}
		
		if(event.getActionCommand().equals("UNFOLLOW")){
			String s = new String();
			s = "Unfollow";
			selecteduserwindow.refreshFollowing(s);
		}
		
		
		
		
	}
	
}
