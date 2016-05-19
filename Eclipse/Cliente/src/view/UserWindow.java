package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.ScrollPane;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class UserWindow extends JFrame{

	private JTextArea jtaFollowing; 
	private JTextArea jtaUsername;
	public UserWindow(){
		
		JPanel jpHead = new JPanel(); 
		jpHead.setLayout(new GridLayout(1, 2));
		JLabel jlUsername = new JLabel("Nickname:");
		jlUsername.setForeground(Color.white);
		jtaUsername = new JTextArea(); 
		jtaUsername.setEditable(false);
		jtaUsername.setBackground(CustomColor.icon);
		jpHead.add(jlUsername, BorderLayout.CENTER);
		jpHead.add(jtaUsername, BorderLayout.CENTER);
		TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.WHITE), "Usuario", javax.swing.border.
			      TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.
			      TitledBorder.DEFAULT_POSITION, null, java.awt.Color.white);
		
		jpHead.setBorder(titledBorder);
		jpHead.setBackground(CustomColor.background);
		
		this.getContentPane().add(jpHead, BorderLayout.PAGE_START);
		
		
		JTabbedPane jtbTabs = new JTabbedPane(); 
		/*
		JPanel jpFollowersTab = new JPanel(); 
		jpFollowersTab.setLayout(new BorderLayout());
		jtaFollowers = new JTextArea();
		jtaFollowers.setEditable(false);
		JScrollPane jspFollowers = new JScrollPane(jtaFollowers);
		jspFollowers.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		jpFollowersTab.add(jspFollowers, BorderLayout.CENTER);
		*/
		
		JPanel jpFollowingTab = new JPanel(); 
		jpFollowingTab.setLayout(new BorderLayout());
		jtaFollowing = new JTextArea();
		jtaFollowing.setEditable(false);
		jtaFollowing.setBackground(CustomColor.icon);

		JScrollPane jspFollowing = new JScrollPane(jtaFollowing);
		jspFollowing.setBackground(Color.white);
		jspFollowing.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		jspFollowing.setBackground(CustomColor.selected);
		jpFollowingTab.add(jspFollowing, BorderLayout.CENTER);
		
		
		//jtbTabs.addTab("Followers", jpFollowersTab);
		jtbTabs.addTab("Following", jpFollowingTab);
		
		this.getContentPane().add(jtbTabs);
		this.getContentPane().setBackground(CustomColor.background);
	
		
		this.setSize(300, 500);
		this.setTitle("Perfil Usuario");
		this.setLocationRelativeTo(null);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void refreshUser(String string){
		jtaUsername.setText(string);
	}
	
	
}
