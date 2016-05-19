package view;

import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
//import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import model.User;
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
	private GridLayout glPlayerButtons;
	private GridLayout glPageEnd;
	private BorderLayout blMusic;
	private BorderLayout blPlayer;

	//private JTextArea jtListOfSongs;
	private JScrollPane jspMusicList;
	private JSlider jSlider;
	
	private JButton jbAdd;
	private JButton jbStatistics;
	private JButton jbPlay;
	private JButton jbPrevious;
	private JButton jbNext;

	private ImageIcon iiNext1;
	private ImageIcon iiNext2;
	private ImageIcon iiNext3;

	private ImageIcon iiPlay1;
	private ImageIcon iiPlay2;
	private ImageIcon iiPlay3;

	//private JLabel jlTemporalSong;
	private JLabel jlTime;
	//private JLabel SongState;
	private JLabel jlSongName;

	private ImageIcon iiPrevious1;
	private ImageIcon iiPrevious2;
	private ImageIcon iiPrevious3;
	//private ImageIcon temporalSong;
	
	Object[][] jtUserDataController = new Object[][]{};
	Object[][] jtUserData = {{"1","Prueba1","","","","","",""},{"2","Prueba2","","","","","",""},{"3","Prueba3","","","","","",""}};
	DefaultTableModel tableModelUser;
	JTable jtUser;

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
		String[] jtMusicColumns = {"Name", "Genre", "Album", "Artist"};
		Object[][] jtMusicData = {{"El tractor amarillo", "Pop", "Zapato Veloz", "Manuel Calderon"},{"Cantando", "Rap", "Vivir para contarlo", "Kase O"},{"Ballantines", "Rap", "Vicios y Virtudes", "Kase O"},{"Set Me Free", "Electro House", "The Remixes Part 1", "Martin Garrix"},{"Ballantines", "Rap", "Vicios y Virtudes", "Kase O"},{"Set Me Free", "Electro House", "The Remixes Part 1", "Martin Garrix"},{"Ballantines", "Rap", "Vicios y Virtudes", "Kase O"},{"Set Me Free", "Electro House", "The Remixes Part 1", "Martin Garrix"},{"Ballantines", "Rap", "Vicios y Virtudes", "Kase O"},{"Set Me Free", "Electro House", "The Remixes Part 1", "Martin Garrix"},{"Ballantines", "Rap", "Vicios y Virtudes", "Kase O"},{"Set Me Free", "Electro House", "The Remixes Part 1", "Martin Garrix"},{"Ballantines", "Rap", "Vicios y Virtudes", "Kase O"},{"Set Me Free", "Electro House", "The Remixes Part 1", "Martin Garrix"},{"Ballantines", "Rap", "Vicios y Virtudes", "Kase O"},{"Set Me Free", "Electro House", "The Remixes Part 1", "Martin Garrix"},{"Ballantines", "Rap", "Vicios y Virtudes", "Kase O"},{"Set Me Free", "Electro House", "The Remixes Part 1", "Martin Garrix"},{"Ballantines", "Rap", "Vicios y Virtudes", "Kase O"},{"Set Me Free", "Electro House", "The Remixes Part 1", "Martin Garrix"},{"Ballantines", "Rap", "Vicios y Virtudes", "Kase O"},{"Set Me Free", "Electro House", "The Remixes Part 1", "Martin Garrix"},{"Ballantines", "Rap", "Vicios y Virtudes", "Kase O"},{"Set Me Free", "Electro House", "The Remixes Part 1", "Martin Garrix"},{"Ballantines", "Rap", "Vicios y Virtudes", "Kase O"},{"Set Me Free", "Electro House", "The Remixes Part 1", "Martin Garrix"},{"Ballantines", "Rap", "Vicios y Virtudes", "Kase O"},{"Set Me Free", "Electro House", "The Remixes Part 1", "Martin Garrix"},{"Ballantines", "Rap", "Vicios y Virtudes", "Kase O"},{"Set Me Free", "Electro House", "The Remixes Part 1", "Martin Garrix"},{"Ballantines", "Rap", "Vicios y Virtudes", "Kase O"},{"Set Me Free", "Electro House", "The Remixes Part 1", "Martin Garrix"},{"Ballantines", "Rap", "Vicios y Virtudes", "Kase O"},{"Set Me Free", "Electro House", "The Remixes Part 1", "Martin Garrix"},{"Ballantines", "Rap", "Vicios y Virtudes", "Kase O"},{"Set Me Free", "Electro House", "The Remixes Part 1", "Martin Garrix"},{"Ballantines", "Rap", "Vicios y Virtudes", "Kase O"},{"Set Me Free", "Electro House", "The Remixes Part 1", "Martin Garrix"},{"Ballantines", "Rap", "Vicios y Virtudes", "Kase O"},{"Set Me Free", "Electro House", "The Remixes Part 1", "Martin Garrix"},{"Ballantines", "Rap", "Vicios y Virtudes", "Kase O"},{"Set Me Free", "Electro House", "The Remixes Part 1", "Martin Garrix"},{"Ballantines", "Rap", "Vicios y Virtudes", "Kase O"},{"Set Me Free", "Electro House", "The Remixes Part 1", "Martin Garrix"},{"Ballantines", "Rap", "Vicios y Virtudes", "Kase O"},{"Set Me Free", "Electro House", "The Remixes Part 1", "Martin Garrix"},{"Ballantines", "Rap", "Vicios y Virtudes", "Kase O"},{"Set Me Free", "Electro House", "The Remixes Part 1", "Martin Garrix"},{"Ballantines", "Rap", "Vicios y Virtudes", "Kase O"},{"Set Me Free", "Electro House", "The Remixes Part 1", "Martin Garrix"},{"Ballantines", "Rap", "Vicios y Virtudes", "Kase O"},{"Set Me Free", "Electro House", "The Remixes Part 1", "Martin Garrix"},{"Ballantines", "Rap", "Vicios y Virtudes", "Kase O"},{"Set Me Free", "Electro House", "The Remixes Part 1", "Martin Garrix"},{"Ballantines", "Rap", "Vicios y Virtudes", "Kase O"},{"Set Me Free", "Electro House", "The Remixes Part 1", "Martin Garrix"},{"Ballantines", "Rap", "Vicios y Virtudes", "Kase O"},{"Set Me Free", "Electro House", "The Remixes Part 1", "Martin Garrix"},{"Ballantines", "Rap", "Vicios y Virtudes", "Kase O"},{"Set Me Free", "Electro House", "The Remixes Part 1", "Martin Garrix"},{"Ballantines", "Rap", "Vicios y Virtudes", "Kase O"},{"Set Me Free", "Electro House", "The Remixes Part 1", "Martin Garrix"},{"Ballantines", "Rap", "Vicios y Virtudes", "Kase O"},{"Set Me Free", "Electro House", "The Remixes Part 1", "Martin Garrix"},{"Ballantines", "Rap", "Vicios y Virtudes", "Kase O"},{"Set Me Free", "Electro House", "The Remixes Part 1", "Martin Garrix"},{"Ballantines", "Rap", "Vicios y Virtudes", "Kase O"},{"Set Me Free", "Electro House", "The Remixes Part 1", "Martin Garrix"},{"Ballantines", "Rap", "Vicios y Virtudes", "Kase O"},{"Set Me Free", "Electro House", "The Remixes Part 1", "Martin Garrix"},{"Ballantines", "Rap", "Vicios y Virtudes", "Kase O"},{"Set Me Free", "Electro House", "The Remixes Part 1", "Martin Garrix"}};
		//se crea la tabla
		JTable jtMusicList = new JTable(jtMusicData, jtMusicColumns);

		//se hace que los datos no sean editables
		DefaultTableModel tableModelMusic = new DefaultTableModel(jtMusicData, jtMusicColumns) {
			@Override
			public boolean isCellEditable(int row, int column) {
				//all cells false
				return false;
			}
		}; 
		jtMusicList.setModel(tableModelMusic);
		jtMusicList.setForeground(Color.BLACK);
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
		jpPageEnd = new JPanel();
		jpPageEnd.setPreferredSize(new Dimension(400,90));			

		//Estructura de panell de 2 files per 1 columna
		glPageEnd = new GridLayout(2,1);
		jpPageEnd.setLayout(glPageEnd);

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
		
		jpPageEnd.add(jpButtons);

		/*
		 * AQUI S'HA DE CREAR EL REPRODUCTOR !!
		 */
		//Estructura de subsubpanell nom�s de botons del reproductor
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
		jSlider.setPreferredSize(new Dimension(700, 20));

		//Creem etiqueta de la can�� que est� sonant y de l'estat d'aquesta
		jlSongName = new JLabel();
		jlSongName.setForeground(new Color(0, 0, 0));
		jlSongName.setText("          Lalalla Song" + "                      --> STOPED <--");
		
		jpPlayer.add(jlSongName, BorderLayout.NORTH);
		jpPlayer.add(jpPlayerButtons, BorderLayout.WEST);
		//jpPlayer.add(jlTemporalSong, BorderLayout.CENTER);
		jpPlayer.add(jSlider, BorderLayout.CENTER);
		jpPlayer.add(jlTime, BorderLayout.EAST);

		jpPageEnd.add(jpPlayer);

		jpMusic.add(jpPageEnd, BorderLayout.PAGE_END);


		//TAB USERS

		//table
		//hardcodeo de columnas y datos 
		String[] jtUserColumns = {"id","Username", "Register date", "Last login", "Song lists", "Songs", "Followers", "Following"};
		
		
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
		
		jtUser.addMouseListener(new MouseAdapter() {
	        public void mousePressed(MouseEvent e) {
	            if ( SwingUtilities.isLeftMouseButton(e)) {
	               
	            } else {
	                 if ( SwingUtilities.isRightMouseButton(e)) {
	                    Point p = e.getPoint();
	                    int rowNumber = jtUser.rowAtPoint( p );
	                    ListSelectionModel modelo = jtUser.getSelectionModel();
	                    modelo.setSelectionInterval( rowNumber, rowNumber );
	                    System.out.println ("Informacion seleccionada: "+modelo.getSelectionMode());
	                	
	                    
	                  
	            		String valores="";
	         
	            		 String valor = String.valueOf(jtUser.getValueAt(rowNumber, 0));
	            	
	            		JOptionPane.showMessageDialog(null, "valores de la columna1: " +valor);
	  
	                	
	                }
	            }
	        }
	    });

		jtUser.setModel(tableModelUser);
		jtUser.setFocusable(false);
	
		
		JScrollPane jspUsers = new JScrollPane(jtUser);
		jpUsers = new JPanel();
		jpUsers.add(jspUsers, BorderLayout.CENTER);

		//Incloeixo les pesta�es a la finestra
		jtpTabs.addTab("Music", jpMusic);
		jtpTabs.addTab("Users", jspUsers);

		this.getContentPane().add(jtpTabs, BorderLayout.CENTER);
		this.setResizable(true);
		this.setSize(new Dimension(1600,870));
		this.setTitle("eSpotifai - Server Management");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
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

	public void registerController(ButtonsController controller) {
		jbAdd.addActionListener(controller);
		jbAdd.setActionCommand("MainWindow.addActionCommand");

		jbStatistics.addActionListener(controller);
		jbStatistics.setActionCommand("MainWindow.statisticsActionCommand");	
		
		
	}
	
	public void refreshUsers(LinkedList <Object[]> list){
		while (tableModelUser.getRowCount()!= 0){
			tableModelUser.removeRow(0);
		}
		for (int i = 0; i<list.size(); i++){
			tableModelUser.addRow(list.get(i));
		}
	}
}
