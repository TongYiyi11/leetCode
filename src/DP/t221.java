package DP;

public class t221 {
    public int maximalSquare(char[][] matrix){
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int M = matrix.length;
        int N = matrix[0].length;
        int[][] dp = new int[M + 1][N + 1];
        int res = 0;
        for(int i = 1; i <= M; i++){
            for(int j = 1; j <= N; j++){
                if(matrix[i - 1][j - 1] == '1'){
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res * res;
    }
}
