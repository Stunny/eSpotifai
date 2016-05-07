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

public class Usuari extends JFrame{
	private JTextArea followers;
	private JTextArea following; 
	private JTextArea usuari;
	public Usuari(){
		
		JPanel panell1 = new JPanel(); 
		panell1.setLayout(new GridLayout(1, 2));
		JLabel nom = new JLabel("Nickname:"); 
		usuari = new JTextArea(); 
		usuari.setEditable(false);
		panell1.add(nom, BorderLayout.CENTER);
		panell1.add(usuari, BorderLayout.CENTER);
		
		this.getContentPane().add(panell1, BorderLayout.PAGE_START);
		
		
		JTabbedPane panell = new JTabbedPane(); 
		
		JPanel p1 = new JPanel(); 
		p1.setLayout(new BorderLayout());
		followers = new JTextArea();
		followers.setEditable(false);
		JScrollPane jpf = new JScrollPane(followers);
		jpf.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		p1.add(jpf, BorderLayout.CENTER);
		
		JPanel p2 = new JPanel(); 
		p2.setLayout(new BorderLayout());
		following = new JTextArea();
		following.setEditable(false);
		JScrollPane jpf1 = new JScrollPane(followers);
		jpf1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		p2.add(jpf1, BorderLayout.CENTER);
	
		
		panell.addTab("Followers", p1);
		panell.addTab("Following", p2);
		this.getContentPane().add(panell);
	
		
		this.setSize(300, 500);
		this.setTitle("Perfil Usuario");
		this.setLocationRelativeTo(null);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
