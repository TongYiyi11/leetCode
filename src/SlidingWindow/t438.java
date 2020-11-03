package SlidingWindow;

import java.util.LinkedList;
import java.util.List;

public class t438 {
    public List<Integer> findAnagrams(String s, String p){
        List<Integer> res = new LinkedList<>();
        if(p.length() == 0) return res;
        int[] window = new int[128];
        int[] need = new int[128];
        int required = 0;
        for(char c: p.toCharArray()){
            if(need[c] == 0) required += 1;
            need[c] += 1;
        }
        int valid = 0, left = 0, right = 0;
        while(right < s.length()){
            char curr = s.charAt(right);
            right += 1;
            if(need[curr] != 0){
                window[curr] += 1;
                if(window[curr] == need[curr]) valid += 1;
            }
            while(right - left >= p.length()){
                if(valid == required){
                    res.add(left);
                }
                char prev = s.charAt(left);
                left += 1;
                if(need[prev] != 0){
                    if(window[prev] == need[prev]) valid -= 1;
                    window[prev] -= 1;
                }
            }
        }
        return res;
    }
}
