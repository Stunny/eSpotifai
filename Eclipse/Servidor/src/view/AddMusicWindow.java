package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.ButtonsController;
/**
 * Pantalla per afegir una nova can�� a l'aplicaci�
 * @author Elna Cabot, Miguel D�az, Marc Mill�n, Alejandro Vogel, Marta Zapatero
 * @version 1.0
 * @see JFrame
 * @see JPanel
 * @see JLabel
 * @see JTextField
 * @see JButton
 * @see GridLayout
 *
 */
public class AddMusicWindow extends JFrame{
	/**
	 * Finestra que cont� la pantalla d'afegir una nova can��
	 * @see JPanel
	 */
	private JPanel jpAddMusic;
	
	/**
	 * Etiqueta de t�tol de can��
	 * @see JLabel
	 */
	private JLabel jlSongTitle;
	/**
	 * Etiqueta de g�nere de la can��
	 * @see JLabel
	 */
	private JLabel jlGenre;
	/**
	 * Etiqueta de �lbum de la can��
	 * @see JLabel
	 */
	private JLabel jlAlbum;
	/**
	 * Etiqueta de artista int�rpret de la can��
	 * @see JLabel
	 */
	private JLabel jlArtist;
	/**
	 * Etiqueta de ruta de l'arxiu de la can��
	 * @see JLabel
	 */
	private JLabel jlPath;
	/**
	 * Camp d'introducci� de text: nom de la can��
	 * @see JTextField
	 */
	private JTextField jtfSongTitle;
	/**
	 * Camp d'introducci� de text: g�nere de la can��
	 * @see JTextField
	 */
	private JTextField jtfGenre;
	/**
	 * Camp d'introducci� de text: �lbum de la can��
	 * @see JTextField
	 */
	private JTextField jtfAlbum;
	/**
	 * Camp d'introducci� de text: artista int�rpret de la can��
	 * @see JTextField
	 */
	private JTextField jtfArtist;
	/**
	 * Camp d'introducci� de text: ruta de l'arxiu de la can��
	 * @see JTextField
	 */
	private JTextField jtfPath;
	/**
	 * Confirma la operaci� de afegir una can��
	 * @see JButton
	 */
	private JButton jbAccept;
	/**
	 * Obre un di�leg per trobar la ruta de l'arxiu
	 * @see JButton
	 */
	private JButton jbFindPath;
	/**
	 * Construeix una pantalla de afegir una nova can��
	 * @see GridLayout
	 * @see JPanel
	 * @see JLabel
	 * @see JTextField
	 * @see JButton
	 */
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
		
		jbFindPath = new JButton("Find path...");
		jbFindPath.setHorizontalAlignment(JTextField.CENTER);
		jpAddMusic.add(jbFindPath);
		
		//L'inserto en el panell general
		this.getContentPane().add(jpAddMusic, BorderLayout.CENTER);
		
		//Assignem titol a la finestra
		this.setTitle(" Music addition ");
		
		this.setSize(new Dimension(400,200));
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}	
	/**
	 * Controlador de input d'usuari a la pantalla d'afegir una nova can��
	 * @param controller Listener d'input
	 * @see ButtonsController
	 */
	public void registerControllerAdd(ButtonsController controller) {
		jbAccept.addActionListener(controller);
		jbAccept.setActionCommand("AddMusicWindow.acceptActionCommand");
		jbFindPath.addActionListener(controller);
		jbFindPath.setActionCommand("AddMusicWindow.findPathActionCommand");
	}
	/**
	 * Torna el t�tol de la can�� introduida
	 * @return Song Title
	 */
	public String getTypedSongTitle() {
		return jtfSongTitle.getText();
	}
	/**
	 * Torna el nom de l'artista introduit
	 * @return Song Artist
	 */
	public String getTypedArtist() {
		return jtfArtist.getText();
	}
	/**
	 * Torna el nom de l'album introduit
	 * @return Song Album
	 */
	public String getTypedAlbum() {
		return jtfAlbum.getText();
	}
	/**
	 * Torna el g�nere de la can�� introduit
	 * @return Song genre
	 */
	public String getTypedGenre() {
		return jtfGenre.getText();
	}
	/**
	 * Torna la ruta de l'arxiu d'audio de la can��
	 * @return Song path
	 */
	public String getTypedPath() {
		return jtfPath.getText();
	}
	/**
	 * Introdueix la ruta trobada 
	 * @param path Song path
	 */
	public void setFoundPath(String path) {
		jtfPath.setText(path);
	}
	/**
	 * Posa en blanc tots els camps d'introducci� de text del di�leg
	 */
	public void clearTextFields() {
		jtfSongTitle.setText("");
		jtfArtist.setText("");
		jtfAlbum.setText("");
		jtfGenre.setText("");
		jtfPath.setText("");
	}
}