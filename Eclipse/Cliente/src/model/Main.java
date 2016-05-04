package model;

import javax.swing.SwingUtilities;

import controller.ButtonController;
import view.AccesRegistre;
import view.Inicio;
import view.Registre;

public class Main {
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				AccesRegistre w = new AccesRegistre();
				Registre r = new Registre();
				Inicio i = new Inicio();
				
				ButtonController controlador = new ButtonController(i);
				i.registerController(controlador);
				i.setVisible(true);
				r.setVisible(false);
				w.setVisible(false);
			
			}
		});
	}
}
