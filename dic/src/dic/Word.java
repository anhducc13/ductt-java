package dic;

import java.util.Comparator;

public class Word {
    private String spelling;
    private String explain;

    public String getSpelling() {
        return spelling;
    }

    public void setSpelling(String spelling) {
        this.spelling = spelling;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public Word(String spelling, String explain) {
        this.spelling = spelling;
        this.explain = explain;
    }
    
    public Word(String textLineInFile){
        this(textLineInFile,textLineInFile);
//        this.spelling = textLineInFile.substring(0,textLineInFile.indexOf('\t'));
//        this.explain = textLineInFile.substring(textLineInFile.indexOf('\t')+1);
    }
    
    
    public void printWord(){
        System.out.println("|" + spelling + "\t\t|" + explain);
    }  
}

class WordComparator implements Comparator<Word> {
        @Override
	public int compare(Word w1, Word w2) {
		return w1.getSpelling().compareTo(w2.getSpelling());
	}
}