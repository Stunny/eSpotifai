package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
/**
 * 
 * A partir d'un usuari retorna una <i>playlist</i>.
 * @author Elna Cabot, Miguel Díaz, Marc Millán, Alejandro Vogel, Marta Zapatero
 * 
 * @version 1.0
 * @see JPanel
 * @see JTable
 * @see DefaultTableModel
 * @see JScrollPane
 * @see JFrame
 * @see JMenuItem
 * @see JPopupMenu
 * @see ListSelectionModel
 *
 */
import controller.PopUpController;
import model.Playlist;

public class PlaylistSearchUser extends JFrame{
	/**
	 * Menu emergent
	 * @see JPopupMenu
	 */
	private JPopupMenu popupPlaylist;
	/**
	 * Opcio dins del menu emergent
	 * @see JMenuItem
	 * @see JPopupMenu
	 */
	private JMenuItem visualitzar;
	/**
	 * Llista de selecció
	 * @see ListSelectionModel
	 */
	private ListSelectionModel modelo;
	/**
	 * IDentificador de la <i>Playlist</i>
	 */
	private String id = ""; 
	private JButton before; 
	DefaultTableModel tableModelFollowedLists;
	
	/**
	 * Retorna una llista de cançons a partir d'un usuari seleccionat.
	 */
	public PlaylistSearchUser(){
		JPanel jpListsFollowing = new JPanel(new BorderLayout());
		
		jpListsFollowing.setBorder(BorderFactory.createTitledBorder("Following"));
		
		
		String[] jtFollowedListsColumns = {"id","Followed Lists"};
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
		popupPlaylist.add(visualitzar = new JMenuItem("View List"));
		visualitzar.setHorizontalTextPosition(JMenuItem.RIGHT);
		popupPlaylist.setLabel("Justificacion");
		popupPlaylist.setBorder(new BevelBorder(BevelBorder.RAISED));
		jtFollowedLists.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e) {
				if ( SwingUtilities.isLeftMouseButton(e)) {
					popupPlaylist.setVisible(false);
					//System.out.println("hola guarra");

				} else {
					if ( SwingUtilities.isRightMouseButton(e)) {
						Point p = e.getPoint();
						int rowNumber = jtFollowedLists.rowAtPoint(p);
						modelo = jtFollowedLists.getSelectionModel();
						modelo.setSelectionInterval( rowNumber, rowNumber );
						// modelo1.clearSelection();
						// modelo2.clearSelection();
						id = (String) jtFollowedLists.getValueAt(rowNumber, 0);
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

		before = new JButton("Back");
		this.getContentPane().add(before, BorderLayout.SOUTH);


		this.setSize(300, 500);
		this.setTitle("User Playlist");
		this.setLocationRelativeTo(null);
	}

	public void registerController(PopUpController controller){
		before.addActionListener(controller);
		before.setActionCommand("PlaylistSearchUser.beforeActionCommand");
		visualitzar.addActionListener(controller);
		visualitzar.setActionCommand("PlaylistSearchUser.visualitzarActionCommand");
		
	}
	
	
	
	public void refreshPlaylists(LinkedList<Playlist> playlistList) {
		LinkedList<Object[]> list = new LinkedList<Object[]>();
		for (int i = 0; i < playlistList.size(); i++){
			Object[] objs = {playlistList.get(i).getId(), playlistList.get(i).getName()};
			list.add(objs);
		}
		while (tableModelFollowedLists.getRowCount()!= 0){
			tableModelFollowedLists.removeRow(0);
		}
		for (int i = 0; i<list.size(); i++){
			tableModelFollowedLists.addRow(list.get(i));
		}
		
	}
	
	public String getId(){
		return id;
	}


}
