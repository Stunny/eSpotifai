package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import controller.PopUpController;
/**
 * Pantalla en la que l'usuari pot puntuar una can�� de 1 a 5 punts.
 * @author Elna Cabot, Miguel D�az, Marc Mill�n, Alejandro Vogel, Marta Zapatero
 * @version 1.0
 * @see JFrame
 * @see JPanel
 * @see JRadioButton
 *
 */
public class Vots extends JFrame {
	/**
	 * Bot� radial 1 punt
	 */
	private JRadioButton jrb1;
	/**
	 * Bot� radial 2 punts
	 */
	private JRadioButton jrb2; 
	/**
	 * Bot� radial 3 punts
	 */
	private JRadioButton jrb3; 
	/**
	 * Bot� radial 4 punts
	 */
	private JRadioButton jrb4; 
	/**
	 * Bot� radial 5 punts
	 */
	private JRadioButton jrb5; 

	/**
	 * Construeix la pantalla de puntuaci� de can��
	 */
	public Vots(){
		JPanel jpMain = new JPanel(); 
		jpMain.setLayout(new GridLayout(5, 1));
		ButtonGroup buttonGroup = new ButtonGroup();
		
		
		jrb1 = new JRadioButton("1 Estrella", false);
		jrb2 = new JRadioButton("2 Estrellas",false);
		jrb3 = new JRadioButton("3 Estrellas",false);
		jrb4 = new JRadioButton("4 Estrellas",false);
		jrb5 = new JRadioButton("5 Estrellas",false);
		
		jrb1.setForeground(Color.white);
		jrb2.setForeground(Color.white);
		jrb3.setForeground(Color.white);
		jrb4.setForeground(Color.white);
		jrb5.setForeground(Color.white);
		
		buttonGroup.add(jrb1);
		buttonGroup.add(jrb2);
		buttonGroup.add(jrb3);
		buttonGroup.add(jrb4);
		buttonGroup.add(jrb5);
		
		jpMain.add(jrb1);
		jpMain.add(jrb2);
		jpMain.add(jrb3);
		jpMain.add(jrb4);
		jpMain.add(jrb5);
		jpMain.setBackground(CustomColor.background);
		
		
		this.getContentPane().add(jpMain, BorderLayout.CENTER);
		this.setSize(150, 300);
		this.setTitle("Votar una canço");
		this.setLocationRelativeTo(null);
	
	}
	/**
	 * Controlador de l'input de la pantalla de puntuaci�
	 * @param controller Listener que captura l'entrada a la pantalla de puntuaci�.
	 * @see PopUpController
	 * @see ActionListener
	 */
	public void registerController(PopUpController controller){
		jrb1.addActionListener(controller);
		jrb2.addActionListener(controller);
		jrb3.addActionListener(controller);
		jrb4.addActionListener(controller);
		jrb5.addActionListener(controller);
		
		jrb1.setActionCommand("Vots.jrb1");
		jrb2.setActionCommand("Vots.jrb2");
		jrb3.setActionCommand("Vots.jrb3");
		jrb4.setActionCommand("Vots.jrb4");
		jrb5.setActionCommand("Vots.jrb5");
	
	}
	
	
	
}
