package week10;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Prac1 {

    // Lấy toàn bộ code của file không lấy comment
    public static String getCode(String path) {
        String code = "";
        try {
            String temp;
            BufferedReader br = new BufferedReader(new FileReader(path));
            while ((temp = br.readLine()) != null) {
                // Loại các comment "//"
                if (temp.trim().startsWith("//")) {
                } else if (temp.contains("//")) {
                    code = code + temp.substring(0, temp.indexOf("//")) + "\n";
                } else {
                    code = code + temp + "\n";
                }
            }

            // Loại các comment "/**/"
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
            br.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File Not Found");
        } catch (IOException ex) {
            System.out.println("Fail Read File");
        }

        return code;
    }

    // Lấy toàn bộ tên hàm (dòng đầu tiên của hàm) có chứa biểu thức chính quy
    public static List<String> getNameFuncs(String pattern, String path) {
        ArrayList<String> funcs = new ArrayList<>();
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(getCode(path));

        while (m.find()) {
            funcs.add(m.group(0));
        }
        for (int i = 0; i < funcs.size(); i++) {
            String ele = funcs.get(i).trim();
            if (ele.charAt(ele.length() - 1) == ';') {
                funcs.remove(i);
                i--;
            }
        }

        return funcs;
    }

    // Lấy nội dung của hàm có tên cho trước
    public static String getFunc(String nameFunc, String path) {
        String func;
        String tmp = getCode(path);

        int first = tmp.indexOf(nameFunc);
        int last = first;
        int cntOpen = 0;
        int cntClose = 0;
        int i = first;
        while (i < tmp.length()) {
            if (tmp.charAt(i) == '{') {
                cntOpen++;
            }
            if (tmp.charAt(i) == '}') {
                cntClose++;
            }
            if (cntOpen != 0 && cntClose != 0 && cntOpen == cntClose) {
                last = i;
                break;
            }
            i++;
        }

        func = tmp.substring(first, last + 1);
        return func;
    }

    // Lấy tất cả hàm static 
    public static List<String> getAllFunctions(String path) {
        List<String> funcs = new ArrayList<>();
        List<String> nameFunc = getNameFuncs(path,".*static.*");
        String code = getCode(path);
        nameFunc.forEach((ele) -> {
            funcs.add(getFunc(ele, code));
        });
        
        return funcs;
    }

    // Tìm hàm có tên theo yêu cầu "name(<Kiểu dữ liệu>,...)
    public static String findFunctionByName(String name, String path) {
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
        String ap = ".*";
        for (int i = 0; i < vars.length; i++) {
            ap = ap + vars[i] + ".*";
        }

        String pattern = ".*" + nameFunc + "(" + ap + ")";
        
        List listNameFunc = getNameFuncs(pattern, path);
        
        return listNameFunc.isEmpty() ? "" : getFunc((String)listNameFunc.get(0), path);
    }

    public static void main(String[] args) {
        System.out.println(findFunctionByName("findFileBygName(String, String)", "E:\\Hoc_Tap\\OOP\\THOOP\\ductt-java\\OOP\\Week10\\src\\week9\\Utils.java"));
    }
}
