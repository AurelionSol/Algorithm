package SwordOffer;

public class No12_Power {
    public static void main(String[] args) {

        System.out.println(Power(2.5, 3));
    }

    public static double Power(double base, int exponent) {
        double sum = 1;
        boolean flag = exponent > 0;
        if (!flag) exponent = -exponent;
        for (int i = 0; i < exponent; i++) {
            sum *= base;
        }
        return flag ? sum : (1 / sum);
    }
}
