import java.util.ArrayList;
import java.util.HashMap;

public class t6 {
    public String convert(String s, int numRows){
        if(numRows == 1 || s.length() <= numRows){
            return s;
        }
        ArrayList<StringBuilder> convertStr = new ArrayList<>();
        //notice ! can use StringBuilder to store items at every row rather than ArrayList
        for(int n = 0; n < numRows; n++){
            convertStr.add(new StringBuilder());
        }
        int row = 0;
        boolean upDir = false;
        for(char c: s.toCharArray()){
            convertStr.get(row).append(c);
            if(row == 0 || row == numRows - 1){
                upDir = !upDir;    //notice! convert the direction
            }
            row = upDir ? row + 1 : row - 1;
        }

        StringBuilder result = new StringBuilder();
        for(StringBuilder str: convertStr){
            result.append(str);
        }
        return result.toString();
    }

    public static void main(String[] args){
        String s = "LEETCODEISHIRING";
        t6 test = new t6();
        System.out.println(test.convert(s, 4));
    }
}
