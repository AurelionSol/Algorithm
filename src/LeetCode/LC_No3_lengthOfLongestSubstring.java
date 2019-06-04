package LeetCode;

import java.util.HashMap;

public class LC_No3_lengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
        System.out.println("Hello World");
    }
    //用map存储每个字符最近出现的位置
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int len = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i)) || map.get(s.charAt(i)) < left) {
                len = Math.max(len, i - left + 1);
            } else {
                left = map.get(s.charAt(i));
            }
            map.put(s.charAt(i), i + 1);
        }
        return len;
    }
}
