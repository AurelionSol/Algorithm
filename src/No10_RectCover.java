public class No10_RectCover {
    public static void main(String[] args) {

        System.out.println("Hello World!");
    }

    public int RectCover(int target) {
        int[] fib = new int[100];
        fib[0] = 0;
        fib[1] = 1;
        fib[2]=2;
        for (int i = 3; i < 100; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[target];
    }
}
