package dic;

import java.util.*;

public class ListWord {
    public ArrayList <Word> listWord;

    public ListWord(ArrayList<Word> listWord) {
        this.listWord = listWord;
    }

    public ListWord() {listWord = null;}
    
    public void addList(Word w){
        //listWord.add(w);
        Collections.sort(listWord,new WordComparator());
        for(Word ele : listWord){
            ele.printWord();
        }
    }
    
    public void showAllWord(){
        for(Word ele : listWord){
            ele.printWord();
        }
    }
    
    
    public ArrayList <Word> subListWord(String subStr){
        ArrayList <Word> subList = new ArrayList <>();
        
        for(Word ele : listWord){
            if(ele.getSpelling().indexOf(subStr) == 0){
                subList.add(ele);
            }
        }
        return subList;
        
    }
    
}
