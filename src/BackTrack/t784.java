package BackTrack;

import java.util.ArrayList;
import java.util.List;

public class t784 {
    List<String> ans = new ArrayList<>();
    public List<String> letterCasePermutation(String S){
        if(S.length() == 0) return ans;
        StringBuilder res = new StringBuilder();
        backtrack(res, S, 0);
        return ans;
    }
    private void backtrack(StringBuilder res, String S, int start){
        if(res.length() == S.length()){
            ans.add(res.toString());
            return;
        }
        char ch = S.charAt(start);
        if(Character.isLetter(ch)){
            backtrack(res.append((char)(ch ^ (1 << 5))), S, start + 1);
            res.delete(start, res.length());
        }
        backtrack(res.append(ch), S, start + 1);
    }

    public static void main(String[] args){
        t784 test = new t784();
        List<String> ans = test.letterCasePermutation("a1b2");
    }

}
