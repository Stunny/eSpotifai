package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

import controller.PopUpController;

public class AddList extends JFrame{
	DefaultTableModel tableMusic;
	private JPopupMenu popup;
	private JMenuItem insert;
	
	
	
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
		String[] columns = {"Playlists"};
		Object[][] information = {{"Idiota"}};
		JTable jtMusic = new JTable(information, columns);
		tableMusic = new DefaultTableModel(information, columns){
			@Override
			public boolean isCellEditable(int row, int column) {
				//all cells false
				return false;
			}
		};
		
		popup = new JPopupMenu();
		popup.add(insert = new JMenuItem("AfeguirCanço"));
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
		            		// id = Integer.parseInt(String.valueOf( jtMusic.getValueAt(rowNumber, 0)));
		            		popup.show(jp,  e.getX(), e.getY());
		            		 
		                }
		            }
		        }
		    });
		
		jtMusic.setModel(tableMusic);
		jtMusic.setFocusable(false);
		
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
		this.setTitle("Añadir Canción en Playlist");
		this.setLocationRelativeTo(null);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void registerController1(PopUpController controller2){
		insert.addActionListener(controller2);
		insert.setActionCommand("AddList.insertActionCommand");
		
	}
	
}
