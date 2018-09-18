package dic;

import java.io.IOException;
//import java.util.ArrayList;
import java.util.*;

public class Manage {
    static Scanner sc = new Scanner(System.in);
    static Manage d = new Manage();
    static MyFile f = new MyFile("ductt.txt");
    static ListWord l = new ListWord();
    
    public static void main(String[] args) throws IOException {
        l.listWord = f.toList();
        l.insertWordtoList(new Word("hello","xin chào"));
        
        for (Word ele : l.listWord) {
            ele.printWord();
        }
        f.toFile(l.listWord);
        
        
    }
}
