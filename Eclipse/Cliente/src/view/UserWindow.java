package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.ScrollPane;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UserWindow extends JFrame{
	
	private JTextArea jtaFollowers;
	private JTextArea jtaFollowing; 
	private JTextArea jtaUsername;
	public UserWindow(){
		
		JPanel jpHead = new JPanel(); 
		jpHead.setLayout(new GridLayout(1, 2));
		JLabel jlUsername = new JLabel("Nickname:"); 
		jtaUsername = new JTextArea(); 
		jtaUsername.setEditable(false);
		jpHead.add(jlUsername, BorderLayout.CENTER);
		jpHead.add(jtaUsername, BorderLayout.CENTER);
		
		this.getContentPane().add(jpHead, BorderLayout.PAGE_START);
		
		
		JTabbedPane jtbTabs = new JTabbedPane(); 
		
		JPanel jpFollowersTab = new JPanel(); 
		jpFollowersTab.setLayout(new BorderLayout());
		jtaFollowers = new JTextArea();
		jtaFollowers.setEditable(false);
		JScrollPane jspFollowers = new JScrollPane(jtaFollowers);
		jspFollowers.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		jpFollowersTab.add(jspFollowers, BorderLayout.CENTER);
		
		JPanel jpFollowingTab = new JPanel(); 
		jpFollowingTab.setLayout(new BorderLayout());
		jtaFollowing = new JTextArea();
		jtaFollowing.setEditable(false);
		JScrollPane jspFollowing = new JScrollPane(jtaFollowing);
		jspFollowing.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		jpFollowingTab.add(jspFollowing, BorderLayout.CENTER);
	
		
		jtbTabs.addTab("jtaFollowers", jpFollowersTab);
		jtbTabs.addTab("jtaFollowing", jpFollowingTab);
		this.getContentPane().add(jtbTabs);
	
		
		this.setSize(300, 500);
		this.setTitle("Perfil Usuario");
		this.setLocationRelativeTo(null);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
