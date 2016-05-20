
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.AddList;
import view.MainWindow;


public class PopUpController implements ActionListener{
	private MainWindow mainwindow;
		
	public PopUpController(MainWindow mainwindow){
		this.mainwindow = mainwindow;
	}


	public void actionPerformed(ActionEvent event) {
		
		if (event.getActionCommand().equals("MainWindow.reproducirActionCommand")) {
			
		}
		if (event.getActionCommand().equals("MainWindow.añadirActionCommand")){
			AddList addlist = new AddList();
			addlist.setVisible(true);
		}
		if(event.getActionCommand().equals("MainWindow.delateActionCommand")){
			
		}
		
		if(event.getActionCommand().equals("MainWindow.visualitzarActionCommand")){
			
		}
		
	}

}