package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LargestArr {

    public static void print(int[] arr) {
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
    }

    public static int partition(int[] arr, int lo, int hi) {
        int pivot = arr[hi];
        int i = lo;
        for (int j = lo; j <= hi; j++) {
            if (arr[j] <= pivot) {
                if (i != j) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
                i++;
            }
        }
        return i - 1;
    }

    public static int partition1(int[] arr, int lo, int hi) {
        int pivot = arr[hi];
        int i = lo, j = hi - 1;

        while (i <= j) {
            while (i < hi && arr[i] <= pivot) {
                i++;
            }
            while (j > lo && arr[j] > pivot) {
                j--;
            }

            if (i <= j) {
                int tmp = arr[i];
                arr[i++] = arr[j];
                arr[j--] = tmp;
            }
        }
        int tmp = arr[i];
        arr[i] = arr[hi];
        arr[hi] = tmp;
        return i;
    }

    public static void quickSort(int[] arr, int lo, int hi) {
        if (lo < hi) {
            int pos = partition1(arr, lo, hi);
            quickSort(arr, lo, pos - 1);
            quickSort(arr, pos + 1, hi);
        }
    }

    public static int findMedian(int[] arr) {
        int left = 0, right = 0, lo = 0, hi = arr.length - 1;
        do {
            int p = partition1(arr, lo, hi);
            left = p;
            right = arr.length - p - 1;
            if (left < right) {
                lo = p + 1;
            } else if (left > right) {
                hi = p - 1;
            } else {
                return arr[p];
            }
        } while (left != right);
        //        int p = partition1(arr, lo, hi);
        //        int left = p, right = arr.length - p - 1;
        //
        //        if (left < right) {
        //            return findMedian(arr, p + 1, hi);
        //        } else if (left > right) {
        //            return findMedian(arr, lo, p - 1);
        //        } else {
        //            return arr[p];
        //        }
        //        if (lo < hi) {
        //            int p = partition1(arr, lo, hi);
        //            int left = p, right = arr.length - p - 1;
        //            
        //            if (left < right) {
        //                return findMedian(arr, p + 1, hi);
        //            } else if (left > right) {
        //                return findMedian(arr, lo, p - 1);
        //            } else {
        //                return p;
        //            }
        //        }
        return -1;

    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
//        Scanner sc = new Scanner(System.in);
//        for (int i = 0; i < 10001; i++) {
//            arr[i] = sc.nextInt();
//        }
//        quickSort(arr, 0, arr.length - 1);
//        System.out.println(findMedian(arr));
//        System.out.println(partition1(arr, 0, arr.length-1));
        int[] arr = new int[10001];
        BufferedReader br = new BufferedReader(new FileReader("test.txt"));
        for (int i = 0; i < 10001; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(findMedian(arr));
        quickSort(arr, 0, arr.length - 1);

        BufferedWriter bw = new BufferedWriter(new FileWriter("test1.txt"));
        for (int i = 0; i < 10001; i++) {
            bw.write(Integer.toString(arr[i]));
            bw.newLine();
        }
        print(arr);
    }
}
