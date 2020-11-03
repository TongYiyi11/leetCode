package DP;

import java.util.Arrays;

public class t416 {
    public boolean canPartition(int[] nums){
        if(nums.length == 0) return false;
        int sum = 0;
        for(int n : nums){
            sum += n;
        }
        if(sum % 2 != 0) return false;
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        for(int i = 1; i < nums.length; i++){
            dp[0] = true;
            for(int j = target; j >= 0; j--){
                if(j - nums[i - 1] < 0){
                    dp[j] = dp[j];
                }else{
                    dp[j] = dp[j] || dp[j - nums[i - 1]];
                }
            }
        }
        return dp[target];
    }
}
