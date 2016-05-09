package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import controller.ButtonsController;

public class MainWindow extends JFrame{

	private JTabbedPane jtpTabs;
	private JPanel jpMusic;
	private JPanel jpUsers;
	private JPanel jpPageEnd;
	private JPanel jpButtons;
	private JPanel jpPlayer;
	private JPanel jpPlayerButtons;

	private GridLayout glButtons;
	private GridLayout glPanellPlay;
	private GridLayout glPlayerButtons;
	private GridLayout glPageEnd;
	private BorderLayout blMusic;
	private JTextArea jtListOfSongs;
	private JScrollPane jspMusicList;
	private BorderLayout blPlayer;

	private JButton jbAdd;
	private JButton jbStatistics;
	private JButton jbPlay;
	private JButton jbPrevious;
	private JButton jbNext;

	private ImageIcon iiNext1;
	private ImageIcon iiNext2;
	private ImageIcon iiNext3;
	
	private JLabel jlMusicProgressBar;
	private JLabel jlTime;

	private ImageIcon iiPlay1;
	private ImageIcon iiPlay2;
	private ImageIcon iiPlay3;

	private ImageIcon iiPrevious1;
	private ImageIcon iiPrevious2;
	private ImageIcon iiPrevious3;
	
	private ImageIcon iiMusicProgressBar;

