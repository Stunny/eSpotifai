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
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import model.Playlist;
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
	 * @see JTextField
	 */
	private JTextField jtffollow;
	/**
	 * Area de text on es mostra
	 * @see JTextField
	 */
	private JTextField jtfUsername;
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
	DefaultTableModel tableModelFollowedLists;



	/**
	 * Constructor de la ventana de l'usuari seleccionat.
	 */
	public SelectedUserWindow(){

		JPanel superior = new JPanel();
		superior.setLayout(new GridLayout(2, 1));


		JPanel jpHead = new JPanel(); 
		jpHead.setLayout(new GridLayout(1, 2));
		JLabel jlUsername = new JLabel("Username:");
		jlUsername.setForeground(Color.white);
		jtfUsername = new JTextField(); 
		jtfUsername.setEditable(false);
		jtfUsername.setBackground(CustomColor.icon);
		jtfUsername.setForeground(Color.white);
		jtfUsername.setHorizontalAlignment(JTextField.CENTER);
		jtfUsername.setEditable(false);
		jpHead.add(jlUsername, BorderLayout.CENTER);
		jpHead.add(jtfUsername, BorderLayout.CENTER);
		TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.WHITE), "Usuario", javax.swing.border.
				TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.
				TitledBorder.DEFAULT_POSITION, null, java.awt.Color.white);

		jpHead.setBorder(titledBorder);
		jpHead.setBackground(CustomColor.background);
		superior.add(jpHead);

		JPanel jpSecond = new JPanel(); 
		jpSecond.setLayout(new GridLayout(2, 2));
		JLabel jlfollowing = new JLabel("Status");
		jlfollowing.setForeground(Color.white);
		jtffollow = new JTextField();
		jtffollow.setBackground(CustomColor.icon);
		jtffollow.setForeground(Color.white);
		jtffollow.setHorizontalAlignment(JTextField.CENTER);
		jtffollow.setEditable(false);
		jbFollow = new JButton("FOLLOW");
		jbUnfollow = new JButton("UNFOLLOW");
		jpSecond.add(jlfollowing, BorderLayout.CENTER);
		jpSecond.add(jtffollow, BorderLayout.CENTER);
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
		tableModelFollowedLists = new DefaultTableModel(jtFollowedListsData, jtFollowedListsColumns) {
			@Override
			public boolean isCellEditable(int row, int column) {
				//all cells false
				return false;
			}

		}; 

		popupPlaylist = new JPopupMenu();
		popupPlaylist.add(visualitzar = new JMenuItem("View songs"));
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
		this.setTitle("User profile");
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

	public void refreshPlaylists(LinkedList<Playlist> playlistList) {
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


	/**
	 * Actualitza continuament la llista de usuaris seguits
	 * @param string 
	 * @see JTextField
	 */
	public void refreshFollowing(String string){
		jtffollow.setText(string);
	}
	/**
	 * Actualitza la pagina d'usuari seleccionat en la seva totalitat.
	 * @param string
	 * @see JTextField
	 */
	public void refreshUser(String string){
		jtfUsername.setText(string);
	}

}