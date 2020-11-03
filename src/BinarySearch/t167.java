package BinarySearch;

public class t167 {
    public int[] twoSum(int[] numbers, int target){
        int[] res = new int[2];
        int left = 0, right = numbers.length - 1;
        while(left < right){
            int sum = numbers[left] + numbers[right];
            if(sum == target){
                res[0] = left + 1;
                res[1] = right + 1;
                return res;
            }else if(sum > target){
                right -= 1;
            }else{
                left += 1;
            }
        }
        return res;
    }

    public static void main(String[] args){
        int[] numbers = new int[]{2, 7, 11, 15};
        t167 test = new t167();
        test.twoSum(numbers, 9);
    }
}
