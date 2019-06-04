import java.util.ArrayList;

public class No19_printMatrix {
    static ArrayList<Integer> list = new ArrayList();

    public static void main(String[] args) {
        list.clear();
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[][] matrix2 = {{1, 2}, {3, 4}};
        int[][] matrix3 = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        int[][] matrix4 = {{1}, {2}, {3}, {4}, {5}};
        int[][] matrix5 = {{1, 2}, {3, 4}, {5, 6}, {7, 8}, {9, 10}};
        int[][] matrix6 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
        list = printMatrix(matrix);
        for (int i :
                list) {
            System.out.print(i + ",");
        }
    }

    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        int start = 0;
        int iIndex = matrix[0].length;
        int jIndex = matrix.length;
        while (start < jIndex && start < iIndex) {
            printIandJ(matrix, start, iIndex, jIndex);
            start++;
            iIndex--;
            jIndex--;
        }
        int length = matrix[0].length*matrix.length;
        ArrayList<Integer> list2= new ArrayList<>();
        for (int i = 0; i < length; i++) {
            list2.add(list.get(i));
        }
        return list2;
    }

    public static void printIandJ(int[][] matrix, int start, int iIndex, int jIndex) {
        for (int i = 0; i < iIndex - start; i++) {
            list.add(matrix[start][start + i]);
        }
        for (int i = 1; i < jIndex - start; i++) {
            list.add(matrix[start + i][iIndex - 1]);
        }
        for (int i = 1; i < iIndex - start; i++) {
            list.add(matrix[jIndex - 1][iIndex - i - 1]);
        }
        for (int i = 1; i < jIndex - 1 - start; i++) {
            list.add(matrix[jIndex - 1 - i][start]);
        }
    }
}
