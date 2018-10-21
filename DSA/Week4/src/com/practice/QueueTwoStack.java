package com.practice;

import java.io.*;
import java.util.*;

/**
 *
 * @DucTT
 */
public class QueueTwoStack {

    public static void Enqueue(int x, Stack stMain, Stack stComple) {
        while (!stMain.empty()) {
            stComple.push(stMain.pop());
        }
        stMain.push(x);
        while (!stComple.empty()) {
            stMain.push(stComple.pop());
        }
    }

    public static void Dequeue(Stack stMain) {
        stMain.pop();
    }

    public static int printFrontQueue(Stack stMain) {
        return (int) stMain.peek();
    }

    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
//        int numOfOperation = sc.nextInt();
//        Stack<Integer> stMain = new Stack<>();
//        Stack<Integer> stComple = new Stack<>();
//        String s = "";
//        String value = "";
//        for (int i = 0; i < numOfOperation; i++) {
//            int option = sc.nextInt();
//            switch (option) {
//                case 1:
//                    Integer x = sc.nextInt();
//                    Enqueue(x,stMain,stComple);
//                    break;
//                case 2:
//                    Dequeue(stMain);
//                    break;
//                case 3:
//                    value = value + Integer.toString(printFrontQueue(stMain)) + "\n";
//                    System.out.println(printFrontQueue(stMain));
//                    break;
//            }
//        }
//        System.out.println(value);

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int numOfOperation = Integer.parseInt(br.readLine());
//        Stack<Integer> stMain = new Stack<>();
//        Stack<Integer> stComple = new Stack<>();
//        String s = "";
//
//        for (int i = 0; i < numOfOperation; i++) {
//            String input = br.readLine();
//            String arr[] = input.split(" ");
//            int option = Integer.parseInt(arr[0]);
//            switch (option) {
//                case 1:
//                    int x = Integer.parseInt(arr[1]);
//                    Enqueue(x, stMain, stComple);
//                    break;
//                case 2:
//                    Dequeue(stMain);
//                    break;
//                case 3:
//                    System.out.println(printFrontQueue(stMain));
//                    break;
//            }
//        }

        Scanner sc = new Scanner(System.in);
        int numOfOperation = sc.nextInt();
        Queue <Integer> q = new LinkedList<>();
        String s = "";
        String value = "";

        for (int i = 0; i < numOfOperation; i++) {
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    int x = sc.nextInt();
                    q.add(x);
                    break;
                case 2:
                    q.remove();
                    break;
                case 3:
                    value = value + Integer.toString(q.element()) + "\n";
                    break;
            }
            
        }
        System.out.println(value);
    }
}
