import java.util.Scanner;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class Bai4 {
    static int sumList(List<Integer> arr) {
        int size = arr.size();
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += arr.get(i);
        }
        return sum;

    }

    static String balancedSums(List<Integer> arr) {
        int size = arr.size(), i = 0;
        int leftSum = 0, rightSum = sumList(arr) - arr.get(0);
        do {
            if (leftSum == rightSum) {
                return "YES";
            }
            i++;
            leftSum += arr.get(i - 1);
            rightSum -= arr.get(i);
        } while (i < size - 1);

        return "NO";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int sizeAr = sc.nextInt();
            List<Integer> arr = new LinkedList<>();
            for (int j = 0; j < sizeAr; j++) {
                int ele = sc.nextInt();
                arr.add(ele);
            }
            System.out.println(balancedSums(arr));
        }
        sc.close();
    }
}
