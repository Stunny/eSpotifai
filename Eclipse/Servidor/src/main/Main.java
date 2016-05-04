package main;

import model.BBDDconnection;

public class Main {

	public static void main(String[] args) {
		BBDDconnection dataBase = new BBDDconnection ("root", "", "espotyfai", 3306);
		String user = "Omeja";
		String password = "password";
		
		dataBase.startConnection();
		
		System.out.println("\nUsuarios:");
		System.out.println (dataBase.showUsers()); 
		
		System.out.println("\nConexion con un usuario: Omeja");
		String mensaje = dataBase.userConnection(user, password);
		System.out.println ("Mensaje: "+mensaje); 
		if (mensaje.equals("Correct")){
			dataBase.updateLastAcces(user);
			System.out.println("Ultima conexion actualizada");
		}
		
		System.out.println("\nAñadir un nuevo usuario: Maria");
		System.out.println(dataBase.addUser("Maria", "sisi"));
		
		System.out.println("\nUsuarios:");
		System.out.println (dataBase.showUsers());
		
		System.out.println("\nEliminar un usuario: Maria");
		System.out.println(dataBase.deleteUser("Maria"));
		
		System.out.println("\nUsuarios:");
		System.out.println (dataBase.showUsers());
		
		System.out.println("\nCanciones:");
		System.out.println (dataBase.showSongs());
		
		System.out.println("\nAñadir un nueva cancion: Algo");
		System.out.println (dataBase.addSong("Algo", "Porqueria", "Alguien", "Basura", null, 0));
		
		System.out.println("\nCanciones:");
		System.out.println (dataBase.showSongs());
		
		System.out.println("\nEliminar un cancion: Algo");
		System.out.println (dataBase.deleteSong(4));
		
		System.out.println("\nCanciones:");
		System.out.println (dataBase.showSongs());
		
		System.out.println("\nSeguidores:");
		System.out.println (dataBase.showFollows());
		
		dataBase.stopConnection();
	}
}
