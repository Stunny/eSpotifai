
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;

//import model.DDBBConnection;
import database.DDBBConnection;
import view.AddMusicWindow;
import view.MainWindow;
import view.StatisticsWindow;

public class ButtonsController implements ActionListener{

	// VISTA
	private MainWindow main;
	private AddMusicWindow music;
	
	// NETWORK
	//private InformationService infoService;
	
	//Modelo 
	private DDBBConnection model;

	public ButtonsController(MainWindow view, DDBBConnection model,  AddMusicWindow music) {
		this.main = view;
		this.model = model;
		this.music = music;
		// Instanciem la classe per poder enviar missatges.
		// Passem una referencia a lobjecte per si cal notificar alguna informacio.
		// Aquest tambe podria ser creat des del prinicpal.	
		//this.infoService = new InformationService(this);
	}

	public void actionPerformed(ActionEvent event) {
		System.out.println(event.getActionCommand());
		if (event.getActionCommand().equals("MainWindow.addActionCommand")) {
			// Recuperem la informaci� que sha escrit a la vista
			// i l'enviem al servidor
			
			//Creem la vista temporal de adici�
			music.setVisible(true);
			
			// Actualitzem la vista
			//vista.addText(vista.getTypedMessage());
		}else if (event.getActionCommand().equals("MainWindow.statisticsActionCommand")){
			StatisticsWindow StadisticsView = new StatisticsWindow();
			StadisticsView.setVisible(true);

		}else if (event.getActionCommand().equals("MainWindow.playActionCommand")){
			
			try {
				main.goMP3();
				//mainWindow.goMP3();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if (event.getActionCommand().equals("RIGHTSONG")){
			StatisticsWindow StadisticsView = new StatisticsWindow();
			StadisticsView.setVisible(true);
			
		}else if (event.getActionCommand().equals("LEFTSONG")){
			
			StatisticsWindow StadisticsView = new StatisticsWindow();
			StadisticsView.setVisible(true);
		}
		if (event.getActionCommand().equals("AddMusicWindow.acceptActionCommand")){
			model.addSong(music.getTypedSongTitle(), music.getTypedGenre(), music.getTypedArtist(),
					music.getTypedAlbum(), music.getTypedPath(), 0);
			System.out.println("A�adida: "+music.getTypedSongTitle());
		}
	}
}

