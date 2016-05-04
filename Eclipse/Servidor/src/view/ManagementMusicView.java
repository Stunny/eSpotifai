package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import controller.ButtonsController;

public class ManagementMusicView extends JFrame{

	private JTabbedPane jtpPestanyas;
	private JPanel jpPanellMusic;
	private JPanel jpPanellUsers;
	private JPanel jpPanellMusicButtonsPlayer;
	private JPanel jpPanellButtons;
	private JPanel jpPanellPlay;

	private GridLayout glPanellPlay;
	private GridLayout glPanellButtons;
	private GridLayout glPanellMusicButtonsPlayer;
	private BorderLayout blPanellMusic;
	private JTextArea jtListOfSongs;
	private JScrollPane jspListOfSongs;

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

	private ImageIcon rightbutton1;
	private ImageIcon rightbutton2;
	private ImageIcon rightbutton3;

	public ManagementMusicView() {

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
		String[] columnNamessongs = {"Username", "Register date", "Last login", "Song lists", "Songs", "Followers", "Following"};
		Object[][] datasongs = {{"a", "b", "c", "d", "e", "f", "g"}, {"1", "2", "3", "4", "5", "6", "7"}};
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

		//Li assigno a aquesta area de text que pugui fer scroll
		jspListOfSongs = new JScrollPane(songstable);
		//Asigno un titul al apartat de la llista de cançons
		jspListOfSongs.setBorder(BorderFactory.createTitledBorder("Llist of songs"));
		//Introdueixo aquest apartat/Panell a la primera fila del panell
		jpPanellMusic.add(jspListOfSongs, BorderLayout.CENTER);


		//Creem el subpanell per montar l'estructura del apartat "butons  - ADD i estadistiques - i el reproductor "
		jpPanellMusicButtonsPlayer = new JPanel();

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

		//Creo botó per controlar els usuaris "Users"
		jbEstadistics = new JButton("Estadistics");
		jbEstadistics.setHorizontalAlignment(JButton.CENTER);
		jpPanellButtons.add(jbEstadistics);

		jpPanellMusicButtonsPlayer.add(jpPanellButtons);

		/*
		 * AQUI S'HA DE CREAR EL REPRODUCTOR !!
		 */
		//Estructura de subsubpanell només de botons del reproductor
		jpPanellPlay = new JPanel();
		glPanellPlay = new GridLayout(1,4);
		jpPanellPlay.setLayout(glPanellPlay);

		playButton = new JButton();
		rightButton = new JButton();
		leftButton = new JButton();

		playbutton1 = new ImageIcon("src/imagenes/playButn1.png");
		playbutton2 = new ImageIcon("src/imagenes/playButn2.png");
		playbutton3 = new ImageIcon("src/imagenes/playButn3.png");

		rightbutton1 = new ImageIcon("src/imagenes/rightbutn1.png");
		rightbutton2 = new ImageIcon("src/imagenes/rightbutn2.png");
		rightbutton3 = new ImageIcon("src/imagenes/rightbutn3.png");

		leftbutton1 = new ImageIcon("src/imagenes/leftbutn1.png");
		leftbutton2 = new ImageIcon("src/imagenes/leftbutn2.png");
		leftbutton3 = new ImageIcon("src/imagenes/leftbutn3.png");

		ConfigurationButton(playButton, playbutton1, playbutton2, playbutton3);
		ConfigurationButton(rightButton, rightbutton1, rightbutton2, rightbutton3);
		ConfigurationButton(leftButton, leftbutton1, leftbutton2, leftbutton3);

		jpPanellPlay.add(rightButton, BorderLayout.WEST);
		jpPanellPlay.add(playButton, BorderLayout.CENTER);
		jpPanellPlay.add(leftButton, BorderLayout.EAST);

		jpPanellMusicButtonsPlayer.add(jpPanellPlay);
		//jpPanellMusicButtonsPlayer.add(jpPanellPlay);
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
		this.setSize(new Dimension(2000,850));
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

	public void registerController(ButtonsController controller) {
		jbAdd.addActionListener(controller);
		jbAdd.setActionCommand("ADD");

		jbEstadistics.addActionListener(controller);
		jbEstadistics.setActionCommand("ESTADISTICS");	
	}
}
