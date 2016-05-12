package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
	private JButton jbRemove; 
	private JButton jbAdd;
	private JTextField jtfSearch; 
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
		jpPageStart.setLayout(new GridLayout(1, 4));
		
		JLabel jlLogo = new JLabel("ESPOTIFAI");
		jpPageStart.add(jlLogo, BorderLayout.CENTER);
		jtfSearch = new JTextField();
		jpPageStart.add(jtfSearch, BorderLayout.CENTER);
		jbClose = new JButton("CERRAR SESIÓN"); 
		jpPageStart.add(jbClose, BorderLayout.CENTER);
		jbProfile = new JButton("USUARIO");
		jpPageStart.add(jbProfile, BorderLayout.PAGE_START);
		
		
		jpMain.add(jpPageStart, BorderLayout.PAGE_START);
		// END jpPageStart
		
		//START (P2)

		
		// START (jpPageWest)
		JPanel jpPageWest = new JPanel(); 
		jpPageWest.setLayout(new GridLayout( 2, 1));
		
		JPanel jpLists = new JPanel(new BorderLayout());
		jpLists.setBorder(BorderFactory.createTitledBorder("PLAYLIST"));
		jtaLists = new JTextArea(); 
		jtaLists.setEditable(false);
		JScrollPane jspLists = new JScrollPane(jtaLists);
		jspLists.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		jspLists.setPreferredSize(new Dimension(250,250));
		jpLists.add(jspLists, BorderLayout.CENTER);
		jpPageWest.add(jpLists, BorderLayout.CENTER); //INSERIM PANELL 1 LLISTAT DE MUSICA
		
		jbAdd = new JButton("Nueva Lista");
		jpPageWest.add(jbAdd);
		
		
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
		jpPageEast.add(jtfArtist, BorderLayout.CENTER);
		
		JLabel jlAlbum = new JLabel("�?lbum:");
		jpPageEast.add(jlAlbum, BorderLayout.CENTER);
		jtfAlbum = new JTextField();
		jpPageEast.add(jtfAlbum, BorderLayout.CENTER);
		
		JLabel jlGenre = new JLabel("Género:");
		jpPageEast.add(jlGenre, BorderLayout.CENTER);
		jtfGenre = new JTextField();
		jpPageEast.add(jtfGenre, BorderLayout.CENTER);
		
		JLabel jlSongTitle = new JLabel("Nombre de la canción:");
		jpPageEast.add(jlSongTitle, BorderLayout.CENTER);
		jtfSongTitle = new JTextField();
		jpPageEast.add(jtfSongTitle, BorderLayout.CENTER);
		
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
		jbAdd.setActionCommand("MainWindow.addActionCommand");
		jbProfile.setActionCommand("MainWindow.profileActionCommand");
		jbClose.setActionCommand("MainWindow.closeActionCommand");
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