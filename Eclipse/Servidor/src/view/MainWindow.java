package view;

import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.Popup;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
//import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

//import view.PopupMenu.PopupPrintListener;
import model.CustomPlayer;
import model.User;
import controller.ButtonsController;
import controller.PopUpController;
/**
 * Pantalla principal de la versi� de servidor de l'aplicaci�
 * @author Elna Cabot, Miguel D�az, Marc Mill�n, Alejandro Vogel, Marta Zapatero
 * @version 1.0
 * @see CustomPlayer
 * @see JTabbedPane
 * @see JScrollPane
 * @see JPanel
 * @see JLabel
 * @see JTable
 * @see JSlider
 * @see JButton
 * @see JPopupMenu
 * @see JMenuItem
 * @see GridLayout
 * @see BorderLayout
 * @see ImageIcon
 * @see DefaultTableModel
 * @see ButtonsController
 * @see PopUpController
 * @see ActionListener
 */
public class MainWindow extends JFrame{
	/**
	 * Reproductor
	 * @see CustomPlayer
	 */
	private CustomPlayer customPlayer;
	/**
	 * Conjunt de pestanyes de la pantalla
	 */
	private JTabbedPane jtpTabs;
	/**
	 * Panell on es col�locar� la informaci� de can�ons
	 * @see Song
	 * @see JPanel
	 */
	private JPanel jpMusic;
	private JTable jpUsers;

	/**
	 * Subpanell
	 */
	private JPanel jpPageEnd;

	/**
	 * Subpanell de botons
	 */
	private JPanel jpButtons;

	/**
	 * Panell on va col�locat el reproductor
	 */
	private JPanel jpPlayer; 
	private JPanel jpPlayerButtons; 

	/**
	 * Panell de can�ons
	 */
	private JPanel jpSong;

	/**
	 * Grid Layoput del subpanell de butons
	 */
	private GridLayout glButtons;

	/**
	 * Grid Layout dels botons del reproductor
	 */
	private GridLayout glPlayerButtons; 

	/**
	 * Indicar� dins un border layout l'etiqueta d'una can�� i l'estat de la mateixa
	 */
	private GridLayout glPageEnd;

	/**
	 * Grid Layout
	 */
	private GridLayout glSong;

	/**
	 * Estructura Border Layout com a finestra de cintingut de musica
	 */
	private BorderLayout blMusic;

	/**
	 * Estructura Border Layout per contenir el reproductor
	 */
	private BorderLayout blPlayer; 

	//private JTextArea jtListOfSongs;

	/**
	 * Area de representaci� on es podr� fer scroll
	 */
	private JScrollPane jspMusicList;

	/**
	 * Mostra gr�ficament el moment en el que es troba la can��.
	 * @see JSlider
	 */
	private JSlider jSlider; //

	/**
	 * Bot� per a afegir camps
	 */
	private JButton jbAdd;

	/**
	 * Mostrar� les estad�stiques de la aplicaci�
	 */
	private JButton jbStatistics;

	//=========================
	/**
	 * Bot� <i style="color:indigo">PLAY</i> del reproductor.
	 * @see JButton
	 */
	private JButton jbPlay;
	/**	
	 * Bot� <i style="color:indigo">PREVIOUS</i> del reproductor.
	 * @see JButton
	 */
	private JButton jbPrevious;
	/**
	 * Bot� <i style="color:indigo">NEXT</i> del reproductor.
	 * @see JButton
	 */
	private JButton jbNext;
	/**
	 * Bot� <i style="color:indigo">SINGLE REPEAT</i> del reproductor.
	 * @see JRadioButton
	 */
	private JRadioButton jrbRepeatOne;
	/**
	 * Bot� <i style="color:indigo">GLOBAL REPEAT</i> del reproductor.
	 * @see JRadioButton
	 */
	private JRadioButton jrbRepeatList;
	/**
	 * Icon de Next #1
	 */
	private ImageIcon iiNext1;
	/**
	 * Icon de Next #2
	 */
	private ImageIcon iiNext2;
	/**
	 * Icon de next #3
	 */
	private ImageIcon iiNext3;
	/**
	 * Icon de play #1
	 */
	private ImageIcon iiPlay1;
	/**
	 * Icon de play #2
	 */
	private ImageIcon iiPlay2;
	/**
	 * Icon de play #3
	 */
	private ImageIcon iiPlay3;
	/**
	 * Icon de pausa #1
	 */
	private ImageIcon iiPause1;
	/**
	 * Icon de pausa #2
	 */
	private ImageIcon iiPause2;
	/**
	 * Icon de pausa #3
	 */
	private ImageIcon iiPause3;
	/**
	 * Icon de anterior #1
	 */
	private ImageIcon iiPrevious1;

