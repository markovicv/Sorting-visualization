package algorithms;

import ui.Visualizator;
import utils.Swaper;

public class BubbleSort implements Sorter,Runnable{
    private Visualizator visualizator;
    private int[] array;

    public BubbleSort(Visualizator visualizator){
        this.visualizator = visualizator;
    }
    public BubbleSort(){

    }



    @Override
    public void mySleep(int seconds) {
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setVisualizator(Visualizator visualizator) {
        this.visualizator = visualizator;
    }

    @Override
    public void setArray(int[] array) {
        this.array = array;
    }

    @Override
    public void run() {
        boolean swaped = false;

        for(int i=0;i<array.length-1;i++){
            swaped = false;
            for(int j = 0;j<array.length-1;j++){
                if(array[j]>array[j+1]){
                    Swaper.swap(j,j+1,array);
                    swaped = true;
                    visualizator.repaint();
                    mySleep(2);

                }
            }
            if(!swaped)
                break;
        }

    }
}
