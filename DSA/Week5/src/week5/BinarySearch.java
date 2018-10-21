package week5;

import java.util.Arrays;

public class BinarySearch {

    public static int BS(int V, int arr[]) {
        int left = 0, right = arr.length - 1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (V < arr[mid]) {
                right = mid - 1;
            } else if (V > arr[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }

        }
        return -1;
    }

    public static int BS(int arr[], int V, int left, int right) {
        if (left <= right) {
            int mid = left + (right - left) / 2;
            if (V < arr[mid]) {
                return BS(arr, V, left, mid);
            } else if (V > arr[mid]) {
                return BS(arr, V, mid + 1, right);
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        int arr[] = {1, 1};
//        System.out.println(Arrays.binarySearch(arr, 1));
//        System.out.println(BS(arr,1, 0, arr.length - 1));
        String x = "abc", y = "ab";
        System.out.println(y.compareTo(x));
        
    }
}
