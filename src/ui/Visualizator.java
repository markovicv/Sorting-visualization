package ui;
import algorithms.SortManager;
import observer.Observer;
import utils.Konstants;

import javax.swing.*;
import java.awt.*;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Visualizator extends JPanel implements Observer {

    public int[] array = new int[Konstants.NUMER_OF_BARS];
    public SortManager algo;
    private ExecutorService executorService;
    private Thread sortingThread;
    private Random random;
    private String type;
    private Color color = new Color(51,93,204);

    public Visualizator(){
        this.type = Konstants.BAR;
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
        this.executorService = Executors.newFixedThreadPool(10);
        for(int i=0;i<Konstants.NUMER_OF_BARS;i++){
            int h = (int)((1.0*array[i])/Konstants.NUMER_OF_BARS * 800);
            int xbeg = i*Konstants.BAR_WIDTH;
            int ybeg = Konstants.HEIGHT - h - 100;



            graphics2D.setColor(color);

            if(type.equals(Konstants.BAR))
                graphics2D.fillRect(xbeg,ybeg,Konstants.BAR_WIDTH,h);
            else if(type.equals(Konstants.DOT))
                graphics2D.fillRect(xbeg,ybeg,5,5);
            else if(type.equals(Konstants.STAR))
                graphics2D.drawString("*",xbeg,ybeg);

           
        }

    }

    public SortManager getAlgo() {
        return algo;
    }

    public void setAlgo(SortManager algo) {
        if(!canStart())
            return;
        this.algo = algo;
        this.algo.addObserver(this);
        this.algo.setArray(array);


    }
    public void setAlgoSleepTime(int milliseonds){

        this.algo.setSleepTime(milliseonds);
        System.out.println(this.algo.getSleepTime());

    }
    public void startSorting(){
       if(!canStart())
           return;
        sortingThread = new Thread(algo);
        executorService.submit(sortingThread);

    }
    public void shuffle(int[] array){
       if(!canStart())
           return;

        int n = array.length-1;
        Random random = new Random();

        for(int i=n-1; i>0;i--){
            int j = random.nextInt(i);
            this.swap(i,j,array);
        }

    }
    private void swap(int a,int b,int[] array){
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }
    public void stopSorting(){
        this.algo.stop();
    }
    public void resumeSorting(){
        this.algo.resume();
    }


    public void setType(String type) {
        this.type = type;
        this.repaint();
    }

    public void setColor(Color color) {
        this.color = color;
    }
    private boolean canStart(){
        if(this.algo!=null){
            if(this.algo.isSorting){
                return false;
            }
        }
        return true;
    }
}
