package DP;

public class t392 {
    public boolean isSubsequence(String s, String t){
        boolean[][] dp = new boolean[t.length() + 1][s.length() + 1];
        int i = 0, j = 0;
        for(i = 0; i < t.length() + 1; i++){
            dp[i][0] = true;
        }
        for(j = 1; j < s.length() + 1; j++){
            dp[0][j] = false;
        }
        for(i = 1; i < t.length() + 1; i++){
            for(j = 1; j < s.length() + 1; j++){
                dp[i][j] = dp[i - 1][j] || (dp[i - 1][j - 1] && s.charAt(j - 1) == t.charAt(i - 1));
            }
        }
        return dp[t.length()][s.length()];
    }
}
