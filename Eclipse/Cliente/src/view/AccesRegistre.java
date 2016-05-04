package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AccesRegistre  extends JFrame{
	private JTextField jtfUsuari; 
	private JTextField jtfContra;
	private JButton jbAcces; 
	private JButton jbRegi; 
	
	
	// Color.decode("#282324");  COLOR FONS
	
	
	public AccesRegistre(){
		
		
		
		//PRIMERA VENTANA ACCEDER Y REGISTRARSE
		// PRIMER PANEL PARA ACCEDER TE PIDE USUARIO Y CONTRASEÑA
		JPanel jp = new JPanel(); 
		jp.setLayout(new GridLayout(3, 1));
	
		
		JPanel jp1 = new JPanel(); 
		jp1.setLayout(new GridLayout(1,2));
		jp1.add(new JLabel("Usuari"), BorderLayout.CENTER);
		jtfUsuari = new JTextField();
		jp1.add(jtfUsuari, BorderLayout.CENTER);
		jp1.setBackground(Color.gray);
		
		
		
		JPanel jp2 = new JPanel(); 
		jp2.setLayout(new GridLayout(1,2));
		jp2.add(new JLabel("Contrasenya"), BorderLayout.CENTER);
		jtfContra = new JTextField();
		jp2.add(jtfContra, BorderLayout.CENTER);
		jp2.setBackground(Color.gray);
		
		JPanel jp3 = new JPanel(); 
		jbAcces = new JButton("ACCEDIR");
		jp3.add(jbAcces, BorderLayout.CENTER);
		jp3.setBackground(CustomColor.background);
		
		jp.add(jp1);
		jp.add(jp2);
		jp.add(jp3);
		jp.setBorder(BorderFactory.createTitledBorder("Accedir a Espotifai"));
		jp.setBackground(Color.BLUE);
		this.getContentPane().add(jp, BorderLayout.CENTER);
		
		
		// PANEL SUPERIOR QUE CONTIENE EL LOGO
		JPanel jpImatge = new JPanel();
		JLabel jlImatge = new JLabel();
		jlImatge.setIcon(new ImageIcon(getClass().getResource("/logo.png")));
		jpImatge.add(jlImatge);
		jpImatge.setBackground(Color.BLUE);
		getContentPane().add(jpImatge, BorderLayout.PAGE_START);
		
		
		// SEGUNDO PANEL TE PREGUNTA SI NO TIENES USUARIO Y SI QUIERES REGISTRARTE
		JPanel jpr = new JPanel();
		jpr.setLayout(new GridLayout(2,1));
		
		JPanel jo = new JPanel(); 
		jo.add(new JLabel("Encara no tens usuari? Registra't") , BorderLayout.CENTER);
		jo.setBackground(Color.gray);
		jpr.add(jo, BorderLayout.CENTER);
		JPanel ju = new JPanel();
		jbRegi  = new JButton("REGISTRA'T");
		ju.add(jbRegi, BorderLayout.CENTER);
		ju.setBackground(CustomColor.background);
		jpr.add(ju);
		
		
		
		jpr.setBorder(BorderFactory.createTitledBorder("Registrar-se"));
		jpr.setBackground(Color.decode("#282324")); // COLOR DE FONDO
		this.getContentPane().add(jpr, BorderLayout.AFTER_LAST_LINE);
		
		
		
		//TAMAÑO DE LA VENTANA
		this.setSize(300, 500);
		this.setTitle("Accès a Espotyfai");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	

	
	
}
