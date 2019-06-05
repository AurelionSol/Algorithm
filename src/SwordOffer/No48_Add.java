package SwordOffer;

public class No48_Add {
    public static void main(String[] args) {
        System.out.println(Add(111, 899));
        System.out.println("Hello World");
    }

    // 加法等于 两个数的异或加上两个数的进位，循环处理，直到没有进位为止。
    public static int Add(int num1, int num2) {
        while (num2!=0) {
            int temp = num1^num2;
            num2 = (num1&num2)<<1;
            num1 = temp;
        }
        return num1;

    }

}