	/**
	 * 
	 * Icon de anterior #2	 
	 */
	private ImageIcon iiPrevious2;
	/**
	 * Iconde anterior #3
	 */
	private ImageIcon iiPrevious3;
	//private ImageIcon temporalSong;

	//=========================

	/**
	 * Taula de contingut de la part d'usuari
	 */
	DefaultTableModel tableModelUser;

	/**
	 * Taula de contigut de la part de m�sica
	 */
	DefaultTableModel tableModelMusic;

	/**
	 * Porta a la pantalla de seguidors
	 */
	private JMenuItem seguidores;

	/**
	 * Porta a la pantalla de seguits
	 */
	private JMenuItem seguidos;

	/**
	 * Porta a la pantalla de <i>playlists</i>
	 */
	private JMenuItem listas;

	/**
	 * Obre el di�leg per confirmar l'eliminaci�
	 */
	private JMenuItem eliminar;

	/**
	 * Obre el di�leg per confirmar l'eliminaci�
	 */
	private JMenuItem eliminar2;

	/**
	 * ID d'usuari
	 */
	private int id = 0;

	/**
	 * ID de can��
	 */
	private int idSong = 0;

	/**
	 * Men� emergent a l'usuari
	 */
	public JPopupMenu popup;

	/**
	 * Menu emergent d'una can��
	 */
	public JPopupMenu popupSong;
	//=============
	//private JLabel jlTemporalSong;

	/**
	 * Etiqueta on es representa la mesura del temps del reproductor
	 */
	private JLabel jlTime;
	//private JLabel SongState;

	/**
	 * Etiqueta on es representa elnom de lacan�� que est� sent reproduida
	 */
	private JLabel jlSongName;

	/**
	 * Estat de la reproducci� dela can��(aturat,pausat,en reproducci�...)
	 */
	private JLabel jlSongState;

	//private ImageIcon temporalSong;
	/**
	 * 
	 */
	private boolean stateSong = false;
	/**
	 * 
	 */
	private String state = "";
	/**
	 * 
	 */
	private String statePlayer = "";
	/**
	 * 
	 */
	private int max = 0, value = 0;
	//==================


	private JTable jtMusicList;
	private JTable jtUser;


