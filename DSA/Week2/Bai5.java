import java.util.Scanner;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class Bai5 {
    static ArrayList<Integer> closestNumbers(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();
        Arrays.sort(arr);
        int sz = arr.length;

        int minDiff = arr[1] - arr[0];
        result.add(arr[0]);
        result.add(arr[1]);

        for(int i = 1; i < sz-1; i++){
            int diff = arr[i+1] - arr[i];
            if(diff == minDiff){
                result.add(arr[i]);
                result.add(arr[i+1]);
            }
            else if(diff < minDiff){
                minDiff = diff;
                result.clear();
                result.add(arr[i]);
                result.add(arr[i+1]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        ArrayList<Integer> result = closestNumbers(arr);

        for(Integer ele: result){
            System.out.print(ele + " ");
        }

        sc.close();
    }
}
