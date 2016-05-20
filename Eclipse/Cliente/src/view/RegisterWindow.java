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
import javax.swing.border.TitledBorder;

public class RegisterWindow extends JFrame{
	private JTextField jtfUsername; 
	private JTextField jtfPassword; 
	private JButton jbRegister;
	private JButton jbAtras;
	
	public RegisterWindow(){
		
		JPanel jpLogo = new JPanel(); 
		JLabel jlLogo = new JLabel("ESPOTIFAI"); 
		jlLogo.setFont(new java.awt.Font("Phosphate", 0, 36)); 
		jlLogo.setForeground(Color.white);
		jpLogo.add(jlLogo);
		jpLogo.setBackground(CustomColor.background);
		this.getContentPane().add(jpLogo, BorderLayout.PAGE_START);
	
		
		JPanel jpRegister = new JPanel(); 
		jpRegister.setLayout(new GridLayout(3, 1));
		
		JPanel jpUsername = new JPanel(); 
		jpUsername.setLayout(new GridLayout(1,2));
		JLabel jlUsername = new JLabel("Username");
		jlUsername.setForeground(Color.white); 
		jpUsername.add(jlUsername, BorderLayout.CENTER);
		jtfUsername = new JTextField(); 
		jtfUsername.setBackground(CustomColor.icon);
		jpUsername.add(jtfUsername, BorderLayout.CENTER);
		jpUsername.setBackground(CustomColor.background);
		
		JPanel jpPassword = new JPanel(); 
		jpPassword.setLayout(new GridLayout(1,2));
		JLabel password = new JLabel("Contrasenya");
		password.setForeground(Color.white); 
		jpPassword.add(password);
		jpPassword.setBackground(CustomColor.background);
		jtfPassword = new JTextField();
		jtfPassword.setBackground(CustomColor.icon);
		jpPassword.add(jtfPassword, BorderLayout.CENTER);
		jpPassword.setBackground(CustomColor.background);
		
		JPanel jpRegisterButton = new JPanel(new GridLayout(1, 2)); 
		jbAtras = new JButton("ENRERE");
		jbRegister = new JButton("REGISTRA'T");
		jpRegisterButton.add(jbAtras,BorderLayout.CENTER);
		jpRegisterButton.add(jbRegister, BorderLayout.CENTER);
		jpRegisterButton.setBackground(CustomColor.background);
		//jpRegisterButton.setBackground(Color.gray);
		
		jpRegister.add(jpUsername, BorderLayout.NORTH);
		jpRegister.add(jpPassword, BorderLayout.CENTER);
		jpRegister.add(jpRegisterButton, BorderLayout.SOUTH);
		TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.WHITE), "Registrar-se", javax.swing.border.
			      TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.
			      TitledBorder.DEFAULT_POSITION, null, java.awt.Color.white);
		
		jpRegister.setBorder(titledBorder);
		//jpRegister.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.WHITE), "Registrar-se"));
		jpRegister.setBackground(Color.decode("#282324"));
		this.getContentPane().add(jpRegister, BorderLayout.CENTER);
		
		this.setSize(300, 300);
		this.setTitle("Registrar-se a Espotifai");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void registerController(ActionListener controller){
		jbRegister.addActionListener(controller);
		jbAtras.addActionListener(controller);
		jbRegister.setActionCommand("RegisterWindow.registerActionCommand");
		jbAtras.setActionCommand("RegisterWindow.atrasActionCommand");
	}
	
	public String getTypedUsername(){
		return jtfUsername.getText();
	}
	
	public String getTypedPassword(){
		return jtfPassword.getText();
	}
	
	
}
