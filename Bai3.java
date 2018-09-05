import java.util.Scanner;

public class Bai3 {

    static int sizeAr = 6;
    
    static int hourglassSum(int[][] arr) {

        int sumMax = arr[1][1] + arr[0][0] + arr[0][1] + arr[0][2] + arr[2][0] + arr[2][1] + arr[2][2]; 
        for(int i = 1; i < sizeAr-1; i++){
            for(int j = 1; j < sizeAr-1; j++){
                int sum = arr[i][j] + arr[i-1][j-1] + arr[i-1][j] + arr[i-1][j+1] + arr[i+1][j-1] + arr[i+1][j] + arr[i+1][j+1];
                if(sum > sumMax) sumMax = sum; 
            }
        }
        return sumMax;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[sizeAr][sizeAr];
        for(int i = 0; i < sizeAr; i++){
            for(int j = 0; j < sizeAr; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        sc.close();

        System.out.print(hourglassSum(arr));
    }
}
