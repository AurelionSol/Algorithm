import java.io.File;

public class No1_FindInTwoDimArray {

    public static void main(String[] args) {
        int[][] array = new int[0][0];

        System.out.println(Find(16, array));
    }

    public static boolean Find(int target, int[][] array) {
        int len = array[0].length;
        for (int i = 0; i < len; i++) {
            if (array[i][0] <= target && array[i][len - 1] >= target) {
                for (int j = 0; j < len; j++) {
                    if (array[i][j] == target) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
