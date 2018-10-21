package bt;

import java.util.*;

public class B6 {

    static double[] runningMedian(int[] a) {
        double[] median = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            Arrays.sort(a, 0, i + 1);
            for (int j = 0; j <= i; j++) {
                System.out.print(a[j] + " ");
            }
            System.out.println();
            if (i % 2 == 0) {
                median[i] = (double) a[i / 2];
            } else {
                median[i] = (a[i / 2] + a[i / 2 + 1]) / (double) 2;
            }
        }

        return median;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        double[] median;
        median = runningMedian(arr);
        for (int i = 0; i < n; i++) {
            System.out.println(median[i] + " ");
        }
    }
}
