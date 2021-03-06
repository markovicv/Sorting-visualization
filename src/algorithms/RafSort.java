package algorithms;

public class RafSort extends SortManager {

    @Override
    public void sort(){
        this.isSorting = true;
        rafSort();
        this.isSorting = false;
    }

    private void rafSort() {
        for(int i=0; i<array.length;i++){
            for(int j = i+1;j<array.length;j++){
                if(array[i] > array[j]){
                    this.swap(i,j,array);
                    notifyObservers();
                    sleep(sleepTime);
                    System.out.println(sleepTime);
                }
            }
        }
    }



}
