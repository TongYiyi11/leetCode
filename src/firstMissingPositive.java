/*
Given an unsorted integer array, find the smallest missing positive integer.
Example1:
Input: [1,2,0]
Output: 3
Example2:
Input: [7,8,9,11,12]
Output: 1
 */
public class firstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        int i = 0;
        while(i < len){
            if(nums[i] > 0 && nums[i] <= len && nums[i] != i + 1) {
                int indx = nums[i] - 1;
                int temp = nums[indx];
                if(temp != nums[i]){
                    nums[indx] = nums[i];
                    nums[i] = temp;
                }else i++;
            }
            else i++;
        }

        for(int j = 0; j < len; j++){
            if(nums[j] != j + 1) return j + 1;
        }
        return len + 1;
    }

    public static void main(String[] args){
        int[] nums = new int[]{1,1};
        firstMissingPositive test = new firstMissingPositive();
        System.out.println(test.firstMissingPositive(nums));
    }

}
