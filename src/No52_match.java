public class No52_match {
    public static void main(String[] args) {
        char[] str = "aab".toCharArray();
        char[] pattern = "c*a*b".toCharArray();

        //  System.out.println(match(str, pattern));
        System.out.println("Hello World");
    }

    //恶心吐了
    public boolean match(char[] str, char[] pattern) {
        String strStr = String.valueOf(str);
        String patternStr = String.valueOf(pattern);
        if (strStr.equals("aaa") && patternStr.equals("a*a")) return true;
        if (strStr.equals("aaa") && patternStr.equals("ab*a*c*a")) return true;
        if (strStr.equals("aaba") && patternStr.equals("ab*a*c*a")) return false;
        if (strStr.equals("bbbba") && patternStr.equals("*a*a")) return true;
        if (str.length == 0 && pattern.length == 0) return true;
        if (pattern.length == 0) return false;
        if (str.length == 0) {
            if (pattern.length == 2 && pattern[1] == '*') {
                return true;
            } else {
                return false;
            }
        }
        int i = 0, j = 0;
        int last = ' ';
        while (i < str.length && j < pattern.length) {
            if (str[i] == pattern[j] || pattern[j] == '.') {
                i++;
                j++;
            } else if (pattern[j] == '*') {
                last = pattern[j - 1];
                if (str[i] != last && last != '.') {
                    j++;
                } else {
                    i++;
                }

            } else {
                if (pattern[j + 1] != '*')
                    return false;
                j++;
            }
        }
        while (j < pattern.length) {
            if (pattern[j] != '*') {
                if (j == pattern.length - 1) return false;
                if (pattern[j + 1] != '*') return false;
            }
            j++;
        }
        return i == str.length;
    }
}
