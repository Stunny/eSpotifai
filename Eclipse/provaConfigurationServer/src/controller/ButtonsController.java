package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;

import provaConfigurationServer.Player;
import view.AddMusicWindow;
import view.StatisticsWindow;
import view.MainWindow;

public class ButtonsController implements ActionListener{

	// VISTA
	private MainWindow view;
	private Player p;
	// NETWORK
	//private InformationService infoService;

	public ButtonsController(MainWindow view) {
		
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
			
			//Creem la vista temporal de adició
			AddMusicWindow addView = new AddMusicWindow();
			addView.setVisible(true);
			
			// Actualitzem la vista
			//vista.addText(vista.getTypedMessage());
		}else if (event.getActionCommand().equals("ESTADISTICS")){
			StatisticsWindow StadisticsView = new StatisticsWindow();
			StadisticsView.setVisible(true);

		}else if (event.getActionCommand().equals("PLAY")){
			
			try {
				view.goMP3();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if (event.getActionCommand().equals("RIGHTSONG")){
			StatisticsWindow StadisticsView = new StatisticsWindow();
			StadisticsView.setVisible(true);
			
		}else if (event.getActionCommand().equals("LEFTSONG")){
			
			StatisticsWindow StadisticsView = new StatisticsWindow();
			StadisticsView.setVisible(true);
		}
	}
	
	public void run(){
		while (true){
			view.refreshTime();
		}
	}
}