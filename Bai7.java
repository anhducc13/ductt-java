import java.util.Scanner;
import java.util.Arrays;

public class Bai7 {
    static int cntThreeSum(int[] arr) {
        int n = arr.length;
        int cnt = 0;
        
        for(int i = 0; i < n-2; i++){
            for(int j = i+1; j < n-1; j++){
                for(int k = j+1; k < n; k++){
                    if(arr[i] + arr[j] + arr[k] == 0) cnt++;
                }
            }
        }
        return cnt;
    }

    static int cntThreeSumFast(int[] a) {
        Arrays.sort(a);
        int n = a.length;
        int cnt = 0, l,r;
        
        for (int i = 0 ; i < n-2 ; i++){
            l = i+1; r = n-1;
            while (l<r){
                int sum = a[i] + a[l] + a[r];
                if (sum == 0){
                    cnt++;
                    while (a[l+1]==a[l] )l++;
                    while (a[r-1]==a[r] )r--;
                    l++; r--;
                }
                else if (sum > 0) r--;
                else l++;
            }
            while (a[i+1]==a[i] && i < n) i++;
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
