package view;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;





import controller.ButtonsController;

public class StatisticsWindow extends JDialog{


    private JPanel jpViewStadistics;
    private JPanel jpStadisticGraphics;
    
    private BorderLayout blViewStadistics;
    private GridLayout glStadisticGraphics;
    
    private JLabel jlSong1;
    private JLabel jlSong2;
    private JLabel jlSong3;
    private JLabel jlSong4;
    private JLabel jlSong5;
    private JLabel jlSong6;
    private JLabel jlSong7;
    private JLabel jlSong8;
    private JLabel jlSong9;
    private JLabel jlSong10;
    private JLabel jlNumSong1;
    private JLabel jlNumSong2;
    private JLabel jlNumSong3;
    private JLabel jlNumSong4;
    private JLabel jlNumSong5;
    private JLabel jlNumSong6;
    private JLabel jlNumSong7;
    private JLabel jlNumSong8;
    private JLabel jlNumSong9;
    private JLabel jlNumSong10;
    
    
    
    public StatisticsWindow() {

        jpViewStadistics = new JPanel();
        blViewStadistics = new BorderLayout();
        setContentPane(jpViewStadistics);
        jpViewStadistics.setLayout(null);
        
        //Creo un altre panell per inserir les barres estadistiques
        /*jpStadisticGraphics = new JPanel();
        glStadisticGraphics = new GridLayout(2,10);
        jpStadisticGraphics.setLayout(glStadisticGraphics);
        */
        /*	
        	CREACIÓ DE BARRESSSSSSS
        	HERE
        */
        /*
        jlSong1 = new JLabel();
        jlSong1.setHorizontalAlignment(JLabel.CENTER);
        jlSong1.setText("Song1");
        
        jlSong2 = new JLabel();
        jlSong2.setHorizontalAlignment(JLabel.CENTER);
        jlSong2.setText("Song2");
        
        jlSong3 = new JLabel();
        jlSong3.setHorizontalAlignment(JLabel.CENTER);
        jlSong3.setText("Song3");

        jlSong4 = new JLabel();
        jlSong4.setHorizontalAlignment(JLabel.CENTER);
        jlSong4.setText("Song4");

        jlSong5 = new JLabel();
        jlSong5.setHorizontalAlignment(JLabel.CENTER);
        jlSong5.setText("Song5");

        jlSong6 = new JLabel();
        jlSong6.setHorizontalAlignment(JLabel.CENTER);
        jlSong6.setText("Song6");

        jlSong7 = new JLabel();
        jlSong7.setHorizontalAlignment(JLabel.CENTER);
        jlSong7.setText("Song7");

        jlSong8 = new JLabel();
        jlSong8.setHorizontalAlignment(JLabel.CENTER);
        jlSong8.setText("Song8");

        jlSong9 = new JLabel();
        jlSong9.setHorizontalAlignment(JLabel.CENTER);
        jlSong9.setText("Song9");

        jlSong10 = new JLabel();
        jlSong10.setHorizontalAlignment(JLabel.CENTER);
        jlSong10.setText("Song10");
        
        jpStadisticGraphics.add(jlSong1);
        jpStadisticGraphics.add(jlSong2);
        jpStadisticGraphics.add(jlSong3);
        jpStadisticGraphics.add(jlSong4);
        jpStadisticGraphics.add(jlSong5);
        jpStadisticGraphics.add(jlSong6);
        jpStadisticGraphics.add(jlSong7);
        jpStadisticGraphics.add(jlSong8);
        jpStadisticGraphics.add(jlSong9);
        jpStadisticGraphics.add(jlSong10);
        */
        
        repaint();
        
        jpViewStadistics.setBorder(BorderFactory.createTitledBorder("Stadistics Top 10 songs of eSpotifai"));
		//Assignem titol a la finestra
		this.setTitle(" TOP 10 SONGS ");

		this.setSize(new Dimension(1100,680));
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);

    }

    public void paint(Graphics g)
    {
        super.paint(g);

            String s1 = "100";
            String s2 = "200";
            String s3 = "400";
            String s4 = "100";
            String s5 = "2000";
            String s6 = "4500";
            String s7 = "1400";
            String s8 = "2700";
            String s9 = "4040";
            String s10 = "1400";
            
            int v1=Integer.parseInt(s1);
            int v2=Integer.parseInt(s2);
            int v3=Integer.parseInt(s3);
            int v4=Integer.parseInt(s4);
            int v5=Integer.parseInt(s5);
            int v6=Integer.parseInt(s6);
            int v7=Integer.parseInt(s7);
            int v8=Integer.parseInt(s8);
            int v9=Integer.parseInt(s9);
            int v10=Integer.parseInt(s10);
            
            int mayor = retornarMayor(v1,v2,v3,v4,v5,v6,v7,v8,v9,v10);
            
            int large1=v1*500/mayor;
            int large2=v2*500/mayor;
            int large3=v3*500/mayor;
            int large4=v4*500/mayor;
            int large5=v5*500/mayor;
            int large6=v6*500/mayor;
            int large7=v7*500/mayor;
            int large8=v8*500/mayor;
            int large9=v9*500/mayor;
            int large10=v10*500/mayor;

            g.setColor(new Color(0, 0, 0));
            g.fillRect(90, 60, 3, 580);
            
            g.setColor(new Color(0, 0, 0));
            g.fillRect(20,600, 1060,3);
            g.drawString("nº " + '\n' + "reproductions", 100,70);
            
            //1r camp x
            //2o camp y, comença a printar-se la barra
            //3r camp grossor de la barra
            //4o camp longitud de barra
            
            g.setColor(new Color(255,0,0));
            g.fillRect(120,600-large1,40,large1);
            g.drawString("Song 1", 120, 620);
            g.drawString(s1, 40, 600-large1-2);

            g.setColor(new Color(0,128,0));
            g.fillRect(220,600-large2,40,large2);
            g.drawString("Song 2", 220, 620);
            g.drawString(s2, 40, 600-large2-2);

            g.setColor(new Color(0,0,255));
            g.fillRect(320,600-large3, 40, large3);
            g.drawString("Song 3", 320, 620);
            g.drawString(s3, 40, 600-large3-2);
            
            g.setColor(new Color(255,50,0));
            g.fillRect(420,600-large4, 40, large4);
            g.drawString("Song 4",420, 620);
            g.drawString(s4, 40, 600-large4-2);

            g.setColor(new Color(0,128,50));
            g.fillRect(520,600-large5,40, large5);
            g.drawString("Song 5", 520, 620);
            g.drawString(s5, 40, 600-large5-2);

            g.setColor(new Color(50,0,255));
            g.fillRect(620,600-large6,40, large6);
            g.drawString("Song 6",620, 620);
            g.drawString(s6, 40, 600-large6-2);
            
            g.setColor(new Color(255,90,0));
            g.fillRect(720,600-large7,40,large7);
            g.drawString("Song 7", 720, 620);
            g.drawString(s7, 40, 600-large7-2);

            g.setColor(new Color(0,128,90));
            g.fillRect(820,600-large8,40, large8);
            g.drawString("Song 8", 820, 620);
            g.drawString(s8, 40, 600-large8-2);

            g.setColor(new Color(90,0,255));
            g.fillRect(920,600-large9,40, large9);
            g.drawString("Song 9", 920, 620);
            g.drawString(s9, 40, 600-large9-2);
            
            g.setColor(new Color(255,0,100));
            g.fillRect(1020,600-large10,40, large10);
            g.drawString("Song 10", 1020, 620);
            g.drawString(s10, 40, 600-large10-2);
    }
    
	private int retornarMayor(int v1,int v2,int v3, int v4,int v5,int v6, int v7, int v8, int v9, int v10){
		
		int max1 = Math.max(v1, v2);
		int max2 = Math.max(max1,v3);
		int max3 = Math.max(max2,v4);
		int max4 = Math.max(max3,v5);
		int max5 = Math.max(max4,v6);
		int max6 = Math.max(max5,v7);
		int max7 = Math.max(max6,v8);
		int max8 = Math.max(max7,v9);
		int max9 = Math.max(max8,v10);
		
		return max9;
	}
       
}