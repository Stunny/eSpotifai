package view;


import provaConfigurationServer.Mp3;
import provaConfigurationServer.Player;

import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.ButtonsController;

public class MainWindow extends JFrame{

	private Player player;

	private JTabbedPane jtpPestanyas;
	private JPanel jpPanellMusic;
	private JPanel jpPanellUsers;
	private JPanel jpPanellMusicButtonsPlayer;
	private JPanel jpPanellButtons;
	private JPanel jpPanellPlay;
	private JPanel jpPanellOnlyButtons;
	private JPanel jpSong;

	private GridLayout glPanellButtons;
	private GridLayout glPanellOnlyButtons;
	private GridLayout glPanellMusicButtonsPlayer;
	private GridLayout glSong;
	private BorderLayout blPanellMusic;
	private BorderLayout blPanellPlay;

	//private JTextArea jtListOfSongs;
	private JScrollPane jspListOfSongs;
	private JSlider jSlider1;

	private JButton jbAdd;
	private JButton jbEstadistics;
	private JButton playButton;
	private JButton rightButton;
	private JButton leftButton;

	private ImageIcon leftbutton1;
	private ImageIcon leftbutton2;
	private ImageIcon leftbutton3;

	private ImageIcon playbutton1;
	private ImageIcon playbutton2;
	private ImageIcon playbutton3;

	private ImageIcon pausebutton1;
	private ImageIcon pausebutton2;
	private ImageIcon pausebutton3;

	private ImageIcon rightbutton1;
	private ImageIcon rightbutton2;
	private ImageIcon rightbutton3;

	//private JLabel jlTemporalSong;
	private JLabel jlTime;
	//private JLabel SongState;
	private JLabel NameSong;

	private JLabel NameStateSong;

	//private ImageIcon temporalSong;
	private boolean stateSong = false;
	private String state = "";
	private String statePlayer = "";
	private int max = 0, value = 0;

	//Mp3 pistaMp3 = new Mp3();

