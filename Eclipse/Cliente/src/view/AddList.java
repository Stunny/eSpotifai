package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class AddList extends JFrame{
	private JTextArea lists;
	
	public AddList(){
		JTabbedPane jtbTabs = new JTabbedPane();
		JPanel panellists = new JPanel(); 
		
		lists = new JTextArea();
		lists.setBackground(CustomColor.icon);
		lists.setEditable(false);
		JScrollPane jspLists = new JScrollPane(lists);
		jspLists.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		jspLists.setPreferredSize(new Dimension(250,250));
		panellists.add(jspLists, BorderLayout.CENTER);
		panellists.setBackground(CustomColor.secondary);
		
		jtbTabs.addTab("PlayList", panellists);
		
		
		this.getContentPane().add(jtbTabs);
		this.getContentPane().setBackground(CustomColor.background);
		
		this.setResizable(true);
		this.setSize(300, 300);
		this.setTitle("Añadir Canción");
		this.setLocationRelativeTo(null);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
}
