package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.ButtonsController;

public class AddMusicWindow extends JDialog{
	
	private JPanel jpAddMusic;
	

	private JLabel jlSongTitle;
	private JLabel jlGenre;
	private JLabel jlAlbum;
	private JLabel jlArtist;
	private JLabel jlPath;
	
	private JTextField jtfSongTitle;
	private JTextField jtfGenre;
	private JTextField jtfAlbum;
	private JTextField jtfArtist;
	private JTextField jtfPath;
	
	private JButton jbAccept;

	public AddMusicWindow() {
		
		//Redistribucu� per guias simetricas de 6 files i dos columnes
		jpAddMusic = new JPanel();
		GridLayout glAddMusic = new GridLayout(6,2);
		jpAddMusic.setLayout(glAddMusic);

		//Creo la etiqueta de "SongTitle"
		jlSongTitle = new JLabel();
		jlSongTitle.setHorizontalAlignment(JLabel.LEFT);
		jlSongTitle.setText("Song title");
		jpAddMusic.add(jlSongTitle);
				
		//Creo area de text per la inscripci� del nom de la can�o
		jtfSongTitle = new JTextField("");
		jtfSongTitle.setHorizontalAlignment(JTextField.CENTER);
		jpAddMusic.add(jtfSongTitle);
		
		//Creo la etiqueta de "music genre"
		jlGenre = new JLabel();
		jlGenre.setHorizontalAlignment(JLabel.LEFT);
		jlGenre.setText("Music genre");
		jpAddMusic.add(jlGenre);
						
		//Creo area de text per la inscripci� del nom del genere de la can��
		jtfGenre = new JTextField("");
		jtfGenre.setHorizontalAlignment(JTextField.CENTER);
		jpAddMusic.add(jtfGenre);
		
		//Creo la etiqueta de "album"
		jlAlbum = new JLabel();
		jlAlbum.setHorizontalAlignment(JLabel.LEFT);
		jlAlbum.setText("Album");
		jpAddMusic.add(jlAlbum);
								
		//Creo area de text per la inscripci� del nom del Album
		jtfAlbum = new JTextField("");
		jtfAlbum.setHorizontalAlignment(JTextField.CENTER);
		jpAddMusic.add(jtfAlbum);
						
		//Creo la etiqueta de "artista"
		jlArtist = new JLabel();
		jlArtist.setHorizontalAlignment(JLabel.LEFT);
		jlArtist.setText("Artist");
		jpAddMusic.add(jlArtist);
								
		//Creo area de text per la inscripci� del nom de Artista
		jtfArtist = new JTextField("");
		jtfArtist.setHorizontalAlignment(JTextField.CENTER);
		jpAddMusic.add(jtfArtist);
		
		//Creo la etiqueta de de la ubicaci� de la can��
		jlPath = new JLabel();
		jlPath.setHorizontalAlignment(JLabel.LEFT);
		jlPath.setText("Path");
		jpAddMusic.add(jlPath);
			
		//Creo area de text per la inscripci� del nom de "Path" de la can��
		jtfPath = new JTextField("");
		jtfPath.setHorizontalAlignment(JTextField.CENTER);
		jpAddMusic.add(jtfPath);
		jpAddMusic.setBorder(BorderFactory.createTitledBorder("Insert information"));
		
		//Creo bot� de addici�
		jbAccept = new JButton("Accept");
		//jbAccept.setPreferedSize(new Dimension(400, 20));
		jbAccept.setHorizontalAlignment(JButton.CENTER);
		jpAddMusic.add(jbAccept);
		
		//L'inserto en el panell general
		this.getContentPane().add(jpAddMusic, BorderLayout.CENTER);
		
		//Assignem titol a la finestra
		this.setTitle(" Music addition ");
		
		this.setSize(new Dimension(400,200));
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
	}	
	
	public void registerControllerAdd(ButtonsController controller) {
		jbAccept.addActionListener(controller);
		jbAccept.setActionCommand("AddMusicWindow.acceptActionCommand");
	}
	
	public String getTypedSongTitle() {
		return jtfSongTitle.getText();
	}
	
	public String getTypedArtist() {
		return jtfArtist.getText();
	}
	
	public String getTypedAlbum() {
		return jtfAlbum.getText();
	}
	
	public String getTypedGenre() {
		return jtfGenre.getText();
	}
	
	public String getTypedPath() {
		return jtfPath.getText();
	}
}