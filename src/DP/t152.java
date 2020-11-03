package DP;

public class t152 {
    public int maxProduct(int[] nums){
        int maxF = nums[0];
        int minF = nums[0];
        int res = nums[0];
        for(int i = 1; i < nums.length; i++){
            int temp = Math.max(maxF * nums[i], Math.max(minF * nums[i], nums[i]));
            minF = Math.min(maxF * nums[i], Math.min(minF * nums[i], nums[i]));
            maxF = temp;
            res = Math.max(res, maxF);
        }
        return res;
    }
}
