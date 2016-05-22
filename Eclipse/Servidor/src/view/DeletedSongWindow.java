package view;


import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

//Ventana para informar al usuario de que se ha eliminado correctamente el coche
@SuppressWarnings("serial")
/**
 * Informa de la correcta eliminaci� d'una can��
 * @author Elna Cabot, Miguel D�az, Marc Mill�n, Alejandro Vogel, Marta Zapatero
 * @version 1.0
 * @see JLabel
 * @see JFrame
 * 
 *
 */
public class DeletedSongWindow extends JFrame {
	//Atributo que contiene el mensaje 
	/**
	 * Etiqueta del missatge
	 */
	private JLabel jlEtiqueta;
	/**
	 * Construeix la finestra que infoirma de la correcta eliminaci� de la can��
	 */
	public DeletedSongWindow() {
		//Creamos una etiqueta que ponga el mensaje 
		jlEtiqueta = new JLabel("La cancion ha sido eliminado correctamente");
		//Alineamos el texto
		jlEtiqueta.setHorizontalAlignment(JLabel.CENTER);
		
		//A�adimos el panel del mensaje al panel principal que se nos mostrar�
		getContentPane().add(jlEtiqueta, BorderLayout.CENTER);
		
		//Determinamoas las caracteristicas de esta ventana emergente
		setSize(300,100);
		setTitle("REMOVE: ");
		setLocationRelativeTo(null);
		
		//Indicamos como cerrar la ventana
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
}