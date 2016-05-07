package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.AccesRegistre;
import view.Inicio;
import view.NewList;
import view.OK;
import view.Registre;
import view.Usuari;

public class ButtonController implements ActionListener {
	private AccesRegistre inicio1;
	private Inicio inici2;
	private Registre regi;
	public ButtonController( AccesRegistre inicio1, Inicio inici2, Registre regi){
		this.inicio1 = inicio1;
		this.inici2 = inici2;
		this.regi = regi;
	}
	
	public void actionPerformed(ActionEvent event){

			//PANTALLA ACCEDIR
		if(event.getActionCommand().equals("ACCES")){ 
			inici2.setVisible(true);
			inicio1.setVisible(false);
			
			
		}
			//PANTALLA ACCEDIR
		if(event.getActionCommand().equals("REGI")){
			regi.setVisible(true);
			inicio1.setVisible(false);
		}
		
		//PANTALLA REGISTRE
		if(event.getActionCommand().equals("REGISTRE")){
			inici2.setVisible(true);
			regi.setVisible(false);
			inicio1.setVisible(false);
		}
		
		 	//PANTALLA INICI
		if(event.getActionCommand().equals("AFEGUIR")){

			NewList nl = new NewList(); 
			nl.setVisible(true);          
		} 
			//PANTALLA INICIO
		if(event.getActionCommand().equals("PERFIL")){
			Usuari u = new Usuari(); 
			u.setVisible(true);
			
		}
		
		// PANTALLA INICI
		if(event.getActionCommand().equals("TANCAR")){
			inici2.setVisible(false);
			inicio1.setVisible(true);
			
		}
			//PANTALLA REGISTRE
		
		
	}
}
