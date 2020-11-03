import java.util.HashMap;
import java.util.Map;

public class t12 {
    public String intToRoman(int num){
        StringBuilder romanStr = new StringBuilder();
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        for(int i = 0; i < nums.length; i++){
            while((num - nums[i]) >= 0){
                romanStr.append(romans[i]);
                num -= nums[i];
            }
        }

        return romanStr.toString();
    }
    
    public static void main(String[] args){
        int num = 58;
        t12 test = new t12();
        System.out.println(test.intToRoman(num));
    }
}
