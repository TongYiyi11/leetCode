package DP;

public class t413 {
    public int numberOfArithmeticSlices(int[] A){
        if(A.length < 3) return 0;
        int prev = 0;
        int res = 0;
        for(int i = 2; i < A.length; ++i){
            if(A[i - 1] * 2 == A[i - 2] + A[i]){
                prev = prev + 1;
            }else{
                prev = 0;
            }
            res += prev;
        }
        return res;
    }
}
