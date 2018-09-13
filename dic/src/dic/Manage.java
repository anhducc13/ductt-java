package dic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Manage {
    static Manage d = new Manage();
    static  MyFile f = new MyFile("ductt.txt") ;    
    static ListWord l = new ListWord();
    
    
    void loadDic() throws IOException{
        l = new ListWord(f.toList());
    }
    
    void addWord(Word w) throws IOException{
        l.addList(w);
        f.toFile(l.listWord);
//        d.loadDic();
    }
    
    public static void main(String[] args) throws IOException {
        d.loadDic();
        d.addWord(new Word("z"));
        //l.showAllWord();    
    }
}
