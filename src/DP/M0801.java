package DP;

public class M0801 {
    public int waysToStep(int n){
        if(n <= 2) return n;
        if(n == 3) return 4;
        double n1 = 1;
        double n2 = 2;
        double n3 = 4;
        double temp = 0;
        for(int i = 4; i <= n; i++){
            temp = n1 + n2 + n3;
            n1 = n2;
            n2 = n3;
            n3 = temp;
        }
        return (int) (temp % 1000000007);
    }
}
