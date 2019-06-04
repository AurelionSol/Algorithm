package ByteDance;

import java.util.Scanner;

public class HandString {
    public static void main(String[] args) {
        new HandString().f();
    }

    public void f() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), c = sc.nextInt();
        int[][] mx = new int[c][n];
        for (int i = 0; i < n; i++) {
            int len = sc.nextInt();
            for (int j = 0; j < len; j++) {
                int color = sc.nextInt();
                mx[color - 1][i] = color;
            }
        }
        int count = 0;
        for (int i = 0; i < c; i++) {
            int color = i + 1;
            boolean flag = false;
            for (int j = 0; j < n; j++) {
                if (mx[i][j] == color) {
                    int temp = 0;
                    for (int k = 1; k < m; k++) {
                        temp = (j + k) % n;
                        if (mx[i][temp] == color) {
                            flag = true;
                            break;
                        }
                    }
                    if (flag) {
                        count++;
                        break;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
