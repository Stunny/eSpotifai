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
import model.Playlist;
import model.Song;

/**
 * Clase de la ventana principal de l'aplicaci� Espotyfai.
 * @author Elna Cabot, Miguel Diaz, Marc Millan, Alejandro Vogel, Marta Zapatero
 * @version 1.0
 * @see JFrame
 * 
 */
public class MainWindow extends JFrame {
	/**
	 * Area de text on es mostren les <i>playlists</i> de l'usuari.
	 * @see JTextArea
	 */
	private JTextArea jtaLists; 
	/**
	 * Bot� per a afegir una nova llista.
	 * @see JButton
	 */
	private JButton jbAdd;
	/**
	 * Area de text per introduir les paraules de les que es vol fer una cerca.
	 * @see JTextField
	 */
	private JTextField jtfSearch; 
	/**
	 * Acciona la cerca del que s'ha introduit a <i style="color:indigo;">jtfSearch</i>.
	 * @see JButton
	 */
	private JButton jbSearch;
	/**
	 * Bot� que obre la finestra <i style="color:indigo;">UserWindow</i>
	 * @see JButton
	 * @see UserWindow
	 */
	private JButton jbProfile;
	/**
	 * Taula on es mostra la llista de can�ons amb els detalls de cadascuna.
	 * @see JTable
	 */
	/**
	 * Bot� per que l'usuari indiqui que vol tancar la sessi�
	 * @see JButton
	 */
	private JButton jbClose;
	
	public JPopupMenu popup;
	public JPopupMenu popupPlaylist;
	public JPopupMenu popupPlaylist1;
	
	private String id = "";
	DefaultTableModel tableMusic;
	DefaultTableModel tablePlaylist;
	DefaultTableModel tableModelLists;
	DefaultTableModel tableModelFollowedLists;
	private int idUser = 0; 
	
	private JMenuItem reproducir;
	private JMenuItem anadir;
	private JMenuItem visualitzar;
	private JMenuItem visualitzarPlaylist;
	private JMenuItem delatePlaylist;
	private JMenuItem vot;
	private JMenuItem modificar;
	
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

	private ListSelectionModel modelo1;
	private ListSelectionModel modelo2;
	
	private String mode= "all";

	
	//DefaultTableModel tableModelLists;
	
	
	private String user;

	//private ImageIcon temporalSong;
	//=====
	
	//=============
		//private JLabel jlTemporalSong;
		private JLabel jlTime;
		//private JLabel SongState;
		private JLabel jlSongName;
		private JLabel jlSongState;

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
		Object[][] jtFollowedListsData = {};
		//se crea la tabla
		JTable jtFollowedLists = new JTable(jtFollowedListsData, jtFollowedListsColumns);
		
