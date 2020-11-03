package DP;

public class t303 {
    int[] sum;
    public t303(int[] nums){
        int l = nums.length;
        sum = new int[l + 1];
        for(int m = 1; m < l + 1; m++){
            sum[m] = sum[m - 1] + nums[m - 1];
        }
    }

    public int sumRange(int i, int j){
        return sum[j + 1] - sum[i];
    }
}
