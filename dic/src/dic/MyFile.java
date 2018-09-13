package dic;

import java.io.*;
import java.util.ArrayList;

public class MyFile {
    public BufferedReader br;
    public BufferedWriter bw;
    public File file;

    public MyFile(String fileName) {
        this.file = new File(fileName);
    }
   
    public ArrayList<Word> toList() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
        ArrayList <Word> listWord = new ArrayList <>();        
        String line = br.readLine();;
        
        do{
            Word w = new Word(line);
            listWord.add(w);
            line = br.readLine();
            
        } while(line != null);
        
        br.close();
        return listWord;
    }
    
    public void toFile(ArrayList<Word> list) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF8")); 
        for(Word ele : list){
            bw.write(ele.getSpelling() + "\t" + ele.getExplain());
            bw.newLine();
        }
        bw.close();
    }
    
}
