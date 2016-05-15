package main;

import customExceptions.DatabaseNotLoadedException;
import model.DDBBConnection;

public class Main {

	public static void main(String[] args) {
		DDBBConnection ddbbConnection = new DDBBConnection ("root", "", "espotyfai", 3306);
		String username = "Omeja";
		String password = "password";
		
		try {
			
			ddbbConnection.startConnection();
			
			System.out.println("going to test ddbbConnection");
			
			
			System.out.println("\nUsuarios:");
			System.out.println (ddbbConnection.showUsers()); 
			
			System.out.println("\nConexion con un usuario: Omeja");
			String message = ddbbConnection.userConnection(username, password);
			System.out.println ("message: "+message); 
			if (message.equals("Correct")){
				ddbbConnection.updateLastAcces(username);
				System.out.println("Ultima conexion actualizada");
			}
			
			System.out.println("\nAñadir un nuevo usuario: Maria");
			System.out.println(ddbbConnection.addUser("Maria", "sisi"));
			
			System.out.println("\nUsuarios:");
			System.out.println (ddbbConnection.showUsers());
			
			System.out.println("\nEliminar un usuario: Maria");
			System.out.println(ddbbConnection.deleteUser("Maria"));
			
			System.out.println("\nUsuarios:");
			System.out.println (ddbbConnection.showUsers());
			
			System.out.println("\nCanciones:");
			System.out.println (ddbbConnection.showSongs());
			
			System.out.println("\nAñadir un nueva cancion: Algo");
			System.out.println (ddbbConnection.addSong("Algo", "Porqueria", "Alguien", "Basura", null, 0));
			
			System.out.println("\nCanciones:");
			System.out.println (ddbbConnection.showSongs());
			
			System.out.println("\nEliminar un cancion: Algo");
			System.out.println (ddbbConnection.deleteSong(4));
			
			System.out.println("\nCanciones:");
			System.out.println (ddbbConnection.showSongs());
			
			System.out.println("\nSeguidores:");
			System.out.println (ddbbConnection.showFollows());
			
			ddbbConnection.stopConnection();
			
		} catch (DatabaseNotLoadedException e) {
			System.out.println(e.getMessage());
		}
		
		
	}
}
