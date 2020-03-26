package algorithms;
import utils.Swaper;

public class QuickSort extends SortManager {


    public QuickSort(){


    }

    private int getIndex(int pivot,int left,int right,int[] array) throws Exception{
        while(left<=right){
            while(array[left]<pivot)
                left++;
            while(array[right]>pivot)
                right--;
            if(left<=right) {
                if(pauserSorting.get()){
                    synchronized (lock){
                        lock.wait();
                    }
                }

                Swaper.swap(left, right, array);
                left++;
                right--;
                notifyObservers();
                sleep(sleepTime);


            }

        }
        return left;
    }


    private void quickSort(int[] array,int lo,int hi) throws Exception{
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
        try {
            quickSort(array,0,array.length-1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.isSorting = false;

    }


}
