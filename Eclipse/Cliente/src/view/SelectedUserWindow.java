package view;

import java.awt.BorderLayout;
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

public class SelectedUserWindow extends JFrame {
	
	private JTextArea jtaPlaylist;
	private JTextArea jtafollow;
	private JTextArea jtaUsername;
	private JButton jbFollow; 
	private JButton jbUnfollow;
	
	public SelectedUserWindow(){
		
		JPanel superior = new JPanel();
		superior.setLayout(new GridLayout(2, 1));
		
		
		JPanel jpHead = new JPanel(); 
		jpHead.setLayout(new GridLayout(1, 2));
		JLabel jlUsername = new JLabel("Nickname:"); 
		jtaUsername = new JTextArea(); 
		jtaUsername.setEditable(false);
		jpHead.add(jlUsername, BorderLayout.CENTER);
		jpHead.add(jtaUsername, BorderLayout.CENTER);
		
		superior.add(jpHead);
		
		JPanel jpSecond = new JPanel(); 
		jpSecond.setLayout(new GridLayout(2, 2));
		JLabel jlfollowing = new JLabel("Estado");
		jtafollow = new JTextArea();
		jbFollow = new JButton("FOLLOW");
		jbUnfollow = new JButton("UNFOLLOW");
		jpSecond.add(jlfollowing, BorderLayout.CENTER);
		jpSecond.add(jtafollow, BorderLayout.CENTER);
		jpSecond.add(jbFollow, BorderLayout.CENTER);
		jpSecond.add(jbUnfollow, BorderLayout.CENTER);
	
		jpSecond.setBorder(BorderFactory.createTitledBorder("Datos del Usuario"));
		
		superior.add(jpSecond);
		
		this.getContentPane().add(superior, BorderLayout.PAGE_START);
		
		
		JTabbedPane jtbTabs = new JTabbedPane(); 
		
		JPanel jpPlaylistTab = new JPanel(); 
		jpPlaylistTab.setLayout(new BorderLayout());
		jtaPlaylist= new JTextArea();
		jtaPlaylist.setEditable(true);
		JScrollPane jspPlaylists= new JScrollPane(jtaPlaylist);
		jspPlaylists.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		jpPlaylistTab.add(jspPlaylists, BorderLayout.CENTER);
		
	
	
		
		jtbTabs.addTab("Playlist", jpPlaylistTab);
		
		this.getContentPane().add(jtbTabs);
	
		
		this.setSize(300, 500);
		this.setTitle("Perfil Usuario");
		this.setLocationRelativeTo(null);
	}
	
	public void registerController(ActionListener controller){
		jbFollow.addActionListener(controller);
		jbUnfollow.addActionListener(controller);
		jbFollow.setActionCommand("FOLLOW");
		jbUnfollow.setActionCommand("UNFOLLOW");
	
	}
	
	public void refreshFollowing(String string){
		jtafollow.setText(string);
	}
	
	public void refreshFollowing1(String string){
		jtafollow.setText(string);
	}
	
	public void refreshUser(String string){
		jtaUsername.setText(string);
	}
	
}
