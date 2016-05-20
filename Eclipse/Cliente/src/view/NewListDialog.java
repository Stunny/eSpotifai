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

public class NewListDialog extends JFrame{
	private JTextField jtfList;
	private JButton jbCreate; 
	private JButton jbCancel;
	private JRadioButton jrbPublic;
	private JRadioButton jrbPrivate;
	
	public NewListDialog(){
		JPanel jpMain = new JPanel();
		jpMain.setLayout(new GridLayout(3,2));
		
		
		JLabel jlNewList = new JLabel("Nueva Lista");
		jlNewList.setForeground(Color.white);
		jpMain.add(jlNewList);
		jtfList = new JTextField();
		jtfList.setBackground(CustomColor.icon);
		jpMain.add(jtfList);
		
		jrbPublic = new JRadioButton("Publica", true);
		jrbPrivate = new JRadioButton("Privada", false);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(jrbPublic);
		buttonGroup.add(jrbPrivate);
		
		jpMain.add(jrbPublic);
		jpMain.add(jrbPrivate);
		
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
	public void registerController(ActionListener controller){
		jbCreate.addActionListener(controller);
		jbCancel.addActionListener(controller);
		jbCreate.setActionCommand("NewListDialog.createActionCommand");
		jbCancel.setActionCommand("NewListDialog.cancelActionCommand");
	}
}
