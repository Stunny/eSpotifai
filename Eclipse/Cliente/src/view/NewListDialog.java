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

import controller.ButtonController;

/**
 * Classe que obre una ventana emergent per a la creaci� d'una nova llista de reproduccio.
 * @author Elna Cabot, Miguel Diaz, Marc Millan, Marta Zapatero, Alejandro Vogel
 * @version 1.0
 * @see JFrame
 *
 */
public class NewListDialog extends JFrame{
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


	/**
	 * Constructor de la ventana emergent
	 * @see JPanel
	 * @see GridLayout
	 */

	public NewListDialog(){
		JPanel jpMain = new JPanel();
		jpMain.setLayout(new GridLayout(3,2));


		JLabel jlNewList = new JLabel("New Playlist");
		jlNewList.setForeground(Color.white);
		jpMain.add(jlNewList);
		jtfList = new JTextField();
		jtfList.setBackground(CustomColor.icon);
		jpMain.add(jtfList);

		jrbPublic = new JRadioButton("Public", true);
		jrbPrivate = new JRadioButton("Private", false);

		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(jrbPublic);
		buttonGroup.add(jrbPrivate);
		jpMain.add(jrbPublic);
		jpMain.add(jrbPrivate);
		jbCreate = new JButton("CREATE");
		jbCancel = new JButton("CANCEL");
		jpMain.add(jbCreate);
		jpMain.add(jbCancel);
		jpMain.setBackground(CustomColor.background);

		this.getContentPane().add(jpMain, BorderLayout.CENTER);


		this.setSize(350, 120);
		this.setTitle("Create new Playlist");
		this.setLocationRelativeTo(null);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



	}
	/**
	 * Controlador de interacci� de l'usuari
	 * @param controller Listener utilitzat per controlar la selecci� de l'usuari
	 * @see ActionListener
	 */
	public void registerController(ButtonController controller){
		jbCreate.addActionListener(controller);
		jbCreate.setActionCommand("NewListDialog.createActionCommand");
		jbCancel.addActionListener(controller);
		jbCancel.setActionCommand("NewListDialog.cancelActionCommand");
	}

	public String getTypedName() {
		return jtfList.getText();
	}

	public void setTypedName(String name){
		jtfList.setText(name);
	}

	public int getPublic(){
		if(jrbPublic.isSelected()){
			return 1;
		}
		return 0;
	}
}
