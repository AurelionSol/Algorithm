package SwordOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

public class No34_FirstNotRepeatingChar {

    public static void main(String[] args) {
        String s = "SCpPwKPMwdSGXDXiiHxGkGDTtcjVmUTZreuhLetplMWyiUtIVdsMI";
        System.out.println(FirstNotRepeatingCharMap(s));
        System.out.println("Hello World!");
    }
//HashMap
    public static int FirstNotRepeatingCharMap(String str){
        if (str.length()==0){
            return  -1;
        }
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))){
                int time = map.get(str.charAt(i));
                map.put(str.charAt(i), ++time);
            }else {
                map.put(str.charAt(i), 1);
            }
        }

        for (int i = 0; i < str.length() ; i++) {
            if (map.get(str.charAt(i)) == 1) {
                return i;
            }
        }
        return  -1;
    }
//铁憨憨解法
    public static int FirstNotRepeatingChar(String str) {
        if (str.length()==0){
            return -1;
        }
        if (str.length() == 1) {
            return 0;
        }
        char[] s1 = str.toCharArray();
        ArrayList<Character> list = new ArrayList<>();
        Arrays.sort(s1);
        char temp = s1[0];
        for (int i = 1; i < s1.length - 1; i++) {
            if (s1[i] != temp && s1[i] != s1[i + 1]) {
                list.add(s1[i]);
            }
            temp = s1[i];
        }
        if (s1[s1.length - 1] != s1[s1.length - 2]) {
            list.add(s1[s1.length - 1]);
        }
        if (s1[0] != s1[1]) {
            list.add(s1[0]);
        }
        if (list.size() == 0) {
            return -1;
        }
        int min = s1.length;
        for (Character c :
                list) {
            if (str.indexOf(c) < min) {
                min = str.indexOf(c);
            }
        }
        return min;
    }
}
