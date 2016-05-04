package provaConfigurationServer;

import java.util.Scanner;

import view.ManagementMusicAddView;
import view.ManagementMusicView;;

public class Main {
	
	public static void main(String[] args ){
		
		login();
		
		ManagementConfiguration mc = new ManagementConfiguration();
		mc.runConfiguration();
		
		// Creem la VISTA
		ManagementMusicView mainView = new ManagementMusicView();
		mainView.setVisible(true);
		
		//Creem la vista temporal de adició
		ManagementMusicAddView addView = new ManagementMusicAddView();
		addView.setVisible(true);
		
	}
	
	private static void login() {
		boolean ok = false;
		Scanner sc = new Scanner(System.in);
		LoginManager lm = new LoginManager();
		
		
		while (!ok) {
		System.out.println("1.-login 2.-register");
		int option = sc.nextInt();
		String dummy = sc.nextLine();
		
		System.out.println("user? ");
		String user = sc.nextLine();
		
		System.out.println("password? ");
		String password = sc.nextLine();
		
		
		switch (option) {
		case 1: ok = lm.login(user, password);
		break;
		case 2: ok = lm.register(user, password);
		break;
		default: ok = false;
		}
		
		
		if (ok) System.out.println("ok!");
		
		}
	}
}

