package DP;

public class M1716 {
    public int massage(int[] nums){
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        int max0 = nums[0];
        int max1 = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++){
            int temp = Math.max(max0 + nums[i], max1);
            max0 = max1;
            max1 = temp;
        }
        return max1;
    }
}
