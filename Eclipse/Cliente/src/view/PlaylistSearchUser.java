package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

import controller.PopUpController;

public class PlaylistSearchUser extends JFrame{
	private JPopupMenu popupPlaylist;
	private JMenuItem visualitzar;
	private ListSelectionModel modelo;
	private int id = 0; 
	private JButton before; 
	
	public PlaylistSearchUser(){
		JPanel jpListsFollowing = new JPanel(new BorderLayout());
		jpListsFollowing.setBorder(BorderFactory.createTitledBorder("Playlist"));
		
		
		String[] jtFollowedListsColumns = {"id","Playlist"};
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
		
		
		
		
		this.getContentPane().add(jpListsFollowing,BorderLayout.CENTER);
		
		this.getContentPane().setBackground(CustomColor.background);
		
		before = new JButton("Enrere");
		this.getContentPane().add(before, BorderLayout.SOUTH);

		
		this.setSize(300, 500);
		this.setTitle("Playlist Usuario");
		this.setLocationRelativeTo(null);
	}
	
	public void registerController(PopUpController controller){
		before.addActionListener(controller);
		before.setActionCommand("PlaylistSearchUser.beforeActionCommand");
	}
	
	
}
