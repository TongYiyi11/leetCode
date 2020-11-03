package DP;

public class t279 {
    public int numSquares(int n){
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for(int j = 1; j < n + 1; j++){
            dp[j] = j;
            for(int i = 1; i * i <= j; i++){
                dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args){
        t279 test = new t279();
        System.out.println(test.numSquares(13));
    }
}
