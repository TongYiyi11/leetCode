package DP;

public class t300 {
    public int lengthOfLIS(int[] nums){
        if(nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int end = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > dp[end]){
                end += 1;
                dp[end] = nums[i];
            }else{
                int left = 0, right = end;
                while(left < right){
                    int mid = left + (right - left) / 2;
                    if(dp[mid] < nums[i]){
                        left = mid + 1;
                    }else{
                        right = mid;
                    }
                }
                dp[left] = nums[i];
            }
        }
        return end + 1;
    }
}
