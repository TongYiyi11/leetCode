package DP;

public class t309 {
    public int maxProfit(int[] prices){
        if(prices.length == 0) return 0;
        int dp0 = 0, dp1 = -prices[0];
        int pre_2 = 0;
        for(int i = 2; i < prices.length + 1; i++){
            int temp = dp0;
            dp0 = Math.max(dp1 + prices[i - 1], dp0);
            dp1 = Math.max(pre_2 - prices[i - 1], dp1);
            pre_2 = temp;
        }
        return dp0;
    }
}
