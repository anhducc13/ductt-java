package test;

import java.io.Serializable;
import java.util.Comparator;

public class Word implements Serializable{
    private String word_taget;
    private String word_explain;
    
    public Word() { }
    

    public Word(String word_taget, String word_explain) {
        this.word_taget = word_taget;
        this.word_explain = word_explain;
    }
    
    public Word(Word w) {
        this(w.word_taget,w.word_explain);
    }

    public Word(String lineInFile) {
        String [] spl = lineInFile.split("\t");
        this.word_taget = spl[0];
        this.word_explain = spl[1];
    }

    public String getWord_taget() {
        return word_taget;
    }

    public void setWord_taget(String word_taget) {
        this.word_taget = word_taget;
    }

    public String getWord_explain() {
        return word_explain;
    }

    public void setWord_explain(String word_explain) {
        this.word_explain = word_explain;
    }

    public void printWord() {
        System.out.printf("%-40s%-40s\n",word_taget,word_explain);
    }
    
    public int compareTo(String str) {
        return this.word_taget.compareTo(str);
    }
}

// Tạo class so sánh 2 Word
class WordComparator implements Comparator<Word> {
    @Override
    public int compare(Word w1, Word w2) {
        return w1.getWord_taget().compareTo(w2.getWord_taget());
    }
}