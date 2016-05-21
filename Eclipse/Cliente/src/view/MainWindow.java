package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

import controller.PopUpController;
import model.CustomPlayer;
import model.Song;

/**
 * Clase de la ventana principal de l'aplicaci� Espotyfai.
 * @author Elna Cabot, Miguel Diaz, Marc Millan, Alejandro Vogel, Marta Zapatero
 * @version 1.0
 * @see <a>JFrame</a>
 */
public class MainWindow extends JFrame {
	private JTextArea jtaLists; 
	private JTextArea jtaListsfollowing;
	private JButton jbRemove; 
	private JButton jbAdd;
	private JTextField jtfSearch; 
	private JButton jbSearch;
	private JButton jbProfile;
	private JTextField jtfArtist; 
	private JTextField jtfAlbum; 
	private JTextField jtfGenre; 
	private JTextField jtfSongTitle; 
	private JButton jbClose;
	
	public JPopupMenu popup;
	public JPopupMenu popupPlaylist;
	public JPopupMenu popupPlaylist1;
	
	private JTable jpUsers;
	private int id = 0;
	DefaultTableModel tableMusic;
	DefaultTableModel tablePlaylist;
	
	private JMenuItem reproducir;
	private JMenuItem anadir;
	private JMenuItem eliminar;
	private JMenuItem visualitzar;
	private JMenuItem delate;
	private JMenuItem visualitzarPlaylist;
	private JMenuItem delatePlaylist;
	private JMenuItem vot;
	
	//====
	private JPanel jpPlayer; 
	private JPanel jpPlayerButtons; 
	private GridLayout glPlayerButtons; 
	private BorderLayout blPlayer; 
	private CustomPlayer customPlayer;
	private JPanel jpSong;
	private JSlider jSlider;
	private GridLayout glSong;
	
	
	private JButton jbPlay;
	private JButton jbPrevious;
	private JButton jbNext;

	private ImageIcon iiNext1;
	private ImageIcon iiNext2;
	private ImageIcon iiNext3;

	private ImageIcon iiPlay1;
	private ImageIcon iiPlay2;
	private ImageIcon iiPlay3;

	private ImageIcon iiPause1;
	private ImageIcon iiPause2;
	private ImageIcon iiPause3;

	private ImageIcon iiPrevious1;
	private ImageIcon iiPrevious2;
	private ImageIcon iiPrevious3;

	private ListSelectionModel modelo;
	private ListSelectionModel modelo1;
	private ListSelectionModel modelo2;
	//private ImageIcon temporalSong;
	//=====
	
	//=============
		//private JLabel jlTemporalSong;
		private JLabel jlTime;
		//private JLabel SongState;
		private JLabel jlSongName;
		private JLabel jlSongState;

		//private ImageIcon temporalSong;
		private boolean stateSong = false;
		private String state = "";
		private String statePlayer = "";
		private int max = 0, value = 0;
	//==================
	
	/**
	 * Constructor de la pantalla principal.
	 */
	
