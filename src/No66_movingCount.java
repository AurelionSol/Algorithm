public class No66_movingCount {
    public static void main(String[] args) {
        No66_movingCount movingCount = new No66_movingCount();
        int count = movingCount.movingCount(5, 10, 10);
        System.out.println(count);
        System.out.println("Hello World");
    }

    public int movingCount(int threshold, int rows, int cols) {
        int len = rows * cols;
        int[] flag = new int[len];
        return reachCount(threshold, rows, cols, 0, 0, flag);
    }

    public int reachCount(int threshold, int rows, int cols, int i, int j, int[] flag) {
        int index = i * cols + j;
        int count = 0;
        if (i < 0 || i >= rows || j < 0 || j >= cols || isSuccess(threshold, i, j) || flag[index] == 1) {
            return 0;
        }
        flag[index] = 1;
        return 1 + (reachCount(threshold, rows, cols, i + 1, j, flag)) +
                (reachCount(threshold, rows, cols, i - 1, j, flag)) +
                (reachCount(threshold, rows, cols, i, j + 1, flag)) +
                (reachCount(threshold, rows, cols, i, j - 1, flag));

    }

    public boolean isSuccess(int threshold, int i, int j) {
        int sum = 0;
        while (i > 0) {
            sum += i % 10;
            i /= 10;
        }
        while (j > 0) {
            sum += j % 10;
            j /= 10;
        }
        return threshold < sum;
    }
}
