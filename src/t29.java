public class t29 {
    public int divide(int dividend, int divisor){
        boolean sign = (dividend ^ divisor) < 0;  //用异或来计算是否符号相异
        int result = 0;
        //正数边界难处理，改为负数
        if(dividend > 0) {
            dividend = -dividend;
        }
        if(divisor > 0) divisor = -divisor;
        while(dividend <= divisor) {
            int temp_result = -1;
            int temp_divisor = divisor;
            while(dividend <= (temp_divisor << 1)) {
                if(temp_divisor <= (Integer.MIN_VALUE >> 1)) break;
                temp_result = temp_result << 1;
                temp_divisor = temp_divisor << 1;
            }
            dividend = dividend - temp_divisor;
            result += temp_result;
        }
        if(!sign) {
            if(result == Integer.MIN_VALUE) return Integer.MAX_VALUE;
            result = - result;
        }
        return result;
    }

    public static void main(String[] args){
        t29 test = new t29();
        System.out.println(test.divide(-1523294044, 1314591570));
    }
}
