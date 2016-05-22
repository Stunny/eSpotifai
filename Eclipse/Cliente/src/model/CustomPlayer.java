package model;


import javazoom.jlgui.basicplayer.BasicController;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerEvent;
import javazoom.jlgui.basicplayer.BasicPlayerException;
import javazoom.jlgui.basicplayer.BasicPlayerListener;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;


import javax.media.CannotRealizeException;
import javax.media.Manager;
import javax.media.NoPlayerException;

import javax.swing.JSlider;

public class CustomPlayer implements BasicPlayerListener {
	private int frameNow;
	private BasicPlayer player;
	private boolean todoOk = false;
	private boolean run = false;
	private String t = "";

	private Long duration;

	private Timer tiempo ;
	private TimerTask task;
	private Map empty_map = new HashMap();
	private int bytesLength;
	private int frameSlider;
	private int seconds = 0;
	private int minutes = 0;
	private String nameSong = "";
	private int framesSong = 1;
	private int framesSongActual = 1;
	//private Double microsecondsSongActual;
	private int durationSong = 0;
	private int microdecondsSongActual;

	//velocidad del runable dels frames
	private int speed = 1000;

	public CustomPlayer(){ 
		player = new BasicPlayer();
		// Me suscribo al reproductor para obtener sus eventos.
		player.addBasicPlayerListener(this);
	}

	public int getSeconds(){

		return this.seconds;
	}
	public int getMinutes(){

		return this.minutes;
	}

	public String playPlayer(JSlider b) throws Exception{
		t = "No existe ningun archivo...";

		if (todoOk) {
			//si no se esta reproduciendo

			if(!run){ //if stopped
				player.play();
				this.run = true;
				t = "Reproduciendo";

			}else{ //if playing
				player.play();
			}
		}
		return t;
	}


	public void abrirMp3(String ruta) throws Exception{


		//si se esta reproduciendo un mp3, se detiene
		if(todoOk){
			this.stopPlayer();
		}


		//se asigna el mp3 al reproductor
		player.open(new File(ruta));
		this.nameSong = ruta;


		this.todoOk = true;

	}



	public String getName(){

		String[] itemsSong = nameSong.split("/");
		String finalName = "";
		for(int i = 0; i < itemsSong.length ; i++){
			finalName = itemsSong[i];
		}
		return finalName;

	}
	
	
	
	public int getStatus(){
		return player.getStatus();
	}
	
	
	

	public void stopAnimation() {
		
		//System.out.println("INDICO al temps que es cancela");
		tiempo.cancel();

		//System.out.println("INDICO al task time temps que es cancela");
		task.cancel();            
	}

	
	public void pause() throws Exception {
		//this.nameSong = "/PAUSE";
		player.pause();
		//tiempo.wait();
		//task.wait();
	}

	public void resume() throws Exception {
		player.resume();
		//tiempo.
	}

	public boolean isEnded(){

		if (player.getStatus() == 2){
			return true;
		}else{
			return false;
		}
	}

	public void stopPlayer() throws Exception {
		player.stop();
		this.todoOk = false;
		//this.nameSong = "/ ";
		//return "stop";
		//stopAnimation();
	}

	@Override
	/** * Necesario por implementar BasicPlayerListener. Es ejecutado una vez se
	 * carga un fichero. En este caso, obtiene el tama�o en bytes del fichero. */
	public void opened(Object arg0, Map arg1) {
		if (arg1.containsKey("audio.length.bytes")) {
			String bytesLengthString = arg1.get("audio.length.bytes").toString();
			bytesLength = Integer.valueOf(bytesLengthString);
		}
		if (arg1.containsKey("audio.length.frames")) {
			String framesSongString = arg1.get("audio.length.frames").toString();
			framesSong = Integer.valueOf(framesSongString);
		}	
		if (arg1.containsKey("duration")) {

			String durationString = arg1.get("duration").toString();
			durationSong = Integer.valueOf(durationString);
		}
	}

	
	public int getFrameSlider(){
		return frameSlider;
	}
	//Imaginad que quer�is usarlo en un jSlider, solamente habr�a que fijar el m�ximo del
	//slider en bytesLength y el valor actual en lo que diga progress

	
	/** * Necesario por implementar BasicPlayerListener. Seg�n la documentaci�n,
	 * este m�todo es llamado varias veces por segundo para informar del
	 * progreso en la reproducci�n. */
	
	public void progress(int bytesread, long microseconds, byte[] pcmdata,  Map properties) {
		float progressUpdate = (float)((bytesread* 1.0f)/ (bytesLength* 1.0f));
		int progressNow = (int) (bytesLength*1.0f * progressUpdate);

		// Descomentando la siguiente l�nea se mosrtar�a el progreso
		frameNow = (int)(bytesLength* 1.0f * progressUpdate);

		if (properties.containsKey("mp3.frame")) {
			String framesSongActualString = properties.get("mp3.frame").toString();
			framesSongActual = Integer.valueOf(framesSongActualString);

		}
		if (properties.containsKey("mp3.position.microseconds")) {

			String microdecondsSongActualString = properties.get("mp3.position.microseconds").toString();
			microdecondsSongActual = Integer.valueOf(microdecondsSongActualString);

		}

		//System.out.println("progressUpdate: " + progressUpdate + "bytesLength: " + bytesLength);
		this.minutes = (microdecondsSongActual/ 1000000)/60;
		this.seconds = (microdecondsSongActual/ 1000000)%60;
		double actualTime = microdecondsSongActual/100000;
		double songDuration = durationSong/100000;
		//frameSlider = microdecondsSongActual * 100 / durationSong;
		frameSlider = (int) (actualTime * 100 / songDuration);

		
		if( progressUpdate == 1.0){

			try {
				
				player.stop();
				seconds = 0;
				seconds = 0;
				frameSlider = 0;
				run = false;

			} catch (BasicPlayerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	//PROCEDIMENTS OBLIGATORIS D'IMPLEMENTAR JA QUE ESTEM UTILITZANT
	//una clase implementada de BasicPlayerListener
	@Override
	public void setController(BasicController arg0) {
		// TODO Auto-generated method stub
	}


	@Override
	public void stateUpdated(BasicPlayerEvent arg0) {
		// TODO Auto-generated method stub
	}


}
