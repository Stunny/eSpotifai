
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.AddList;
import view.MainWindow;


public class PopUpController implements ActionListener{
	private MainWindow mainwindow;
	private AddList addlist;
		
	public PopUpController(MainWindow mainwindow, AddList addlist){
		this.mainwindow = mainwindow;
		this.addlist = addlist;
	}


	public void actionPerformed(ActionEvent event) {
		
		if (event.getActionCommand().equals("MainWindow.reproducirActionCommand")) {
			
		}
		if (event.getActionCommand().equals("MainWindow.anadirActionCommand")){
			AddList addlist = new AddList();
			addlist.setVisible(true);
		}
		if(event.getActionCommand().equals("MainWindow.delateActionCommand")){
			
		}
		
		if(event.getActionCommand().equals("MainWindow.visualitzarActionCommand")){
			
		}
		
	}

}