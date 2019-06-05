package SwordOffer;

public class No2_replaceAllSpace {
    public static void main(String[] args) {

        System.out.println("Hello World!");
    }

    public static String replaceSpace(StringBuffer str) {
        while (str.indexOf(" ") != -1) {
            int index = str.indexOf(" ");
            str = str.deleteCharAt(index);
            str = str.insert(index, "%20");
        }
        return str.toString();
    }
}
