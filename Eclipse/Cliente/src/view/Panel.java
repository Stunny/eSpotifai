package view;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
/**
 * 
 * @author Elna Cabot, Miguel Diaz, Marc Millan, Alejandro Vogel, Marta Zapatero
 * @version 1.0
 * @see JPanel
 *
 */
public class Panel extends JPanel{
	ImageIcon imagen; 
	String nombre; 
	/**
	 * Constructor de Panel
	 * @param nombre
	 */
	public Panel(String nombre){
		this.nombre = nombre;
	}
	/**
	 * Representa i coloca el Panel
	 */
	public void paint(Graphics g){
		Dimension tamanio = getSize(); 
		imagen  = new ImageIcon(getClass().getResource(nombre)); 
		g.drawImage(imagen.getImage(), 0, 0, tamanio.width, tamanio.height, null);
		setOpaque(false);
		super.paint(g);
	}
	
}
