import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class t18 {
    public List<List<Integer>> fourSum(int[] nums, int target){
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || len < 4) return result;
        Arrays.sort(nums);

        int L, R, sum;
        int i = 0;
        while(i < len - 3){
            int j = i + 1;
            while(j < len - 2){
                L = j + 1;
                R = len - 1;
                while(L < R){
                    sum = nums[i] + nums[j] + nums[L] + nums[R];
                    if(sum == target){
                        result.add(Arrays.asList(nums[i], nums[j], nums[L], nums[R]));
                        while(L < R && nums[L] == nums[L + 1] && nums[R] == nums[R - 1]){
                            L += 1;
                            R -= 1;
                        }
                        L += 1;
                        R -= 1;
                    }
                    if(sum > target) R -= 1;
                    if(sum < target) L += 1;
                }

                while(j < len - 2 && nums[j] == nums[j + 1]) j += 1;
                j += 1;
            }

            while(i < len - 3 && nums[i] == nums[i + 1]) i += 1;
            i += 1;

        }
        return result;

    }
}
