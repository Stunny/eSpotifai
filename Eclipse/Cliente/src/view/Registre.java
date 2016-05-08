package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Registre extends JFrame{
	private JTextField jtfNick; 
	private JTextField jtfContra; 
	private JButton jbRegi; 
	
	public Registre(){
		/*// PANEL SUPERIOR QUE CONTIENE EL LOGO
		JPanel jpImatge = new JPanel();
		JLabel jlImatge = new JLabel();
		jlImatge.setIcon(new ImageIcon(getClass().getResource("/logo.png")));
		jpImatge.add(jlImatge);
		jpImatge.setBackground(Color.BLUE);
		getContentPane().add(jpImatge, BorderLayout.PAGE_START);
		*/
		
		JPanel j1 = new JPanel(); 
		JLabel logo = new JLabel("ESPOTIFAI"); 
		j1.add(logo);
		this.getContentPane().add(j1, BorderLayout.PAGE_START);
		
		JPanel jp = new JPanel(); 
		jp.setLayout(new GridLayout(3, 1));
		
		JPanel jp1 = new JPanel(); 
		jp1.setLayout(new GridLayout(1,2));
		JLabel jl = new JLabel("Nickname");
		jl.setForeground(Color.white); 
		jp1.add(jl, BorderLayout.CENTER);
		jtfNick = new JTextField(); 
		jtfNick.setBackground(Color.gray);
		jp1.add(jtfNick, BorderLayout.CENTER);
		jp1.setBackground(Color.gray);
		
		JPanel jp2 = new JPanel(); 
		jp2.setLayout(new GridLayout(1,2));
		jp2.add(new JLabel("Contrasenya"), BorderLayout.CENTER);
		jtfContra = new JTextField();
		jp2.add(jtfContra, BorderLayout.CENTER);
		jp2.setBackground(Color.gray);
		
		JPanel jp3 = new JPanel(); 
		jbRegi = new JButton("REGISTRA'T");
		jp3.add(jbRegi, BorderLayout.CENTER);
		//jp3.setBackground(Color.gray);
		
		jp.add(jp1);
		jp.add(jp2);
		jp.add(jp3);
		jp.setBorder(BorderFactory.createTitledBorder("Registra't"));
		this.getContentPane().add(jp, BorderLayout.CENTER);
		
		this.setSize(300, 300);
		this.setTitle("Registrar-se a Espotifai");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void registerController(ActionListener controlador){
		jbRegi.addActionListener(controlador);
		jbRegi.setActionCommand("REGISTRE");
	}
	
	public String typedNick(){
		return jtfNick.getText();
	}
	
	public String typedContra(){
		return jtfContra.getText();
	}
	
	
}
