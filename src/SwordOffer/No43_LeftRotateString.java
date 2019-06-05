package SwordOffer;

import java.util.Arrays;

public class No43_LeftRotateString {
    public static void main(String[] args) {
        System.out.println(LeftRotateStringT("abcXYZdef", 12));
        System.out.println("Hello World");
    }

    //直接调用substring
    public static String LeftRotateString(String str, int n) {
        if (str.length() == 0) return "";
        n = n % str.length();
        String left = str.substring(0, n);
        String right = str.substring(n, str.length());
        return right + left;
    }

    //用YX = (XTY T)T做
    public static String LeftRotateStringT(String str, int n) {
        char[] chars = str.toCharArray();
        int len = str.length();
        if (len == 0) return "";
        n = n % len;
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        for (int i = n, j = len-1; i < j; i++, j--) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        for (int i = 0, j = len-1; i < j; i++, j--) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        return String.valueOf(chars);
    }

}
