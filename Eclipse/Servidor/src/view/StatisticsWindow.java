package view;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;







import model.Song;
import controller.ButtonsController;

public class StatisticsWindow extends JDialog{


	private JPanel jpStatistics;
	private JPanel jpGraphic;

	private BorderLayout blStatistics;
	private GridLayout glGraphic;
	private LinkedList<Song> songs;
	private LinkedList<Song> listSortSongs;

	private int maxNum = 0;

	public StatisticsWindow(LinkedList<Song> s) {

		//System.out.println("AQUI ANTES declaraciones ");
		jpStatistics = new JPanel();
		blStatistics = new BorderLayout();
		setContentPane(jpStatistics);
		jpStatistics.setLayout(null);

		//System.out.println("AQUI DESPUES declaraciones ");

		songs = new LinkedList<Song>();
		this.songs = s;
		listSortSongs = new LinkedList<Song>();

		listSortSongs = sortSongs(songs);

		//System.out.println("AQUI ANTES repaint ");
		repaint();
		//System.out.println("AQUI DESPUES  repaint");

		jpStatistics.setBorder(BorderFactory.createTitledBorder("Stadistics Top 10 songs of eSpotifai"));

		//Assignem titol a la finestra
		this.setTitle(" TOP 10 SONGS ");

		this.setSize(new Dimension(1100,680));
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

	}

	public void paint(Graphics g){

		super.paint(g);

		int j = 0;

		g.setColor(new Color(0, 0, 0));
		g.fillRect(90, 60, 3, 580);

		g.setColor(new Color(0, 0, 0));
		g.fillRect(20,600, 1060,3);
		g.drawString("n� " + '\n' + "reproductions", 100,70);
		maxNum = 0;

		//System.out.println("AQUI ANTES ");
		while ( j < listSortSongs.size() && j < 10){

			//System.out.println("TAMANYO : " + listSortSongs.size());

			int v1 = listSortSongs.get(j).getReproducciones();
			//System.out.println("listSortsongs top ordenats " + 0 + "  name " + listSortSongs.get(j).getName());

			//System.out.println("listSortsongs top ordenats " + 0 + "  name " + listSortSongs.get(j).getReproducciones());

			if( maxNum <= v1){
				maxNum = v1;
			}
			//System.out.println("j : " + j);
			j++;
		}
		//System.out.println("AQUI DESPUES");

		int xRect = 120;
		int xRectName = 120;
		int colorGreen = 0;
		int colorBlue = 0;
		int colorRed = 0;

		if ( maxNum == 0){
			maxNum++;
		}

		j = 0;
		while( j < listSortSongs.size() && j < 10){

			//System.out.println("NAME : " + listSortSongs.get(j).getName() + "views : " + listSortSongs.get(j).getReproducciones());

			int s1 = listSortSongs.get(j).getReproducciones();

			int large = (listSortSongs.get(j).getReproducciones())*500/maxNum;

			if(large == 0){
				large = large +5;
			}

			//System.out.println("NAME : " + listSortSongs.get(j).getName() + "large barra estadisticas " + large);

			//1r camp x
			//2o camp y, comen�a a printar-se la barra
			//3r camp grossor de la barra
			//4o camp longitud de barra

			g.setColor(new Color(colorRed,colorGreen,colorBlue));
			g.fillRect(xRectName,600-large,40,large);
			g.drawString(listSortSongs.get(j).getName(), xRectName, 620);
			g.drawString(s1+"", 40, 600-large-2);

			xRect = xRect +100;

			colorGreen = randomice(0,255);
			colorBlue = randomice(0,255);
			colorRed = randomice(0,255);
			xRectName = xRectName +100;


			j++;
		}
	}
	public static int randomice(int max,int min){
		return (int)(Math.random()*(max-min))+min;  
	}

	public LinkedList<Song> sortSongs(LinkedList<Song> songs){
		int i, j;
		Song auxSong;
		LinkedList<Song> auxTop10 = new LinkedList<Song>();

		for( i = 0; i<songs.size()-1; i++){
			for(j = 0; j < (songs.size()-i-1); j++){
				if(songs.get(j+1).getReproducciones() < songs.get(j).getReproducciones()){

					// //System.out.println("songs top desordenats" + j + "name " + songs.get(j).getName());
					auxSong = songs.get(j+1);
					songs.set(j+1, songs.get(j));
					songs.set(j, auxSong);
				}
			}

		}
		int s = 0;
		while (s < songs.size() && s < 10){
			////System.out.println("songs top ordenats" + s + "name " + songs.get(s).getName());
			auxTop10.add(songs.get(s));
			s++;
		}
		////System.out.println("songs top ordenats" + 0 + "name " + songs.get(0).getName());

		////System.out.println("songs top ordenats" + 0 + "name " + songs.get(1).getName());
		return auxTop10;
	}
}