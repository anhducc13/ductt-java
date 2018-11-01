package week9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Ductt
 */
public class FileAction {

    public static String readContentFromFile(String path) {
        String s = null;
        try {
            File file = new File(path);
            FileReader reader = new FileReader(file);
            BufferedReader in = new BufferedReader(reader);
            s = in.readLine();
            in.close();
            return s;
        } catch (FileNotFoundException ex) {
            System.out.println("Fail!");
            System.out.println(ex);
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
            out.println(text);
            System.out.println("Success!");
            out.close();
            writer.close();
        } catch (IOException ex) {
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

    public static void main(String[] args) {
        File file = findFileByName("E:\\Hoc_Tap", "MK1.txt");
        
    }
}
