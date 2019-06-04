import java.util.ArrayList;

public class No44_ReverseSentence {
    public static void main(String[] args) {

        System.out.println(ReverseSentenceT("student. a am I"));
        System.out.println("Hello World");
    }

    //通过翻转来做
    public static String ReverseSentenceT(String str) {
        if (str.length() == 0) return "";
        char[] chars = str.toCharArray();
        int len = str.length();
        for (int i = 0, j = len - 1; i < j; i++, j--) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        int left=0,right=0;
        while (left<=right&&right<len){
            if (chars[right]==' '){
                for (int i = left, j = right - 1; i < j; i++, j--) {
                    char temp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = temp;
                }
                left=right+1;
            }
            right++;
        }
        for (int i = left, j = right - 1; i < j; i++, j--) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        return String.valueOf(chars);
    }

    //开额外数组
    public static String ReverseSentence(String str) {
        if (str.length() == 0) return "";
        ArrayList<String> list = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                list.add(spilt(str, ' ', index));
                index = i + 1;
            }
        }
        list.add(spilt(str, ' ', index));
        StringBuilder builder = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            builder.append(list.get(i));
            if (i != 0)
                builder.append(' ');
        }
        return builder.toString();
    }

    public static String spilt(String str, char c, int index) {
        StringBuilder builder = new StringBuilder();
        for (int i = index; i < str.length(); i++) {
            if (str.charAt(i) == c)
                return builder.toString();
            builder.append(str.charAt(i));
        }
        return builder.toString();
    }
}
