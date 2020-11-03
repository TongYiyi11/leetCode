public class t4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2){
        int n1 = nums1.length;
        int n2 = nums2.length;
        int sumN = n1 + n2;
        int[] merge = new int[sumN];
        if(n1 == 0 && n2 == 0){
            throw new IllegalArgumentException("Cannot find the median of two empty num arrays!");
        }

        int i = 0, j = 0;
        int index = 0;
        while(i < n1 || j < n2){
            if(j >= n2){
                merge[index] = nums1[i];
                i += 1;
                index += 1;
                continue;
            }
            if(i >= n1){
                merge[index] = nums2[j];
                j += 1;
                index += 1;
                continue;
            }
            if(nums1[i] <= nums2[j]){
                merge[index] = nums1[i];
                i += 1;
            }else{
                merge[index] = nums2[j];
                j += 1;
            }
            index += 1;
        }

        if(sumN % 2 == 0){
            return (merge[sumN / 2 - 1] + merge[sumN / 2]) / 2.0;
        }else{
            return merge[(sumN + 1) / 2 - 1];
        }
    }

    public static void main(String[] args){
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3, 4};
        t4 test = new t4();
        System.out.println(test.findMedianSortedArrays(nums1, nums2));
    }
}
