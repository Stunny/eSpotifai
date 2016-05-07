package model;

import javax.swing.SwingUtilities;

import controller.ButtonController;
import view.AccesRegistre;
import view.Inicio;
import view.Registre;
import view.Usuari;

public class Main {
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				AccesRegistre w = new AccesRegistre();
				Registre r = new Registre();
				Inicio i = new Inicio();
				Usuari u = new Usuari();
				
				ButtonController controlador = new ButtonController(w, i, r);
				w.registerController(controlador);
				i.registerController(controlador);
				r.registerController(controlador);
				w.setVisible(true);
				
			
			}
		});
	}
}
