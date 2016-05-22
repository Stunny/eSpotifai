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
import javax.swing.JTextField;

import controller.PopUpController;

/**
 * Classe que obre una ventana emergent per a la creaci� d'una nova llista de reproduccio.
 * @author Elna Cabot, Miguel Diaz, Marc Millan, Marta Zapatero, Alejandro Vogel
 * @version 1.0
 * @see JFrame
 *
 */
public class ModifyNameList extends JFrame{
	/**
	 * Introducci� del nom de la nova llista de reproducci�
	 * @see JTextField
	 */
	private JTextField jtfList;
	/**
	 * Acciona la creaci� de la nova llista
	 * @see JButton
	 */
	private JButton jbCreate; 
	/**
	 * Cancela la creaci� d'una nova llista
	 * @see JButton
	 */
	private JButton jbCancel;
	private JRadioButton jrbPublic;
	private JRadioButton jrbPrivate;
	private String name = "";
	

	/**
	 * Constructor de la ventana emergent
	 * @see JPanel
	 * @see GridLayout
	 */

	public ModifyNameList(){
		JPanel jpMain = new JPanel();
		jpMain.setLayout(new GridLayout(2,2));
		
		
		JLabel jlNewList = new JLabel("Nombre Lista:");
		jlNewList.setForeground(Color.white);
		jpMain.add(jlNewList);
		jtfList = new JTextField();
		jtfList.setBackground(CustomColor.icon);
		jpMain.add(jtfList);
		
		jbCreate = new JButton("CREAR");
		jbCancel = new JButton("CANCELAR");
		jpMain.add(jbCreate);
		jpMain.add(jbCancel);
		jpMain.setBackground(CustomColor.background);
		
		this.getContentPane().add(jpMain, BorderLayout.CENTER);
		
		
		this.setSize(350, 120);
		this.setTitle("Crear nueva lista");
		this.setLocationRelativeTo(null);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	
		
	}
	/**
	 * Controlador de interacci� de l'usuari
	 * @param controller Listener utilitzat per controlar la selecci� de l'usuari
	 * @see ActionListener
	 */
	public void registerController(PopUpController controller){
		jbCreate.addActionListener(controller);
		jbCancel.addActionListener(controller);
		jbCreate.setActionCommand("ModifyNameList.createActionCommand");
		jbCancel.setActionCommand("ModifyNameList.cancelActionCommand");
	}
	
	public String getTypedName(){
		return jtfList.getText();
	}
	
	
	
}