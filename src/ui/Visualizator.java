package ui;

import algorithms.BubbleSort;
import algorithms.QuickSort;
import algorithms.Sorter;
import utils.Konstants;
import utils.Shuffler;
import javax.swing.*;
import java.awt.*;


public class Visualizator extends JPanel {

    public int[] array = new int[Konstants.NUMER_OF_BARS];
    public Sorter algo;
    private Thread sortingThread;

    public Visualizator(){
        for(int i=0;i<array.length;i++)
            array[i] = i;
        Shuffler.shuffler(array);



    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D graphics2D = (Graphics2D)g;
        super.paintComponent(graphics2D);

        this.setBackground(Color.BLACK);

        for(int i=0;i<Konstants.NUMER_OF_BARS;i++){
            int h = array[i]*3;
            int xbeg = i*Konstants.BAR_WIDTH;
            int ybeg = Konstants.HEIGHT - h - 100;

            int dif = i%Konstants.RGB_MAX;
          //  int dif = 0;
            graphics2D.setColor(new Color(255,Konstants.RGB_MAX-dif,Konstants.RGB_MAX-dif));
            graphics2D.fillRect(xbeg,ybeg,Konstants.BAR_WIDTH,h);
        }

    }

    public Sorter getAlgo() {
        return algo;
    }

    public void setAlgo(Sorter algo) {
        this.algo = algo;
        this.algo.setVisualizator(this);
        this.algo.setArray(this.array);

    }
    public void startSorting(){
        sortingThread = new Thread(algo);
        sortingThread.start();
    }
}
