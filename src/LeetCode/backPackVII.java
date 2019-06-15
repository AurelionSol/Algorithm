package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class backPackVII {
    List<Integer> list = new ArrayList<>();
    int n = 8;
    int[] price = {3, 2};
    int[] weights = {300, 160};

    public static void main(String args[]) {
        backPackVII killMonster = new backPackVII();
        int n = 8;
        int[] price = {3, 2};
        int[] weight = {300, 160};
        int[] amount = {1, 6};
        killMonster.backPackVII(n, price, weight, amount);
        System.out.println(-7 % 10);
    }
//    def backPackVII(self, n, prices, weight, amounts):
//            # write your code here
//    dp = [0 for j in range(n+1)]
//
//            for i in range(0, len(prices)):
//            for k in range(0, amounts[i]):
//            for j in range(n, prices[i]-1, -1):
//    dp[j] = max(dp[j], dp[j-prices[i]]+weight[i])
//        return dp[-1]

    public int backPackVII(int n, int[] prices, int[] weight, int[] amounts) {
        // write your code here
        int[] dp = new int[n + 1];
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < amounts[i]; j++) {
                for (int k = n; k >= prices[i]; k--) {
                    dp[k] = Math.max(dp[k], dp[k - prices[i]] + weight[i]);
                }
            }
        }
        return  dp[n];
    }


}
