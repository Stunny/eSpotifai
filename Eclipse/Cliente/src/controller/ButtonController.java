package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import main.Main;
import model.AccessLogic;
import network.ServerCommunication;
import threads.RefreshThread;
import threads.TimeThread;
import view.LoginWindow;
import view.MainWindow;
import view.NewListDialog;
import view.RegisterWindow;
import view.SelectedUserWindow;
import view.UserWindow;
/**
 * Controlador de botons de la vista
 * @author Elna Cabot, Miguel D�az, Marc Mill�n, Alejandro Vogel, Marta Zapatero
 * @version 1.0
 * @see ActionListener
 * @see view.loginWindow
 * @see view.RegisterWindow
 * @see view.MainWindow
 * @see view.SelecteduserWindow
 * @see controller.NetworkController
 * @see model.User
 * 
 *
 */
public class ButtonController implements ActionListener {
	/**
	 * Pantalla de login
	 */
	private LoginWindow loginWindow;
	/**
	 * Pantalla principal
	 * @see view.LoginWindow
	 */
	private MainWindow mainWindow;
	/**
	 * Comunicador amb el servidor
	 * @see view.MainWindow
	 */
	private ServerCommunication serverCommunication;
	/**
	 * Pantalla d'usuari seleccionat
	 * @see network.ServerCommunication
	 */
	private SelectedUserWindow selecteduserwindow;
	/**
	 * Pantalla de registre d'usuari
	 * @see view.SelectedUserWindow
	 */
	private RegisterWindow registerWindow;
	/**
	 * Nom d'usuari
	 * @see model.User
	 */
	private String User; 
	/**
	 * Controlador de xarxa
	 * @see controller.NetworkController
	 */
	private NetworkController networkcontroller;
	private UserWindow userwindow;

	
	private int songIndex = 0;
	
	private NewListDialog NewListDialogDialog;

	/**
	 * Construeix un controlador de botons.
	 * @param loginWindow
	 * @param registerWindow
	 * @param mainWindow
	 * @param selecteduserwindow
	 * @param networkcontroller
	 * @see javax.swing.JButton
	 * @see view.loginWindow
	 * @see view.RegisterWindow
	 * @see view.MainWindow
	 * @see view.SelecteduserWindow
	 * @see controller.NetworkController
	 * 
	 */
	public ButtonController(NewListDialog NewListDialogDialog, LoginWindow loginWindow, RegisterWindow registerWindow, MainWindow mainWindow, SelectedUserWindow selecteduserwindow, NetworkController networkcontroller, UserWindow userwindow){
		this.NewListDialogDialog = NewListDialogDialog;
		this.loginWindow = loginWindow;
		this.mainWindow = mainWindow;
		this.registerWindow= registerWindow;
		this.selecteduserwindow = selecteduserwindow;
		this.networkcontroller = networkcontroller;
		this.userwindow = userwindow;

	}
	/**
	 *  
	 */
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

						ThreadController threadController = new ThreadController(mainWindow);
						Main.refreshThread = new RefreshThread(threadController);
						Main.refreshThread.start();
						Main.timeThread = new TimeThread(threadController);
						Main.timeThread.start();
						Main.wantToLeave = false;

