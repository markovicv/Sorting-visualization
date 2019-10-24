package algorithms;

import ui.Visualizator;

public interface Sorter extends Runnable {

  //  public void sort(int[] array);
    public void mySleep(int seconds);
    public void setVisualizator(Visualizator visualizator);
    public void setArray(int[] array);
}
