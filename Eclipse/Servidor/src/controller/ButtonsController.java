
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

import model.CustomPlayer;
import network.database.DDBBConnection;
import view.AddMusicWindow;
import view.MainWindow;
import view.StatisticsWindow;

public class ButtonsController implements ActionListener{

	// VISTA
	private MainWindow mainWindow;
	private CustomPlayer p;
	private AddMusicWindow addMusicWindow;
	private int songIndex = 0;

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
			// Recuperem la informaci� que sha escrit a la vista
			// i l'enviem al servidor
			addMusicWindow.setVisible(true);

			// Actualitzem la vista
			//vista.addText(vista.getTypedMessage());
		}
		if (event.getActionCommand().equals("MainWindow.statisticsActionCommand")){
			StatisticsWindow StadisticsView = new StatisticsWindow(ddbbConnection.getSongs());
			StadisticsView.setVisible(true);

		}
		if (event.getActionCommand().equals("MainWindow.playActionCommand")){
			try {
				mainWindow.goMP3(mainWindow.getSongPath(songIndex));
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} 
		if (event.getActionCommand().equals("MainWindow.nextActionCommand")){
			if (songIndex < mainWindow.getSongAmount()-1) songIndex++;
			else songIndex = 0;
			try {
				mainWindow.changeMP3(mainWindow.getSongPath(songIndex));
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		if (event.getActionCommand().equals("MainWindow.previousActionCommand")){

			if (songIndex > 0) songIndex--;
			try {
				mainWindow.changeMP3(mainWindow.getSongPath(songIndex));
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}


		if (event.getActionCommand().equals("AddMusicWindow.acceptActionCommand")){
			String title = addMusicWindow.getTypedSongTitle();
			String genre = addMusicWindow.getTypedGenre();
			String artist = addMusicWindow.getTypedArtist();
			String album = addMusicWindow.getTypedAlbum();
			String path = addMusicWindow.getTypedPath();

			if (title.equals("") || genre.equals("") || artist.equals("") || album.equals("") || path.equals("")) {
				JOptionPane.showMessageDialog(null, "Fill in all gaps.", " ", JOptionPane.ERROR_MESSAGE);
			} else {
				path = path.replace('\\', '/');
				ddbbConnection.addSong(title, genre, artist, album, path, 0);
				//System.out.println("A�adida: "+ title);

				addMusicWindow.setVisible(false);
				addMusicWindow.clearTextFields();
			}
		}

		if (event.getActionCommand().equals("AddMusicWindow.findPathActionCommand")) {

			JFileChooser jFileChooser = new JFileChooser();
			String path = "";
			jFileChooser.setFileFilter(new FileNameExtensionFilter("MP3 files", "mp3"));
			jFileChooser.setCurrentDirectory(new File("./Resources"));
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