public class t11 {
    public int maxArea(int[] height){
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        while(left < right){
            maxArea = Math.max(maxArea, (right - left) * Math.min(height[left], height[right]));
            if(height[left] <= height[right]){
                left += 1;
            }else{
                right -= 1;
            }
        }
        return maxArea;
    }

    public static void main(String args[]){
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        t11 test = new t11();
        System.out.println(test.maxArea(height));
    }
}
