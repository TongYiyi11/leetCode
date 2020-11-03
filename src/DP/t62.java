package DP;

public class t62 {
    public int uniquePaths(int m, int n){
        int[] dp = new int[n + 1];
        for(int j = 1; j < n + 1; j++){
            dp[j] = 1;
        }
        for(int i = 2; i < m + 1; i++){
            for(int j = 2; j < n + 1; j++){
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[n];
    }
}
