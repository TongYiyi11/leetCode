package DP;

public class t63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid){
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];
        for(int j = 0; j < n; j++){
            if(obstacleGrid[0][j] == 1){
                break;
            }else{
                dp[j] = 1;
            }
        }
        for(int i = 1; i < m; i++){
            for(int j = 0; j < n; j++){
                if(obstacleGrid[i][j] == 1){
                    dp[j] = 0;
                }else{
                    dp[j] = j == 0 ? dp[j] : dp[j] + dp[j - 1];
                }
            }
        }
        return dp[n - 1];
    }
}
