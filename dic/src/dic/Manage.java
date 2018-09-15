package dic;

import java.io.IOException;
//import java.util.ArrayList;
import java.util.Scanner;

public class Manage {
    static Scanner sc = new Scanner(System.in);
    static Manage d = new Manage();
    static MyFile f = new MyFile("ductt.txt");
    static ListWord l = new ListWord();
    
    public static void main(String[] args) throws IOException {
        
        for(int i = 0; i < 1; i++){
            System.out.print("a: ");
            String s = sc.nextLine();
            
            System.out.print("b: ");
            String e = sc.nextLine();
            Word w = new Word(s,e);
            l.insertWordtoList(w);
        }
        
        f.toFile(l.listWord);
        
        
    }
}
