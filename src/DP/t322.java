package DP;

import java.util.Arrays;

public class t322 {
    public int coinChange(int[] coins, int amount){
        if(amount == 0) return 0;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for(int i = 1; i <= amount; i++){
            for(int j: coins){
                if(i - j < 0) continue;
                dp[i] = Math.min(dp[i], dp[i - j] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
