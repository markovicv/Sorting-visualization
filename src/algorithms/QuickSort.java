package algorithms;

import ui.Visualizator;
import utils.Swaper;

public class QuickSort implements Sorter {
    private Visualizator visualizator;
    private int[] array;

    public QuickSort(Visualizator visualizator){
        this.visualizator = visualizator;
    }
    public QuickSort(){


    }

    private int getIndex(int pivot,int left,int right,int[] array){
        while(left<=right){
            while(array[left]<pivot)
                left++;
            while(array[right]>pivot)
                right--;
            if(left<=right) {

                Swaper.swap(left, right, array);
                left++;
                right--;
                visualizator.repaint();
                mySleep(2);
            }

        }
        return left;
    }


    private void quickSort(int[] array,int lo,int hi){
        if(lo>=hi)
            return;
        int pivot = array[(lo+hi)/2];
        int index = getIndex(pivot,lo,hi,array);
        quickSort(array,lo,index-1);
        quickSort(array,index,hi);

    }

    @Override
    public void run() {
        quickSort(array,0,array.length-1);
    }

    @Override
    public void mySleep(int seconds) {
        try{
            Thread.sleep(seconds);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void setArray(int[] array) {
        this.array = array;
    }

    @Override
    public void setVisualizator(Visualizator visualizator) {
        this.visualizator =visualizator;
    }
}
