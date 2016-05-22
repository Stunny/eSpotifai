
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.net.MalformedURLException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import database.DDBBConnection;
import model.CustomPlayer;
import view.AddMusicWindow;
import view.MainWindow;
import view.StatisticsWindow;

public class ButtonsController implements ActionListener{

	// VISTA
	private MainWindow mainWindow;
	private CustomPlayer p;
	private AddMusicWindow addMusicWindow;
	
	// NETWORK
	//private InformationService infoService;
	private DDBBConnection ddbbConnection;

	public ButtonsController(MainWindow mainWindow, DDBBConnection ddbbConnection, AddMusicWindow addMusicWindow) {
		this.mainWindow = mainWindow;
		this.ddbbConnection = ddbbConnection;
		this.addMusicWindow = addMusicWindow;
		// Instanciem la classe per poder enviar missatges.
		// Passem una referencia a lobjecte per si cal notificar alguna informacio.
		// Aquest tambe podria ser creat des del prinicpal.	
		//this.infoService = new InformationService(this);
	}

	public void actionPerformed(ActionEvent event) {
		
		if (event.getActionCommand().equals("MainWindow.addActionCommand")) {
			// Recuperem la informació que sha escrit a la vista
			// i l'enviem al servidor
			addMusicWindow.setVisible(true);
			
			// Actualitzem la vista
			//vista.addText(vista.getTypedMessage());
		}else if (event.getActionCommand().equals("MainWindow.statisticsActionCommand")){
			StatisticsWindow StadisticsView = new StatisticsWindow(ddbbConnection.getSongs());
			StadisticsView.setVisible(true);

		}else if (event.getActionCommand().equals("MainWindow.playActionCommand")){
			
			try {
				mainWindow.goMP3();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else if (event.getActionCommand().equals("RIGHTSONG")){
			//StatisticsWindow StadisticsView = new StatisticsWindow();
			//StadisticsView.setVisible(true);
			
		} else if (event.getActionCommand().equals("LEFTSONG")){
			
			//StatisticsWindow StadisticsView = new StatisticsWindow();
			//StadisticsView.setVisible(true);
		}
		else if (event.getActionCommand().equals("AddMusicWindow.acceptActionCommand")){
			String title = addMusicWindow.getTypedSongTitle();
			String genre = addMusicWindow.getTypedGenre();
			String artist = addMusicWindow.getTypedArtist();
			String album = addMusicWindow.getTypedAlbum();
			String path = addMusicWindow.getTypedPath();

			if (title.equals("") || genre.equals("") || artist.equals("") || album.equals("") || path.equals("")) {
				JOptionPane.showMessageDialog(null, "Rellena todos los campos.", " ", JOptionPane.ERROR_MESSAGE);
			} else {
				path = path.replace('\\', '/');
				ddbbConnection.addSong(title, genre, artist, album, path, 0);
				System.out.println("Añadida: "+ title);

				addMusicWindow.setVisible(false);
				addMusicWindow.clearTextFields();
			}
		}
		
		else if (event.getActionCommand().equals("AddMusicWindow.findPathActionCommand")) {

			JFileChooser jFileChooser = new JFileChooser();
			String path = "";
			jFileChooser.setFileFilter(new FileNameExtensionFilter("MP3 files", "mp3"));
			if (jFileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				path = jFileChooser.getSelectedFile().getAbsolutePath();
			}
			addMusicWindow.setFoundPath(path);
			
		}
	}

	public void run(){
		while (true){
			mainWindow.refreshTime();
		}
	}
}