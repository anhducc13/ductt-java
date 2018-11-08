package week10;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
                if (cntOpen == 0 && cntClose == 0 && code.charAt(x) == ';'
                        || cntOpen != 0 && cntClose != 0 && cntOpen == cntClose) {
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
        while (true) {
            String func = getFunc(code);
            if (func.equals("")) {
                break;
            } else {
                if (func.contains("{")) {
                    funcs.add(func);
                }
                code = code.replace(func, "");
            }
        }
        return funcs;
    }

    public static String findFunctionByName(String name, String code) {
        String func = "";
        if (!name.contains("(")) {
            return "";
        }

        String nameFunc = name.substring(0, name.indexOf("(")).trim();
        String varFunc = name.substring(name.indexOf("(") + 1, name.indexOf(")"));
        String[] vars;
        if (varFunc.contains(",")) {
            vars = varFunc.split(",");
        } else if (varFunc.trim().equals("")) {
            vars = null;
        } else {
            vars = new String[1];
            vars[0] = varFunc.trim();
        }

        String tmp = "(.*)";
        for (int i = 0; i < vars.length; i++) {
            tmp = tmp + vars[i] + "(.*)";
        }

        String pattern = "(.*)" + nameFunc + "(" + tmp + ")";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(code);

        if (m.find()) {

            int first = code.indexOf(m.group(0));
            int last = first;
            int cntOpen = 0;
            int cntClose = 0;
            int i = first;
            while (i < code.length()) {
                if (code.charAt(i) == '{') {
                    cntOpen++;
                }
                if (code.charAt(i) == '}') {
                    cntClose++;
                }
                if (cntOpen != 0 && cntClose != 0 && cntOpen == cntClose) {
                    last = i;
                    break;
                }
                i++;
            }

            func = code.substring(first, last + 1);
        }
        return func;
    }

    public static void main(String[] args) {
        String code = getCode("E:\\Hoc_Tap\\OOP\\THOOP\\ductt-java\\OOP\\Week10\\src\\week9\\Utils.java");
//        List list = getAllFunctions("E:\\Hoc_Tap\\OOP\\THOOP\\ductt-java\\OOP\\Week10\\src\\week9\\Utils.java");
//        System.out.println(list.size());
//        list.forEach((ele) -> {
//            Utils.writeContentToFile((String)ele, "E:\\ductt111.txt", true);
//        });
        Utils.writeContentToFile(findFunctionByName("findFileByName(String,String)", code), "E:\\ductt111.txt", false);
    }
}
