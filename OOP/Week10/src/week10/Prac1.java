package week10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import week9.Utils;

public class Prac1 {

    public static String getCode(String path) {
        String code = "";
        try {
            String temp;
            BufferedReader br = new BufferedReader(new FileReader(path));
            while ((temp = br.readLine()) != null) {
                if (temp.trim().startsWith("//")) {
                } else if (temp.contains("//")) {
                    code = code + temp.substring(0, temp.indexOf("//")) + "\n";
                } else {
                    code = code + temp + "\n";
                }
            }

            int x = code.indexOf("/*");
            while (x != -1) {
                int y = code.indexOf("*/");
                String r;
                if (y == -1) {
                    y = code.length();
                    r = code.substring(x, y);
                    code = code.replace(r, " ");
                } else {
                    r = code.substring(x, y + 2);
                    code = code.replace(r, " ");
                }

                x = code.indexOf("/*");
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File Not Found");
        } catch (IOException ex) {
            System.out.println("Fail Read File");
        }

        return code;
    }

    public static String getFunc(String code) {
        String func = "";
        int x = code.indexOf("static");
        int first;
        int last;
        if (x != -1) {
            while (x != -1 && code.charAt(x) != '\n') {
                x--;
            }
            x++;
            first = x;
            last = x;
            int cntOpen = 0;
            int cntClose = 0;
            while (x < code.length()) {
                if (code.charAt(x) == '{') {
                    cntOpen++;
                }
                if (code.charAt(x) == '}') {
                    cntClose++;
                }
                if (cntOpen != 0 && cntClose != 0 && cntOpen == cntClose) {
                    last = x;
                    break;
                }
                x++;
            }
            func = code.substring(first, last + 1);
        }
        return func;
    }

    public static List<String> getAllFunctions(String path) {
        ArrayList<String> funcs = new ArrayList<>();
        String code = getCode(path);
        while(true) {
            String func = getFunc(code);
            if(func.equals("")) break;
            else {
                funcs.add(func);
                code = code.replace(func, "");
            }
        }
        return funcs;
    }

    public static void main(String[] args) {
        String code = getCode("E:\\Hoc_Tap\\OOP\\THOOP\\ductt-java\\OOP\\Week10\\src\\week9\\Utils.java");
        List l = getAllFunctions("E:\\Hoc_Tap\\OOP\\THOOP\\ductt-java\\OOP\\Week10\\src\\week9\\Utils.java");
        for(Object ele : l) {
            Utils.writeContentToFile((String)ele, "E:\\ductt111.txt", true);
        }
//        Utils.writeContentToFile(getFunc(code), "E:\\ductt111.txt", false);
    }
}
