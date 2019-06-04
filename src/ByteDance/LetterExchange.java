package ByteDance;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class LetterExchange {
    public static void main(String[] args) {
        new LetterExchange().f();
    }

    public void f() {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int m = sc.nextInt();
        int[] len = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            len[c - 'a']++;
        }
    }
}
