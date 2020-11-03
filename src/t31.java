public class t31 {
    public void nextPermutation(int[] nums){
        if(nums.length == 0 || nums.length == 1) return;
        boolean check = false;
        int min = nums.length - 1;
        for(int i = nums.length - 1; i > 0; i--){
            if(nums[i] > nums[i - 1]){
                int temp = nums[min];
                while(temp <= nums[i - 1]){
                    min -= 1;
                    temp = nums[min];
                }
                nums[min] = nums[i - 1];
                nums[i - 1] = temp;
                ascendOrder(i, nums.length - 1, nums);
                check = true;
                break;
            }
        }
        if(!check){
            ascendOrder(0, nums.length - 1, nums);
        }
    }

    private void ascendOrder(int left, int right, int[] nums){
        while(left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left += 1;
            right -= 1;
        }
    }
}
