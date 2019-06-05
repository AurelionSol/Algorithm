package SwordOffer;

public class No7_Fibonacci {

    public static void main(String[] args) {
        System.out.println(Fibonacci(11));
    }

    public static int Fibonacci(int n) {
        int[] fib = new int[100];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i < 100; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n];
    }
}
