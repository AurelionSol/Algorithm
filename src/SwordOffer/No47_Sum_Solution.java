package SwordOffer;

public class No47_Sum_Solution {

    //短路运算
    public int Sum_SolutionSC(int n) {
        int ans = n;
        boolean Flag = (ans > 0) && ((ans += Sum_Solution(n - 1)) > 0);
        return ans;
    }

    //Java赖皮解法
    public int Sum_Solution(int n) {
        return ((int) (Math.pow(n, 2) + n) >> 1);
    }
}
