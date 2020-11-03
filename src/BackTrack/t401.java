package BackTrack;

import java.util.ArrayList;
import java.util.List;

public class t401 {
    List<String> res = new ArrayList<>();
    public List<String> readBinaryWatch(int num){
        int[] choices = new int[]{1, 2, 4, 8, 1, 2,
                4, 8, 16, 32};
        if(num > choices.length) return res;
        backtrack(num, choices, 0, 0, 0);
        return res;
    }

    private void backtrack(int num, int[] choices, int hour, int minute, int start){
        //notice! StringBuilder is much faster than direct concatenation of String!
        if(num == 0){
            if(hour > 11 || minute > 59){
                return;
            }
            StringBuilder time = new StringBuilder();
            time.append(hour);
            time.append(":");
            if(minute < 10) {
                time.append("0");
            }
            time.append(minute);
            res.add(time.toString());
            return;
        }

        for(int i = start; i < choices.length; i++){
            if(i < 4){
                hour += choices[i];
            }else{
                minute += choices[i];
            }
            backtrack(num - 1, choices, hour, minute, i + 1);
            if(i < 4){
                hour -= choices[i];
            }else{
                minute -= choices[i];
            }
        }
    }

    public static void main(String[] args){
        t401 test = new t401();
        int time = 11 * 60 + 59;
    }

}
