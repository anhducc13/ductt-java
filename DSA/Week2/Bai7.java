import java.util.Scanner;
import java.util.Arrays;

public class Bai7 {
    static int binarySearch(int [] arr, int key) {
        
        return -1;
    }
    static void cntThreeSum(int[] arr) {
        int n = arr.length;
        
        for(int i = 0; i < n-2; i++){
            for(int j = i+1; j < n-1; j++){
                for(int k = j+1; k < n; k++){
                    if(arr[i] + arr[j] + arr[k] == 0) {
                        System.out.println(arr[i] + " " + arr[j] + " " + arr[k] + "\n");
                    }
                }
            }
        }
    }

    static void cntThreeSumFast(int[] a) {
        Arrays.sort(a);
        int n = a.length;
        for(int i = 0; i < n-1; i++){
            for(int j = i+1; j < n; j++){

            }
        }
        
        
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int result = cntThreeSumFast(arr);
        System.out.print(result);

        sc.close();
    }
}
