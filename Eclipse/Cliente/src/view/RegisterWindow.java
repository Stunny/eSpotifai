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

public class RegisterWindow extends JFrame{
	private JTextField jtfUsername; 
	private JTextField jtfPassword; 
	private JButton jbRegister; 
	
	public RegisterWindow(){
		/*// PANEL SUPERIOR QUE CONTIENE EL Logo
		JPanel jpImatge = new JPanel();
		JLabel jlImatge = new JLabel();
		jlImatge.setIcon(new ImageIcon(getClass().getResource("/Logo.png")));
		jpImatge.add(jlImatge);
		jpImatge.setBackground(Color.BLUE);
		getContentPane().add(jpImatge, BorderLayout.PAGE_START);
		*/
		
		JPanel jpLogo = new JPanel(); 
		JLabel jlLogo = new JLabel("ESPOTIFAI"); 
		jpLogo.add(jlLogo);
		this.getContentPane().add(jpLogo, BorderLayout.PAGE_START);
		
		JPanel jpRegister = new JPanel(); 
		jpRegister.setLayout(new GridLayout(3, 1));
		
		JPanel jpUsername = new JPanel(); 
		jpUsername.setLayout(new GridLayout(1,2));
		JLabel jlUsername = new JLabel("Username");
		jlUsername.setForeground(Color.white); 
		jpUsername.add(jlUsername, BorderLayout.CENTER);
		jtfUsername = new JTextField(); 
		jpUsername.add(jtfUsername, BorderLayout.CENTER);
		jpUsername.setBackground(Color.gray);
		
		JPanel jpPassword = new JPanel(); 
		jpPassword.setLayout(new GridLayout(1,2));
		jpPassword.add(new JLabel("Contrasenya"), BorderLayout.CENTER);
		jtfPassword = new JTextField();
		jpPassword.add(jtfPassword, BorderLayout.CENTER);
		jpPassword.setBackground(Color.gray);
		
		JPanel jpRegisterButton = new JPanel(); 
		jbRegister = new JButton("REGISTRA'T");
		jpRegisterButton.add(jbRegister, BorderLayout.CENTER);
		//jpRegisterButton.setBackground(Color.gray);
		
		jpRegister.add(jpUsername);
		jpRegister.add(jpPassword);
		jpRegister.add(jpRegisterButton);
		jpRegister.setBorder(BorderFactory.createTitledBorder("Registra't"));
		this.getContentPane().add(jpRegister, BorderLayout.CENTER);
		
		this.setSize(300, 300);
		this.setTitle("Registrar-se a Espotifai");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void registerController(ActionListener controller){
		jbRegister.addActionListener(controller);
		jbRegister.setActionCommand("RegisterWindow.registerActionCommand");
	}
	
	public String getTypedUsername(){
		return jtfUsername.getText();
	}
	
	public String getTypedPassword(){
		return jtfPassword.getText();
	}
	
	
}
