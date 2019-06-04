package ByteDance;


import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

public class SmartEditor {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        ArrayList<String> strs = new ArrayList();
        for (int i = 0; i < n; i++) {
            strs.add(s.next());
        }
        for (int i = 0; i < strs.size(); i++) {
            System.out.println(edit(strs.get(i)));
        }

    }

    public static String edit(String str) {
        if (str.length() == 0) return null;
        StringBuilder builder = new StringBuilder();
        char[] chars = str.toCharArray();
        boolean isAA = false;
        boolean isAAB = false;
        builder.append(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                if (isAA || isAAB) {
                    continue;
                }
                isAAB = false;
                isAA = true;
            } else {
                if (isAA) {
                    isAAB = true;
                }else {
                    isAAB=false;
                }
                isAA = false;
            }
            builder.append(chars[i]);
        }
        return builder.toString();
    }
}
