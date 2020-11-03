package DP;

public class t70 {
    public int climbStairs(int n){
        if(n <= 2) return n;
        int n1 = 1;
        int n2 = 2;
        int temp = 0;
        for(int i = 3; i <= n; i++){
            temp = n1 + n2;
            n1 = n2;
            n2 = temp;
        }
        return temp;
    }
}
