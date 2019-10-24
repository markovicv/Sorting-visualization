package utils;

public class Swaper {


    public static void swap(int a,int b,int[] array){
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }
}
