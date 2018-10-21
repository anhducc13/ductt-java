package com.practice;
import java.util.*;

public class Prac2 {

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        int numOfHandle = sc.nextInt();

        for(int i = 0; i < numOfHandle; i++) {
            String handle = sc.next();
            
            if(handle.equals("Insert")) {
                int pos = sc.nextInt();
                int value = sc.nextInt();
                list.add(pos, value);
            }
            
            else if(handle.equals("Delete")) {
                int pos = sc.nextInt();
                list.remove(pos);
            }
        }

        for(Integer ele : list) {
            System.out.print(ele + " ");
        }
    }
}

