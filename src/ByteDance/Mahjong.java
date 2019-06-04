package ByteDance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Mahjong {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 13; i++) {
            list.add(s.nextInt());
        }
        for (int i = 1; i < 10; i++) {
            ArrayList<Integer> temp = new ArrayList<>(list);
            temp.add(i);
            if (isHu(temp)) System.out.println(i);
        }
    }

    public static boolean isHu(ArrayList<Integer> list) {
        if (list.size() != 14) {
            return false;
        }
        Collections.sort(list);

        return true;
    }

}
