package SwordOffer;

public class No8_JumpFloor {
    public static void main(String[] args) {

        System.out.println(JumpFloor(29));
    }

    public static int JumpFloor(int target) {
        int sum = 0;
        int count = 0;
        while (target >= count) {
            sum += Cmn(count, target);
            count++;
            target--;
        }
        return sum;
    }

    public static long Cmn(int m, int n) {
        if (n == 0) {
            return 0;
        }
        long den = 1;
        long mol = 1;
        while (m > 0) {
            den *= n;
            mol *= m;
            n--;
            m--;
        }
        return den / mol;
    }
}
