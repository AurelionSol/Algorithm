package SwordOffer;

import java.util.LinkedHashMap;

public class No54_FirstAppearingOnce {
    LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();

    public static void main(String[] args) {
        No54_FirstAppearingOnce firstAppearingOnce = new No54_FirstAppearingOnce();
        char[] chars = "google".toCharArray();
        String res = "";
        for (int i = 0; i < chars.length; i++) {
            firstAppearingOnce.Insert(chars[i]);
            res += firstAppearingOnce.FirstAppearingOnce();
        }
        System.out.println(res);
        System.out.println("Hello World");
    }

    public void Insert(char ch) {
        if (map.containsKey(ch)) {
            map.put(ch, 1);
        } else {
            map.put(ch, 0);
        }
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        for (char c : map.keySet()
        ) {
            if (map.get(c) == 0) {
                return c;
            }
        }
        return '#';
    }
}
