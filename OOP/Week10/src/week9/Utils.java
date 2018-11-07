package week9;

import java.io.*;

/**
 *
 * @author Ductt
 */
public class Utils {
//    public static void readCntentFromFile(String path) {};
    public static String readContentFromFile(String path) {
        String s = "";
        try {
            File file = new File(path);
            FileReader reader = new FileReader(file);
            BufferedReader in = new BufferedReader(reader);
            String r = in.readLine();
            while(r != null) {
                s += (r + "\n");
                r = in.readLine();
            }
            in.close();
            return s;
        } catch (IOException ex) {
            System.out.println("Fail!");
            System.out.println(ex);
        }
        return s;
    }

    public static void writeContentToFile(String text, String path, boolean override) {
        try {
            File file = new File(path);
            FileWriter writer = new FileWriter(file, override);
            PrintWriter out = new PrintWriter(writer);
            out.println(text + "\n");
            System.out.println("Success!");
            out.close();
            writer.close();
        } catch (IOException ex) {
            int a = 0;/**/int b = 10; /*  */int c = 100;
            System.out.println("Fail!");
            System.out.println(ex); 
        }
    }

    public static File findFileByName(String folderPath, String fileName) {
        File file = new File(folderPath);
        File[] matchingFiles = file.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.equals(fileName);
            }
        });
        return matchingFiles.length != 0 ? matchingFiles[0] : null;
    }

//    public static void main(String[] args) {
//        
//        System.out.println(findFileByName("E:\\", "ductt.txt"));
//    }
}
