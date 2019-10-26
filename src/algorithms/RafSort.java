package algorithms;

import ui.Visualizator;
import utils.Swaper;

public class RafSort implements Sorter {
    private Visualizator visualizator;
    private int[] array;

    public RafSort(Visualizator visualizator){
        this.visualizator=visualizator;
    }
    public RafSort(){

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
        for(int i=0; i<array.length;i++){
            for(int j = i+1;j<array.length;j++){
                if(array[i] > array[j]){
                    Swaper.swap(i,j,array);
                    visualizator.repaint();
                    mySleep(2);
                }
            }
        }
    }
}
