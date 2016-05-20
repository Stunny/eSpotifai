package view;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;


/**
 * Clase heretada de JPanel per a la creaci� d'espais per Imatges.
 * @author Elna Cabot, Miguel Diaz, Marc Millan, Alejandro Vogel, Marta Zapatero
 * @version 1.0
 * @see JPanel
 */

public class Image extends javax.swing.JPanel {
	/**
	 * Constructor que especifica les dimensions del JPanel a 300x400. 
	 */
	public Image() {
		this.setSize(300, 400); //se selecciona el tamaño del panel
	}
 
	/**
	 * Selecciona y dibuixa a un panell una imatge continguda al paquet del programa
	 * @param grafico 
	 * @see Graphics
	 */
 
	public void paint(Graphics grafico) {
		Dimension height = getSize();
 
		//Se selecciona la imagen que tenemos en el paquete de la //ruta del programa
 
		ImageIcon Img = new ImageIcon(getClass().getResource("/Images/Diagrama.png")); 
 
		//se dibuja la imagen que tenemos en el paquete Images //dentro de un panel
 
		grafico.drawImage(Img.getImage(), 0, 0, height.width, height.height, null);
 
		setOpaque(false);
		super.paintComponent(grafico);
	}
}