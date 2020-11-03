public class t27 {
    public int removeElement(int[] nums, int val){
        int i = 0, j = 0;
        while(j < nums.length){
            if(nums[j] == val){
                j += 1;
                continue;
            }else{
                nums[i] = nums[j];
                j += 1;
                i += 1;
            }
        }
        return i;
    }
}
