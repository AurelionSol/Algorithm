package ByteDance;

public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String A, String B) {
        // write your code here

        int lenA = A.length(), lenB = B.length();
        if (lenA <= 0 || lenB <= 0) return 0;
        int[][] dp = new int[lenA + 1][lenB + 1];
        for (int i = 1; i <= lenA; i++) {
            for (int j = 1; j <= lenB; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[lenA][lenB];
    }
}
