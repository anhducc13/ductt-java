package week10;

import java.util.Random;

public class Prac2 {
    
    public static double [] randomArr(int n, double min, double max) {
        double [] arr = new double[n];
        Random r = new Random();
        for(int i = 0; i < n; i++) {
            double num = min + (max - min) * r.nextDouble();
            arr[i] = Math.round(num*100)/100.00;
        }
        
        return arr;
    }
    
    public static void bubbleSort(double [] arr) {
        int length = arr.length;
        for(int i = 0; i < length-1; i++) {
            for(int j = i+ 1; j < length; j++) {
                if(arr[i] > arr[j]) {
                    double tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        double [] arr = randomArr(1000, -100, 100);
        bubbleSort(arr);
        for(double ele : arr) {
            System.out.println(ele);
        }
        
    }
}
