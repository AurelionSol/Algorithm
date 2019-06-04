import java.util.ArrayList;

public class No51_multiply {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        System.out.println(multiply(A));
        System.out.println("Hello World");
    }

    //用矩阵法做，分别计算两边的乘积其实数组是对称的，不存在从前往后容易，从后往前就困难了
    public static int[] multiply(int[] A) {
        if (A.length == 0) return A;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(A[0]);
        int count = 1;
        for (int i = A.length - 1; i > 0; i--) {
            list.add(list.get(count - 1) * A[i]);
            count++;
        }
        int[] B = new int[A.length];
        count--;
        B[0] = list.get(count);
        int mult = A[0];
        for (int i = 1; i < A.length; i++) {
            B[i] = mult * list.get(count - i);
            mult *= A[i];
        }
        return B;
    }
}
