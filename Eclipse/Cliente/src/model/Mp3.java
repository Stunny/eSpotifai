package model;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.media.CannotRealizeException;
import javax.media.Clock;
import javax.media.Duration;
import javax.media.Manager;
import javax.media.NoPlayerException;
import javax.media.Player;
import javax.swing.JFileChooser;
import javax.swing.JSlider;
import javax.swing.filechooser.FileNameExtensionFilter;


public class Mp3 {
	
	//el player
	private CustomPlayer customPlayer;
	//animacion tiempo
	private Timer tiempo ;
	private TimerTask task;
	//velocidad
	private int speed = 1000;
	//Frame reproductor
	private int frame=0;
	//control    
	boolean todo_ok = false;									
	boolean run = false;    
										
	//archivo
	URL mediaURL = null;
	String file = "";   
	String t = null;
	
	//filtro
	private static FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo MP3","mp3","mp3");
	
	//el constructor vacio
	public Mp3() {} 

	/* controles de reproduccion */
	public String STOP(){
		//comprueba que el reproductor tenga un archivo
		if (todo_ok){
			try {
				customPlayer.stop();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.todo_ok = false;
			this.run = false;
			this.file = "";
			this.stopAnimation();
		}
		return "Reproductor MP3";
	}

	/* Reproduce un archivo mp3, si no encuentra ninguno devuelve
	un string con mensaje */
	public String PLAY(JSlider b){
		t = "No existe ningun archivo...";
		if (todo_ok){
			//si no se esta reproduciendo
			
			if(!run){
				try {
					customPlayer.play(b);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				this.run = true;
				t = "Reproduciendo";
				this.startAnimation(b);
			}
		}
		return t;
	}

	//para la animacion  
	public void startAnimation(final JSlider b) {    
		if (todo_ok) {
			tiempo = new Timer();           
			task = new TimerTask() {               
				public void run() {     
					//calculamos el tiempo de la animacion por 100%
					System.out.println("MediaTime= "+ ((Clock) customPlayer).getMediaTime());
					System.out.println("MediaTimeSeconds= "+((Clock) customPlayer).getMediaTime().getSeconds());
					frame = (int) Math.round((((Clock) customPlayer).getMediaTime().getSeconds() * 100)/((Duration) customPlayer).getDuration().getSeconds());
					//cuando ambos sean iguales quiere decir que el video a alcanzado el final de la reproduccion
					if(((Clock) customPlayer).getMediaTime().getSeconds() == ((Duration) customPlayer).getDuration().getSeconds()){                    
						 // 100%
						frame = 100;
						
						//SE DETIENE Y DESTRUYE EL MEDIA PLAYER
						STOP();
					}else{
						// Se actualiza el nuevo valor del Slider
						b.setValue(frame);                     
						//Porcentaja de reproduccion
						System.out.println("Tiempo de reproduccion: " + frame + "% de 100%");
					}
				}
			};
			//se inicia la animacion                                                   
			tiempo.schedule(task,0,speed); 
		}
	}

	//detiene la animacion
	public void stopAnimation() {
		System.out.println("INDICO al temps que es cancela");
		
		tiempo.cancel();

		System.out.println("INDICO al task time temps que es cancela");
		task.cancel();            
	}

	/* Metod que muestra una ventana de dialgo para añadir "archivos" al reproductor
	 * hace uso del metodo anterior "setvideo"
	 */
	public String AbrirMp3() throws MalformedURLException{
		//JFileChooser fileChooser = new JFileChooser();     
		//fileChooser.setFileFilter(filter);
		//int result = fileChooser.showOpenDialog(null);
		System.out.println("just obro el procediment ABRIR MP3");
		URL url = new URL("file:/C:/Users/Marc/Downloads/Quentin Tarantino Soundtracks Discography - HTD 2015/Pulp Fiction (Collector's Edition) (2009) - Soundtrack/04. Let's Stay Together.mp3");
		System.out.println("INDICO LA RUTA DE LA CAN�O");
		//if ( result == JFileChooser.APPROVE_OPTION ){
			try {
				//si se esta reproduciendo un mp3, se detiene
				if(todo_ok){
					this.STOP();
				}
				//System.out.println("asigno a file el nom de la can�o que es reproduir�");
				
				//se asigna a mediaURL el archivo de la pista seleccionada
				//URL url = fileChooser.getSelectedFile().toURL();
				//se coloca el nombre de la cancion en la variable file
				//this.file = fileChooser.getSelectedFile().getName();
				//se asigna el mp3 al reproductor
				System.out.println("Assigno el mp3 al reproductor mediaPlayer");
				//mediaPlayer = Manager.createRealizedPlayer( url );
				customPlayer = (CustomPlayer) Manager.createRealizedPlayer( url );
				
				
				//se coloca a true
				this.todo_ok = true;          
			} catch (NoPlayerException ex) {
				Logger.getLogger(Mp3.class.getName()).log(Level.SEVERE, null, ex);
			
			} catch (CannotRealizeException ex) {
				Logger.getLogger(Mp3.class.getName()).log(Level.SEVERE, null, ex);
			
			} catch (IOException ex) {                
				Logger.getLogger(Mp3.class.getName()).log(Level.SEVERE, null, ex);
			} 
		//}
		return "Reproductor mp3 - " + this.file;
	}
}

