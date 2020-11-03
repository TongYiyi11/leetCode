package DP;

public class t85 {
    private static class square{
        public int x;
        public int y;
        public square(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public int maximalRectangle(char[][] matrix){
        int height = matrix.length;
        int width = matrix[0].length;
        square[][] dp = new square[height + 1][width + 1];
        for(int i = 0; i <= height; i++){
            dp[i][0] = new square(0, 0);
        }
        for(int j = 1; j <= width; j++){
            dp[0][j] = new square(0, 0);
        }
        int res = 0;
        for(int i = 1; i <= height; i++){
            for(int j = 1; j <= width; j++){
                if(matrix[i - 1][j - 1] == '1'){
                    int x = Math.min(dp[i - 1][j - 1].x, Math.min(dp[i - 1][j].x, dp[i][j - 1].x));
                    int y = Math.min(dp[i - 1][j - 1].y, Math.min(dp[i - 1][j].y, dp[i][j - 1].y));
                    dp[i][j] = new square(x + 1, y + 1);
                }else{
                    dp[i][j] = new square(0, 0);
                }
                res = Math.max(res, dp[i][j].x * dp[i][j].y);
            }
        }
        return res;
    }

    public static void main(String[] args){
        t85 test = new t85();
        char[][] matrix = new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        System.out.println(test.maximalRectangle(matrix));
    }
}
