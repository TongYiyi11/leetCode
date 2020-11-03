package DP;

public class t121 {
    public int maxProfit(int[] prices){
        if(prices.length < 2) return 0;
        int prev = 0;
        int min = prices[0];
        for(int i = 1; i < prices.length; i++){
            prev = Math.max(prev, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return prev;
    }
}
