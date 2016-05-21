package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controller.PopUpController;
/**
 * Ventana de "perfil" de un usuari seleccionat
 * @author Elna Cabot, Miguel D�az, Marc Mill�n, Alejandro Vogel, Marta Zapatero
 * @version 1.0
 * @see JFrame
 *
 */
public class SelectedUserWindow extends JFrame {
	
	/**
	 * Area de text on es mostra 
	 * @see JTextArea
	 */
	private JTextArea jtaPlaylist;
	/**
	 * Area de text on es mostra
	 * @see JTextArea
	 */
	private JTextArea jtafollow;
	/**
	 * Area de text on es mostra
	 * @see JTextArea
	 */
	private JTextArea jtaUsername;
	/**
	 * 
	 * @see JButton
	 */
	private JButton jbFollow; 
	/**
	 * Bot� que activa l'acci� de fer "follow" a l'usuari al que pertany el perfil.
	 * @see JButton
	 */
	private JButton jbUnfollow;
	private JPopupMenu popupPlaylist;
	private JMenuItem visualitzar;
	private ListSelectionModel modelo;
	private int id = 0; 
	
	
	
	/**
	 * Constructor de la ventana de l'usuari seleccionat.
	 */
	public SelectedUserWindow(){
		
		JPanel superior = new JPanel();
		superior.setLayout(new GridLayout(2, 1));
		
		
		JPanel jpHead = new JPanel(); 
		jpHead.setLayout(new GridLayout(1, 2));
		JLabel jlUsername = new JLabel("Nickname:");
		jlUsername.setForeground(Color.white);
		jtaUsername = new JTextArea(); 
		jtaUsername.setEditable(false);
		jtaUsername.setBackground(CustomColor.icon);
		jpHead.add(jlUsername, BorderLayout.CENTER);
		jpHead.add(jtaUsername, BorderLayout.CENTER);
		TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.WHITE), "Usuario", javax.swing.border.
			      TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.
			      TitledBorder.DEFAULT_POSITION, null, java.awt.Color.white);
		
		jpHead.setBorder(titledBorder);
		jpHead.setBackground(CustomColor.background);
		superior.add(jpHead);
		
		JPanel jpSecond = new JPanel(); 
		jpSecond.setLayout(new GridLayout(2, 2));
		JLabel jlfollowing = new JLabel("Estado");
		jlfollowing.setForeground(Color.white);
		jtafollow = new JTextArea();
		jtafollow.setBackground(CustomColor.icon);
		jbFollow = new JButton("FOLLOW");
		jbUnfollow = new JButton("UNFOLLOW");
		jpSecond.add(jlfollowing, BorderLayout.CENTER);
		jpSecond.add(jtafollow, BorderLayout.CENTER);
		jpSecond.add(jbFollow, BorderLayout.CENTER);
		jpSecond.add(jbUnfollow, BorderLayout.CENTER);
		jpSecond.setBackground(CustomColor.background);
		TitledBorder titledBorder1 = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.WHITE),"Datos del Usuario", javax.swing.border.
			      TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.
			      TitledBorder.DEFAULT_POSITION, null, java.awt.Color.white);
		
		jpSecond.setBorder(titledBorder1);
		//jpSecond.setBorder(BorderFactory.createTitledBorder("Datos del Usuario"));
		
		superior.add(jpSecond);
		
		
		this.getContentPane().add(superior, BorderLayout.PAGE_START);
		

		JPanel jpListsFollowing = new JPanel(new BorderLayout());
		jpListsFollowing.setBorder(BorderFactory.createTitledBorder("Playlist"));
		
		
		String[] jtFollowedListsColumns = {"id","Playlist"};
		Object[][] jtFollowedListsData = {{"1", "playlist"},{"2","playlist"}};
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
		popupPlaylist.add(visualitzar = new JMenuItem("Visualitzar cançons"));
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
		
	
		
		this.getContentPane().add(jpListsFollowing, BorderLayout.CENTER);
		this.getContentPane().add(jpListsFollowing,BorderLayout.CENTER);
		
		
		
		
		
		
		this.getContentPane().setBackground(CustomColor.background);

		
		this.setSize(300, 500);
		this.setTitle("Perfil Usuario");
		this.setLocationRelativeTo(null);
		
	}
	/**
	 * Controlador de la interacci� de interacci� d'usuari amb la finestra.
	 * @param controller Captura l'acci� que espec�fica l'usuari
	 * @see ActionListener
	 */
	public void registerController(ActionListener controller){
		jbFollow.addActionListener(controller);
		jbUnfollow.addActionListener(controller);
		jbFollow.setActionCommand("FOLLOW");
		jbUnfollow.setActionCommand("UNFOLLOW");
		
	
	}
	
	public void registerController1(PopUpController controller){
		visualitzar.addActionListener(controller);
		visualitzar.setActionCommand("SelectedUserWindow.visualitzarActionCommand");;
	}
	
	
	
	/**
	 * Actualitza continuament la llista de usuaris seguits
	 * @param string 
	 * @see JTextArea
	 */
	public void refreshFollowing(String string){
		jtafollow.setText(string);
	}
	/**
	 * Actualitza la pagina d'usuari seleccionat en la seva totalitat.
	 * @param string
	 * @see JTextArea
	 */
	public void refreshUser(String string){
		jtaUsername.setText(string);
	}
	
}