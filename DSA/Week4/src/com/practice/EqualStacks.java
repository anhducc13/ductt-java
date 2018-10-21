package com.practice;

import com.setup.Stack;
import java.util.Scanner;

public class EqualStacks {

    int Total(int[] arr) {
        int s = 0;
        for (int x : arr) {
            s += x;
        }
        return s;
    }

    int minEqualStack(int[] h1, int[] h2, int[] h3) {
        Stack st1 = new Stack();
        Stack st2 = new Stack();
        Stack st3 = new Stack();

        for (int i = h1.length - 1; i >= 0; i--) {
            st1.push(h1[i]);
        }
        for (int i = h2.length - 1; i >= 0; i--) {
            st2.push(h2[i]);
        }
        for (int i = h3.length - 1; i >= 0; i--) {
            st3.push(h3[i]);
        }

        int sum1 = Total(h1), sum2 = Total(h2), sum3 = Total(h3);

        while (!(st1.isEmpty() || st2.isEmpty() || st3.isEmpty())) {
            if (sum1 == sum2 && sum2 == sum3) {
                return sum1;
            } else if (sum1 >= sum2 && sum1 >= sum3) {
                sum1 -= (int) st1.pop();
            } else if (sum2 >= sum3 && sum2 >= sum1) {
                sum2 -= (int) st2.pop();
            } else if (sum3 >= sum1 && sum3 >= sum2) {
                sum3 -= (int) st3.pop();
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        EqualStacks eq = new EqualStacks();
        Scanner sc = new Scanner(System.in);

        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int n3 = sc.nextInt();

        int[] h1 = new int[n1];
        int[] h2 = new int[n2];
        int[] h3 = new int[n3];

        for (int i = 0; i < n1; i++) {
            h1[i] = sc.nextInt();
        }

        for (int i = 0; i < n2; i++) {
            h2[i] = sc.nextInt();
        }

        for (int i = 0; i < n3; i++) {
            h3[i] = sc.nextInt();
        }

        System.out.println(eq.minEqualStack(h1, h2, h3));
    }
}
