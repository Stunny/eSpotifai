package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MainWindow extends JFrame {
	private JTextArea jtaLists; 
	private JTextArea jtaListsfollowing;
	private JButton jbRemove; 
	private JButton jbAdd;
	private JTextField jtfSearch; 
	private JButton jbSearch;
	private JButton jbProfile;
	private JTable jtMusic; 
	private JTextField jtfArtist; 
	private JTextField jtfAlbum; 
	private JTextField jtfGenre; 
	private JTextField jtfSongTitle; 
	private JButton jbClose;
	
	
	
	
	public MainWindow(){
		JPanel jpMain = new JPanel(); 
		jpMain.setLayout(new BorderLayout());
	
		//START(jpPageStart)
		JPanel jpPageStart = new JPanel();
		jpPageStart.setLayout(new GridLayout(1, 5));
		
		JLabel jlLogo = new JLabel("ESPOTIFAI");
		jlLogo.setFont(new java.awt.Font("Phosphate", 0, 25)); 
		jlLogo.setForeground(Color.white);
		jpPageStart.add(jlLogo, BorderLayout.CENTER);
		jtfSearch = new JTextField();
		jtfSearch.setBackground(CustomColor.icon);
		jpPageStart.add(jtfSearch, BorderLayout.CENTER);
		jbSearch = new JButton("BUSCAR"); 

		/*jbSearch.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
		jbSearch.setContentAreaFilled(false);
		jbSearch.setBackground(Color.BLACK);
		jbSearch.setForeground(Color.WHITE);
		jbSearch.setOpaque(true);
		
		/*jbSearch.setBackground(Color.red);
		jbSearch.setContentAreaFilled(false);
        jbSearch.setOpaque(true);
        jbSearch.setBorderPainted(true);
        jbSearch.getBackground();*/
        
		jpPageStart.add(jbSearch, BorderLayout.CENTER);
		jbClose = new JButton("CERRAR SESIÓN"); 
		jpPageStart.add(jbClose, BorderLayout.CENTER);
		jbProfile = new JButton("USUARIO");
		jpPageStart.add(jbProfile, BorderLayout.PAGE_START);
		jpPageStart.setBackground(CustomColor.background);
		
		jpMain.add(jpPageStart, BorderLayout.PAGE_START);
		
		// END jpPageStart
		
		//START (P2)

		
		// START (jpPageWest)
		JPanel jpPageWest = new JPanel(); 
		jpPageWest.setLayout(new BorderLayout());
		
		JPanel jpListsFollowing = new JPanel(new BorderLayout());
		jpListsFollowing.setBorder(BorderFactory.createTitledBorder("PLAYLIST FOLLOWING"));
		jtaListsfollowing = new JTextArea(); 
		jtaListsfollowing.setBackground(CustomColor.icon);
		jtaListsfollowing.setEditable(false);
		JScrollPane jspListsFollowing = new JScrollPane(jtaListsfollowing);
		jspListsFollowing.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		jspListsFollowing.setPreferredSize(new Dimension(250,250));
		jpListsFollowing.add(jspListsFollowing, BorderLayout.CENTER);
		jpListsFollowing.setBackground(CustomColor.secondary);
		jpPageWest.add(jpListsFollowing, BorderLayout.NORTH);
	
		
		JPanel jpLists = new JPanel(new BorderLayout());
		jpLists.setBorder(BorderFactory.createTitledBorder("PLAYLIST"));
		jtaLists = new JTextArea(); 
		jtaLists.setBackground(CustomColor.icon);
		jtaLists.setEditable(false);
		JScrollPane jspLists = new JScrollPane(jtaLists);
		jspLists.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		jspLists.setPreferredSize(new Dimension(250,250));
		jpLists.add(jspLists, BorderLayout.CENTER);
		jpLists.setBackground(CustomColor.secondary);
		jpPageWest.add(jpLists, BorderLayout.CENTER); //INSERIM PANELL 1 LLISTAT DE MUSICA
		
		
		jbAdd = new JButton(" + Nueva Lista");
		//jpLists.add(jbAdd);
		
		jpPageWest.add(jbAdd, BorderLayout.SOUTH);
		//jpPageWest.add(jbAdd);
		jpPageWest.setBackground(CustomColor.secondary);
		
		//END (jpPageWest)
		jpMain.add(jpPageWest, BorderLayout.WEST);
		
		//START jpPageCenter
		String[] columnas = {"NOMBRE", "GÉNERO", "ALBUM", "ARTISTA", "ESTRELLAS", "REPRODUCCIONES"};
		String [][] dades = {{"Nuria Canta Mal", " Punk", "Puta Vida Tete", "Erna", "5", "10000000000"}};
		jtMusic = new JTable(dades, columnas);
		//jtMusic.setPreferredScrollableViewportSize(new Dimension(400, 450));
		//jtMusic.setFillsViewportHeight(true);
		JScrollPane jspMusic = new JScrollPane(jtMusic);
		jspMusic.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		
		jpMain.add(jspMusic, BorderLayout.CENTER);
		
		//START(jpPageEast)
		
		JPanel jpPageEast = new JPanel(); 
		jpPageEast.setLayout(new GridLayout(8,1));
		
		jpPageEast.setBorder(BorderFactory.createTitledBorder("Filtro"));
		
		JLabel jlArtist = new JLabel("Artista:");
		jpPageEast.add(jlArtist, BorderLayout.CENTER);
		jtfArtist = new JTextField();
		jtfArtist.setBackground(CustomColor.icon);
		jpPageEast.add(jtfArtist, BorderLayout.CENTER);
		
		JLabel jlAlbum = new JLabel("�?lbum:");
		jpPageEast.add(jlAlbum, BorderLayout.CENTER);
		jtfAlbum = new JTextField();
		jtfAlbum.setBackground(CustomColor.icon);
		jpPageEast.add(jtfAlbum, BorderLayout.CENTER);
		
		JLabel jlGenre = new JLabel("Género:");
		jpPageEast.add(jlGenre, BorderLayout.CENTER);
		jtfGenre = new JTextField();
		jtfGenre.setBackground(CustomColor.icon);
		jpPageEast.add(jtfGenre, BorderLayout.CENTER);
		
		JLabel jlSongTitle = new JLabel("Nombre de la canción:");
		jpPageEast.add(jlSongTitle, BorderLayout.CENTER);
		jtfSongTitle = new JTextField();
		jtfSongTitle.setBackground(CustomColor.icon);
		jpPageEast.add(jtfSongTitle, BorderLayout.CENTER);
		jpPageEast.setBackground(CustomColor.secondary);
		
		jpMain.add(jpPageEast, BorderLayout.EAST);
		
		 
		//END(jpPageEast) 
			
			

		//END P2
		
		
		this.getContentPane().add(jpMain, BorderLayout.CENTER);
		
		
		this.setSize(1280, 720);
		this.setTitle("Espotifai");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void registerController(ActionListener controller){
		jbAdd.addActionListener(controller);
		jbProfile.addActionListener(controller);
		jbClose.addActionListener(controller);
		jbSearch.addActionListener(controller);
		jbAdd.setActionCommand("MainWindow.addActionCommand");
		jbProfile.setActionCommand("MainWindow.profileActionCommand");
		jbClose.setActionCommand("MainWindow.closeActionCommand");
		jbSearch.setActionCommand("MainWindow.searchActionCommand");
	}
	
	public String getTypedSearch(){
		return jtfSearch.getText();
	}
	
	public String getTypedArtist(){
		return jtfArtist.getText();
	}
	
	public String getTypedAlbum(){
		return jtfArtist.getText();
	}
	
	public String getTypedGenre(){
		return jtfGenre.getText();
	}
	
	public String getTypedSongTitle(){
		return jtfSongTitle.getText();
	}
	
	public void refreshLists(String string){
		jtaLists.setText(string);
	}
	
	
	
	
	
}