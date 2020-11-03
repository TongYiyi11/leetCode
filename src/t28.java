public class t28 {
    public int strStr(String haystack, String needle){
        int len = needle.length();
        if(len == 0) return 0;

        int[][] dp = new int[len][256];  //256 corresponds with ASCII
        dp[0][needle.charAt(0)] = 1;
        int x = 0;
        for(int i = 1; i < len; i++){
            for(int j = 0; j < 256; j++){
                if(j == needle.charAt(i)){
                    dp[i][j] = i + 1;
                }else{
                    dp[i][j] = dp[x][j];
                }
            }
            x = dp[x][needle.charAt(i)];
        }

        int curr = 0;
        for(int c = 0; c < haystack.length(); c++){
            curr = dp[curr][haystack.charAt(c)];
            if(curr == len) return c - len + 1;
        }
        return -1;
    }
}
