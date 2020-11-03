import java.util.HashMap;

public class t13 {
    public int romanToInt(String s){
//        HashMap<Character, Integer> table = new HashMap<>();
//        table.put('I', 1);
//        table.put('V', 5);
//        table.put('X', 10);
//        table.put('L', 50);
//        table.put('C', 100);
//        table.put('D', 500);
//        table.put('M', 1000);
        int curr;
        int prev = 4000;
        int result = 0;
        for(char c: s.toCharArray()){
            curr = getValue(c);
            if(curr > prev){
                result = result + curr - 2 * prev;
            }else{
                result += curr;
            }
            prev = curr;
        }
        return result;
    }

    //note! quicker than HashMap!
    private int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
