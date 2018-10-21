package test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Dictionary;
import java.util.logging.Level;
import java.util.logging.Logger;

public class File {

    public static void main(String[] args) {
        ArrayList<Word> list = new ArrayList<>();

        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader("E_V1.txt"));
            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
                list.add(new Word(line));
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
        }

       
        try {
            FileOutputStream fileOut = new FileOutputStream("dictionaries.txt");
            ObjectOutputStream ojOut = new ObjectOutputStream(fileOut);
            ojOut.writeObject(list);

        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
    }

}
