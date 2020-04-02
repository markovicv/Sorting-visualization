package algorithms;
import observer.Observable;
import observer.Observer;
import utils.Konstants;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class SortManager implements Observable,Runnable {
    protected List<Observer> observers = new ArrayList<>();
    protected int[] array;
    protected int sleepTime;
    public boolean isSorting = false;
    protected AtomicBoolean pauserSorting = new AtomicBoolean(false);
    protected Object lock = new Object();


    protected void sleep(int miliseconds){
        try {
            Thread.sleep(miliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
    protected  void swap(int a,int b,int[] array){
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }


    public void stop(){
        this.pauserSorting.set(true);
    }
    public void resume(){
        this.pauserSorting.set(false);
        synchronized (lock) {
            lock.notify();
        }
    }

    @Override
    public void run() {
        sort();
    }

    @Override
    public void addObserver(Observer o) {
        if(observers.contains(o))
            return;
        observers.add(o);
    }

    @Override
    public void notifyObservers() {
        for(Observer o:observers)
            o.update();
    }

    public abstract void sort();
    public void setArray(int[] array){
        this.array =array;
    }
    public void setSleepTime(int time){
        this.sleepTime = time;
    }

    public int getSleepTime() {
        return sleepTime;
    }
}
