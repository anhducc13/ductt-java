package sort;

/**
 *
 * @DucTT
 */
public class QuickSort {

    public static int partitionFirstPivot(int arr[], int lo, int hi) {
        int pivot = arr[lo];
        int i = lo + 1;
        for (int j = lo + 1; j <= hi; j++) {
            if (arr[j] <= pivot) {
                i++;
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        int tmp = arr[i];
        arr[i] = arr[lo];
        arr[lo] = tmp;

        return i;

    }

    public static int partitionLastPivot(int arr[], int lo, int hi) {
        int pivot = arr[hi];
        int i = lo, j = hi - 1;

        while (i <= j) {
            while (i < hi && arr[i] < pivot) {
                i++;
            }
            while (j >= lo && arr[j] >= pivot) {
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
        int tmp = arr[i];
        arr[i] = arr[hi];
        arr[hi] = tmp;

        return i;

    }

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

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void quickSort(int arr[], int lo, int hi) {
        if (lo < hi) {
            int p = partition(arr, lo, hi);
            quickSort(arr, lo, p - 1);
            quickSort(arr, p + 1, hi);

        }
    }

    public static void main(String[] args) {
        int arr[] = {9, 7, 5, 3, 1};
//        int p = partitionLastPivot(arr, 0, arr.length - 1);

        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
//        System.out.println(p);
    }
}
