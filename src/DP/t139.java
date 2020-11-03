package DP;

import java.util.List;

public class t139 {
     public boolean wordBreak(String s, List<String> wordDict){
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1; i < s.length() + 1; i++){
            for(int j = 0; j < wordDict.size(); j++){
                String word = wordDict.get(j);
                if(i - word.length() < 0) continue;
                String subStr = s.substring(i - word.length(), i);
                dp[i] = subStr.equals(word) && dp[i - word.length()];
                if(dp[i]) break;
            }
        }
        return dp[s.length()];
    }
}
