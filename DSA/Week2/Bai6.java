import java.util.Scanner;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class Bai6 {
    static int pairs(int k, int[] arr) {
        Arrays.sort(arr);
        int sz = arr.length;
        int cntPair = 0;
        for(int i = 0; i < sz-1; i++){
            if(arr[i+1] == arr[i]){
                i++;
                continue;
            }
            for(int j = i+1; j < sz; j++){
                int diff = arr[j] - arr[i];
                if(diff == k){
                    cntPair++;
                    break;
                }
                if(diff > k){
                    break;
                }
            }
        }
        return cntPair;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int [] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int result = pairs(k, arr);
        System.out.print(result);

        sc.close();
    }
}
