package DP;

public class t746 {
    public int minCostClimbingStairs(int[] cost){
        int c1 = cost[0];
        int c2 = cost[1];
        for(int i = 2; i < cost.length; i++){
            int temp = Math.min(c1, c2) + cost[i];
            c1 = c2;
            c2 = temp;
        }
        return Math.min(c1, c2);
    }
}