	public MainWindow(){
		JPanel jpMain = new JPanel(); 
		jpMain.setLayout(new BorderLayout());
	
		//START(jpPageStart)
		JPanel jpPageStart = new JPanel();
		jpPageStart.setLayout(new GridLayout(1, 5));
		
		JLabel jlLogo = new JLabel("ESPOTIFAI");
		jlLogo.setFont(new java.awt.Font("Phosphate", 0, 25)); 
		jlLogo.setForeground(Color.white);
		
		jlLogo.addMouseListener(new MouseAdapter()  
		{  
		    public void mouseClicked(MouseEvent e)  
		    {  
		       // you can open a new frame here as
		       // i have assumed you have declared "frame" as instance variable
		      JOptionPane.showMessageDialog(null, "HOLA GUARRA");

		    }  
		}); 
		
		jpPageStart.add(jlLogo, BorderLayout.CENTER);
		jtfSearch = new JTextField();
		jtfSearch.setBackground(CustomColor.icon);
		jpPageStart.add(jtfSearch, BorderLayout.CENTER);
		jbSearch = new JButton("BUSCAR"); 
		jpPageStart.add(jbSearch, BorderLayout.CENTER);
		jbClose = new JButton("CERRAR SESIÓN"); 
		jpPageStart.add(jbClose, BorderLayout.CENTER);
		jbProfile = new JButton("USUARIO");
		jpPageStart.add(jbProfile, BorderLayout.PAGE_START);
		jpPageStart.setBackground(CustomColor.background);
		
		jpMain.add(jpPageStart, BorderLayout.PAGE_START);
		
		// END jpPageStart
		
		//START (P2)

		// -----------------------------------------------
		
		// START (jpPageWest)
		JPanel jpPageWest = new JPanel(); 
		jpPageWest.setLayout(new BorderLayout());
		
		JPanel jpListsFollowing = new JPanel(new BorderLayout());
		jpListsFollowing.setBorder(BorderFactory.createTitledBorder("PLAYLIST FOLLOWING"));
	
		
		String[] jtFollowedListsColumns = {"id","Followed Lists", "Creador"};
		Object[][] jtFollowedListsData = {{"1","HOLA", "ELNA"},{"2","HOLA1","Elna"}};
		//se crea la tabla
		JTable jtFollowedLists = new JTable(jtFollowedListsData, jtFollowedListsColumns);
		
		//se hace que los datos no sean editables
		DefaultTableModel tableModelFollowedLists = new DefaultTableModel(jtFollowedListsData, jtFollowedListsColumns) {
			@Override
			public boolean isCellEditable(int row, int column) {
				//all cells false
				return false;
			}

		}; 
		
		popupPlaylist = new JPopupMenu();
		popupPlaylist.add(visualitzar = new JMenuItem("Visualitzar llista"));
		visualitzar.setHorizontalTextPosition(JMenuItem.RIGHT);
		popupPlaylist.setLabel("Justificacion");
		popupPlaylist.setBorder(new BevelBorder(BevelBorder.RAISED));
		jtFollowedLists.addMouseListener(new MouseAdapter(){
			  public void mousePressed(MouseEvent e) {
		            if ( SwingUtilities.isLeftMouseButton(e)) {
		            	popupPlaylist.setVisible(false);
		            	System.out.println("hola guarra");
		            	
		            } else {
		                 if ( SwingUtilities.isRightMouseButton(e)) {
		                    Point p = e.getPoint();
		                    int rowNumber = jtFollowedLists.rowAtPoint(p);
		                    modelo = jtFollowedLists.getSelectionModel();
		                    modelo.setSelectionInterval( rowNumber, rowNumber );
		                   // modelo1.clearSelection();
		                   // modelo2.clearSelection();
		            		id = Integer.parseInt(String.valueOf( jtFollowedLists.getValueAt(rowNumber, 0)));
		            		popupPlaylist.show(jpListsFollowing,  e.getX(), e.getY());
		            		 
		                }
		            }
		        }
		    });
		
		
		jtFollowedLists.getTableHeader().setReorderingAllowed(false);
		jtFollowedLists.setModel(tableModelFollowedLists);
		jtFollowedLists.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jtFollowedLists.setFocusable(false);

		JScrollPane jspListsFollowing = new JScrollPane(jtFollowedLists);
		JTable jpFollowedLists = new JTable();
		jpFollowedLists.add(jspListsFollowing, BorderLayout.CENTER);
		jpListsFollowing.add(jspListsFollowing, BorderLayout.CENTER);
		jpListsFollowing.setBackground(CustomColor.secondary);
		jpListsFollowing.setPreferredSize(new Dimension(0, 300));
		jpPageWest.add(jpListsFollowing, BorderLayout.NORTH);
		
		//-----------------------------------------------------------------
		
		JPanel jpLists = new JPanel(new BorderLayout());
		jpLists.setBorder(BorderFactory.createTitledBorder("PLAYLIST "));
		
		String[] jtListsColumns1 = {"id","Lists"};
		Object[][] jtListsData1 = {{"1","HOLA"}};
		//se crea la tabla
		JTable jtLists = new JTable(jtListsData1, jtListsColumns1);

		//se hace que los datos no sean editables
		DefaultTableModel tableModelLists = new DefaultTableModel(jtListsData1, jtListsColumns1) {
			@Override
			public boolean isCellEditable(int row, int column) {
				//all cells false
				return false;
			}

		}; 
		
		popupPlaylist1 = new JPopupMenu();
		popupPlaylist1.add(visualitzarPlaylist = new JMenuItem("Visualitzar llista"));
		visualitzarPlaylist.setHorizontalTextPosition(JMenuItem.RIGHT);
		popupPlaylist1.add(delatePlaylist  = new JMenuItem("Eliminar Llista"));
		delatePlaylist.setHorizontalTextPosition(JMenuItem.RIGHT);
		popupPlaylist1.setLabel("Justificacion");
		popupPlaylist1.setBorder(new BevelBorder(BevelBorder.RAISED));
		jtLists.addMouseListener(new MouseAdapter(){
			  public void mousePressed(MouseEvent e) {
				  if ( SwingUtilities.isLeftMouseButton(e)) {
		            	popupPlaylist1.setVisible(false);

		            	
		            } else {
		                 if ( SwingUtilities.isRightMouseButton(e)) {
		                    Point p = e.getPoint();
		                    int rowNumber = jtLists.rowAtPoint(p);
		                    modelo1 = jtLists.getSelectionModel();
		                    modelo1.setSelectionInterval( rowNumber, rowNumber );
		                    //modelo.clearSelection();
		                    //modelo2.clearSelection();
		            		// id = Integer.parseInt(String.valueOf( jtMusic.getValueAt(rowNumber, 0)));
		            		popupPlaylist1.show(jpLists,  e.getX(), e.getY());
		            		 
		                }
		            }
		        }
		    });
		
		jtLists.getTableHeader().setReorderingAllowed(false);
		jtLists.setModel(tableModelLists);
		jtLists.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jtLists.setFocusable(false);

		JScrollPane jspLists = new JScrollPane(jtLists);
		JTable jpListsPlaylist = new JTable();
		jpListsPlaylist.add(jspLists, BorderLayout.CENTER);
		jpLists.add(jspLists, BorderLayout.CENTER);
		jpLists.setBackground(CustomColor.secondary);
		jpLists.setPreferredSize(new Dimension(250, 0));
		jpPageWest.add(jpLists, BorderLayout.CENTER);
		
		/*
		JPanel jpLists = new JPanel();
		jpLists.setBorder(BorderFactory.createTitledBorder("PLAYLIST"));
		jtaLists = new JTextArea(); 
		jtaLists.setBackground(CustomColor.icon);
		jtaLists.setEditable(false);
		JScrollPane jspLists = new JScrollPane(jtaLists);
		jspLists.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		jspLists.setPreferredSize(new Dimension(250,250));
		jpLists.add(jspLists, BorderLayout.CENTER);
		jpLists.setBackground(CustomColor.secondary);
		jpPageWest.add(jpLists, BorderLayout.CENTER); //INSERIM PANELL 1 LLISTAT DE MUSICA
		*/
		
		
		
		// ----------------------------------------------------------------
	
		jbAdd = new JButton(" + Nueva Lista");
		
		
		jpPageWest.add(jbAdd, BorderLayout.SOUTH);
		jpPageWest.setBackground(CustomColor.secondary);
		
		//END (jpPageWest)
		jpMain.add(jpPageWest, BorderLayout.WEST);
		
		//START jpPageCenter
		
		String[] columns = {"NOMBRE", "GÉNERO", "ALBUM", "ARTISTA", "ESTRELLAS", "REPRODUCCIONES"};
		Object[][] information = {{"Idiota", "Rock", "Ninguno", "Elna", "5", "1000000"}};
		JTable jtMusic = new JTable(information, columns);
		tableMusic = new DefaultTableModel(information, columns){
			@Override
			public boolean isCellEditable(int row, int column) {
				//all cells false
				return false;
			}
		};
		
		popup = new JPopupMenu();
		popup.add(reproducir = new JMenuItem("Reproduir Canço"));
		reproducir.setHorizontalTextPosition(JMenuItem.RIGHT);
		popup.add(anadir = new JMenuItem("Afeguir a una Playlist"));
		anadir.setHorizontalTextPosition(JMenuItem.RIGHT);
		popup.add(vot = new JMenuItem("Votar per la canço"));
		vot.setHorizontalTextPosition(JMenuItem.RIGHT);
		
		//popup.add(reproducir = new JMenuItem("Eliminar Canço", new ImageIcon("1.gif")));
		//reproducir.setHorizontalTextPosition(JMenuItem.RIGHT);
		
		popup.setLabel("Justificacion");
		popup.setBorder(new BevelBorder(BevelBorder.RAISED));
		
		jtMusic.addMouseListener(new MouseAdapter(){
			  public void mousePressed(MouseEvent e) {
		            if ( SwingUtilities.isLeftMouseButton(e)) {
		            	popup.setVisible(false);
		            } else {
		                 if ( SwingUtilities.isRightMouseButton(e)) {
		                    Point p = e.getPoint();
		                    int rowNumber = jtMusic.rowAtPoint(p);
		                    modelo2 = jtMusic.getSelectionModel();
		                    modelo2.setSelectionInterval( rowNumber, rowNumber );
		                    //modelo.clearSelection();
		                    //modelo1.clearSelection();
		            		// id = Integer.parseInt(String.valueOf( jtMusic.getValueAt(rowNumber, 0)));
		            		popup.show(jpMain,  e.getX(), e.getY());
		            		 
		                }
		            }
		        }
			  
		    });
		
		jtMusic.getTableHeader().setReorderingAllowed(false);
		jtMusic.setModel(tableMusic);
		jtMusic.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jtMusic.setFocusable(false);
		
		JScrollPane jspUsers = new JScrollPane(jtMusic);
		
	
		 jpMain.addMouseListener(new MouseAdapter() {
		        public void mousePressed(MouseEvent e) {
		            if ( SwingUtilities.isLeftMouseButton(e)) {
		            	popup.setVisible(false);
		            }
		        }
		  });
		 
		  jpMain.add(jspUsers, BorderLayout.CENTER);
		  
		 //-------------------------------------------------------
		  
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
			glSong = new GridLayout(1,2);
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

			jpPlayer.add(jpSong, BorderLayout.NORTH);
			jpPlayer.add(jpPlayerButtons, BorderLayout.WEST);
			//jpPlayer.add(jlTemporalSong, BorderLayout.CENTER);
			jpPlayer.add(jSlider, BorderLayout.CENTER);
			jpPlayer.add(jlTime, BorderLayout.EAST);
			
		jpMain.add(jpPlayer, BorderLayout.SOUTH) ;
		//jpMain.setPreferredSize(new Dimension(0, 130));
		
		this.getContentPane().add(jpMain, BorderLayout.CENTER);
		
		this.setResizable(true);
		this.setSize(1280, 720);
		this.setTitle("Espotifai");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	/**
	 * 
	 * @param controller 
	 * @see ActionListener
	 */
	
	public void registerController(ActionListener controller){
		jbAdd.addActionListener(controller);
		jbProfile.addActionListener(controller);
		jbClose.addActionListener(controller);
		jbSearch.addActionListener(controller);
		jbPlay.addActionListener(controller);
		jbAdd.setActionCommand("MainWindow.addActionCommand");
		jbProfile.setActionCommand("MainWindow.profileActionCommand");
		jbClose.setActionCommand("MainWindow.closeActionCommand");
		jbSearch.setActionCommand("MainWindow.searchActionCommand");
		jbPlay.setActionCommand("MainWindow.playActionCommand");
		
		
		
		
	}
	
	public void registerController1(PopUpController controller2){
		reproducir.addActionListener(controller2);
		anadir.addActionListener(controller2);
		visualitzar.addActionListener(controller2);
		delatePlaylist.addActionListener(controller2);
		vot.addActionListener(controller2);
		visualitzarPlaylist.addActionListener(controller2);
		
		reproducir.setActionCommand("MainWindow.reproducirActionCommand");
		anadir.setActionCommand("MainWindow.anadirActionCommand");
		visualitzar.setActionCommand("MainWindow.visualitzarActionCommand");
		delatePlaylist.setActionCommand("MainWindow.delatePlaylistActionCommand");
		vot.setActionCommand("MainWindow.votActionCommand");
		visualitzarPlaylist.setActionCommand("MainWindow.visualitzarPlaylitsActionCommand");
		
	}
	

	
	
	/**
	 * 
	 * @return
	 */

	public String getTypedSearch(){
		return jtfSearch.getText();
	}
	/**
	 * 
	 * @return
	 */
	public String getTypedArtist(){
		return jtfArtist.getText();
	}
	/**
	 * 
	 * @return
	 */
	public String getTypedAlbum(){
		return jtfArtist.getText();
	}
	/**
	 * 
	 * @return
	 */
	public String getTypedGenre(){
		return jtfGenre.getText();
	}
	/**
	 * 
	 * @return
	 */
	public String getTypedSongTitle(){
		return jtfSongTitle.getText();
	}
	
	public void refreshUsers(LinkedList <Object[]> list){
		while (tablePlaylist.getRowCount()!= 0){
			tablePlaylist.removeRow(0);
		}
		for (int i = 0; i<list.size(); i++){
			tablePlaylist.addRow(list.get(i));
		}
	}
	
	public void refreshMusic(LinkedList<Object[]> list){
		while (tableMusic.getRowCount()!= 0){
			tableMusic.removeRow(0);
		}
		for (int i = 0; i<list.size(); i++){
			tableMusic.addRow(list.get(i));
		}
	}

	/**
	 * 
	 * @param string
	 */
	public void refreshLists(String string){
		jtaLists.setText(string);

	}
	
	public void refreshListsFollowing(String string){
		//jtaListsfollowing.setText(string);
		//jtaListsfollowing.setForeground(Color.white);
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

	
	
	public void goMP3() throws Exception{

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
				String songLink = "C:/Users/Marta/Music/Mystery Skulls - Money.mp3";

				customPlayer.abrirMp3(songLink);
				state = customPlayer.play(jSlider);

			}catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
			stateSong = true;
			ConfigurationButton(jbPlay, iiPause1, iiPause2, iiPause3);
			jlSongName.setText(customPlayer.getName());

		}
		/*//Si el player est� parat i fa clik
		if (player.isEnded()){

			try{

				//Creo un reproductor un altre cop ja que internament el BasicPlayer ha fet un closeStrem();
				player = new Player();

				System.out.println("\nENTRO EN EL VISUALITZADOR DE CAN�O PER SEGON COP\n");
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
	
	public void changeButtonToPlay(){

		if( getState() == 2){

			ConfigurationButton(jbPlay, iiPlay1, iiPlay2, iiPlay3);
			jlSongState.setForeground(new Color(255,255,255));
			jlSongState.setText("           --> CLICK PLAY TO LISTEN THE SONG <--");

		}
	}
	
	
	
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

		//jlTime.setText(String.valueOf(player.getMinutes() + ":" + player.getSeconds()));
	}
		
	public void refreshSongs(LinkedList<Song> songsList) {
		
		LinkedList<Object[]> list = new LinkedList<Object[]>();
		for (int i = 0; i < songsList.size(); i++){
			Object[] objs = {songsList.get(i).getName(), songsList.get(i).getGenre(),
							songsList.get(i).getAlbum(), songsList.get(i).getArtist(), 
							songsList.get(i).getStars(), songsList.get(i).getReproductions()};
			list.add(objs);
		}
		
		while (tableMusic.getRowCount()!= 0){
			tableMusic.removeRow(0);
		}
		for (int i = 0; i<list.size(); i++){
			tableMusic.addRow(list.get(i));
		}
		
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
	
	
	
	
	
}