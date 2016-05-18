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
import javax.swing.border.TitledBorder;

public class LoginWindow  extends JFrame{
	private JTextField jtfUsername; 
	private JTextField jtfPassword;
	private JButton jbLogin; 
	private JButton jbRegister; 
	
	
	// Color.decode("#282324");  COLOR FONS
	
	
	public LoginWindow(){
		
		JPanel jpLogo = new JPanel(); 
		JLabel jlLogo = new JLabel("ESPOTIFAI"); 
		jlLogo.setFont(new java.awt.Font("Phosphate", 0, 36)); 
		jlLogo.setForeground(Color.white);
		jpLogo.add(jlLogo);
		jpLogo.setBackground(CustomColor.background);
		this.getContentPane().add(jpLogo, BorderLayout.PAGE_START);
		
		//PRIMERA VENTANA ACCEDER Y REGISTRARSE
		// PRIMER PANEL PARA ACCEDER TE PIDE USUARIO Y CONTRASEÑA
		JPanel jpLogin = new JPanel(); 
		jpLogin.setLayout(new GridLayout(3, 1));
	
		
		JPanel jpUsername = new JPanel(); 
		jpUsername.setLayout(new GridLayout(1,2));
		JLabel user = new JLabel("Username"); 
		user.setForeground(Color.white);
		jpUsername.add(user, BorderLayout.CENTER);
		jtfUsername = new JTextField();
		jtfUsername.setBackground(CustomColor.icon);
		jpUsername.add(jtfUsername, BorderLayout.CENTER);
		jpUsername.setBackground(CustomColor.background);
		
		
		
		JPanel jpPassword = new JPanel(); 
		jpPassword.setLayout(new GridLayout(1,2));
		JLabel contrasenya = new JLabel("Contrasenya");
		contrasenya.setForeground(Color.white);
		jpPassword.add(contrasenya, BorderLayout.CENTER);
		
		jtfPassword = new JTextField();
		jtfPassword.setBackground(CustomColor.icon);
		jpPassword.add(jtfPassword, BorderLayout.CENTER);
		jpPassword.setBackground(CustomColor.background);
		
		JPanel jpLoginButton = new JPanel(); 
		jbLogin = new JButton("ACCEDIR");
		jpLoginButton.add(jbLogin, BorderLayout.CENTER);
		
		jpLoginButton.setBackground(CustomColor.background);
		
		jpLogin.add(jpUsername);
		jpLogin.add(jpPassword);
		jpLogin.add(jpLoginButton);
		
		TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.WHITE), "Accedir a Espotifai", javax.swing.border.
			      TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.
			      TitledBorder.DEFAULT_POSITION, null, java.awt.Color.white);
		
		jpLogin.setBorder(titledBorder);
		
		//jpLogin.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.WHITE), "Accedir a Espotifai"));
		
		//jpLogin.setBorder(BorderFactory.createTitledBorder("Accedir a Espotifai"));
		jpLogin.setBackground(CustomColor.background);
		this.getContentPane().add(jpLogin, BorderLayout.CENTER);
		
		
		// SEGUNDO PANEL TE PREGUNTA SI NO TIENES USUARIO Y SI QUIERES REGISTRARTE
		JPanel jpRegister = new JPanel();
		jpRegister.setLayout(new GridLayout(2,1));
		
		JPanel jlRegister = new JPanel(); 
		JLabel register = new JLabel("Encara no tens usuari? Registra't");
		register.setForeground(Color.white);
		jlRegister.add(register);
		jlRegister.setBackground(CustomColor.background);
		jpRegister.add(jlRegister, BorderLayout.CENTER);
		JPanel jpRegisterButton = new JPanel();
		jbRegister  = new JButton("REGISTRA'T");
		jpRegisterButton.add(jbRegister, BorderLayout.CENTER);
		jpRegisterButton.setBackground(CustomColor.background);
		jpRegister.add(jpRegisterButton);

		
		TitledBorder titledBorder2 = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.WHITE), "Registrar-se", javax.swing.border.
			      TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.
			      TitledBorder.DEFAULT_POSITION, null, java.awt.Color.white);
		
		jpRegister.setBorder(titledBorder2);
		
		//jpRegister.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.WHITE), "Registrar-se"));
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

