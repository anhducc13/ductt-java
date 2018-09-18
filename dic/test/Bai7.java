import java.util.*;

public class Bai7 {
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
        for (int i = 0 ; i < n-2 ; i++){
            int l = i+1; int r = n-1;
            while (l<r){
                int sum = a[i] + a[l] + a[r];
                if (sum == 0){
                    System.out.println(a[i] + " " + a[l] + " " + a[r]);
                    while (a[l+1]==a[l])l++;
                    while (a[r-1]==a[r])r--;
                    l++; r--;
                }
                else if (sum > 0) r--;
                else l++;
            }
            
            while (a[i+1] == a[i]) i++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        cntThreeSumFast(arr);

        sc.close();
    }
}
