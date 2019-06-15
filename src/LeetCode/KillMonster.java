package LeetCode;

import java.util.*;

public class KillMonster {
    public static void main(String args[]) {
        KillMonster killMonster = new KillMonster();
        int n = 5;
        int[][] v = {{3, 9, 2, 1, 5}, {0, 9, 6, 5, 9}, {6, 1, 8, 6, 3}, {3, 7, 0, 4, 4}, {9, 9, 0, 6, 5}, {5, 6, 5, 6, 7}};
        killMonster.killMonster2(n, v);
        System.out.println(-7 % 10);
    }

    public int killMonster(int n, int[][] v) {
        //
        List<int[]> list = new ArrayList<>();
        int[] atoman = v[0];
        for (int i = 1; i < v.length; i++) {
            list.add(v[i]);
        }
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return getMax(o1) - getMax(o2);
            }
        });
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            int[] monster = list.get(i);
            for (int j = 0; j < atoman.length; j++) {
                if (atoman[j] < monster[j]) return count;
                atoman[j] += monster[j];
            }
            count++;
        }
        return count;
    }

    public int getMax(int[] num) {
        int max = -1;
        for (int i = 0; i < num.length; i++) {
            if (num[i] > max) max = num[i];
        }
        return max;
    }

    public int killMonster2(int n, int[][] v) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 1; i < v.length; i++)
            queue.add(v[i]);
        boolean flag = false;
        int res = 0;
        int[] tmp;
        while (!flag) {
            flag = true;
            A:
            for (int i = 0; i < queue.size(); i++) {
                tmp = queue.poll();
                for (int j = 0; j < v[0].length; j++)
                    if (v[0][j] < tmp[j]) {
                        queue.add(tmp);
                        continue A;
                    }
                res++;
                for (int j = 0; j < v[0].length; j++)
                    v[0][j] += tmp[j];
                flag = false;
            }
        }
        return res;
    }

}
