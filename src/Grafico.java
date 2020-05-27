package es_20;


        import java.awt.Graphics;
        import javax.swing.JFrame;
        import java.awt.*;
        import java.util.ArrayList;
        import javax.swing.*;

public class Grafico extends JPanel
{

    public static ArrayList<ModelloTemperature> modello = new ArrayList<ModelloTemperature>();//creazione array list

    public Grafico(ArrayList<ModelloTemperature> modello) {
        this.modello = modello;
    }


    public void paint(Graphics g)
    {
        int startx = 65;//partenza cordinata x(anni dell'asse x)
        int starty = 565;//partenza cordinata y(anni dell'asse x)

        int startxn = 32;//partenza cordinata x(numeri dell'asse y)
        int startyn = 550;//partenza cordinata y(numeri dell'asse y)

        int startxl = 80;//partenza cordinata x(linee tracciate nel grafico)
        int startyl = 47;//partenza cordinata y(linee tracciate nel grafico)

        g.setColor(Color.black);

        //creazione asse y
        g.drawLine(50, 550, 50, 5);
        //creazione asse y

        //freccia asse y
        g.drawLine(50, 0, 43, 13);
        g.drawLine(50, 0, 57, 13);
        //freccia asse y

        //creazione asse x
        g.drawLine(50, 550, 1245, 550);
        //creazione asse x

        //freccia asse x
        g.drawLine(1250, 550, 1237, 543);
        g.drawLine(1250, 550, 1237, 557);
        //freccia asse x

        g.setColor(Color.black);

        //for per la stampa del grafico
        for (int i = 0; i < modello.size()-1; i++)
        {
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

            g.drawLine(startxl, 550 - (i1/2), startxl + 44, 550 - (i2/2));//stampa linee del grafico

            g.setColor(Color.red);
            g.fillOval(startxl - 1, 550 - (i1/2)-1, 3, 4);//stampa eriempimento punti di intersezione tra le linee
            //g.drawLine(startxl, 550, startxl, 550 - (i1/2));//tracciamento linee dalle cordinate degli anni sull asse x fino all'intersezione sulle linee del grafico
            g.setColor(Color.black);

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
        for(int i =0; i < modello.size(); i++)
        {
            g.drawString(modello.get(i).getAnno(),startx,starty);
            startx += 44;
        }
        //for per la stampa dell'anno sull'asse y

        //for per la stampa dei numeri sull'asse x
        g.setColor(Color.blue);
        for (int i = 0;i <= 5; i++)
        {
            g.drawString(String.valueOf(i)+"°",startxn,startyn);
            startyn -= 50;
        }
        g.setColor(Color.red);
        int test = 250;
        for (int i = 6;i <= 10; i++)
        {
            g.drawString(String.valueOf(i)+"°",startxn,test);
            test -= 50;
        }


        //for per la stampa dell'anno sull'asse x
    }
}
