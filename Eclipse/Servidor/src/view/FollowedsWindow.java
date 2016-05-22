package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.LinkedList;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 * Pantalla on es mostren tots els usuaris als que segueix un de determinat
 * @author Elna Cabot, Miguel D�az, Marc Mill�n, Alejandro Vogel, Marta Zapatero
 * @version 1.0
 * @see JFrame
 * @see JTable
 * @see JPanel
 * @see JScrollPane
 * @see DefaultTableModel
 *
 */
public class FollowedsWindow extends JFrame{
	/**
	 * Taula de contingut de la pantalla
	 * @see DefaultTableModel
	 */
	private DefaultTableModel tableModelUser;
	/**
	 * Taula on es col�locar� el contingut a la pantalla
	 * @see JTable
	 */
	private JTable jpUsers;
	/**
	 * Construeix la pantalla de seguidros d'un usuari
	 * @param infTable
	 * @param name
	 * @see JTable
	 * @see JPanel
	 * @see JScrollPane
	 * @see DefaultTableModel
	 */
	public FollowedsWindow(LinkedList<Object[]> infTable, String name){
		new JPanel();
		
	
	String[] jtUserColumns = {"id","Username", "Register date", "Last login", "Song lists", "Songs", "Followers", "Following"};
	Object[][] jtUserData = {};
	//se crea la tabla
	JTable jtUser = new JTable(jtUserData, jtUserColumns);
	
	//se hace que los datos no sean editables
	tableModelUser = new DefaultTableModel(jtUserData, jtUserColumns) {
		@Override
		public boolean isCellEditable(int row, int column) {
			//all cells false
			return false;
		}
		
	}; 
	while (tableModelUser.getRowCount()!= 0){
		tableModelUser.removeRow(0);
	}
	for (int i = 0; i<infTable.size(); i++){
		tableModelUser.addRow(infTable.get(i));
	}
	
	jtUser.setModel(tableModelUser);
	jtUser.setFocusable(false);

	JScrollPane jspUsers = new JScrollPane(jtUser);
	jpUsers = new JTable();
	jpUsers.add(jspUsers, BorderLayout.CENTER);

	this.getContentPane().add(jspUsers, BorderLayout.CENTER);
	
	this.setResizable(true);
	this.setSize(new Dimension(1600,870));
	this.setTitle("User Followeds - "+name);
	this.setLocationRelativeTo(null);
	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}

