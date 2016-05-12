package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginWindow  extends JFrame{
	private JTextField jtfUsername; 
	private JTextField jtfPassword;
	private JButton jbLogin; 
	private JButton jbRegister; 
	
	
	// Color.decode("#282324");  COLOR FONS
	
	
	public LoginWindow(){
		
		JPanel jpLogo = new JPanel(); 
		JLabel jlLogo = new JLabel("ESPOTIFAI"); 
		jpLogo.add(jlLogo);
		this.getContentPane().add(jpLogo, BorderLayout.PAGE_START);
		
		//PRIMERA VENTANA ACCEDER Y REGISTRARSE
		// PRIMER PANEL PARA ACCEDER TE PIDE USUARIO Y CONTRASEÑA
		JPanel jpLogin = new JPanel(); 
		jpLogin.setLayout(new GridLayout(3, 1));
	
		
		JPanel jpUsername = new JPanel(); 
		jpUsername.setLayout(new GridLayout(1,2));
		jpUsername.add(new JLabel("Username"), BorderLayout.CENTER);
		jtfUsername = new JTextField();
		jpUsername.add(jtfUsername, BorderLayout.CENTER);
		jpUsername.setBackground(Color.gray);
		
		
		
		JPanel jpPassword = new JPanel(); 
		jpPassword.setLayout(new GridLayout(1,2));
		jpPassword.add(new JLabel("Contrasenya"), BorderLayout.CENTER);
		jtfPassword = new JTextField();
		jpPassword.add(jtfPassword, BorderLayout.CENTER);
		jpPassword.setBackground(Color.gray);
		
		JPanel jpLoginButton = new JPanel(); 
		jbLogin = new JButton("ACCEDIR");
		jpLoginButton.add(jbLogin, BorderLayout.CENTER);
		jpLoginButton.setBackground(CustomColor.background);
		
		jpLogin.add(jpUsername);
		jpLogin.add(jpPassword);
		jpLogin.add(jpLoginButton);
		jpLogin.setBorder(BorderFactory.createTitledBorder("Accedir a Espotifai"));
		jpLogin.setBackground(Color.BLUE);
		this.getContentPane().add(jpLogin, BorderLayout.CENTER);
		
		
		/*// PANEL SUPERIOR QUE CONTIENE EL jlLogo
		JPanel jpImatge = new JPanel();
		JLabel jlImatge = new JLabel();
		jlImatge.setIcon(new ImageIcon(getClass().getResource("/logo.png")));
		jpImatge.add(jlImatge);
		jpImatge.setBackground(Color.BLUE);
		getContentPane().add(jpImatge, BorderLayout.PAGE_START);
		*/
		
		// SEGUNDO PANEL TE PREGUNTA SI NO TIENES USUARIO Y SI QUIERES REGISTRARTE
		JPanel jpRegister = new JPanel();
		jpRegister.setLayout(new GridLayout(2,1));
		
		JPanel jlRegister = new JPanel(); 
		jlRegister.add(new JLabel("Encara no tens usuari? Registra't") , BorderLayout.CENTER);
		jlRegister.setBackground(Color.gray);
		jpRegister.add(jlRegister, BorderLayout.CENTER);
		JPanel jpRegisterButton = new JPanel();
		jbRegister  = new JButton("REGISTRA'T");
		jpRegisterButton.add(jbRegister, BorderLayout.CENTER);
		jpRegisterButton.setBackground(CustomColor.background);
		jpRegister.add(jpRegisterButton);
		
		
		
		jpRegister.setBorder(BorderFactory.createTitledBorder("Registrar-se"));
		jpRegister.setBackground(Color.decode("#282324")); // COLOR DE FONDO
		this.getContentPane().add(jpRegister, BorderLayout.AFTER_LAST_LINE);
		
		
		
		//TAMAÑO DE LA VENTANA
		this.setSize(300, 300);
		this.setTitle("Accès a Espotyfai");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void registerController(ActionListener controller){
		jbLogin.addActionListener(controller);
		jbRegister.addActionListener(controller);
		jbLogin.setActionCommand("LoginWindow.loginActionCommand");
		jbRegister.setActionCommand("LoginWindow.registerActionCommand");
	}
	
	
	public String getTypedUsername() {
		return jtfUsername.getText();
	}
	
	public String getTypedPassword() {
		return jtfPassword.getText();
	}
	

	
	
}

