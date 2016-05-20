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
	
	private JTable jpUsers;
	private int id = 0;
	DefaultTableModel tableMusic;
	DefaultTableModel tablePlaylist;
	
	private JMenuItem reproducir;
	private JMenuItem añadir;
	private JMenuItem eliminar;
	private JMenuItem visualitzar;
	private JMenuItem delate;
	//private JMenuItem eliminar;
	
	
	
	
	
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
		jtaListsfollowing = new JTextArea(); 
		jtaListsfollowing.setBackground(CustomColor.icon);
		jtaListsfollowing.setEditable(false);
		JScrollPane jspListsFollowing = new JScrollPane(jtaListsfollowing);
		jspListsFollowing.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		jspListsFollowing.setPreferredSize(new Dimension(250,250));
		jpListsFollowing.add(jspListsFollowing, BorderLayout.CENTER);
		jpListsFollowing.setBackground(CustomColor.secondary);
		jpPageWest.add(jpListsFollowing, BorderLayout.NORTH);
	
		
		//JPanel jpLists = new JPanel();
		//jpLists.setBorder(BorderFactory.createTitledBorder("PLAYLIST"));
		/*String[] columnsplaylist = {"PLAYLIST"};
		Object[][] informationplaylist = {{"playlist1"}};
		JTable jtPlayList = new JTable(informationplaylist, columnsplaylist); 
		tablePlaylist = new DefaultTableModel(informationplaylist, columnsplaylist){
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
		jtPlayList.addMouseListener(new MouseAdapter(){
			  public void mousePressed(MouseEvent e) {
		            if ( SwingUtilities.isLeftMouseButton(e)) {
		            	popupPlaylist.setVisible(false);
		            } else {
		                 if ( SwingUtilities.isRightMouseButton(e)) {
		                    Point p = e.getPoint();
		                    int rowNumber = jtPlayList.rowAtPoint(p);
		                    ListSelectionModel modelo = jtPlayList.getSelectionModel();
		                    modelo.setSelectionInterval( rowNumber, rowNumber );
		            		// id = Integer.parseInt(String.valueOf( jtMusic.getValueAt(rowNumber, 0)));
		            		popupPlaylist.show(jpPageWest,  e.getX(), e.getY());
		            		 
		                }
		            }
		        }
		    });
		jtPlayList.setModel(tableMusic);
		jtPlayList.setFocusable(false);
		JScrollPane jspUsers1 = new JScrollPane(jtPlayList);
		
		jpPageWest.addMouseListener(new MouseAdapter() {
	        public void mousePressed(MouseEvent e) {
	            if ( SwingUtilities.isLeftMouseButton(e)) {
	            	popupPlaylist.setVisible(false);
	            }
	        }
		});
		
		
		
		jpPageWest.add(jspUsers1, BorderLayout.CENTER);
		*/
		
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
		
		popup.add(añadir = new JMenuItem("Afeguir a una Playlist"));
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
		añadir.addActionListener(controller2);
		visualitzar.addActionListener(controller2);
		delate.addActionListener(controller2);
		reproducir.setActionCommand("MainWindow.reproducirActionCommand");
		añadir.setActionCommand("MainWindow.añadirActionCommand");
		visualitzar.setActionCommand("MainWindow.visualitzarActionCommand");
		delate.setActionCommand("MainWindow.delateActionCommand");
	}
	
	
	
	public String getTypedSearch(){
		return jtfSearch.getText();
	}
	
	public String getTypedArtist(){
		return jtfArtist.getText();
	}
	
	public String getTypedAlbum(){
		return jtfArtist.getText();
	}
	
	public String getTypedGenre(){
		return jtfGenre.getText();
	}
	
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
	
	public void refreshListsFollowing(String string){
		jtaListsfollowing.setText(string);
		jtaListsfollowing.setForeground(Color.white);
	}
	
	
	
	
	
	
	
}