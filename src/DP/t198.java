package DP;

public class t198 {
    public int rob(int[] nums){
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int n1 = nums[0];
        int n2 = nums[1];
        int res = Math.max(n1, n2);
        int beforeMax = nums[0];
        for(int i = 2; i < nums.length; i++){
            n1 = n2;
            n2 = beforeMax + nums[i];
            beforeMax = Math.max(beforeMax, n1);
            res = Math.max(res, n2);
        }
        return res;
    }
}