		//se hace que los datos no sean editables
		tableModelFollowedLists = new DefaultTableModel(jtFollowedListsData, jtFollowedListsColumns) {
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
		                    ListSelectionModel modelo = jtFollowedLists.getSelectionModel();
		                    modelo.setSelectionInterval( rowNumber, rowNumber );
		                   // modelo1.clearSelection();
		                   // modelo2.clearSelection();
		                    id =   String.valueOf( jtFollowedLists.getValueAt(rowNumber, 0));
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
		tableModelLists = new DefaultTableModel(jtListsData1, jtListsColumns1) {
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
		popupPlaylist1.add(modificar = new JMenuItem("Modificar Llista"));
		modificar.setHorizontalTextPosition(JMenuItem.RIGHT);
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
		                    id =  String.valueOf( jtLists.getValueAt(rowNumber, 0));
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
	 * Controlador de interacci� de l'usuari amb MainWindow
	 * @param controller Listener que captura la acci� que l'usuari vol dur a terme
	 * @see ActionListener
	 */
	
	public void registerController(ActionListener controller){
		jbAdd.addActionListener(controller);
		jbProfile.addActionListener(controller);
		jbClose.addActionListener(controller);
		jbSearch.addActionListener(controller);
		jbPlay.addActionListener(controller);
		jbNext.addActionListener(controller);
		jbPrevious.addActionListener(controller);
		jbAdd.setActionCommand("MainWindow.addActionCommand");
		jbProfile.setActionCommand("MainWindow.profileActionCommand");
		jbClose.setActionCommand("MainWindow.closeActionCommand");
		jbSearch.setActionCommand("MainWindow.searchActionCommand");
		jbPlay.setActionCommand("MainWindow.playActionCommand");
		jbNext.setActionCommand("MainWindow.nextActionCommand");
		jbPrevious.setActionCommand("MainWindow.previousActionCommand");
		
		
		
	}
	
	public void registerController1(PopUpController controller2){
		reproducir.addActionListener(controller2);
		anadir.addActionListener(controller2);
		visualitzar.addActionListener(controller2);
		delatePlaylist.addActionListener(controller2);
		vot.addActionListener(controller2);
		visualitzarPlaylist.addActionListener(controller2);
		modificar.addActionListener(controller2);
		
		reproducir.setActionCommand("MainWindow.reproducirActionCommand");
		anadir.setActionCommand("MainWindow.anadirActionCommand");
		visualitzar.setActionCommand("MainWindow.visualitzarActionCommand");
		delatePlaylist.setActionCommand("MainWindow.delatePlaylistActionCommand");
		vot.setActionCommand("MainWindow.votActionCommand");
		visualitzarPlaylist.setActionCommand("MainWindow.visualitzarPlaylitsActionCommand");
		modificar.setActionCommand("MainWindow.modificarActionCommand");
	}
	

	
	
	/**
	 * Getter de la String introduida al camp de cerca
	 * @return
	 */

	public String getTypedSearch(){
		return jtfSearch.getText();
	}
	
	
	public void refreshPlaylist(LinkedList <Object[]> list){
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
	 * Actualitza continuament la llista de playlists mostrada.
	 * @param string
	 * @see JTextArea
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

			//Si la can�o s'est� reproduint pula pausa PLAY
		}else if (customPlayer.getStatus() == 0){

			//}else if (stateSong){

			customPlayer.pause();
			ConfigurationButton(jbPlay, iiPlay1, iiPlay2, iiPlay3);
		}else {//if (player.getStatus() == 2 || (player.getStatus() != 0 && player.getStatus() != 1)){
			//Si no ha arrancat encara la can�o obre el fitxer mp3
			//}else{
			try{

				//Creo un reproductor
				//player = new Player();

				//String songLink = "C:/Users/Marc/Downloads/Quentin Tarantino Soundtracks Discography - HTD 2015/Pulp Fiction (Collector's Edition) (2009) - Soundtrack/04. Let's Stay Together.mp3";
				//String songLink = "C:/Users/Marc/Downloads/Quentin Tarantino Soundtracks Discography - HTD 2015/Pulp Fiction (Collector's Edition) (2009) - Soundtrack/14. Personality Goes a Long Way.mp3";
				//String songLink = "C:/Users/Marc/Downloads/grillos05_mp3.mp3";
				//String songLink = "/Users/elnacabotparedes/Music/iTunes/iTunes Media/Music/Martin Garrix/Unknown Album/01 Poison.mp3";
				String songLink = "C:/Users/Marta/Music/Mystery_Skulls_-Magic.mp3";

				customPlayer.abrirMp3(songLink);
				customPlayer.playPlayer(jSlider);

			}catch (Exception ex) {
				System.out.println("Error: " + ex.getMessage());
			}
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
	
public void refreshPlaylists(LinkedList<Playlist> playlistList) {
	LinkedList<Playlist> playlistListUser = new LinkedList<Playlist>();
	
	for (int i = 0; i<playlistList.size(); i++){
		if (playlistList.get(i).getUsername().equals(user)){
			playlistListUser.add(playlistList.get(i));
		}
	}
		LinkedList<Object[]> list = new LinkedList<Object[]>();
		for (int i = 0; i < playlistListUser.size(); i++){
			Object[] objs = {playlistListUser.get(i).getId(), playlistListUser.get(i).getName()};
			list.add(objs);
		}
		
		while (tableModelLists.getRowCount()!= 0){
			tableModelLists.removeRow(0);
		}
		for (int i = 0; i<list.size(); i++){
			tableModelLists.addRow(list.get(i));
		}
		
	}

	public void refreshPublicPlaylists(LinkedList<Playlist> playlistList) {
		LinkedList<Object[]> list = new LinkedList<Object[]>();
		for (int i = 0; i < playlistList.size(); i++){
			Object[] objs = {playlistList.get(i).getId(), playlistList.get(i).getName(), playlistList.get(i).getUsername()};
			list.add(objs);
		}
		while (tableModelFollowedLists.getRowCount()!= 0){
			tableModelFollowedLists.removeRow(0);
		}
		for (int i = 0; i<list.size(); i++){
			tableModelFollowedLists.addRow(list.get(i));
		}
		
	}



	public String getId() {
		return id;
	}


	public void  setId(String id) {
		this.id = id;
	}
	
	public void setUser (String user){
		this.user = user;
	}
	
	public int getSongAtIndex(int index) {
		return Integer.parseInt((String) tableMusic.getValueAt(index, 0));
	}
	
	public int getSongAmount() {
		return tableMusic.getRowCount();
	}
	public int getUserId(){
		return idUser;
	}
	
	public void setUserId (int id){
		this.idUser = id;
	}
	
	public void setMode (String modo){
		this.mode = modo;
	}
	
	public String getMode (){
		return mode;	}
	
}