	public MainWindow() {

		//Creem el conjunt de pestanyes
		jtpTabs = new JTabbedPane();

		//Creem el panell per montar l'estructura de l'apartat "Music"
		jpMusic = new JPanel();

		//Estructura de panell de tipus BorderLayout
		blMusic = new BorderLayout();
		jpMusic.setLayout(blMusic);

		//Creo el panell Scroll de la llista de cançons
		//table
		//hardcodeo de columnas y datos 
		String[] jtMusicColumns = {"Username", "Register date", "Last login", "Song lists", "Songs", "Followers", "Following"};
		Object[][] jtMusicData = {{"a", "b", "c", "d", "e", "f", "g"}, {"1", "2", "3", "4", "5", "6", "7"}};
		//se crea la tabla
		JTable jtMusicList = new JTable(jtMusicData, jtMusicColumns);

		//se hace que los datos no sean editables
		DefaultTableModel tmMusicList = new DefaultTableModel(jtMusicData, jtMusicColumns) {
			@Override
			public boolean isCellEditable(int row, int column) {
				//all cells false
				return false;
			}
		}; 

		jtMusicList.setModel(tmMusicList);

		//Li assigno a aquesta area de text que pugui fer scroll
		jspMusicList = new JScrollPane(jtMusicList);
		//Asigno un titul al apartat de la llista de cançons
		jspMusicList.setBorder(BorderFactory.createTitledBorder("List of songs"));
		//Introdueixo aquest apartat/Panell a la primera fila del panell
		jpMusic.add(jspMusicList, BorderLayout.CENTER);

		//Creem el subpanell per montar l'estructura del apartat "butons  - ADD i estadistiques - i el reproductor "
		jpPageEnd = new JPanel();
		jpPageEnd.setPreferredSize(new Dimension(400,60));			

		//Estructura de panell de 2 files per 1 columna
		glPageEnd = new GridLayout(2,1);
		jpPageEnd.setLayout(glPageEnd);

		//Estructura de subsubpanell només de botons
		jpButtons = new JPanel();
		glButtons = new GridLayout(1,2);
		jpButtons.setLayout(glButtons);

		//Creo botó de afegir canço "Add"
		jbAdd = new JButton("Add");
		jbAdd.setHorizontalAlignment(JButton.CENTER);
		jpButtons.add(jbAdd);

		//Creo botó per controlar els usuaris "Estadistics"
		jbStatistics = new JButton("Statistics");
		jbStatistics.setHorizontalAlignment(JButton.CENTER);
		jpButtons.add(jbStatistics);

		jpPageEnd.add(jpButtons);

		/*
		 * AQUI S'HA DE CREAR EL REPRODUCTOR !!
		 */
		//Estructura de subsubpanell només de botons del reproductor
		jpPlayer = new JPanel();
		blPlayer = new BorderLayout();
		jpPlayer.setLayout(blPlayer);
		
		jbPlay = new JButton();
		
		jbPrevious = new JButton();
		
		jpPlayerButtons = new JPanel();
		glPlayerButtons = new GridLayout(1,3);
		jpPlayerButtons.setLayout(glPlayerButtons);
		
		jbNext = new JButton();
		
		iiPlay1 = new ImageIcon("src/imagenes/playButn1.png");
		iiPlay2 = new ImageIcon("src/imagenes/playButn2.png");
		iiPlay3 = new ImageIcon("src/imagenes/playButn3.png");
		
		iiPrevious1 = new ImageIcon("src/imagenes/rightbutn1.png");
		iiPrevious2 = new ImageIcon("src/imagenes/rightbutn2.png");
		iiPrevious3 = new ImageIcon("src/imagenes/rightbutn3.png");
		
		iiNext1 = new ImageIcon("src/imagenes/leftbutn1.png");
		iiNext2 = new ImageIcon("src/imagenes/leftbutn2.png");
		iiNext3 = new ImageIcon("src/imagenes/leftbutn3.png");
		
		iiMusicProgressBar = new ImageIcon("src/imagenes/secuencialSong.png");
		jlMusicProgressBar = new JLabel(iiMusicProgressBar);
		jlMusicProgressBar.setPreferredSize(new Dimension(700,10));
		
		jlTime = new JLabel();
		jlTime.setHorizontalAlignment(JLabel.CENTER);
		jlTime.setText(" 00:00");
		
		ConfigurationButton(jbPlay, iiPlay1, iiPlay2, iiPlay3);
		ConfigurationButton(jbPrevious, iiPrevious1, iiPrevious2, iiPrevious3);
		ConfigurationButton(jbNext, iiNext1, iiNext2, iiNext3);
		
		jpPlayerButtons.add(jbPrevious);
		jpPlayerButtons.add(jbPlay);
		jpPlayerButtons.add(jbNext);
		
		jpPlayer.add(jpPlayerButtons, BorderLayout.WEST);
		jpPlayer.add(jlMusicProgressBar, BorderLayout.CENTER);
		jpPlayer.add(jlTime, BorderLayout.EAST);

		jpPageEnd.add(jpPlayer);
		
		jpMusic.add(jpPageEnd, BorderLayout.PAGE_END);
		

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

		JScrollPane jspUsers = new JScrollPane(usertable);
		jpUsers = new JPanel();
		jpUsers.add(jspUsers, BorderLayout.CENTER);

		//Incloeixo les pestañes a la finestra
		jtpTabs.addTab("Music", jpMusic);
		jtpTabs.addTab("Users", jspUsers);

		this.getContentPane().add(jtpTabs, BorderLayout.CENTER);
		this.setResizable(true);
		this.setSize(new Dimension(2000,850));
		this.setTitle("eSpotifai - Server Management");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}


	public void ConfigurationButton(JButton jButton,ImageIcon imageIcon1,ImageIcon imageIcon2,ImageIcon imageIcon3){

		//Definim que l'icon tindrá una imageIcon assignada per defecte
		jButton.setIcon(imageIcon1);

		//Configurem que el botó no tingui marc 
		jButton.setBorderPainted(false);

		//Per a que no es pinti el botó
		jButton.setContentAreaFilled(false);
		jButton.setFocusable(false);
		jButton.setRolloverEnabled(true);

		//Definim l'icon que es mostrará quan l'usuari estigui sobre el botó 
		jButton.setRolloverIcon(imageIcon2);

		//Definim l'icon que es mostrará quan l'usuari premi el botó 
		jButton.setPressedIcon(imageIcon3);

	}

	public void registerController(ButtonsController controller) {
		jbAdd.addActionListener(controller);
		jbAdd.setActionCommand("MainWindow.addActionCommand");

		jbStatistics.addActionListener(controller);
		jbStatistics.setActionCommand("MainWindow.statisticsActionCommand");	
	}
}