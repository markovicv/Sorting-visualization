package algorithms;
import observer.Observer;
import utils.Swaper;

public class QuickSort extends SortManager {


    public QuickSort(){


    }

    private int getIndex(int pivot,int left,int right,int[] array){
        while(left<=right){
            while(array[left]<pivot)
                left++;
            while(array[right]>pivot)
                right--;
            if(left<=right) {
                notifyObservers();
                sleep(sleepTime);
                Swaper.swap(left, right, array);
                left++;
                right--;

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
    public void sort() {
        this.isSorting = true;
        quickSort(array,0,array.length-1);
        this.isSorting = false;

    }


}
