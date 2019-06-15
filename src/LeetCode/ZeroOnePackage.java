package LeetCode;

public class ZeroOnePackage {
    public static void main(String args[]) {
        ZeroOnePackage killMonster = new ZeroOnePackage();
        int s = 10;
        int[] v = {1, 2, 3};
        int[] c = {3, 5, 7};
        int[] amount = {1, 6};
        System.out.println(killMonster.getMaxValue(s, v, c));
        System.out.println(-7 % 10);
    }

    public int getMaxValue(int s, int[] v, int[] c) {
        // Write your code here
        int n = v.length;
        int[] dp = new int[s + 1];
        for (int i = 0; i < n; i++) {
            for (int j = s; j >= c[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - c[i]] + v[i]);
            }
        }
        return dp[s];
    }
}
