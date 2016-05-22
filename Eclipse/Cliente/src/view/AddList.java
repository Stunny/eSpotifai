package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
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

import model.Playlist;
import controller.PopUpController;
/**
 * 
 * @author Elna Cabot, Miguel Díaz, Marc Millán, Alejandro Vogel, Marta Zapatero
 * @version 1.0
 * @see JFrame
 * @see DefaultTableModel
 * @see JPopUpMenu
 * @see JMenuItem
 *
 */
public class AddList extends JFrame{
	/**
	 * Taula del contingut de la pantalla
	 * @see DefaultTableModel
	 */
	DefaultTableModel tableMusic;
	/**
	 * Menu emergent 
	 * @see JPopUpMenu
	 */
	private JPopupMenu popup;
	/**
	 * Opció del menú emergent per a insertar
	 * @see JMenuItem
	 */
	private JMenuItem insert;
	
	private int idPlaylist;
	
	/**
	 * Construeix la pantalla de afegir una nova <i>playlist</i>.
	 * @see JPanel
	 * @see JTable
	 * @see JScrollPane
	 */
	public AddList(){
		/*JTabbedPane jtbTabs = new JTabbedPane();
		JPanel panellists = new JPanel(); 

		lists = new JTextArea();
		lists.setBackground(CustomColor.icon);
		lists.setEditable(false);
		JScrollPane jspLists = new JScrollPane(lists);
		jspLists.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		jspLists.setPreferredSize(new Dimension(250,250));
		panellists.add(jspLists, BorderLayout.CENTER);
		panellists.setBackground(CustomColor.secondary);

		jtbTabs.addTab("PlayList", panellists);*/

		JPanel jp = new JPanel();
		jp.setLayout(new BorderLayout());
		String[] columns = {"ID","Playlists"};
		Object[][] information = {};
		JTable jtMusic = new JTable(information, columns);
		tableMusic = new DefaultTableModel(information, columns){
			@Override
			public boolean isCellEditable(int row, int column) {
				//all cells false
				return false;
			}
		};

		popup = new JPopupMenu();
		popup.add(insert = new JMenuItem("AfeguirCanÃ§o"));
		insert.setHorizontalTextPosition(JMenuItem.RIGHT);
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
		            		idPlaylist = Integer.parseInt(String.valueOf( jtMusic.getValueAt(rowNumber, 0)));
		            		popup.show(jtMusic,  e.getX(), e.getY());
		            		 
		                }
		            }
		        }
		    });
		
		jtMusic.setModel(tableMusic);
		jtMusic.setFocusable(false);
		jtMusic.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane jspUsers = new JScrollPane(jtMusic);


		jp.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if ( SwingUtilities.isLeftMouseButton(e)) {
					popup.setVisible(false);
				}
			}
		});

		jp.add(jspUsers, BorderLayout.CENTER);




		this.getContentPane().add(jp, BorderLayout.CENTER);
		this.getContentPane().setBackground(CustomColor.background);

		this.setResizable(true);
		this.setSize(300, 300);
		this.setTitle("AÃ±adir CanciÃ³n en Playlist");
		this.setLocationRelativeTo(null);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	/**
	 * Controlador d'input a la pantalla d'afegir lista
	 * @param controller2 Listener de input a la pantalla AddList
	 * @see PopUpController
	 * @see ActionListener
	 */
	public void registerController1(PopUpController controller2){
		insert.addActionListener(controller2);
		insert.setActionCommand("AddList.insertActionCommand");

	}
	
	public void refreshPlaylits(LinkedList<Playlist> playlistList) {
		LinkedList<Object[]> list = new LinkedList<Object[]>();
		for (int i = 0; i < playlistList.size(); i++){
			Object[] objs = {playlistList.get(i).getId(), playlistList.get(i).getName()};
			list.add(objs);
		}
		while (tableMusic.getRowCount()!= 0){
			tableMusic.removeRow(0);
		}
		for (int i = 0; i<list.size(); i++){
			tableMusic.addRow(list.get(i));
		}

	}
	public int getIdPlaylist() {
		return idPlaylist;
	}
	
}
