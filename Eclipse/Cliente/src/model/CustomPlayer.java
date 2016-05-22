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

import javax.swing.JSlider;
/**
 * Reproductor custom a partir de BasicPlayer
 * @author Elna Cabot, Miguel D�az, Marc Mill�n, Alejandro Vogel, Marta Zapatero
 * @version 1.0
 * @see BasicPlayer
 * @see Timer
 * @see TimerTask
 * @see Map
 * 
 *
 */
public class CustomPlayer implements BasicPlayerListener {
	/**
	 * Frame actual
	 */
	private int frameNow;
	/**
	 * Reproductor
	 */
	private BasicPlayer player;
	/**
	 * Status de la reproducci�
	 */
	private boolean todoOk = false;
	/**
	 * Indica si la reproducci� �s activa
	 */
	private boolean run = false;
	/**
	 * Stastus message
	 */
	private String t = "";
	/**
	 * Temporitzador
	 * @see Timer
	 */
	private Timer tiempo ;
	/**
	 * Tasca associada a un moment determinat del Timer
	 * @see TimerTask
	 * @see Timer
	 */
	private TimerTask task;
	/**
	 * Mapa de hash
	 * @see Map
	 */
	private Map empty_map = new HashMap();
	/**
	 * Longitud en bytes de la can��
	 */
	private Double bytesLength;
	/**
	 * Frame on es troba l'slider
	 */
	private int frameSlider;
	/**
	 * Actualitza continuament l'indicador de de segons del reproductor
	 */
	private int seconds = 0;
	/**
	 * Actualitza continuament l'indicador de minuts del reproductor
	 */
	private int minutes = 0;
	/**
	 * Nom de la can�� que s'est� reproduint
	 */
	private String nameSong = "";
	/**
	 * Frames totals de la can��
	 */
	private Double framesSong = 1.0;
	/**
	 * Frame de la reproducci� on es troba la can�� actualment
	 */
	private Double framesSongActual = 1.0;
	/**
	 * Microsegon de la reproducci� on es troba la can�� en el moment.
	 */
	private Double microsecondsSongActual;
	/**
	 * Durada de la can�� en microsegons
	 */
	private Double durationSong;
	/**
	 * Microsegon en el 
	 */
	private Double microdecondsSongActual;
	
	//velocidad del runable dels frames
	/**
	 * Velocitat del <i>runable</i> dels frames
	 */
	private int speed = 1000;
	/**
	 * Construeix un nou reproductor
	 * 
	 */
	public CustomPlayer(){ 
		player = new BasicPlayer();
		// Me suscribo al reproductor para obtener sus eventos.
		player.addBasicPlayerListener(this);
	}
	/**
	 * Getter de segons
	 * @return Seconds
	 */
	public int getSeconds(){

		return this.seconds;
	}
	/**
	 * Getter de minuts
	 * @return Minutes
	 */
	public int getMinutes(){
		
		return this.minutes;
	}
	/**
	 * Reprodueix la can��
	 * @param b Slider
	 * @return Playing status
	 * @throws Exception
	 */
	public String play(JSlider b)throws Exception{
		t = "No existe ningun archivo...";
		if (todoOk){
			//si no se esta reproduciendo

			if(!run){
				player.play();
				this.run = true;
				t = "Reproduciendo";
			//this.startAnimation(b);
			//this.startSeconds(b);
			}else{
				//player.stop();
				System.out.println("SON IGUALLLLLLLLLLLLs STOP2");
			}
		}
		return t;
	}
/*
	public void startSeconds(final JSlider b){
		seconds = 0;
		minutes = 0;
		tiempo = new Timer();
		task = new TimerTask() {
			public void run() {
				if(player.getStatus() == 0 && framesSongActual > 1.0){
					
					if( seconds >= 59 ){
						seconds = 0;
						minutes ++;
						
					}else{
						seconds++;
					}
					
				}
			}
			
		};
		//se inicia la animacion
		tiempo.schedule(task,0,1000);
	}
	
	public void startAnimation(final JSlider b) {
			
		if (todoOk) {
			
			//seconds = 0;
			//minutes = 0;
			tiempo = new Timer();
			task = new TimerTask() {
				public void run() {

					if(player.getStatus() == 0 && framesSongActual > 1.0){

							
							//System.out.println("el VALOR DEL FRAME DEL JSLIDER :" + b.getValue());
						//minutes = (int) Math.round(microsecondsSongActual/0.000000016667);
						//seconds =  (int) Math.round(microsecondsSongActual % 0.000000016667);	
						

						//System.out.println("La posici� de frame de  framesSongActual: "+framesSongActual );
							frameSlider =  framesSongActual.intValue()*100/ framesSong.intValue();
							//System.out.println("La posici� que s'envia al JSlider es : "+frameSlider );
							//System.out.println("RUNABLE framesSongActual :" + framesSongActual + "framesSong : " + framesSong);
							//frameSlider = frameNow * 100/ (int) Math.round(bytesLength);
							b.setValue(frameSlider);
							//System.out.println("La posici� del JSlider es : "+b.getValue() );
						
					}else if( player.getStatus() == 2){

						b.setValue(0);
					}
				}
			};
			//se inicia la animacion
			tiempo.schedule(task,0,speed);
			//System.out.println("�SE ACABA LA SOOOOOOOOOOONG?");
		}
	}*/

