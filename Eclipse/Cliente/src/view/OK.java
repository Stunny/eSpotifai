package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class OK extends JFrame{
	private JLabel jlEtiqueta;
	
	public OK() {
		
		jlEtiqueta = new JLabel("OKKKKK  USUARIO!!");
		jlEtiqueta.setHorizontalAlignment(JLabel.CENTER);
		
		getContentPane().add(jlEtiqueta, BorderLayout.CENTER);
		
		
		setSize(300,150);
		setTitle("Error SERVER");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}