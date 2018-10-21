package com.practice;

import com.setup.Stack;
import java.util.Scanner;

public class BalancedBrackets {

    boolean checkBalancedBrackets(String s) {
        Stack st = new Stack();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '{':
                case '[':
                case '(':
                    st.push(s.charAt(i));
                    break;
                case '}':
                    if (st.isEmpty() || (char)st.pop() != '{') {
                        return false;
                    }
                    break;
                case ']':
                    if (st.isEmpty() || (char)st.pop() != '[') {
                        return false;
                    }
                    break;
                case ')':
                    if (st.isEmpty() || (char)st.pop() != '(') {
                        return false;
                    }
                    break;
                default:
                    return false;
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BalancedBrackets bb = new BalancedBrackets();
        for (int i = 0; i < 3; i++) {
            System.out.print("Nhập biểu thức dấu ngoặc: ");
            String s = sc.nextLine();

            System.out.println(bb.checkBalancedBrackets(s));
        }

    }
}
