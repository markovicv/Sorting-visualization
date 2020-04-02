package algorithms;

public class BubbleSort extends SortManager{

    public BubbleSort(){

    }

    @Override
    public void sort() {
        try {
            this.isSorting=true;
            bubbleSort();
            this.isSorting =false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void bubbleSort() throws Exception {
        boolean swaped = false;

        for(int i=0;i<array.length-1;i++){
            swaped = false;
            for(int j = 0;j<array.length-1;j++){
                if(array[j]>array[j+1]){
                    if(pauserSorting.get()){
                        synchronized (lock){
                            lock.wait();
                        }
                    }
                    this.swap(j,j+1,array);
                    swaped = true;
                    notifyObservers();
                    sleep(sleepTime);

                }
            }
            if(!swaped)
                break;
        }

    }
}
