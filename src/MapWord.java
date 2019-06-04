import java.util.Scanner;

public class MapWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();
        char[][] chars = new char[n][q];
        String[] strs = new String[q];
        for (int i = 0; i <n ; i++) {
            String temp = sc.nextLine();
            for (int j = 0; j < m; j++) {
                chars[i][j]=temp.charAt(j);
            }
        }

        for (int i = 0; i <q ; i++) {
            String tagrt = sc.nextLine();
            int[][] flag = new int[n][m];
            if(isSuccess(chars, n, m, 0, 0,"" ,tagrt,flag)){
                System.out.println("Has");
            }else {
                System.out.println("Not Has");
            }
        }

    }

    public static boolean isSuccess(char[][] chars, int rows, int cols, int i, int j, String s, String tagrt,int[][] flag) {
        //现在在比较的索引
        if (i < 0 || i >= rows || j < 0 || j >=cols || !s.equals(tagrt)|| flag[i][j] == 1) {
            return false;
        }
        s+=chars[i][j];
        if (s.equals(tagrt)) return true;
        flag[i][j] =1;
        if (isSuccess(chars, rows, cols, i - 1, j, s, tagrt,flag) ||
                isSuccess(chars, rows, cols, i + 1, j, s, tagrt, flag) ||
                isSuccess(chars, rows, cols, i, j - 1, s, tagrt, flag) ||
                isSuccess(chars, rows, cols, i, j + 1, s, tagrt, flag)) return true;
        //标记恢复，体现了回溯法。
        return false;
    }
}
