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

public class Inicio extends JFrame {
	private JTextArea jtaLlistes; 
	private JButton jbEliminar; 
	private JButton jbAfeguir;
	private JTextField Cercador; 
	private JButton Perfil;
	private JTable Taules; 
	private JTextField jtfArtista; 
	private JTextField jtfAlbum; 
	private JTextField jtfGenere; 
	private JTextField jtfCancion; 
	
	
	
	
	public Inicio(){
		JPanel principal = new JPanel(); 
		principal.setLayout(new BorderLayout());
	
		//START(P1)
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(1, 3));
		
		JLabel logo = new JLabel("ESPOTIFAI");
		p1.add(logo, BorderLayout.CENTER);
		Cercador = new JTextField();
		p1.add(Cercador, BorderLayout.CENTER);
		Perfil = new JButton("USUARIO");
		p1.add(Perfil, BorderLayout.PAGE_START);
		
		
		principal.add(p1, BorderLayout.PAGE_START);
		// END P1
		
		//START (P2)

		
		// START (P21)
		JPanel p21 = new JPanel(); 
		p21.setLayout(new GridLayout( 2, 1));
		
		JPanel p211 = new JPanel(new BorderLayout());
		p211.setBorder(BorderFactory.createTitledBorder("PLAYLIST"));
		jtaLlistes = new JTextArea(); 
		jtaLlistes.setEditable(false);
		JScrollPane jspLlistat = new JScrollPane(jtaLlistes);
		jspLlistat.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		jspLlistat.setPreferredSize(new Dimension(250,250));
		p211.add(jspLlistat, BorderLayout.CENTER);
		p21.add(p211, BorderLayout.CENTER); //INSERIM PANELL 1 LLISTAT DE MUSICA
		
		jbAfeguir = new JButton("Nueva Lista");
		p21.add(jbAfeguir);
		
		
		//END (P21)
		principal.add(p21, BorderLayout.WEST);
		
		//START P22
		JPanel p22 = new JPanel(); 
		String[] columnas = {"NOMBRE", "GÉNERO", "ALBUM", "ARTISTA", "ESTRELLAS", "REPRODUCCIONES"};
		String [][] dades = {{"Nuria Canta Mal", " Punk", "Puta Vida Tete", "Erna", "5", "10000000000"}};
		Taules = new JTable(dades, columnas);
		//Taules.setPreferredScrollableViewportSize(new Dimension(400, 450));
		//Taules.setFillsViewportHeight(true);
		JScrollPane jps = new JScrollPane(Taules);
		
		
		principal.add(jps, BorderLayout.CENTER);
		
		//START(P22)
		
		JPanel p23 = new JPanel(); 
		p23.setLayout(new GridLayout(8,1));
		
		p23.setBorder(BorderFactory.createTitledBorder("Filtro"));
		
		JLabel jl = new JLabel("Artista:");
		p23.add(jl, BorderLayout.CENTER);
		jtfArtista = new JTextField();
		p23.add(jtfArtista, BorderLayout.CENTER);
		
		JLabel jl1 = new JLabel("Álbum:");
		p23.add(jl1, BorderLayout.CENTER);
		jtfAlbum = new JTextField();
		p23.add(jtfAlbum, BorderLayout.CENTER);
		
		JLabel jl2 = new JLabel("Género:");
		p23.add(jl2, BorderLayout.CENTER);
		jtfGenere = new JTextField();
		p23.add(jtfGenere, BorderLayout.CENTER);
		
		JLabel jl3 = new JLabel("Nombre de la canción:");
		p23.add(jl3, BorderLayout.CENTER);
		jtfCancion = new JTextField();
		p23.add(jtfCancion, BorderLayout.CENTER);
		
		principal.add(p23, BorderLayout.EAST);
		 
		//END(P22) 
			
			

		//END P2
		
		
		this.getContentPane().add(principal, BorderLayout.CENTER);
		
		this.setSize(1280, 720);
		this.setTitle("Espotifai");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void registerController(ActionListener controlador){
		jbAfeguir.addActionListener(controlador);
		Perfil.addActionListener(controlador);
		jbAfeguir.setActionCommand("AFEGUIR");
		Perfil.setActionCommand("PERFIL");
	}
	
	public String typedCercador(){
		return Cercador.getText();
	}
	
	public String typedArtista(){
		return jtfArtista.getText();
	}
	
	public String typedAlbum(){
		return jtfArtista.getText();
	}
	
	public String typedGenere(){
		return jtfGenere.getText();
	}
	
	public String typedCancion(){
		return jtfCancion.getText();
	}
	
	public void refreshLlistat(String string){
		jtaLlistes.setText(string);
	}
	
	
	
	
	
}