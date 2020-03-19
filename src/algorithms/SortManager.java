package algorithms;

import observer.Observable;
import observer.Observer;

import java.util.ArrayList;
import java.util.List;

public abstract class SortManager implements Observable,Runnable {
    protected List<Observer> observers = new ArrayList<>();
    protected int[] array;
    protected int sleepTime;
    public boolean isSorting = false;



    public void sleep(int miliseconds){
        try {
            Thread.sleep(miliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
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



}
