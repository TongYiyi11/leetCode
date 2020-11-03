package BinarySearch;

public class t50 {
    public double myPow(double x, int n){
        if(n < 0) x = 1 / x;
        return power(x, Math.abs(n));
    }

    private double power(double x, int n){
        if(n == 0) return 1;
        double half = power(x, n / 2);
        return n % 2 == 0 ? half * half : half * half * x;
    }

    public static void main(String[] args){
        t50 test = new t50();
        System.out.println(test.myPow(0.00001, 2147483647));
    }
}
