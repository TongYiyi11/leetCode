public class t7 {
    public int reverse(int x){
        int xRev = 0;
        while(Math.abs(x) >= 1){
            int re = x % 10;
            try{
                int temp = Math.multiplyExact(10, xRev);
                xRev = Math.addExact(temp, re);
            }catch (ArithmeticException ex){
                return 0;
            }
            x = x / 10;
        }
        return xRev;
    }

    public static void main(String[] args){
        t7 test = new t7();
        System.out.println(test.reverse(-123));
    }
}
