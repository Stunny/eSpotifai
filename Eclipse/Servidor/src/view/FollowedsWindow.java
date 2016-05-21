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

public class FollowedsWindow extends JFrame{
	
	private DefaultTableModel tableModelUser;
	private JTable jpUsers;

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

