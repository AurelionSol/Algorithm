package SwordOffer;

public class No53_isNumeric {
    public static void main(String[] args) {
        System.out.println(isNumeric("1.79769313486232E+308".toCharArray()));
        System.out.println("Hello World");
    }

    public static boolean isNumeric(char[] str) {
        if (str == null) return false;
        int len = str.length;
        boolean isDot = false;
        boolean isE = false;
        for (int i = 0; i < len; i++) {
            if (!isNum(str[i])) {
                if (str[i] == '+' || str[i] == '-') {
                    if (i != 0) {
                        if (str[i - 1] != 'e' && str[i - 1] != 'E') return false;
                    }
                } else if (str[i] == '.') {
                    if (isE) return false;
                    if (isDot) return false;
                    if (i == 0 || i == len - 1) return false;
                    if (!isNum(str[i - 1]) && !isNum(str[i + 1])) return false;
                    isDot = true;
                } else if (str[i] == 'e' || str[i] == 'E') {
                    if (i == 0 || i == len - 1) return false;
                    isE = true;
                } else {
                    return false;
                }

            }

        }
        return true;
    }

    public static boolean isNum(char c) {
        return (c >= 48 && c <= 57);
    }
}
