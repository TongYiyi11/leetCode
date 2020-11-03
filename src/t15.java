import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class t15 {
    public List<List<Integer>> threeSum(int[] nums){
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || len < 3) return result;

        Arrays.sort(nums);
        int L, R, sum;
        for(int i = 0; i < len - 2; i++){
            if(nums[i] > 0) break;
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            L = i + 1;
            R = len - 1;
            while(L < R){
                sum = nums[L] + nums[R] + nums[i];
                if(sum == 0){
                    List<Integer> temp = Arrays.asList(nums[i], nums[L], nums[R]);
                    result.add(temp);
                    // notice! delete repeat result! Cannot use result.contains which will lead to running out of time
                    while(L < R && nums[L] == nums[L + 1] && nums[R] == nums[R - 1]){
                        L += 1;
                        R -= 1;
                    }
                    L += 1;
                    R -= 1;
                }
                if(sum > 0){
                    // will slow down the program ?!
                    //while(L < R && nums[R] == nums[R - 1]) R -= 1;
                    R -= 1;
                }
                if(sum < 0){
                    //while(L < R && nums[L] == nums[L + 1]) L += 1;
                    L += 1;
                }
            }
        }

        return result;
    }
}