	/**
	 * Construeix la pantalla principal del servidor de l'aplicaci�
	 * @see CustomPlayer
	 * @see JTabbedPane
	 * @see JScrollPane
	 * @see JPanel
	 * @see JLabel
	 * @see JTable
	 * @see JSlider
	 * @see JButton
	 * @see JPopupMenu
	 * @see JMenuItem
	 * @see GridLayout
	 * @see BorderLayout
	 * @see ImageIcon
	 * @see DefaultTableModel
	 */
	public MainWindow() {

		//Creem el conjunt de pestanyes
		jtpTabs = new JTabbedPane();

		//Creem el panell per montar l'estructura de l'apartat "Music"
		jpMusic = new JPanel();

		//Estructura de panell de tipus BorderLayout
		blMusic = new BorderLayout();
		jpMusic.setLayout(blMusic);


		//Creo el panell Scroll de la llista de can�ons
		//table
		//hardcodeo de columnas y datos 
		String[] jtMusicColumns = {"Id","Name", "Genre", "Album", "Artist", "Location", "Stars", "Reproductions"};
		Object[][] jtMusicData = {};
		//se crea la tabla
		jtMusicList = new JTable(jtMusicData, jtMusicColumns);

		//se hace que los datos no sean editables
		tableModelMusic = new DefaultTableModel(jtMusicData, jtMusicColumns) {
			@Override
			public boolean isCellEditable(int row, int column) {
				//all cells false
				return false;
			}
		}; 

		popupSong = new JPopupMenu();
		eliminar2 = new JMenuItem("Delete");
		eliminar2.setHorizontalTextPosition(JMenuItem.RIGHT);
		popupSong.add(eliminar2);


		popupSong.setLabel("Justification");
		popupSong.setBorder(new BevelBorder(BevelBorder.RAISED));

		jtMusicList.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if ( SwingUtilities.isLeftMouseButton(e)) {
					popupSong.setVisible(false);
					jtMusicList.clearSelection();
				} else {
					if ( SwingUtilities.isRightMouseButton(e)) {
						Point p = e.getPoint();
						int rowNumber = jtMusicList.rowAtPoint( p );
						ListSelectionModel modelo = jtMusicList.getSelectionModel();
						modelo.setSelectionInterval( rowNumber, rowNumber );
						idSong = Integer.parseInt(String.valueOf( jtMusicList.getValueAt(rowNumber, 0)));
						popupSong.show(jtMusicList,  e.getX(), e.getY());
					}
				}
			}
		});
		jtMusicList.getTableHeader().setReorderingAllowed(false);
		jtMusicList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jtMusicList.setModel(tableModelMusic);
		//jtMusicList.setForeground(Color.BLACK);
		jtMusicList.setFocusable(false);
		//jtMusicList.setForeground(Color.BLACK);
		//jtMusicList.setBackground(Color.DARK_GRAY);
		Color myColor = Color.getHSBColor(0.51F,  0.93F,  0.5F);          
		jtMusicList.setBackground(myColor);

		//Li assigno a aquesta area de text que pugui fer scroll
		//jspMusicList = new JScrollPane(jtListOfSongs);
		jspMusicList = new JScrollPane(jtMusicList);

		//Asigno un titul al apartat de la llista de can�ons
		jspMusicList.setBorder(BorderFactory.createTitledBorder("List of songs"));

		//Introdueixo aquest apartat/Panell a la primera fila del panell
		jpMusic.add(jspMusicList, BorderLayout.CENTER);

		//Creem el subpanell per montar l'estructura del apartat "butons  - ADD i estadistiques - i el reproductor "
		/*jpPageEnd = new JPanel();
		jpPageEnd.setPreferredSize(new Dimension(400,90));			

		//Estructura de panell de 2 files per 1 columna
		glPageEnd = new GridLayout(2,1);
		jpPageEnd.setLayout(glPageEnd);*/

		//Estructura de subsubpanell nom�s de botons
		jpButtons = new JPanel();
		glButtons = new GridLayout(1,2);
		jpButtons.setLayout(glButtons);	


		//Creo bot� de afegir can�o "Add"
		jbAdd = new JButton("Add");
		jbAdd.setHorizontalAlignment(JButton.CENTER);
		jpButtons.add(jbAdd);

		//Creo bot� per veure les estadistiques de les millors can�ons "Top 10 songs"
		jbStatistics = new JButton("Top 10 songs");
		jbStatistics.setHorizontalAlignment(JButton.CENTER);
		jpButtons.add(jbStatistics);

		//jpPageEnd.add(jpButtons);
		//========================
		/*
		 * AQUI S'HA DE CREAR EL REPRODUCTOR !!
		 */

		customPlayer = new CustomPlayer();
		//Estructura de subsubpanell nom�s de botons del reproductor
		jpPlayer = new JPanel();
		blPlayer = new BorderLayout();
		jpPlayer.setLayout(blPlayer);

		jbPlay = new JButton();
		jbPrevious = new JButton();
		jbNext = new JButton();
		jpPlayerButtons = new JPanel();
		glPlayerButtons = new GridLayout(1,3);
		jpPlayerButtons.setLayout(glPlayerButtons);



		iiPlay1 = new ImageIcon("src/imagenes/playButn1.png");
		iiPlay2 = new ImageIcon("src/imagenes/playButn2.png");
		iiPlay3 = new ImageIcon("src/imagenes/playButn3.png");

		iiPause1 = new ImageIcon("src/imagenes/pause1.png");
		iiPause2 = new ImageIcon("src/imagenes/pause2.png");
		iiPause3 = new ImageIcon("src/imagenes/pause3.png");

		iiPrevious1 = new ImageIcon("src/imagenes/rightbutn1.png");
		iiPrevious2 = new ImageIcon("src/imagenes/rightbutn2.png");
		iiPrevious3 = new ImageIcon("src/imagenes/rightbutn3.png");

		iiNext1 = new ImageIcon("src/imagenes/leftbutn1.png");
		iiNext2 = new ImageIcon("src/imagenes/leftbutn2.png");
		iiNext3 = new ImageIcon("src/imagenes/leftbutn3.png");

		//temporalSong = new ImageIcon("src/imagenes/secuencialSong.png");
		//jlTemporalSong = new JLabel(temporalSong);
		//jlTemporalSong.setPreferredSize(new Dimension(700,10));

		jlTime = new JLabel();
		jlTime.setHorizontalAlignment(JLabel.CENTER);
		jlTime.setText(" 00:00");

		ConfigurationButton(jbPlay, iiPlay1, iiPlay2, iiPlay3);
		ConfigurationButton(jbPrevious, iiPrevious1, iiPrevious2, iiPrevious3);
		ConfigurationButton(jbNext, iiNext1, iiNext2, iiNext3);

		jpPlayerButtons.add(jbPrevious);
		jpPlayerButtons.add(jbPlay);
		jpPlayerButtons.add(jbNext);

		//Creem el la linia temporal de la can��
		jSlider = new JSlider();
		jSlider.setValue(0);
		jSlider.setPreferredSize(new Dimension(100, 20));

		//Creem el panell que anir� al BorderLayout de NORTH, que contindr� dos JLabels amb l'etiqueta de la can�o i l'estat d'aquesta
		jpSong = new JPanel();
		glSong = new GridLayout(1,3);
		jpSong.setLayout(glSong);

		//Creem etiqueta de la can�� que est� sonant y de l'estat d'aquesta
		jlSongName = new JLabel();
		jlSongName.setForeground(new Color(22, 88, 210));
		jlSongName.setFont(new Font("Britannic Bold", Font.ITALIC, 16));
		jlSongName.setText(" .........Select one song..........");
		jlSongName.setHorizontalAlignment(JTextField.RIGHT);
		jpSong.add(jlSongName);

		jlSongState = new JLabel();
		//jlSongState.setForeground(new Color(0, 255, 0));
		jlSongState.setFont(new Font("Britannic Bold", Font.ITALIC, 16));
		jlSongState.setText(" ");
		jlSongState.setHorizontalAlignment(JTextField.LEFT);
		jpSong.add(jlSongState);
		
		JPanel jpRadioButtons = new JPanel();
		jrbRepeatList = new JRadioButton("Global repeat", true);
		jrbRepeatOne = new JRadioButton("Single repeat", false);
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(jrbRepeatList);
		buttonGroup.add(jrbRepeatOne);
		jpRadioButtons.add(jrbRepeatList);
		jpRadioButtons.add(jrbRepeatOne);
		jpSong.add(jpRadioButtons);

		jpPlayer.add(jpSong, BorderLayout.NORTH);
		jpPlayer.add(jpPlayerButtons, BorderLayout.WEST);
		//jpPlayer.add(jlTemporalSong, BorderLayout.CENTER);
		jpPlayer.add(jSlider, BorderLayout.CENTER);
		jpPlayer.add(jlTime, BorderLayout.EAST);

		//=====================================

		/*jpPageEnd.add(jpPlayer);
		jpPageEnd.setPreferredSize(new Dimension(0, 130));*/

		jpMusic.add(jpButtons, BorderLayout.PAGE_END);


		//TAB USERS

		//table
		//hardcodeo de columnas y datos 
		String[] jtUserColumns = {"id","Username", "Register date", "Last login", "Song lists", "Songs", "Followers", "Following"};
		Object[][] jtUserData = {};
		//se crea la tabla
		jtUser = new JTable(jtUserData, jtUserColumns);

		//se hace que los datos no sean editables
		tableModelUser = new DefaultTableModel(jtUserData, jtUserColumns) {
			@Override
			public boolean isCellEditable(int row, int column) {
				//all cells false
				return false;
			}

		}; 

		popup = new JPopupMenu();
		popup.add(seguidores = new JMenuItem("Show followers", null));
		seguidores.setHorizontalTextPosition(JMenuItem.RIGHT);

		popup.add(seguidos = new JMenuItem("Show followed", null));
		seguidos.setHorizontalTextPosition(JMenuItem.RIGHT);

		popup.add(listas = new JMenuItem("Show playlists", null));
		listas.setHorizontalTextPosition(JMenuItem.RIGHT);

		popup.addSeparator();
		popup.add(eliminar = new JMenuItem("Delete"));


		popup.setLabel("Justification");
		popup.setBorder(new BevelBorder(BevelBorder.RAISED));

		jtUser.addMouseListener(new MouseAdapter() {

			public void mousePressed(MouseEvent e) {
				if ( SwingUtilities.isRightMouseButton(e)) {
					//JOptionPane.showMessageDialog(null, "Yoink!");
					popup.setVisible(false);
				} else {
					if ( SwingUtilities.isLeftMouseButton(e)) {
						Point p = e.getPoint();
						int rowNumber = jtUser.rowAtPoint( p );
						ListSelectionModel modelo = jtUser.getSelectionModel();
						modelo.setSelectionInterval( rowNumber, rowNumber );
						id = Integer.parseInt(String.valueOf( jtUser.getValueAt(rowNumber, 0)));
						popup.show(jtpTabs,  e.getX(), e.getY());

					}
				}
			}
		});
		jtUser.getTableHeader().setReorderingAllowed(false);
		jtUser.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jtUser.setModel(tableModelUser);
		jtUser.setFocusable(false);

		JScrollPane jspUsers = new JScrollPane(jtUser);
		jpUsers = new JTable();
		jpUsers.add(jspUsers, BorderLayout.CENTER);

		jspUsers.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if ( SwingUtilities.isLeftMouseButton(e)) {
					popup.setVisible(false);
				}
			}
		});

		//jpUsers.add(popup = new PopupMenu());
		//Incloeixo les pesta�es a la finestra
		jtpTabs.addTab("Music", jpMusic);
		jtpTabs.addTab("Users", jspUsers);
		jtpTabs.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if ( SwingUtilities.isLeftMouseButton(e)) {
					popup.setVisible(false);
				}
			}
		});
		this.getContentPane().add(jtpTabs, BorderLayout.CENTER);
		this.getContentPane().add(jpPlayer, BorderLayout.SOUTH);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setResizable(true);
		this.setSize(new Dimension(1280,720));
		this.setTitle("eSpotifai - Server Management");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}


	//==========================
	/**
	 * Configura l'aspecte dels botons
	 * @param boton Bot�
	 * @param imatge1 Primera imatge: Icon
	 * @param imatge2 Segona imatge: Rollover Icon
	 * @param imatge3 Tercera imatge: Pressed Icon
	 */
	public void ConfigurationButton(JButton boton,ImageIcon imatge1,ImageIcon imatge2,ImageIcon imatge3){

		//Definim que l'icon tindr� una imatge assignada per defecte
		boton.setIcon(imatge1);

		//Configurem que el bot� no tingui marc 
		boton.setBorderPainted(false);

		//Per a que no es pinti el bot�
		boton.setContentAreaFilled(false);
		boton.setFocusable(false);
		boton.setRolloverEnabled(true);

		//Definim l'icon que es mostrar� quan l'usuari estigui sobre el bot� 
		boton.setRolloverIcon(imatge2);

		//Definim l'icon que es mostrar� quan l'usuari premi el bot� 
		boton.setPressedIcon(imatge3);

	}


	/**
	 * Controla l'estat del reproductor de la pantalla principal
	 * @throws Exception
	 * @see CustomPlayer
	 */

	public void goMP3(String songLink) throws Exception{

		//Si la can�o s'ha reproduit un cop i esta en pause, continua reproduint PAUSE
		//if (!stateSong && state.equals("Reproduciendo")){
		if (customPlayer.getStatus() == 1){

			customPlayer.resume();
			ConfigurationButton(jbPlay, iiPause1, iiPause2, iiPause3);
			stateSong = true;

			//Si la can�o s'est� reproduint pula pausa PLAY
		}else if (customPlayer.getStatus() == 0){

			//}else if (stateSong){

			customPlayer.pause();
			ConfigurationButton(jbPlay, iiPlay1, iiPlay2, iiPlay3);
			stateSong = false;
		}else {//if (player.getStatus() == 2 || (player.getStatus() != 0 && player.getStatus() != 1)){
			//Si no ha arrancat encara la can�o obre el fitxer mp3
			//}else{
			try{

				//Creo un reproductor
				//player = new Player();

				state = "";
				//String songLink = "C:/Users/Marc/Downloads/Quentin Tarantino Soundtracks Discography - HTD 2015/Pulp Fiction (Collector's Edition) (2009) - Soundtrack/04. Let's Stay Together.mp3";
				//String songLink = "C:/Users/Marc/Downloads/Quentin Tarantino Soundtracks Discography - HTD 2015/Pulp Fiction (Collector's Edition) (2009) - Soundtrack/14. Personality Goes a Long Way.mp3";
				//String songLink = "C:/Users/Marc/Downloads/grillos05_mp3.mp3";
				//String songLink = "/Users/elnacabotparedes/Music/iTunes/iTunes Media/Music/Martin Garrix/Unknown Album/01 Poison.mp3";
				//String songLink = "C:/Users/Marta/Music/Mystery_Skulls_-Magic.mp3";

				customPlayer.abrirMp3(songLink);

				state = customPlayer.playPlayer(jSlider);

			}catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
			stateSong = true;
			ConfigurationButton(jbPlay, iiPause1, iiPause2, iiPause3);
			jlSongName.setText(customPlayer.getName());

		}


		//miro l'estat i el printo per pantalla i el nom de la can�o
		if(customPlayer.getStatus() == 0){

			jlSongState.setForeground(new Color(26, 140, 60));
			jlSongState.setText("           --> PLAYING <--");

		}else if(customPlayer.getStatus() == 1){

			jlSongState.setForeground(new Color(184, 12, 16));
			jlSongState.setText("           --> PAUSED <--");

		}else if( getState() == 2){

			jlSongState.setForeground(new Color(255,255,255));
			jlSongState.setText("           --> CLICK PLAY TO LISTEN THE SONG <--");
		}

		jlSongName.setText(customPlayer.getName());

	}


	public void changeMP3(String songLink) throws Exception {

		try{
			//customPlayer.stopPlayer();
			state = "";
			customPlayer.abrirMp3(songLink);
			state = customPlayer.playPlayer(jSlider);

		}catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
		}
		stateSong = true;
		ConfigurationButton(jbPlay, iiPause1, iiPause2, iiPause3);
		jlSongName.setText(customPlayer.getName());

		if(customPlayer.getStatus() == 0){

			jlSongState.setForeground(new Color(26, 140, 60));
			jlSongState.setText("           --> PLAYING <--");

		}else if(customPlayer.getStatus() == 1){

			jlSongState.setForeground(new Color(184, 12, 16));
			jlSongState.setText("           --> PAUSED <--");

		}else if( getState() == 2){

			jlSongState.setForeground(new Color(255,255,255));
			jlSongState.setText("           --> CLICK PLAY TO LISTEN THE SONG <--");
		}
	}


	//===============================
	/**
	 * Controlador d'input de la pantalla principal de l'aplicaci�
	 * @param controller Primer listener d'input de la pantalla principal
	 * @param controller2 Segon listener de la pantalla principal
	 * @see ActionListener
	 * @see ButtonsController
	 * @see PopUpController
	 */

	public void registerController(ButtonsController controller, PopUpController controller2) {
		jbAdd.addActionListener(controller);
		jbAdd.setActionCommand("MainWindow.addActionCommand");

		jbStatistics.addActionListener(controller);
		jbStatistics.setActionCommand("MainWindow.statisticsActionCommand");	

		seguidores.addActionListener(controller2);
		seguidores.setActionCommand("MainWindow.seguidoresActionCommand");

		seguidos.addActionListener(controller2);
		seguidos.setActionCommand("MainWindow.seguidosActionCommand");

		listas.addActionListener(controller2);
		listas.setActionCommand("MainWindow.listasActionCommand");

		eliminar.addActionListener(controller2);
		eliminar.setActionCommand("MainWindow.eliminarActionCommand");

		eliminar2.addActionListener(controller2);
		eliminar2.setActionCommand("MainWindow.eliminar2ActionCommand");
		//===============
		jbPlay.addActionListener(controller);
		jbPlay.setActionCommand("MainWindow.playActionCommand");

		jbNext.addActionListener(controller);
		jbNext.setActionCommand("MainWindow.nextActionCommand");

		jbPrevious.addActionListener(controller);
		jbPrevious.setActionCommand("MainWindow.previousActionCommand");
		//============================

	}
	/**
	 * Avisa a l'usuari de que pot fer click a <i style="color:indigo">PLAY</i> per reproduir la can��.
	 */
	public void changeButtonToPlay(){

		if( getState() == 2){

			ConfigurationButton(jbPlay, iiPlay1, iiPlay2, iiPlay3);
			jlSongState.setForeground(new Color(255,255,255));
			jlSongState.setText("           --> CLICK PLAY TO LISTEN THE SONG <--");

		}
	}
	
	/**
	 * Actualitza els valors de temps de reproducci� del reproductor
	 * @see CustomPlayer
	 */
	
	public void refreshTime() {

		int auxMinutes = 0;
		int auxSeconds = 0;
		String auxSecondsString = "";
		String auxMinutesString = "";

		auxMinutes = customPlayer.getMinutes();
		auxSeconds = customPlayer.getSeconds();

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

		jSlider.setValue(customPlayer.getFrameSlider());
		//changeButtonToPlay();
		if (customPlayer.getStatus() == 2){
			ConfigurationButton(jbPlay, iiPlay1, iiPlay2, iiPlay3);
		}
		
		if (customPlayer.isEnded() && jrbRepeatOne.isSelected()) {
			try {
				changeMP3(customPlayer.getSongPath());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		}
		if (customPlayer.isEnded() && jrbRepeatList.isSelected()) {
			jbNext.doClick();
		}

		//jlTime.setText(String.valueOf(player.getMinutes() + ":" + player.getSeconds()));
	}
///==================
	
	/**
	 * Actualitza la llista d'usuaris
	 * @param list
	 * @see User
	 */
	public void refreshUsers(LinkedList <Object[]> list){
		while (tableModelUser.getRowCount()!= 0){
			tableModelUser.removeRow(0);
		}
		for (int i = 0; i<list.size(); i++){
			tableModelUser.addRow(list.get(i));
		}
	}
	
	
	/**
	 * Actualitza la llista de can�ons
	 * @param list
	 * @see Song
	 */
	public void refreshSongs(LinkedList<Object[]> list) {
		while (tableModelMusic.getRowCount()!= 0){
			tableModelMusic.removeRow(0);
		}
		for (int i = 0; i<list.size(); i++){
			tableModelMusic.addRow(list.get(i));
		}
	}
	/**
	 * Retorna l'ID d'un usuari
	 * @return
	 * @see User
	 */
	public int getId (){
		return id;
	}
	/**
	 * Retorna l'ID d'una can��
	 * @return
	 * @see Song
	 */
	public int getIdSong(){
		return idSong;
	}

	public String getSongPath(int index) {
		return (String)tableModelMusic.getValueAt(index, 5);
	}

	public int getSongAmount() {
		return tableModelMusic.getRowCount();
	}


}