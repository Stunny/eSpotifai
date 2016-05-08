package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

public class UsuariCercat extends JFrame {
	
	private JTextArea llistes;
	private JTextArea following; 
	private JTextArea usuari;
	public UsuariCercat(){
		
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
		llistes = new JTextArea();
		llistes.setEditable(false);
		JScrollPane jpf = new JScrollPane(llistes);
		jpf.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		p1.add(jpf, BorderLayout.CENTER);
	
	
		
		panell.addTab("Playlist", p1);
		this.getContentPane().add(panell);
	
		
		this.setSize(300, 500);
		this.setTitle("Perfil Usuario");
		this.setLocationRelativeTo(null);
	}
	
}
