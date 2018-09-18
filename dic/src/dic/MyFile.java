package dic;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyFile {
    public BufferedReader br;
    public BufferedWriter bw;
    public File file;

    public MyFile(String fileName) {
        this.file = new File(fileName);
    }
   
    
    public ArrayList<Word> toList() throws IOException {
        ArrayList <Word> listWord = new ArrayList <>();     
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
            String line = br.readLine();;
        
            while(line != null) {
                Word w = new Word(line);
                listWord.add(w);
                line = br.readLine();
            }
            
            br.close();
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        return listWord;
    }
    
    public void toFile(ArrayList<Word> list) throws IOException{
        try {
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"UTF-8"));
            for(Word ele : list){
                bw.write(ele.getSpelling() + "\t" + ele.getExplain());
                bw.newLine();
            }
            bw.close();
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
}
