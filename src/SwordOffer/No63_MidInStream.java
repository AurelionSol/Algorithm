package SwordOffer;

import java.util.ArrayList;
import java.util.Collections;


public class No63_MidInStream {
    ArrayList<Integer> list = new ArrayList();

    //不会
    public static void main(String[] args) {
        No63_MidInStream midInStream = new No63_MidInStream();
        int[] num = {5, 2, 3, 4, 1, 6, 7, 0, 8};
        for (int i = 0; i < num.length; i++) {
            midInStream.Insert(num[i]);
            System.out.println(midInStream.GetMedian());
        }
        System.out.println("Hello World");
    }

    public void Insert(Integer num) {
        list.add(num);
        Collections.sort(list);
    }

    public Double GetMedian() {
        int count = list.size() - 1;
        if (count == 0) return list.get(0) * 1.0;
        if (count == 1) return (list.get(0) + list.get(1)) / 2.0;
        if ((count + 1) % 2 == 0) {
            return (list.get(count / 2) + list.get(count / 2 + 1)) / 2.0;
        } else {
            return list.get(count / 2) * 1.0;
        }
    }
}
