package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.ScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controller.PopUpController;
/**
 * Finestra de usuari
 * @author Elna Cabot, Miguel Diaz, Marc Millan, Alejandro Vogel, Marta Zapatero
 * @version 1.0
 * @see JFrame
 *
 */
public class UserWindow extends JFrame{
	/**
	 * Area on es mostrar� el conjunt d'usuaris als que es segueix.
	 * @see JTextArea 
	 */
	private JTextArea jtaFollowing;
	/**
	 * Area on es mostrar� el nom d'usuari.
	 * @see JTextArea
	 */
	private JTextArea jtaUsername;
	private JPopupMenu popupPlaylist;
	private JMenuItem visualitzar;
	private ListSelectionModel modelo;
	private int id = 0; 
	
	
	/**
	 * Construeix la finestra a la cual es mostrar� la informaci� de l'usuari seleccionat. 
	 * @see 
	 */
	public UserWindow(){
		
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
		
		this.getContentPane().add(jpHead, BorderLayout.PAGE_START);
		
	
		
		JPanel jpListsFollowing = new JPanel(new BorderLayout());
		jpListsFollowing.setBorder(BorderFactory.createTitledBorder("Following"));
		
		
		String[] jtFollowedListsColumns = {"id","Following List"};
		Object[][] jtFollowedListsData = {{"1", "ELNA"},{"2","Elna"}};
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
		
	
		
		
		this.getContentPane().add(jpListsFollowing,BorderLayout.CENTER);
		this.getContentPane().setBackground(CustomColor.background);
	
		
		this.setSize(300, 500);
		this.setTitle("Perfil Usuario");
		this.setLocationRelativeTo(null);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	/**
	 * Recarrega la finestra d'usuari
	 * @param string
	 */
	public void refreshUser(String string){
		jtaUsername.setText(string);
	}
	
	public void registerController1(PopUpController controller){
		visualitzar.addActionListener(controller);
		visualitzar.setActionCommand("UserWindow.visualitzarActionCommand");;
	}
	
	
}
