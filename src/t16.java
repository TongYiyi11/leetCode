import java.util.Arrays;

public class t16 {
    public int threeSumClosest(int[] nums, int target){
        int len = nums.length;
        if(nums == null || len < 3){
            return 0;
        }
        Arrays.sort(nums);
        int L, R, res, sum;
        int ans = 0;
        int diff = Integer.MAX_VALUE;
        for(int i = 0; i < len - 2; i++){
            res = target - nums[i];
            L = i + 1;
            R = len - 1;
            while(L < R){
                sum = nums[L] + nums[R];
                if(sum == res) return target;
                if(Math.abs(res - sum) < diff){
                    ans = sum + nums[i];
                    diff = Math.abs(res - sum);
                }
                if(sum > res) R -= 1;
                if(sum < res) L += 1;
            }
        }
        return ans;
    }

    public static void main(String[] args){
        int[] nums = new int[]{6,-18,-20,-7,-15,9,18,10,1,-20,-17,-19,-3,-5,-19,10,6,
                -11,1,-17,-15,6,17,-18,-3,16,19,-20,-3,-17,-15,-3,12,1,-9,4,1,12,-2,14,
                4,-4,19,-20,6,0,-19,18,14,1,-15,-5,14,12,-4,0,-10,6,6,-6,20,-8,-6,5,0,3,
                10,7,-2,17,20,12,19,-13,-1,10,-1,14,0,7,-3,10,14,14,11,0,-4,-15,-8,3,2,-5,
                9,10,16,-4,-3,-9,-8,-14,10,6,2,-12,-7,-16,-6,10};
        int target = -52;
        t16 test = new t16();
        System.out.println(test.threeSumClosest(nums, target));
    }
}
