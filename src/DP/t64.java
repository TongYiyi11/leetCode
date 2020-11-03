package DP;

public class t64 {
    public int minPathSum(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];
        dp[0] = grid[0][0];
        for(int j = 1; j < n; j++){
            dp[j] = grid[0][j] + dp[j - 1];
        }
        for(int i = 1; i < m; i++){
            for(int j = 0; j < n; j++){
                dp[j] = j == 0 ? dp[j] + grid[i][j] : Math.min(dp[j], dp[j - 1]) + grid[i][j];
            }
        }
        return dp[n - 1];
    }
}
