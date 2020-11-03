package DP;

public class t213 {
    public int rob(int[] nums){
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        int dp0 = nums[0];
        int dp1 = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length - 1; i++){
            int temp = Math.max(nums[i] + dp0, dp1);
            dp0 = dp1;
            dp1 = temp;
        }
        int dp20 = nums[1];
        int dp21 = Math.max(nums[1], nums[2]);
        for(int i = 2; i < nums.length - 1; i++){
            int temp = Math.max(nums[i + 1] + dp20, dp21);
            dp20 = dp21;
            dp21 = temp;
        }
        return Math.max(dp1, dp21);
    }


}
