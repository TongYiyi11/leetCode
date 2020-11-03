package BackTrack;

public class t52 {
    private int count = 0;
    public int totalNQueens(int n){
        boolean[][] board = new boolean[n][n];
        backtrack(board, 0);
        return count;
    }
    private void backtrack(boolean[][] board, int row){
        if(row == board.length){
            count++;
            return;
        }
        for(int j = 0; j < board[row].length; j++) {
            if (!isValid(board, row, j)) continue;
            board[row][j] = true;
            backtrack(board, row + 1);
            board[row][j] = false;
        }
    }
    private boolean isValid(boolean[][] board, int row, int col){
        for(int i = 0; i < row; i++){
            if(board[i][col]) return false;
            if((col - (row - i) >= 0) && board[i][col - (row - i)]) return false;
            if((col + (row - i) < board[row].length) && board[i][col + (row - i)]) return false;
        }
        return true;
    }
    public static void main(String[] args){
        t52 test = new t52();
        System.out.println(test.totalNQueens(4));
    }
}
