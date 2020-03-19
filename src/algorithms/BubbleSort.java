package algorithms;

import utils.Swaper;

public class BubbleSort extends SortManager{

    public BubbleSort(){

    }

    @Override
    public void sort() {
        bubbleSort();
    }

    public void bubbleSort() {
        boolean swaped = false;

        for(int i=0;i<array.length-1;i++){
            swaped = false;
            for(int j = 0;j<array.length-1;j++){
                if(array[j]>array[j+1]){
                    Swaper.swap(j,j+1,array);
                    swaped = true;
                    notifyObservers();
                    sleep(2);

                }
            }
            if(!swaped)
                break;
        }

    }
}