	public MainWindow() {

		//Creem el conjunt de pestanyes
		jtpPestanyas = new JTabbedPane();

		//Creem el panell per montar l'estructura de l'apartat "Music"
		jpPanellMusic = new JPanel();

		//Estructura de panell de tipus BorderLayout
		blPanellMusic = new BorderLayout();
		jpPanellMusic.setLayout(blPanellMusic);


		//Creo el panell Scroll de la llista de cançons
		//table
		//hardcodeo de columnas y datos 
		String[] columnNamessongs = {"Name", "Genre", "Album", "Artist"};
		Object[][] datasongs = {{"El tractor amarillo", "Pop", "Zapato Veloz", "Manuel Calderon"},{"Cantando", "Rap", "Vivir para contarlo", "Kase O"},{"Ballantines", "Rap", "Vicios y Virtudes", "Kase O"},{"Set Me Free", "Electro House", "The Remixes Part 1", "Martin Garrix"},{"Ballantines", "Rap", "Vicios y Virtudes", "Kase O"},{"Set Me Free", "Electro House", "The Remixes Part 1", "Martin Garrix"},{"Ballantines", "Rap", "Vicios y Virtudes", "Kase O"},{"Set Me Free", "Electro House", "The Remixes Part 1", "Martin Garrix"},{"Ballantines", "Rap", "Vicios y Virtudes", "Kase O"},{"Set Me Free", "Electro House", "The Remixes Part 1", "Martin Garrix"},{"Ballantines", "Rap", "Vicios y Virtudes", "Kase O"},{"Set Me Free", "Electro House", "The Remixes Part 1", "Martin Garrix"},{"Ballantines", "Rap", "Vicios y Virtudes", "Kase O"},{"Set Me Free", "Electro House", "The Remixes Part 1", "Martin Garrix"},{"Ballantines", "Rap", "Vicios y Virtudes", "Kase O"},{"Set Me Free", "Electro House", "The Remixes Part 1", "Martin Garrix"},{"Ballantines", "Rap", "Vicios y Virtudes", "Kase O"},{"Set Me Free", "Electro House", "The Remixes Part 1", "Martin Garrix"},{"Ballantines", "Rap", "Vicios y Virtudes", "Kase O"},{"Set Me Free", "Electro House", "The Remixes Part 1", "Martin Garrix"},{"Ballantines", "Rap", "Vicios y Virtudes", "Kase O"},{"Set Me Free", "Electro House", "The Remixes Part 1", "Martin Garrix"},{"Ballantines", "Rap", "Vicios y Virtudes", "Kase O"},{"Set Me Free", "Electro House", "The Remixes Part 1", "Martin Garrix"},{"Ballantines", "Rap", "Vicios y Virtudes", "Kase O"},{"Set Me Free", "Electro House", "The Remixes Part 1", "Martin Garrix"},{"Ballantines", "Rap", "Vicios y Virtudes", "Kase O"},{"Set Me Free", "Electro House", "The Remixes Part 1", "Martin Garrix"},{"Ballantines", "Rap", "Vicios y Virtudes", "Kase O"},{"Set Me Free", "Electro House", "The Remixes Part 1", "Martin Garrix"},{"Ballantines", "Rap", "Vicios y Virtudes", "Kase O"},{"Set Me Free", "Electro House", "The Remixes Part 1", "Martin Garrix"},{"Ballantines", "Rap", "Vicios y Virtudes", "Kase O"},{"Set Me Free", "Electro House", "The Remixes Part 1", "Martin Garrix"},{"Ballantines", "Rap", "Vicios y Virtudes", "Kase O"},{"Set Me Free", "Electro House", "The Remixes Part 1", "Martin Garrix"},{"Ballantines", "Rap", "Vicios y Virtudes", "Kase O"},{"Set Me Free", "Electro House", "The Remixes Part 1", "Martin Garrix"},{"Ballantines", "Rap", "Vicios y Virtudes", "Kase O"},{"Set Me Free", "Electro House", "The Remixes Part 1", "Martin Garrix"},{"Ballantines", "Rap", "Vicios y Virtudes", "Kase O"},{"Set Me Free", "Electro House", "The Remixes Part 1", "Martin Garrix"},{"Ballantines", "Rap", "Vicios y Virtudes", "Kase O"},{"Set Me Free", "Electro House", "The Remixes Part 1", "Martin Garrix"},{"Ballantines", "Rap", "Vicios y Virtudes", "Kase O"},{"Set Me Free", "Electro House", "The Remixes Part 1", "Martin Garrix"},{"Ballantines", "Rap", "Vicios y Virtudes", "Kase O"},{"Set Me Free", "Electro House", "The Remixes Part 1", "Martin Garrix"},{"Ballantines", "Rap", "Vicios y Virtudes", "Kase O"},{"Set Me Free", "Electro House", "The Remixes Part 1", "Martin Garrix"},{"Ballantines", "Rap", "Vicios y Virtudes", "Kase O"},{"Set Me Free", "Electro House", "The Remixes Part 1", "Martin Garrix"},{"Ballantines", "Rap", "Vicios y Virtudes", "Kase O"},{"Set Me Free", "Electro House", "The Remixes Part 1", "Martin Garrix"},{"Ballantines", "Rap", "Vicios y Virtudes", "Kase O"},{"Set Me Free", "Electro House", "The Remixes Part 1", "Martin Garrix"},{"Ballantines", "Rap", "Vicios y Virtudes", "Kase O"},{"Set Me Free", "Electro House", "The Remixes Part 1", "Martin Garrix"},{"Ballantines", "Rap", "Vicios y Virtudes", "Kase O"},{"Set Me Free", "Electro House", "The Remixes Part 1", "Martin Garrix"},{"Ballantines", "Rap", "Vicios y Virtudes", "Kase O"},{"Set Me Free", "Electro House", "The Remixes Part 1", "Martin Garrix"},{"Ballantines", "Rap", "Vicios y Virtudes", "Kase O"},{"Set Me Free", "Electro House", "The Remixes Part 1", "Martin Garrix"},{"Ballantines", "Rap", "Vicios y Virtudes", "Kase O"},{"Set Me Free", "Electro House", "The Remixes Part 1", "Martin Garrix"},{"Ballantines", "Rap", "Vicios y Virtudes", "Kase O"},{"Set Me Free", "Electro House", "The Remixes Part 1", "Martin Garrix"},{"Ballantines", "Rap", "Vicios y Virtudes", "Kase O"},{"Set Me Free", "Electro House", "The Remixes Part 1", "Martin Garrix"},{"Ballantines", "Rap", "Vicios y Virtudes", "Kase O"},{"Set Me Free", "Electro House", "The Remixes Part 1", "Martin Garrix"}};
		//se crea la tabla
		JTable songstable = new JTable(datasongs, columnNamessongs);

		//se hace que los datos no sean editables
		DefaultTableModel tableModelsongs = new DefaultTableModel(datasongs, columnNamessongs) {
			@Override
			public boolean isCellEditable(int row, int column) {
				//all cells false
				return false;
			}
		}; 
		songstable.setModel(tableModelsongs);
		songstable.setForeground(Color.BLACK);
		//songstable.setBackground(Color.DARK_GRAY);
		Color myColor = Color.getHSBColor(0.51F,  0.93F,  0.5F);          
		songstable.setBackground(myColor);

		//Li assigno a aquesta area de text que pugui fer scroll
		//jspListOfSongs = new JScrollPane(jtListOfSongs);
		jspListOfSongs = new JScrollPane(songstable);

		//Asigno un titul al apartat de la llista de cançons
		jspListOfSongs.setBorder(BorderFactory.createTitledBorder("Llist of songs"));

		//Introdueixo aquest apartat/Panell a la primera fila del panell
		jpPanellMusic.add(jspListOfSongs, BorderLayout.CENTER);

		//Creem el subpanell per montar l'estructura del apartat "butons  - ADD i estadistiques - i el reproductor "
		jpPanellMusicButtonsPlayer = new JPanel();
		jpPanellMusicButtonsPlayer.setPreferredSize(new Dimension(400,90));			

		//Estructura de panell de 2 files per 1 columna
		glPanellMusicButtonsPlayer = new GridLayout(2,1);
		jpPanellMusicButtonsPlayer.setLayout(glPanellMusicButtonsPlayer);

		//Estructura de subsubpanell només de botons
		jpPanellButtons = new JPanel();
		glPanellButtons = new GridLayout(1,2);
		jpPanellButtons.setLayout(glPanellButtons);	


		//Creo botó de afegir canço "Add"
		jbAdd = new JButton("Add");
		jbAdd.setHorizontalAlignment(JButton.CENTER);
		jpPanellButtons.add(jbAdd);

		//Creo botó per veure les estadistiques de les millors cançons "Top 10 songs"
		jbEstadistics = new JButton("Top 10 songs");
		jbEstadistics.setHorizontalAlignment(JButton.CENTER);
		jpPanellButtons.add(jbEstadistics);

		jpPanellMusicButtonsPlayer.add(jpPanellButtons);

		/*
		 * AQUI S'HA DE CREAR EL REPRODUCTOR !!
		 */

		player = new Player();

		//Estructura de subsubpanell només de botons del reproductor
		jpPanellPlay = new JPanel();
		blPanellPlay = new BorderLayout();
		jpPanellPlay.setLayout(blPanellPlay);

		playButton = new JButton();
		rightButton = new JButton();
		leftButton = new JButton();

		jpPanellOnlyButtons = new JPanel();
		glPanellOnlyButtons = new GridLayout(1,3);
		jpPanellOnlyButtons.setLayout(glPanellOnlyButtons);

		leftButton = new JButton();

		playbutton1 = new ImageIcon("src/imagenes/playButn11.png");
		playbutton2 = new ImageIcon("src/imagenes/playButn2.png");
		playbutton3 = new ImageIcon("src/imagenes/playButn3.png");

		pausebutton1 = new ImageIcon("src/imagenes/pause1.png");
		pausebutton2 = new ImageIcon("src/imagenes/pause2.png");
		pausebutton3 = new ImageIcon("src/imagenes/pause3.png");

		rightbutton1 = new ImageIcon("src/imagenes/rightbutn1.png");
		rightbutton2 = new ImageIcon("src/imagenes/rightbutn2.png");
		rightbutton3 = new ImageIcon("src/imagenes/rightbutn3.png");

		leftbutton1 = new ImageIcon("src/imagenes/leftbutn1.png");
		leftbutton2 = new ImageIcon("src/imagenes/leftbutn2.png");
		leftbutton3 = new ImageIcon("src/imagenes/leftbutn3.png");

		//temporalSong = new ImageIcon("src/imagenes/secuencialSong.png");
		//jlTemporalSong = new JLabel(temporalSong);
		//jlTemporalSong.setPreferredSize(new Dimension(700,10));

		jlTime = new JLabel();
		jlTime.setHorizontalAlignment(JLabel.CENTER);
		jlTime.setText(" 00:00 ");

		ConfigurationButton(playButton, playbutton1, playbutton2, playbutton3);
		ConfigurationButton(rightButton, rightbutton1, rightbutton2, rightbutton3);
		ConfigurationButton(leftButton, leftbutton1, leftbutton2, leftbutton3);

		jpPanellOnlyButtons.add(rightButton);
		jpPanellOnlyButtons.add(playButton);
		jpPanellOnlyButtons.add(leftButton);

		//Creem el la linia temporal de la cançó
		jSlider1 = new JSlider();
		jSlider1.setValue(0);
		jSlider1.setPreferredSize(new Dimension(100, 20));

		//Creem el panell que anirà al BorderLayout de NORTH, que contindrà dos JLabels amb l'etiqueta de la canço i l'estat d'aquesta
		jpSong = new JPanel();
		glSong = new GridLayout(1,2);
		jpSong.setLayout(glSong);

		//Creem etiqueta de la cançó que está sonant y de l'estat d'aquesta
		NameSong = new JLabel();
		NameSong.setForeground(new Color(22, 88, 210));
		NameSong.setFont(new Font("Britannic Bold", Font.ITALIC, 16));
		//NameSong.setFont(font);
		NameSong.setText(" .........Select one song..........");
		NameSong.setHorizontalAlignment(JTextField.RIGHT);
		jpSong.add(NameSong);

		NameStateSong = new JLabel();
		//NameStateSong.setForeground(new Color(0, 255, 0));
		NameStateSong.setFont(new Font("Britannic Bold", Font.ITALIC, 16));
		NameStateSong.setText(" ");
		NameStateSong.setHorizontalAlignment(JTextField.LEFT);
		jpSong.add(NameStateSong);

		jpPanellPlay.add(jpSong, BorderLayout.NORTH);
		jpPanellPlay.add(jpPanellOnlyButtons, BorderLayout.WEST);
		//jpPanellPlay.add(jlTemporalSong, BorderLayout.CENTER);
		jpPanellPlay.add(jSlider1, BorderLayout.CENTER);
		jpPanellPlay.add(jlTime, BorderLayout.EAST);

		jpPanellMusicButtonsPlayer.add(jpPanellPlay);

		jpPanellMusic.add(jpPanellMusicButtonsPlayer, BorderLayout.PAGE_END);




		//TAB USERS

		//table
		//hardcodeo de columnas y datos 
		String[] columnNames = {"Username", "Register date", "Last login", "Song lists", "Songs", "Followers", "Following"};
		Object[][] data = {{"a", "b", "c", "d", "e", "f", "g"}, {"1", "2", "3", "4", "5", "6", "7"}};
		//se crea la tabla
		JTable usertable = new JTable(data, columnNames);

		//se hace que los datos no sean editables
		DefaultTableModel tableModel = new DefaultTableModel(data, columnNames) {
			@Override
			public boolean isCellEditable(int row, int column) {
				//all cells false
				return false;
			}
		}; 

		usertable.setModel(tableModel);

		JScrollPane jspPanellUsers = new JScrollPane(usertable);
		jpPanellUsers = new JPanel();
		jpPanellUsers.add(jspPanellUsers, BorderLayout.CENTER);

		//Incloeixo les pestañes a la finestra
		jtpPestanyas.addTab("Music", jpPanellMusic);
		jtpPestanyas.addTab("Users", jspPanellUsers);

		this.getContentPane().add(jtpPestanyas, BorderLayout.CENTER);
		this.setResizable(true);
		this.setSize(new Dimension(1600,870));
		this.setTitle("eSpotifai - Server Management");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	public void ConfigurationButton(JButton boton,ImageIcon imatge1,ImageIcon imatge2,ImageIcon imatge3){

		//Definim que l'icon tindrá una imatge assignada per defecte
		boton.setIcon(imatge1);

		//Configurem que el botó no tingui marc 
		boton.setBorderPainted(false);

		//Per a que no es pinti el botó
		boton.setContentAreaFilled(false);
		boton.setFocusable(false);
		boton.setRolloverEnabled(true);

		//Definim l'icon que es mostrará quan l'usuari estigui sobre el botó 
		boton.setRolloverIcon(imatge2);

		//Definim l'icon que es mostrará quan l'usuari premi el botó 
		boton.setPressedIcon(imatge3);

	}
	public void goMP3() throws Exception{

		//Si la canço s'ha reproduit un cop i esta en pause, continua reproduint PAUSE
		//if (!stateSong && state.equals("Reproduciendo")){
		if (player.getStatus() == 1){

			player.Continue();
			ConfigurationButton(playButton, pausebutton1, pausebutton2, pausebutton3);
			stateSong = true;

			//Si la canço s'està reproduint pula pausa PLAY
		}else if (player.getStatus() == 0){

		//}else if (stateSong){
			
			player.Pause();
			ConfigurationButton(playButton, playbutton1, playbutton2, playbutton3);
			stateSong = false;
		}else {//if (player.getStatus() == 2 || (player.getStatus() != 0 && player.getStatus() != 1)){
			//Si no ha arrancat encara la canço obre el fitxer mp3
		//}else{
			try{

				//Creo un reproductor
				//player = new Player();

				state = "";
				//String songLink = "C:/Users/Marc/Downloads/Quentin Tarantino Soundtracks Discography - HTD 2015/Pulp Fiction (Collector's Edition) (2009) - Soundtrack/04. Let's Stay Together.mp3";
				//String songLink = "C:/Users/Marc/Downloads/Quentin Tarantino Soundtracks Discography - HTD 2015/Pulp Fiction (Collector's Edition) (2009) - Soundtrack/14. Personality Goes a Long Way.mp3";
				String songLink = "C:/Users/Marc/Downloads/grillos05_mp3.mp3";

				player.AbrirMp3(songLink);
				state = player.Play(jSlider1);

			}catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
			stateSong = true;
			ConfigurationButton(playButton, pausebutton1, pausebutton2, pausebutton3);
			NameSong.setText(player.getName());

		}
		/*//Si el player está parat i fa clik
		if (player.isEnded()){

			try{

				//Creo un reproductor un altre cop ja que internament el BasicPlayer ha fet un closeStrem();
				player = new Player();

				System.out.println("\nENTRO EN EL VISUALITZADOR DE CANçO PER SEGON COP\n");
				state = "";
				String songLink = "C:/Users/Marc/Downloads/Quentin Tarantino Soundtracks Discography - HTD 2015/Pulp Fiction (Collector's Edition) (2009) - Soundtrack/14. Personality Goes a Long Way.mp3";
				//String songLink = "C:/Users/Marc/Downloads/grillos05_mp3.mp3";
				player.AbrirMp3(songLink);
				state = player.Play(jSlider1);

			}catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
			ConfigurationButton(playButton, pausebutton1, pausebutton2, pausebutton3);
			NameSong.setText(player.getName());
		}
		*/
		
		
		//miro l'estat i el printo per pantalla i el nom de la canço
		if( player.getStatus() == 0){

			NameStateSong.setForeground(new Color(26, 140, 60));
			NameStateSong.setText("           --> PLAYING <--");

		}else if( player.getStatus() == 1){

			NameStateSong.setForeground(new Color(184, 12, 16));
			NameStateSong.setText("           --> PAUSED <--");

		}else if( getState() == 2){

			NameStateSong.setForeground(new Color(255,255,255));
			NameStateSong.setText("           --> CLICK PLAY TO LISTEN THE SONG <--");
		}

		NameSong.setText(player.getName());

	}

	public void registerController(ButtonsController controller) {
		jbAdd.addActionListener(controller);
		jbAdd.setActionCommand("ADD");

		jbEstadistics.addActionListener(controller);
		jbEstadistics.setActionCommand("ESTADISTICS");

		playButton.addActionListener(controller);
		playButton.setActionCommand("PLAY");

		rightButton.addActionListener(controller);
		rightButton.setActionCommand("RIGHTSONG");

		leftButton.addActionListener(controller);
		leftButton.setActionCommand("LEFTSONG");
	}

	public void changeButtonToPlay(){
		
		if( getState() == 2){
			
			ConfigurationButton(playButton, playbutton1, playbutton2, playbutton3);
			NameStateSong.setForeground(new Color(255,255,255));
			NameStateSong.setText("           --> CLICK PLAY TO LISTEN THE SONG <--");
			
		}
	}
	public void refreshTime() {

		int auxMinutes = 0;
		int auxSeconds = 0;
		String auxSecondsString = "";
		String auxMinutesString = "";

		auxMinutes = player.getMinutes();
		auxSeconds = player.getSeconds();

		if( auxMinutes > 9 ){
			auxMinutesString = ""+String.valueOf(auxMinutes);
		}else{

			auxMinutesString = "0" + String.valueOf(auxMinutes);
		}

		if( auxSeconds > 9 ){
			auxSecondsString = ""+String.valueOf(auxSeconds);
		}else{
			auxSecondsString = "0" + String.valueOf(auxSeconds);
		}

		String finalSting = auxMinutesString + ":" + auxSecondsString;

		jlTime.setText(auxMinutesString + ":" + auxSecondsString);
		
		jSlider1.setValue(player.getFrameSlider());
		//changeButtonToPlay();
		if (player.getStatus() == 2){
			ConfigurationButton(playButton, playbutton1, playbutton2, playbutton3);
		}

		//jlTime.setText(String.valueOf(player.getMinutes() + ":" + player.getSeconds()));
	}

}




