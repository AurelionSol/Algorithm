package SwordOffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class No33_GetUglyNumber_Solution {
    public static void main(String[] args) {

        System.out.println(GetUglyNumber_SolutionQueue(7));
    }

    //用三个队列
    public static int GetUglyNumber_SolutionQueue(int index) {
        if (index == 0) {
            return 0;
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        int t1 = 0, t2 = 0, t3 = 0;
        for (int i = 0; i < index; i++) {
            int ugly = min(list.get(t1) * 2, list.get(t2) * 3, list.get(t3) * 5);
            list.add(ugly);
            if (ugly == list.get(t1) * 2) t1++;
            if (ugly == list.get(t2) * 3) t2++;
            if (ugly == list.get(t3) * 5) t3++;
        }
        return list.get(index - 1);
    }

    public static int min(int a, int b, int c) {
        int min = a > b ? b : a;
        return c > min ? min : c;
    }

    //不正确哦
    public static int GetUglyNumber_Solution(int index) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 15; j++) {
                for (int k = 0; k < 20; k++) {
                    int ugly = (int) ((Math.pow(5, i)) * (Math.pow(3, j)) * (Math.pow(2, k)));
                    list.add(ugly);
                }
            }
        }
        Collections.sort(list);
        return list.get(index);
    }


}
