import java.util.*;

public class DictionaryCommandline {
    private Scanner sc;
    public void showAllWords() {
        if (!Dictionary.listWord.isEmpty()) {
            System.out.printf("%-4s%c%-40s%c%-40s\n","No",'|',"English",'|',"Vietnamese");
            int i = 1;
            for (Word ele:
                    Dictionary.listWord) {
                System.out.printf("%-5d",i);
                ele.printWord();
                i++;
            }
        }
    }

    DictionaryManagement DicMana = new DictionaryManagement();
    public void dictionaryBasic() {
        DicMana.insertFromCommandline();
        showAllWords();
    }

    public void dictionaryAdvanced() {
        DicMana.insertFromSQL();
        showAllWords();
        DicMana.dictionaryLookup();
    }

    public void dictionarySearcher() {
        sc = new Scanner(System.in);
        System.out.println("----Welcome to Searcher Machine----");
        System.out.print("Enter word: ");
        String wordSearch = sc.nextLine();

        ArrayList <Word> listWordSearch = new ArrayList<>();

        for (Word ele:
             Dictionary.listWord) {
            if(ele.getWord_taget().indexOf(wordSearch) == 0) {
                listWordSearch.add(ele);
            }
        }

        if (listWordSearch.isEmpty()) {
            System.out.println("Not Found !!!");
        }
        else {
            System.out.println("Words start by \"" + wordSearch + "\": ");
            int i = 1;
            for (Word ele:
                 listWordSearch) {
                System.out.printf("%-4d",i);
                ele.printWord();
                i++;
            }
        }
    }

//    public static void main(String[] args) {
//        DictionaryCommandline DicCom = new DictionaryCommandline();
//        DicCom.dictionaryBasic();
//    }

}
