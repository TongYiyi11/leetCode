public class t26 {
    public int removeDuplicates(int[] nums){
        int len = nums.length;
        if(len == 0 || len == 1) return len;
        int i = 0, j = 1;
        while(j < len){
            if(nums[j] == nums[i]){
                j += 1;
            }else{
                i += 1;
                nums[i] = nums[j];
                j += 1;
            }
        }
        return i + 1;
    }
}
