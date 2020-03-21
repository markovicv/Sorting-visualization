package ui;
import algorithms.SortManager;
import observer.Observer;
import utils.Konstants;
import utils.Swaper;
import javax.swing.*;
import java.awt.*;

import java.util.Random;


public class Visualizator extends JPanel implements Observer {

    public int[] array = new int[Konstants.NUMER_OF_BARS];
    public SortManager algo;
    private Thread sortingThread;
    private boolean algorithmIsSorting = false;
    private Random random;
    private Color color = new Color(255,0,0);

    public Visualizator(){
        this.random = new Random();
        for(int i=1;i<array.length;i++)
            array[i-1] = i;
        this.shuffle(array);




    }
    @Override
    public void update() {
        this.repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D graphics2D = (Graphics2D)g;
        super.paintComponent(graphics2D);

        this.setBackground(Color.BLACK);

        for(int i=0;i<Konstants.NUMER_OF_BARS;i++){
            int h = (int)((1.0*array[i])/Konstants.NUMER_OF_BARS * 800);
            int xbeg = i*Konstants.BAR_WIDTH;
            int ybeg = Konstants.HEIGHT - h - 100;

            //int dif = 0;
          //  graphics2D.setColor(new Color((dif * 7)%255,Konstants.RGB_MAX-(dif * 2)%Konstants.RGB_MAX,Konstants.RGB_MAX-dif / 5));

            graphics2D.setColor(color);
            graphics2D.fillRect(xbeg,ybeg,Konstants.BAR_WIDTH,h);
            //graphics2D.fillRect(0,50,5,h);
        //    graphics2D.fillOval(xbeg,ybeg,2,h);
          //  graphics2D.fillRect(xbeg,ybeg,5,5);
        }

    }

    public SortManager getAlgo() {
        return algo;
    }

    public void setAlgo(SortManager algo) {
        this.algo = algo;
        this.algo.addObserver(this);
        this.algo.setArray(array);


    }
    public void setAlgoSleepTime(int milliseonds){
        if(this.algo!=null){
            this.algo.setSleepTime(milliseonds);
        }
    }
    public void startSorting(){
        if(algo.isSorting){
            return;
        }
        sortingThread = new Thread(algo);
        sortingThread.start();
    }
    public void shuffle(int[] array){
        if(this.algo!=null){
            if(this.algo.isSorting)
                return;
        }

        int n = array.length-1;
        Random random = new Random();

        for(int i=n-1; i>0;i--){
            int j = random.nextInt(i);
            Swaper.swap(i,j,array);
        }

    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
