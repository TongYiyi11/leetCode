package DP;

import java.util.List;

public class t120 {
    public int minimumTotal(List<List<Integer>> triangle){
        int N = triangle.size();
        int[] dp = new int[N];
        dp[0] = triangle.get(0).get(0);
        for(int i = 1; i < N; i++){
            for(int j = i; j >= 0; j--){
                if(j == 0){
                    dp[j] = dp[j] + triangle.get(i).get(j);
                }else if(j == i){
                    dp[j] = dp[j - 1] + triangle.get(i).get(j);
                }else{
                    dp[j] = Math.min(dp[j], dp[j - 1]) + triangle.get(i).get(j);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for(int j = 0; j < N; j++){
            res = Math.min(res, dp[j]);
        }
        return res;
    }
}
