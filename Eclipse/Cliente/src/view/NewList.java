package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NewList extends JFrame{
	private JTextField jtfllista;
	private JButton jbCrear; 
	private JButton jbCancelar;
	
	public NewList(){
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(2,2));
		
		
		JLabel llista = new JLabel("Nueva Lista");
		p.add(llista);
		jtfllista = new JTextField(); 
		p.add(jtfllista);
		jbCrear = new JButton("CREAR");
		jbCancelar = new JButton("CANCELAR");
		p.add(jbCrear);
		p.add(jbCancelar);
		
		this.getContentPane().add(p, BorderLayout.CENTER);
		
		this.setSize(350, 120);
		this.setTitle("Crear nueva lista");
		this.setLocationRelativeTo(null);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	
		
	}
	public void registerController(ActionListener controlador){
		jbCrear.addActionListener(controlador);
		jbCancelar.addActionListener(controlador);
		jbCrear.setActionCommand("CREAR");
		jbCancelar.setActionCommand("CANCELAR");
	}
}
