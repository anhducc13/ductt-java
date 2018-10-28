package week8next;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionTest {

    public String duplicate(String s) throws NullPointerException {
        return s.concat(s);
    }

    public int showLast(int[] arr) throws ArrayIndexOutOfBoundsException {
        return arr[arr.length];
    }

    public int division(int a, int b) throws ArithmeticException {
        return a / b;
    }

    public String toStringEx(Object s) throws ClassCastException {
        return (String) s;
    }

    public void readFile(String filename) throws FileNotFoundException, IOException {
        BufferedReader br;
        FileReader f = new FileReader(filename);
        br = new BufferedReader(f);
        System.out.println(br.lines());
    }

    public static void main(String[] args) {
        try {
            String s = new ExceptionTest().duplicate(null);
            System.out.println(s);
        } catch (NullPointerException e) {
            System.out.println(e);
        }
        try {
            System.out.println(new ExceptionTest().showLast(new int [] {1,2,3}));
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }
        try {
            System.out.println(new ExceptionTest().division(1,0));
        } catch(ArithmeticException e) {
            System.out.println(e);
        }
        try {
            System.out.println(new ExceptionTest().toStringEx(12));
        } catch (ClassCastException e) {
            System.out.println(e);
        }
        
        try {
            new ExceptionTest().readFile("ductt.txt");
        } catch(FileNotFoundException e) {
            System.out.println(e);
        } catch(IOException e) {
            System.out.println(e);
        }

    }

}
