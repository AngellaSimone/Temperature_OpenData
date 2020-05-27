package es_20;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GraficoIngrandito extends JPanel
{

    public static ArrayList<ModelloTemperature> modello = new ArrayList<ModelloTemperature>();//creazione array list

    public GraficoIngrandito(ArrayList<ModelloTemperature> modello) {
        this.modello = modello;
    }

    public void paint(Graphics g1) {

        int startx = 65;//partenza cordinata x(anni dell'asse x)
        int starty = 565;//partenza cordinata y(anni dell'asse x)

        int startxn = 32;//partenza cordinata x(numeri dell'asse y)
        int startyn = 550;//partenza cordinata y(numeri dell'asse y)

        int startxl = 80;//partenza cordinata x(linee tracciate nel grafico)
        int startyl = 47;//partenza cordinata y(linee tracciate nel grafico)

        g1.setColor(Color.black);

        //creazione asse y
        g1.drawLine(50, 550, 50, 5);
        //creazione asse y

        //freccia asse y
        g1.drawLine(50, 0, 43, 13);
        g1.drawLine(50, 0, 57, 13);
        //freccia asse y

        //creazione asse x
        g1.drawLine(50, 550, 1245, 550);
        //creazione asse x

        //freccia asse x
        g1.drawLine(1250, 550, 1237, 543);
        g1.drawLine(1250, 550, 1237, 557);
        //freccia asse x


        g1.setColor(Color.black);

        //for per la stampa del grafico
        for (int i = 0; i < modello.size() - 1; i++) {
            float f1 = 0;
            float f2 = 0;

            int i1 = 0;
            int i2 = 0;

            String st1 = "";
            String st2 = "";

            st1 = String.format("%.2f", modello.get(i).getTempMedia()).replace(',', '.');//TempMedia viene approssimato alla 2 cifra dopo la virgola//modifico i carattere presente ',' con '.'
            st2 = String.format("%.2f", modello.get(i + 1).getTempMedia()).replace(',', '.');//TempMedia viene approssimato alla 2 cifra dopo la virgola//modifico i carattere presente ',' con '.'

            f1 = Float.parseFloat(st1) * 100;//tolgo la virgola moltiplicando per 100
            f2 = Float.parseFloat(st2) * 100;//tolgo la virgola moltiplicando per 100

            i1 = (int) f1;//casting float---->int
            i2 = (int) f2;//casting float---->int

            //prova
            //System.out.println("1  " + i1);
            //prova

            g1.drawLine(startxl, 1050-i1, startxl + 44, 1050-i2);//stampa linee del grafico

            g1.setColor(Color.red);
            g1.fillOval(startxl-2, 1050-i1-2, 3, 4);//stampa eriempimento punti di intersezione tra le linee
            //g.drawLine(startxl, 550, startxl, 550 - (i1/2));//tracciamento linee dalle cordinate degli anni sull asse x, fino all'intersezione sulle linee del grafico
            g1.setColor(Color.black);

            startxl += 44;//incremento delle x
        }
        //for per la stampa del grafico

        /*------------------------------------
        int y = 900;
        while(y>50)
        {
            g.setColor(Color.red);
            g.drawLine(200, y, 200, y - 10);
            y = y-10;
        }
        *///----------------------------------

        //for per la stampa dell'anno sull'asse y
        for (int i = 0; i < modello.size(); i++)
        {
            g1.drawString(modello.get(i).getAnno(), startx, starty);
            startx += 44;
        }
        //for per la stampa dell'anno sull'asse y

//---------------------------------------------------------------------------------------------
        //for per la stampa dei numeri sull'asse x
        g1.drawString(0 + "°", startxn, startyn);
        startyn -= 100;
        g1.drawString("..." + "°", startxn, startyn);
        startyn -= 100;
        g1.drawString(7 + "°", startxn, startyn);
        startyn -= 100;
        g1.drawString(8 + "°", startxn, startyn);
        startyn -= 100;
        g1.drawString(9 + "°", startxn, startyn);
        startyn -= 100;
        g1.drawString(10 + "°", startxn, startyn);
        startyn -= 100;
        //for per la stampa dell'anno sull'asse x
//----------------------------------------------------------------------------------------------
    }
}
