package BinarySearch;

public class t69 {
    public int mySqrt(int x){
        int left = 1, right = x;
        while(left <= right){
            int mid = left + (right - left) / 2;
            int temp = x / mid;
            if(temp == mid){
                return mid;
            }else if(temp > mid){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return left - 1;
    }

    public static void main(String[] args){
        t69 test = new t69();
        System.out.println(test.mySqrt(2147395599));
    }
}
