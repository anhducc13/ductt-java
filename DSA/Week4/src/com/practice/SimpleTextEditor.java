package com.practice;

import java.util.Stack;
import java.io.*;

public class SimpleTextEditor {

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int numOfOperation = sc.nextInt();
//        Stack st = new Stack();
//        String s = "";
//
//        for (int i = 0; i < numOfOperation; i++) {
//            int option = sc.nextInt();
//            switch (option) {
//                case 1:
//                    st.push(s);
//                    String append = (String)sc.next();
//                    s += append;
//                    break;
//                case 2:
//                    st.push(s);
//                    int posDel = sc.nextInt();
//                    s = s.substring(0, s.length() - posDel);
//                    break;
//                case 3:
//                    int posPrint = sc.nextInt();
//                    System.out.println(s.charAt(posPrint-1));
//                    break;
//                default:
//                    s = (String)st.pop();

//                    
//            }
//        }
//    }
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numOfOperation = Integer.parseInt(br.readLine());
        Stack st = new Stack();
        String s = "";

        for (int i = 0; i < numOfOperation; i++) {
            String input = br.readLine();
            String arr[] = input.split(" ");
            
            int option = Integer.parseInt(arr[0]);
            
            switch (option) {
                case 1:
                    st.push(s);
                    String append = arr[1];
                    s += append;
                    break;
                case 2:
                    st.push(s);
                    int posDel = Integer.parseInt(arr[1]);
                    s = s.substring(0, s.length() - posDel);
                    break;
                case 3:
                    int posPrint = Integer.parseInt(arr[1]);
                    System.out.println(s.charAt(posPrint-1));
                    break;
                default:
                    s = (String)st.pop();
            }
        }
    }
}