	//public String AbrirMp3(String ruta) throws Exception{
	/**
	 * Obre l'arxiu d'audio a reproduir
	 * @param ruta Ruta de l'arxiu d'audio que es vol obrir
	 * @throws Exception
	 */
	public void abrirMp3(String ruta) throws Exception{

		//URL url = new URL("file:/C:/Users/Marc/Downloads/Quentin Tarantino Soundtracks Discography - HTD 2015/Pulp Fiction (Collector's Edition) (2009) - Soundtrack/04. Let's Stay Together.mp3");
		//try {

		//si se esta reproduciendo un mp3, se detiene
		if(todoOk){
			this.stop();
		}

		//se coloca el nombre de la cancion en la variable file
		//this.file = fileChooser.getSelectedFile().getName();
		//try{
		//se coloca a true
		//se asigna el mp3 al reproductor
		player.open(new File(ruta));
		
		this.nameSong = ruta;
		
		opened(new File(ruta), empty_map);

		/*		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		this.todoOk = true;
		//System.out.println(player.getMixerName());
		//player.setPan(0.50);


		//System.out.println("El get pan es : " + player.getPan());
	}
	/**
	 * Getter del nom de la can��
	 * @return Song name
	 */
	public String getName(){
		
		String[] itemsSong = nameSong.split("/");
		String finalName = "";
		for(int i = 0; i < itemsSong.length ; i++){
			finalName = itemsSong[i];
		}
		return finalName;
		
	}
	/**
	 * Getter del status de la reproducci�
	 * @return Playing status
	 */
	public int getStatus(){
		
		return player.getStatus();
	
	}
	/**
	 * Atura l'animaci� de reproducci�
	 */
	public void stopAnimation() {
		//System.out.println("INDICO al temps que es cancela");

		tiempo.cancel();

		//System.out.println("INDICO al task time temps que es cancela");
		task.cancel();            
	}
	/**
	 * Pausa la reproducci�
	 * @throws Exception
	 */
	public void pause() throws Exception {
		//this.nameSong = "/PAUSE";
		player.pause();
		//tiempo.wait();
		//task.wait();
	}
	/**
	 * Repr�n la reproducci�
	 * @throws Exception
	 */
	public void resume() throws Exception {
		player.resume();
		//tiempo.
	}
	/**
	 * Indica si la reproducci� ha terminat
	 * @return <i style="color:indigo;">FALSE</i> si la reproducci� no ha concl�s. <i style="color:indigo">TRUE</i> si aquesta ha concl�s.
	 */
	public boolean isEnded(){
		
		if (player.getStatus() == 2){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * Atura la reproducci�
	 * @throws Exception
	 */
	public void stop() throws Exception {
		player.stop();
		this.todoOk = false;
		//this.nameSong = "/ ";
		//return "stop";
		//stopAnimation();
	}
	
	@Override
	/**
	 * Necesario por implementar BasicPlayerListener. Es ejecutado una vez se
	 * carga un fichero. En este caso, obtiene el tama�o en bytes del fichero. 
	 */
	public void opened(Object arg0, Map arg1) {
		if (arg1.containsKey("audio.length.bytes")) {
			bytesLength = Double.parseDouble(arg1.get("audio.length.bytes").toString());
		}
		if (arg1.containsKey("audio.length.frames")) {
			framesSong = Double.parseDouble(arg1.get("audio.length.frames").toString());
		}
		if (arg1.containsKey("duration")) {
			durationSong = Double.parseDouble(arg1.get("duration").toString());
		}
		
		//System.out.println("propiedades: " + arg1);
		
	}
	/**
	 * Retorna el frame al que estroba l'slider
	 * @return Actual slider frame
	 */
	public int getFrameSlider(){
		return frameSlider;
	}
	//Imaginad que quer�is usarlo en un jSlider, solamente habr�a que fijar el m�ximo del slider en bytesLength y el valor actual en lo que diga progress

	/** 
	 *  Necesario por implementar BasicPlayerListener. Seg�n la documentaci�n,
	 * este m�todo es llamado varias veces por segundo para informar del
	 * progreso en la reproducci�n. 
	 */
	public void progress(int bytesread, long microseconds, byte[] pcmdata,  Map properties) {
		float progressUpdate = (float) (bytesread * 1.0f / bytesLength * 1.0f);
		int progressNow = (int) (bytesLength * progressUpdate);
		// Descomentando la siguiente l�nea se mosrtar�a el progreso
		frameNow = (int)(bytesLength * progressUpdate);
		
		
		if (properties.containsKey("mp3.frame")) {
			framesSongActual = Double.parseDouble(properties.get("mp3.frame").toString());
		}
		if (properties.containsKey("mp3.position.microseconds")) {
			microdecondsSongActual = Double.parseDouble(properties.get("mp3.position.microseconds").toString());
		}
		
		minutes = (int)(float)(microdecondsSongActual*1.0f / 1000000*1.0f)/60;
		seconds = (int)(float)(microdecondsSongActual*1.0f / 1000000*1.0f)%60;
		
		frameSlider = (int)(float)(microdecondsSongActual * 100 / durationSong);
		//if (properties.containsKey("mp3.position.microseconds")) {
		//	microsecondsSongActual = (Double.parseDouble(properties.get("mp3.position.microseconds").toString()));
		//}
		//System.out.println("propiedades: " + properties);
		//System.out.println("PROGRESS framesSongActual: " + framesSongActual );
		//System.out.println(" -&gt; " + progressNow);

		//System.out.println("progressUpdate: " + progressUpdate + "bytesLength: " + bytesLength);
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
	
	
	//PROCEDIMENTS OBLIGATORIS D'IMPLEMENTAR JA QUE ESTEM UTILITZANT una clase implementada de BasicPlayerListener
	/**
	 * 
	 */
	@Override
	public void setController(BasicController arg0) {
		// TODO Auto-generated method stub

	}
	/**
	 * 
	 */
	@Override
	public void stateUpdated(BasicPlayerEvent arg0) {
		// TODO Auto-generated method stub

	}
}
