package sort;

public class Median {
    public static int partition(int arr[], int lo, int hi) {
        int pivot = arr[lo];
        int i = lo + 1, j = hi;

        while (i <= j) {
            while (i <= hi && arr[i] < pivot) {
                i++;
            }
            while (j > lo && arr[j] >= pivot) {
                j--;
            }
            if (i <= j) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }
        int tmp = arr[j];
        arr[j] = arr[lo];
        arr[lo] = tmp;

        return j;

    }
    
    
    public static void main(String[] args) {
        int arr[] = {1, 3, 9, 8, 2, 7, 5};
        System.out.println(median(arr));
    }
}
