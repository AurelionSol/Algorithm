public class No31_NumberOf1Between1AndN_Solution {

    public static void main(String[] args) {

        System.out.println("Hello World!");
    }

    public int NumberOf1Between1AndN_Solution2(int n) {

        int count = 0;
        int i = 1;
        for (i = 1; i <= n; i *= 10) {
            //i表示当前分析的是哪一个数位
            int a = n / i;
            int b = n % i;
            count = count + (a + 8) / 10 * i;
            if (a % 10 == 1)
                count += (b + 1);
        }
        return count;


    }

    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        for (int i = 0; i <= n; i++) {
            int temp = i;
            while (temp > 0) {
                if (temp % 10 == 1)
                    count++;
                temp /= 10;
            }
        }
        return count;
    }

}
