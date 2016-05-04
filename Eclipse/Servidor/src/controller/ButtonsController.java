package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.ManagementMusicView;

public class ButtonsController implements ActionListener{

	// VISTA
	private ManagementMusicView view;
	// NETWORK
	//private InformationService infoService;

	public ButtonsController(ManagementMusicView view) {
		this.view = view;
		// Instanciem la classe per poder enviar missatges.
		// Passem una referencia a lobjecte per si cal notificar alguna informacio.
		// Aquest tambe podria ser creat des del prinicpal.	
		//this.infoService = new InformationService(this);
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand().equals("ADD")) {
			// Recuperem la informació que sha escrit a la vista
			// i l'enviem al servidor

			// Actualitzem la vista
			//vista.addText(vista.getTypedMessage());
		}else if (event.getActionCommand().equals("ESTADISTICS")){

		}
	}
}
