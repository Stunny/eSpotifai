package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
/**
 * Ventana de "perfil" de un usuari seleccionat
 * @author Elna Cabot, Miguel D�az, Marc Mill�n, Alejandro Vogel, Marta Zapatero
 * @version 1.0
 * @see JFrame
 *
 */
public class SelectedUserWindow extends JFrame {
	
	private JTextArea jtaPlaylist;
	private JTextField jtffollow;
	private  JTextField jtfUsername; 
	private JButton jbFollow; 
	private JButton jbUnfollow;
	/**
	 * Constructor de la ventana
	 */
	public SelectedUserWindow(){
		
		JPanel superior = new JPanel();
		superior.setLayout(new GridLayout(2, 1));
		
		
		JPanel jpHead = new JPanel(); 
		jpHead.setLayout(new GridLayout(1, 2));
		JLabel jlUsername = new JLabel("Nickname:");
		jlUsername.setForeground(Color.white);
		jtfUsername = new JTextField(); 
		jtfUsername.setEditable(false);
		jtfUsername.setBackground(CustomColor.icon);
		jtfUsername.setHorizontalAlignment(JTextField.CENTER);
		jtfUsername.setForeground(Color.white);
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
		JLabel jlfollowing = new JLabel("Estado");
		jlfollowing.setForeground(Color.white);
		jtffollow = new JTextField();
		jtffollow.setEditable(false);
		jtffollow.setBackground(CustomColor.icon);
		jtffollow.setHorizontalAlignment(JTextField.CENTER);
		jtffollow.setForeground(Color.white);
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
		
		
		JTabbedPane jtbTabs = new JTabbedPane(); 
		
		JPanel jpPlaylistTab = new JPanel(); 
		jpPlaylistTab.setLayout(new BorderLayout());
		jtaPlaylist= new JTextArea();
		jtaPlaylist.setEditable(true);
		jtaPlaylist.setEditable(false);
		jtaPlaylist.setBackground(CustomColor.icon);
		JScrollPane jspPlaylists= new JScrollPane(jtaPlaylist);
		jspPlaylists.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		jpPlaylistTab.add(jspPlaylists, BorderLayout.CENTER);
		
	
	
		
		jtbTabs.addTab("Playlist", jpPlaylistTab);
		
		this.getContentPane().add(jtbTabs);
		this.getContentPane().setBackground(CustomColor.background);

		
		this.setSize(300, 500);
		this.setTitle("Perfil Usuario");
		this.setLocationRelativeTo(null);
		
	}
	/**
	 * 
	 * @param controller 
	 * @see ActionListener
	 */
	public void registerController(ActionListener controller){
		jbFollow.addActionListener(controller);
		jbUnfollow.addActionListener(controller);
		jbFollow.setActionCommand("FOLLOW");
		jbUnfollow.setActionCommand("UNFOLLOW");
	
	}
	/**
	 * 
	 * @param string
	 */
	public void refreshFollowing(String string){
		jtffollow.setText(string);
	}
	/**
	 * 
	 * @param string
	 */
	public void refreshFollowing1(String string){
		jtffollow.setText(string);
	}
	/**
	 * 
	 * @param string
	 */
	public void refreshUser(String string){
		jtfUsername.setText(string);
	}
	
}
