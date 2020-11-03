package DP;

public class t264 {
    public static class Ugly{
        private int[] nums;
        public Ugly(int N){
            nums = new int[N];
            int p2 = 0, p3 = 0, p5 = 0;
            nums[0] = 1;
            for(int i = 1; i < N; i++){
                nums[i] = Math.min(Math.min(nums[p2] * 2, nums[p3] * 3), nums[p5] * 5);
                //notice! if there
                if(nums[i] == nums[p2] * 2) p2 += 1;
                if(nums[i] == nums[p3] * 3) p3 += 1;
                if(nums[i] == nums[p5] * 5) p5 += 1;
            }
        }
    }

    public static Ugly uglyNum = new Ugly(1690);
    public int nthUglyNumber(int n){
        return uglyNum.nums[n - 1];
    }

    public static void main(String[] args){
        t264 test = new t264();
        int number = test.nthUglyNumber(10);
        System.out.println(number);
    }
}
