package week11;

import java.util.Arrays;
import java.util.Collections;

public class Prac2 <T extends Comparable> {
    public void QuickSort(T[] arr) {
        Collections.sort(Arrays.asList(arr));
    }

    public static void main(String[] args) {
        Prac2 p2 = new Prac2();
        String[] arr = {"g","b","z","m","gg"};
        
        p2.QuickSort(arr);
        
        System.out.println(Arrays.toString(arr));
    }
}
