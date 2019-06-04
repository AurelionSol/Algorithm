package ByteDance;

import java.util.ArrayList;
import java.util.Scanner;

public class CatchKong {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int d = s.nextInt();
        ArrayList<Integer> points = new ArrayList();
        for (int i = 0; i < n; i++) {
            points.add(s.nextInt());
        }
        int sum = 0;
        int i = 0;
        int j = 2;
        while (j < points.size()) {
            while (points.get(j) - points.get(i) > d && i < j) i++;
            int c = j - i;
            if (c >= 2) {
                sum += (c * (c - 1) / 2);
            }
            j++;
        }
        System.out.println(sum);

    }

}
