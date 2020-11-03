package DP;

public class t1025 {
    public boolean divisorGame(int N){
        boolean[] dp = new boolean[N + 1];
        if(N > 1) dp[2] = true;
        for(int n = 3; n <= N; n++){
            for(int j = 1; j < n; j++){
                if(n % j == 0 && !dp[n - j]){
                    dp[n] = true;
                    break;
                }
            }
        }
        return dp[N];
    }
}
