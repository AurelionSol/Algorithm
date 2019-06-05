package SwordOffer;

import java.util.ArrayList;

public class No41_FindContinuousSequence {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> listTol = FindContinuousSequence(100);
        System.out.println("Hello World");
    }

    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> listTol = new ArrayList<>();
        for (int i = 1; i <= sum / 2; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j <=sum / 2; j++) {
                list.add(i + j);
                int n = j + 1;
                int temp = i * n + (n * n - n) / 2;
                if (temp > sum) break;
                if (temp == sum) {
                    listTol.add(list);
                    break;
                }
            }
        }
        return listTol;
    }
}
