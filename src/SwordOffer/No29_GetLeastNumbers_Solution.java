package SwordOffer;

import java.util.ArrayList;

public class No29_GetLeastNumbers_Solution {
    public static void main(String[] args) {
        int[] input = {4, 5, 1, 6, 2, 7, 3, 8};
        int k = 4;
        System.out.println(GetLeastNumbers_Solution(input, k));
        System.out.println("Hello World!");
    }

    //直接排序，O(nlogn)
    //应该用堆，建一个大小为k的最大堆，每次和堆顶元素比较，小于则入堆。O(nlogk)
    //还可以用快排的思想
    //该算法复杂度O(kn)
    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {

        ArrayList<Integer> list = new ArrayList<>();
        if (k > input.length) {
            return list;
        }
        int max = input[0];
        int count = 0;
        for (int i = 0; i < input.length; i++) {
            if (count < k) {
                list.add(input[i]);
                if (input[i] > max) {
                    max = input[i];
                }
                count++;
            } else {
                if (input[i] < max) {
                    list.remove(list.indexOf(max));
                    list.add(input[i]);
                    max = -1;
                    for (int j :
                            list) {
                        if (j > max) {
                            max = j;
                        }
                    }
                }
            }
        }
        return list;
    }
}
