package DoublePointers;

public class t88 {
    public void merge(int[] nums1, int m, int[] nums2, int n){
        int p1 = m - 1, p2 = n - 1;
        int i = m + n - 1;
        while(p1 >= 0 && p2 >= 0){
            nums1[i--] = nums1[p1] >= nums2[p2] ? nums1[p1--] : nums2[p2--];
        }
        while(p2 >= 0){
            nums1[i--] = nums2[p2--];
        }
    }

    public static void main(String[] args){
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        t88 test = new t88();
        test.merge(nums1, 3, nums2, 3);
    }
}
