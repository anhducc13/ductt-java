import java.util.Scanner;

public class Bai2 {
    
    static int[] reverse(int[] arr){
        int siz = arr.length;
        int[] res = new int[siz];
        for(int i = 0; i < siz; i++){
            res[i] = arr[siz-i-1];
        }
        return res;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }
        sc.close();
        int[] res = reverse(arr);
        for(int i = 0; i < N; i++){
            System.out.print(res[i] + " ");
        }
    }
}
