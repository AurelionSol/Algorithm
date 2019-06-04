import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class No32_PrintMinNumber {
    public static void main(String[] args) {
        int[] nums={3,5,1,4,2};
        System.out.println(PrintMinNumber(nums));
        System.out.println("Hello World!");
    }
    public static String PrintMinNumber(int[] numbers) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            list.add(numbers[i]);
        }
        Collections.sort(list,new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = o1 + "" + o2;
                String s2 = o2 + "" + o1;
                return s1.compareTo(s2);
            }
        });
        StringBuilder s = new StringBuilder();
        for (int j : list) {
            s .append(j);
        }
        return s.toString();

    }


}
