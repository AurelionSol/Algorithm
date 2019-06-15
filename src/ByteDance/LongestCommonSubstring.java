package ByteDance;

public class LongestCommonSubstring {
    public int longestCommonSubstring(String A, String B) {
        // write your code here
        int lenA =A.length(),lenB = B.length();
        int[][] dp = new int[lenA+1][lenB+1];
        int max=0;
        for(int i =1;i<=lenA;i++){
            for(int j=1;j<=lenB;j++){
                if(A.charAt(i-1)==B.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                    if(dp[i][j]>max){
                        max=dp[i][j];
                    }
                }else{
                    dp[i][j]=0;
                }
            }
        }
        return max;
    }
}
