package bt;

import java.util.*;

public class B3 {
    
    static int cookies(int k, int[] A) {
        Queue pqueue = new PriorityQueue(A.length);
        for (int i = 0; i < A.length; i++) {
            pqueue.add(A[i]);
        }
        
        if(pqueue.isEmpty()) return -1;
        
        int numOfChance = 0;
        while((int)pqueue.peek() < k) {
            int del = (int)pqueue.poll();
            if(!pqueue.isEmpty()) {
                int add = (int)pqueue.poll() * 2 + del;
                pqueue.add(add);
                numOfChance++;
            } else {
                numOfChance = -1;
                break;
            }
        }
        return numOfChance;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N, K;
        N = scanner.nextInt();
        K = scanner.nextInt();
        
        int [] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }
        
        System.out.println(cookies(K, arr));
    }
}
