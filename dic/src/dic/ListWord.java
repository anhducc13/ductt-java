package dic;

import java.util.*;

public class ListWord {
    public ArrayList <Word> listWord;

    public ListWord(ArrayList<Word> listWord) {
        this.listWord = listWord;
    }

    public ListWord() { }
    
    
    public void insertWordtoList(Word w) {
        listWord.add(w);
        Collections.sort(listWord);
    }
    
    public ArrayList <Word> Search (String s) {
        ArrayList <Word> listSearch = new ArrayList <> ();
        
        int startSearchPos = -1;
        for(int i = 0; i < listWord.size(); i++) {
            int pos = listWord.get(i).getSpelling().indexOf(s);
            if (pos == 0) {
                startSearchPos = i;
                break;
            }
        }
        
        if(startSearchPos != -1) {
            for(int i = startSearchPos; listWord.get(i).getSpelling().indexOf(s) == 0; i++) {
                listSearch.add(listWord.get(i));
            }
        }
        
        return listSearch;
        
    }
       
}
