import java.util.ArrayList;
import java.util.HashMap;

public class t8 {
    /*
    public int myAtoi(String str){
        str = str.trim();   //delete space at front and end
        if(str.length() == 0){
            return 0;
        }
        boolean positive = true;
        int startIdx = 0;
        String firstStr = str.substring(startIdx, startIdx + 1);
        if(firstStr.equals("+")){
            positive = true;
            startIdx = 1;
        }
        if(firstStr.equals("-")){
            positive = false;
            startIdx = 1;
        }
        if(startIdx >= str.length()){
            return 0;
        }
        int result;
        try{
            result = Integer.parseInt(str.substring(startIdx, startIdx + 1));
        }catch(NumberFormatException ex){
            return 0;
        }

        int temp = 0;
        for(int i = startIdx + 1; i < str.length(); i++){
            try{
                temp = Integer.parseInt(str.substring(i, i + 1));
            }catch (NumberFormatException ex){
                break;
            }
            try{
                result = Math.addExact(Math.multiplyExact(result, 10), temp);
            }catch (ArithmeticException ex){
                return (positive ? Integer.MAX_VALUE : Integer.MIN_VALUE);
            }
        }

        result = positive ? result : -result;

        return result;
    }

    */

    //notice! deterministic finite automation! avoid multiple if..elseif...else
    public int myAtoi(String str){
        HashMap<String, String[]> table = new HashMap<>();
        table.put("start", new String[]{"start", "signed", "in_number", "end"});
        table.put("signed", new String[]{"end", "end", "in_number", "end"});
        table.put("in_number", new String[]{"end", "end", "in_number", "end"});
        table.put("end", new String[]{"end", "end", "end", "end"});

        String state = "start";
        int result = 0;
        boolean positive = true;

        for(char c: str.toCharArray()){
            state = table.get(state)[renewState(c)];
            if(state.equals("signed")){
                positive = c == '+' ? true : false;
            }
            if(state.equals("in_number")){
                try{
                    result = Math.addExact(Math.multiplyExact(result, 10), c - '0');
                }catch (ArithmeticException ex){
                    return (positive ? Integer.MAX_VALUE : Integer.MIN_VALUE);
                }
            }
            if(state.equals("end")) break;
        }

        result = positive ? result : -result;
        return result;
    }

    private int renewState(char c){
        if(Character.isSpaceChar(c)) return 0;
        if(c == '+' || c == '-') return 1;
        if(Character.isDigit(c)) return 2;
        return 3;
    }
}
