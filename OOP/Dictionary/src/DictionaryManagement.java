import java.io.*;
import java.util.Scanner;

public class DictionaryManagement {
    private Scanner sc;
    private static final String fileName = "dictionaries.txt";

    public void insertFromCommandline() {
        sc = new Scanner(System.in);
        System.out.println("---------Add Word To List---------");
        System.out.print("Enter number of word: ");
        int num = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < num; i++) {
            System.out.print("Enter English Word: ");
            String spel = sc.nextLine();
            System.out.print("Enter Vietnamese Explain: ");
            String expl = sc.nextLine();

            Dictionary.listWord.add(new Word(spel, expl));
        }
        System.out.println("Insert success " + num + " word!");
    }

    public void insertFromFile() {
        BufferedReader br = null;

        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));
            String line = br.readLine();;

            while(line != null) {

                if(line.indexOf("\t") == -1) {
                    System.out.println("Format File Wrong!");
                    return;
                }
                Word w = new Word(line);
                Dictionary.listWord.add(w);
                line = br.readLine();
            }

            br.close();
        }
        catch (FileNotFoundException | UnsupportedEncodingException ex) {
            System.out.println("Error " + ex);
        } catch (IOException ex) {
            System.out.println("Error " + ex);
        }
    }

    public void dictionaryLookup() {
        sc = new Scanner(System.in);
        System.out.println("-----------LOOK UP------------");
        System.out.print("Enter word: ");
        String wordLookup = sc.nextLine();
        for (Word ele:
             Dictionary.listWord) {
            if (ele.getWord_taget().equals(wordLookup)) {
                System.out.println("Lookup Success!");
                System.out.print("Your word is: ");
                ele.printWord();
                return;
            }
        }
        System.out.println("Word Not Found!");
    }

    public void dictionaryExportToFile() {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8"));
            for (Word ele : Dictionary.listWord) {
                bw.write(ele.getWord_taget() + "\t" + ele.getWord_explain());
                bw.newLine();
            }
            bw.close();
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
                System.out.println("Error " + ex);
        } catch (IOException ex) {
                System.out.println("Error " + ex);
        }
    }

}
