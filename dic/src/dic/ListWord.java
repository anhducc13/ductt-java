package dic;

import java.util.*;

public class ListWord {
    public ArrayList <Word> listWord;

    public ListWord(ArrayList<Word> listWord) {
        this.listWord = listWord;
    }

    public ListWord() {  }
    
    
    public void insertWordtoList(Word w) {
        listWord.add(w);
       // Collections.sort(listWord);
    }
       
}
