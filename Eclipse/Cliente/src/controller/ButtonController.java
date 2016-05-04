package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Inicio;
import view.OK;

public class ButtonController implements ActionListener {
	private Inicio i ;
	public ButtonController(Inicio i){
		this.i = i;
	}
	public void actionPerformed(ActionEvent event){
		if(event.getActionCommand().equals("AFEGUIR")){
			//INCLUIMOS UNA LISTA

		}else if(event.getActionCommand().equals("PERFIL")){
			//MOSTRAMOS PANTALLA DEL PERFIL
			
		}
	}
}
