package ByteDance;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class findMid {
    public static void main(String args[]) {
        findMid mid = new findMid();
        int[] num = new int[100];
        for (int i = 0; i < 100; i++) {
            num[i] = (int) (Math.random() * 1000);
        }
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 100; i++) {
            list.add(num[i]);
        }
        Collections.sort(list);
        System.out.println(list.get(list.size() / 2));
        System.out.println(mid.find(num));
    }

    public int find(int[] num) {
        if (num == null || num.length <= 0) return -1;
        int l = 0;
        int r = num.length - 1;
        int midIndex = num.length / 2;
        int index = -1;
        while (index != midIndex) {
            index = partition(num, l, r);
            if (index < midIndex) l = index + 1;
            if (index > midIndex) r = index - 1;
        }
        return num[index];
    }

    public int partition(int[] num, int l, int r) {
        int ranNum = (int) (Math.random() * (r - l)) + l;
        int pivot = num[ranNum];
        num[ranNum] = num[l];
        num[l] = pivot;
        while (l < r) {
            while (l < r && num[r] > pivot) r--;
            num[l] = num[r];
            while (l < r && num[l] < pivot) l++;
            num[r] = num[l];
        }
        num[l] = pivot;
        return l;
    }
}
