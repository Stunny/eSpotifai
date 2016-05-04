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

public class ManagementMusicAddView extends JDialog{
	
	private JPanel jpViewAdd;
	
	private JLabel jlMessageAdd;
	private JLabel jlName;
	private JLabel jlGenre;
	private JLabel jlAlbum;
	private JLabel jlArtist;
	private JLabel jlPath;
	
	private JTextField jtWriteName;
	private JTextField jtWriteGenre;
	private JTextField jtWriteAlbum;
	private JTextField jtWriteArtist;
	private JTextField jtWritePath;
	
	private JButton jbAccept;

	public ManagementMusicAddView() {
		
		//Redistribucuó per guias simetricas de 6 files i dos columnes
		jpViewAdd = new JPanel();
		GridLayout gljpViewAdd = new GridLayout(6,2);
		jpViewAdd.setLayout(gljpViewAdd);

		//Creo la etiqueta de "Name"
		jlName = new JLabel();
		jlName.setHorizontalAlignment(JLabel.LEFT);
		jlName.setText("Name");
		jpViewAdd.add(jlName);
				
		//Creo area de text per la inscripció del nom de la canço
		jtWriteName = new JTextField("");
		jtWriteName.setHorizontalAlignment(JTextField.CENTER);
		jpViewAdd.add(jtWriteName);
		
		//Creo la etiqueta de "music genre"
		jlGenre = new JLabel();
		jlGenre.setHorizontalAlignment(JLabel.LEFT);
		jlGenre.setText("Music genre");
		jpViewAdd.add(jlGenre);
						
		//Creo area de text per la inscripció del nom del genere de la cançó
		jtWriteGenre = new JTextField("");
		jtWriteGenre.setHorizontalAlignment(JTextField.CENTER);
		jpViewAdd.add(jtWriteGenre);
		
		//Creo la etiqueta de "album"
		jlAlbum = new JLabel();
		jlAlbum.setHorizontalAlignment(JLabel.LEFT);
		jlAlbum.setText("Album");
		jpViewAdd.add(jlAlbum);
								
		//Creo area de text per la inscripció del nom del Album
		jtWriteAlbum = new JTextField("");
		jtWriteAlbum.setHorizontalAlignment(JTextField.CENTER);
		jpViewAdd.add(jtWriteAlbum);
						
		//Creo la etiqueta de "artista"
		jlArtist = new JLabel();
		jlArtist.setHorizontalAlignment(JLabel.LEFT);
		jlArtist.setText("Artist");
		jpViewAdd.add(jlArtist);
								
		//Creo area de text per la inscripció del nom de Artista
		jtWriteArtist = new JTextField("");
		jtWriteArtist.setHorizontalAlignment(JTextField.CENTER);
		jpViewAdd.add(jtWriteArtist);
		
		//Creo la etiqueta de de la ubicació de la cançó
		jlPath = new JLabel();
		jlPath.setHorizontalAlignment(JLabel.LEFT);
		jlPath.setText("Path");
		jpViewAdd.add(jlPath);
			
		//Creo area de text per la inscripció del nom de "Path" de la cançó
		jtWritePath = new JTextField("");
		jtWritePath.setHorizontalAlignment(JTextField.CENTER);
		jpViewAdd.add(jtWritePath);
		jpViewAdd.setBorder(BorderFactory.createTitledBorder("Insert information"));
		
		//Creo botó de addició
		jbAccept = new JButton("Accept");
		//jbAccept.setPreferedSize(new Dimension(400, 20));
		jbAccept.setHorizontalAlignment(JButton.CENTER);
		jpViewAdd.add(jbAccept);
		
		//L'inserto en el panell general
		this.getContentPane().add(jpViewAdd, BorderLayout.CENTER);
		
		//Assignem titol a la finestra
		this.setTitle(" Music addition ");
		
		this.setSize(new Dimension(400,200));
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
	}	
	
	public void registerControllerAdd(ButtonsController controller) {
		jbAccept.addActionListener(controller);
		jbAccept.setActionCommand("ACCEPT");
	}
}