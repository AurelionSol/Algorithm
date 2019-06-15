package ByteDance;

import java.util.Scanner;

public class MapWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();
        char[][] chars = new char[n][q];
        String[] strs = new String[q];
        for (int i = 0; i < n; i++) {
            String temp = sc.nextLine();
            for (int j = 0; j < m; j++) {
                chars[i][j] = temp.charAt(j);
            }
        }
        next:
        for (int i = 0; i < q; i++) {
            char[] target = sc.nextLine().toCharArray();
            int[][] flag;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (chars[j][k] == target[0]) {
                        flag = new int[n][m];
                        if (isSuccess(chars, n, m, j, k, target, 0, flag)) {
                            System.out.println("Has");
                            continue next;
                        }
                    }
                }
            }
            System.out.println("Not Has");
        }

    }

    public static boolean isSuccess(char[][] chars, int rows, int cols, int i, int j, char[] target, int k, int[][] flag) {
        //现在在比较的索引
        if (i < 0 || i >= rows || j < 0 || j >= cols || chars[i][j] != target[k] || flag[i][j] == 1) {
            return false;
        }
        if (k == target.length) return true;
        flag[i][j] = 1;
        if (isSuccess(chars, rows, cols, i - 1, j, target, k + 1, flag) ||
                isSuccess(chars, rows, cols, i + 1, j, target, k + 1, flag) ||
                isSuccess(chars, rows, cols, i, j - 1, target, k + 1, flag) ||
                isSuccess(chars, rows, cols, i, j + 1, target, k + 1, flag)) return true;
        //标记恢复，体现了回溯法。
        return false;
    }
}
