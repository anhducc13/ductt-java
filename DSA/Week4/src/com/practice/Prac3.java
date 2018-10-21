package com.practice;

import java.util.ArrayList;
import java.util.Scanner;

public class Prac3 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> listInList = new ArrayList<>();
        int numOfRow = sc.nextInt();
        
        for(int i = 0; i < numOfRow; i++) {
            int n = sc.nextInt();
            ArrayList<Integer> listRow = new ArrayList<>();
            for(int j = 0; j < n; j++) {
                listRow.add(sc.nextInt());
            }
            
            listInList.add(listRow);
        }
        
        int numOfQuery = sc.nextInt();
        
        for(int i = 0; i < numOfQuery; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            try {
                System.out.println(listInList.get(x-1).get(y-1));
            } catch(IndexOutOfBoundsException e) {
                System.out.println("ERROR");
       
            }
        }
    }
}
