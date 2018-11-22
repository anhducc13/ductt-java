package week11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Prac1 <T extends Comparable>{

    public T maximum(ArrayList<T> list) {
        return (T)Collections.max(list);
    }
    
    public static void main(String[] args) {
        Prac1 p1 = new Prac1();
        ArrayList<String> list = new ArrayList<>();
        
        list.add("b");
        list.add("aa");
        
        System.out.println(p1.maximum(list));
        System.out.println(Arrays.toString(list.toArray()));
    }
}
