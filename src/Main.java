package es_20;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Canvas;
import java.util.ArrayList;
import java.io.FileReader;


import com.opencsv.CSVReader;
public class Main extends Canvas
{
    public static ArrayList<ModelloTemperature> modello = new ArrayList<ModelloTemperature>();//creazione array list

    public static void main(String[] args)
    {
        JFrame f = new JFrame();

        JLabel l = new JLabel("ESERCIZIO MEDIA TEMPERATURE MINIME ANNUE");
        l.setBounds(110,30,300,20);
        l.setPreferredSize(new Dimension(200,20));
        f.setLayout(null);

        JButton btn = new JButton("STAMPA FILE");
        btn.setBounds(20,80,200,20);
        btn.setPreferredSize(new Dimension(200,20));
        f.setLayout(null);

        JButton btn1 = new JButton("STAMPA GRAFICO");
        btn1.setBounds(260,80,200,20);
        btn1.setPreferredSize(new Dimension(200,20));
        f.setLayout(null);

        JButton btn2 = new JButton("STAMPA GRAFICO INGRANDITO");
        btn2.setBounds(110,120,250,20);
        btn2.setPreferredSize(new Dimension(250,20));
        f.setLayout(null);

        JTextArea area = new JTextArea();
        area.setEditable(false);
        f.setLayout(null);

        JScrollPane scrollbar = new JScrollPane(area, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        scrollbar.setBounds(15,160,450,650);//do le dimensioni al JTextArea che ho aggiunto al JScrollPane
        scrollbar.setBorder(BorderFactory.createCompoundBorder(scrollbar.getBorder(),BorderFactory.createEmptyBorder(10, 10, 10, 10)));//do delle caratteristiche al bordo

        f.add(l);
        f.add(btn);
        f.add(btn1);
        f.add(btn2);
        f.add(scrollbar);//non faccio f.add(area) perché è già contenuto nello scrollpane

        f.setSize(500,900);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //stampa stampa del file e crezione oggetti ModelloTemperature
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){

                CSVReader reader;
                try {
                    FileReader fileReader = new FileReader("./src/temperature_max_min_stagioni_osservate.csv");//ricerca del file
                    reader = new CSVReader(fileReader);

                    // read line by line
                    String[] record = null;
                    Double[] tempMedie = new Double[27];
                    int i=0;

                    while ((record = reader.readNext()) != null)
                    {
                        ModelloTemperature mod = new ModelloTemperature();//creazione oggetto
                        //set valori attributi dell'oggetto
                        mod.setAnno(record[0]);
                        mod.setTempInverno(Double.parseDouble(record[1]));
                        mod.setTempPrimavera(Double.parseDouble(record[2]));
                        mod.setTempEstate(Double.parseDouble(record[3]));
                        mod.setTempAutunno(Double.parseDouble(record[4]));
                        //set valori attributi dell'oggetto

                        //metto in ogni posizione dell'array tempMedia la temperature media calcolata nel metodo calcMedia
                        tempMedie[i] = (calcMedie(mod.getTempInverno(), mod.getTempPrimavera(), mod.getTempEstate(), mod.getTempAutunno()));
                        //metto in ogni posizione dell'array tempMedia la temperature media calcolata nel metodo calcMedia

                        mod.setTempMedia(tempMedie[i]);
                        modello.add(mod);//aggiungo l'oggetto all'array;
                        //System.out.println(mod.toStringInformale());
                        area.append(mod.toStringInformale());//stampo il toStringInformale nel JTextarea
                    }
                    reader.close();

                    //ModelloTemperature temp = modello.get(0);
                    //System.out.println(temp.toStringInformale());

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        //stampa stampa del file e crezione oggetti ModelloTemperature

        //creazione del secondo frame (Grafico)
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                JFrame f1 = new JFrame("Grafico");
                Grafico g = new Grafico(modello);

                f1.add(g);
                f1.setSize(1300, 620);
                f1.setVisible(true);
            }
        });
        //creazione del secondo frame (Grafico)

        //creazione del secondo frame (GraficoIingrandito)
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                JFrame f2 = new JFrame("Grafico ingrandito");
                GraficoIngrandito g1 = new GraficoIngrandito(modello);

                f2.add(g1);
                f2.setLocation(600,200);
                f2.setSize(1300, 620);
                f2.setVisible(true);
            }
        });
        //creazione del secondo frame (GraficoIngrandito)

    }

    //calcolo della media delle temperature minime per ogni anno
    private static Double calcMedie(double inv, double prim, double est, double aut)
    {
        double tot = inv+prim+est+aut;
        String string = "";
        double media = tot/4;

        return media;
    }
    //calcolo della media delle temperature minime per ogni anno

}