						User = loginWindow.getTypedUsername();
						mainWindow.setUserId(AccessLogic.getId(User, networkcontroller));
						mainWindow.setUser(User);
						String d  = "HOLA";
						mainWindow.refreshListsFollowing(d);
						//System.out.println("User:" + User);
					}
				}
			}
		}

		//PANTALLA ACCEDIR (REGISTRET)
		if(event.getActionCommand().equals("LoginWindow.registerActionCommand")){
			registerWindow.setVisible(true);
			loginWindow.setVisible(false);
		}

		//PANTALLA REGISTRO TIRAR ATRAS
		if(event.getActionCommand().equals("RegisterWindow.atrasActionCommand")){
			loginWindow.setVisible(true);
			registerWindow.setVisible(false);
		}

		
		//New
		if(event.getActionCommand().equals("NewListDialog.createActionCommand")){
			if(networkcontroller.addPlaylist(NewListDialogDialog.getTypedName(), mainWindow.getUserId(), NewListDialogDialog.getPublic()).equals("Add")){
				NewListDialogDialog.setTypedName("");
				JOptionPane.showMessageDialog(null, "Lista creada correctamente", " ", JOptionPane.INFORMATION_MESSAGE);
				NewListDialogDialog.setVisible(false);
			}
			else{
				JOptionPane.showMessageDialog(null, "Ya existe dicha lista", " ", JOptionPane.ERROR_MESSAGE);
			}
		}
		if(event.getActionCommand().equals("NewListDialog.cancelActionCommand")){
			NewListDialogDialog.setTypedName("");		
			NewListDialogDialog.setVisible(false);
		}
		
		
		//PANTALLA registerWindow
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
						User = registerWindow.getTypedUsername();
						ThreadController threadController = new ThreadController(mainWindow);
						Main.refreshThread = new RefreshThread(threadController);
						Main.refreshThread.start();
						Main.timeThread = new TimeThread(threadController);
						Main.timeThread.start();
						Main.wantToLeave = false;
					}
				}
			}
		}

		// MAINWINDOW ( NEW PLAYLIST)
		if(event.getActionCommand().equals("MainWindow.addActionCommand")){

			//NewListDialog NewListDialogDialog = new NewListDialog(); 
			NewListDialogDialog.setVisible(true);
		} 

		//PANTALLA INICIO (USUARI)
		if(event.getActionCommand().equals("MainWindow.profileActionCommand")){
			userwindow.refreshUser(User);
			userwindow.setVisible(true);


		}



		//PANTALLA registerWindowSTRE (CERRAR SESION)
		if(event.getActionCommand().equals("MainWindow.closeActionCommand")){
			mainWindow.setVisible(false);
			loginWindow.setVisible(true);
			Main.refreshThread.interrupt();
			Main.timeThread.interrupt();
			try {
				Main.wantToLeave = true;
				mainWindow.stopPlayer();
				Files.deleteIfExists(Paths.get("Resources/song.mp3"));
			} catch (Exception e) {
				System.out.println(e);
				System.out.println("yoink");
				// TODO Auto-generated catch block
			}
		}

		//PANTALLA MAIN (CERCAR USUARI)
		if(event.getActionCommand().equals("MainWindow.searchActionCommand")){
			if(AccessLogic.searchUser(mainWindow.getTypedSearch(), networkcontroller)){
				selecteduserwindow.refreshUser(mainWindow.getTypedSearch());
				selecteduserwindow.refreshPlaylists(AccessLogic.getPlaylists(mainWindow.getTypedSearch(), networkcontroller.getPlaylists()));
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


		//PANTALLA MAIN (PLAY SONG)
		if(event.getActionCommand().equals("MainWindow.playActionCommand")) {
			//try {
			String response = NetworkController.getSongFile(mainWindow.getSongAtIndex(songIndex));
			if (response.equals("ok")) {
				try {
					mainWindow.goMP3();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}


		//PANTALLA MAIN (NEXT SONG)
		if(event.getActionCommand().equals("MainWindow.nextActionCommand")) {
			//try {
			System.out.println("next");
			if (songIndex < mainWindow.getSongAmount() -1) songIndex++;
			else songIndex = 0;
			System.out.println(songIndex);
			String response = NetworkController.getSongFile(mainWindow.getSongAtIndex(songIndex));
			if (response.equals("ok")) {
				try {
					mainWindow.changeMP3();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

		//PANTALLA MAIN (PREVIOUS SONG)
		if(event.getActionCommand().equals("MainWindow.previousActionCommand")) {
			//try {
			if (songIndex > 0) songIndex--;
			System.out.println(songIndex);
			String response = NetworkController.getSongFile(mainWindow.getSongAtIndex(songIndex));
			if (response.equals("ok")) {
				try {
					mainWindow.changeMP3();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}	


	}

}
