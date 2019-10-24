package utils;

import java.util.Random;

public class Shuffler {


    public static void shuffler(int[] array){
        int n = array.length-1;
        Random random = new Random();

        for(int i=n-1; i>0;i--){
            int j = random.nextInt(i);
            swap(i,j,array);
        }

    }

    public static void swap(int a,int b,int[] array){
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;

    }
}
