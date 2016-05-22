
package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 * Pantalla on es mostren tots els seguidors d'un usuari determinat
 * @author Elna Cabot, Miguel D�az, Marc Mill�n, Alejandro Vogel, Marta Zapatero
 * @versio 1.0
 * @see JFrame
 * @see DefaultTableModel
 * @see JTable
 * @see JPanel
 * @see JScrollPane
 *
 */
public class FollowersWindow extends JFrame{
	/**
	 * Taula de contingut de la pantalla
	 * @see DefaultTableModel
	 */
	private DefaultTableModel tableModelUser;
	/**
	 * Taula on es col�locar� el contingut
	 * @see Jtable
	 */
	private JTable jpUsers;
	/**
	 * Construeix la pantalla que mostra els seguidors d'un usuari
	 * @param infTable
	 * @param name
	 * @see DefaultTableModel
	 * @see JTable
	 * @see JPanel
	 * @see JScrollPane
	 */
	public FollowersWindow(LinkedList<Object[]> infTable, String name){
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
	jtUser.getTableHeader().setReorderingAllowed(false);

	JScrollPane jspUsers = new JScrollPane(jtUser);
	jpUsers = new JTable();
	jpUsers.add(jspUsers, BorderLayout.CENTER);

	this.getContentPane().add(jspUsers, BorderLayout.CENTER);
	
	this.setResizable(true);
	this.setSize(new Dimension(1600,870));
	this.setTitle("User Followers - "+name);
	this.setLocationRelativeTo(null);
	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}

