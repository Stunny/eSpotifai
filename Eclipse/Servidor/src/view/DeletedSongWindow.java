package view;


import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

//Ventana para informar al usuario de que se ha eliminado correctamente el coche
@SuppressWarnings("serial")
public class DeletedSongWindow extends JFrame {
	//Atributo que contiene el mensaje 
	private JLabel jlEtiqueta;
	
	public DeletedSongWindow() {
		//Creamos una etiqueta que ponga el mensaje 
		jlEtiqueta = new JLabel("La cancion ha sido eliminado correctamente");
		//Alineamos el texto
		jlEtiqueta.setHorizontalAlignment(JLabel.CENTER);
		
		//Añadimos el panel del mensaje al panel principal que se nos mostrará
		getContentPane().add(jlEtiqueta, BorderLayout.CENTER);
		
		//Determinamoas las caracteristicas de esta ventana emergente
		setSize(300,100);
		setTitle("REMOVE: ");
		setLocationRelativeTo(null);
		
		//Indicamos como cerrar la ventana
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
}