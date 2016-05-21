package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

import controller.PopUpController;

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
	//private JMenuItem eliminar;
	
	
	
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

		
		// START (jpPageWest)
		JPanel jpPageWest = new JPanel(); 
		jpPageWest.setLayout(new BorderLayout());
		
		JPanel jpListsFollowing = new JPanel(new BorderLayout());
		jpListsFollowing.setBorder(BorderFactory.createTitledBorder("PLAYLIST FOLLOWING"));
		/*jtaListsfollowing = new JTextArea(); 
		jtaListsfollowing.setBackground(CustomColor.icon);
		jtaListsfollowing.setEditable(false);
		JScrollPane jspListsFollowing = new JScrollPane(jtaListsfollowing);
		jspListsFollowing.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		jspListsFollowing.setPreferredSize(new Dimension(250,250));
		*/
		
		//-----------------------------------------------------------------
		
		String[] jtFollowedListsColumns = {"Followed Lists"};
		Object[][] jtFollowedListsData = {{"HOLA"}};
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
		popupPlaylist.add(delate  = new JMenuItem("Eliminar Llista"));
		delate.setHorizontalTextPosition(JMenuItem.RIGHT);
		popupPlaylist.setLabel("Justificacion");
		popupPlaylist.setBorder(new BevelBorder(BevelBorder.RAISED));
		jtFollowedLists.addMouseListener(new MouseAdapter(){
			  public void mousePressed(MouseEvent e) {
		            if ( SwingUtilities.isLeftMouseButton(e)) {
		            	popupPlaylist.setVisible(false);
		            } else {
		                 if ( SwingUtilities.isRightMouseButton(e)) {
		                    Point p = e.getPoint();
		                    int rowNumber = jtFollowedLists.rowAtPoint(p);
		                    ListSelectionModel modelo = jtFollowedLists.getSelectionModel();
		                    modelo.setSelectionInterval( rowNumber, rowNumber );
		            		// id = Integer.parseInt(String.valueOf( jtMusic.getValueAt(rowNumber, 0)));
		            		popupPlaylist.show(jpPageWest,  e.getX(), e.getY());
		            		 
		                }
		            }
		        }
		    });
		
		jtFollowedLists.setModel(tableModelFollowedLists);
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
		
		String[] jtListsColumns1 = {"Lists"};
		Object[][] jtListsData1 = {{"HOLA"}};
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
		                    ListSelectionModel modelo = jtLists.getSelectionModel();
		                    modelo.setSelectionInterval( rowNumber, rowNumber );
		            		// id = Integer.parseInt(String.valueOf( jtMusic.getValueAt(rowNumber, 0)));
		            		popupPlaylist1.show(jpPageWest,  e.getX(), e.getY());
		            		 
		                }
		            }
		        }
		    });
		
		jtLists.setModel(tableModelLists);
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

		reproducir.setHorizontalTextPosition(JMenuItem.RIGHT);
		
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
		                    ListSelectionModel modelo = jtMusic.getSelectionModel();
		                    modelo.setSelectionInterval( rowNumber, rowNumber );
		            		// id = Integer.parseInt(String.valueOf( jtMusic.getValueAt(rowNumber, 0)));
		            		popup.show(jpMain,  e.getX(), e.getY());
		            		 
		                }
		            }
		        }
		    });
		
		jtMusic.setModel(tableMusic);
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
		jbAdd.setActionCommand("MainWindow.addActionCommand");
		jbProfile.setActionCommand("MainWindow.profileActionCommand");
		jbClose.setActionCommand("MainWindow.closeActionCommand");
		jbSearch.setActionCommand("MainWindow.searchActionCommand");
		
		
		
		
	}
	
	public void registerController1(PopUpController controller2){
		reproducir.addActionListener(controller2);

		anadir.addActionListener(controller2);
		visualitzar.addActionListener(controller2);
		delate.addActionListener(controller2);
		reproducir.setActionCommand("MainWindow.reproducirActionCommand");
		anadir.setActionCommand("MainWindow.añadirActionCommand");
		visualitzar.setActionCommand("MainWindow.visualitzarActionCommand");
		delate.setActionCommand("MainWindow.delateActionCommand");

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
	
	
	
	
	
	
	
}