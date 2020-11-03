package DP;

public class t304 {
    public static int[][] mat;
    public t304(int[][] matrix){
        if(matrix.length == 0 || matrix[0].length == 0) return;
        int rowN = matrix.length;
        int colN = matrix[0].length;
        mat = new int[rowN + 1][colN + 1];
        for(int i = 0; i < rowN; i++){
            for(int j = 0; j < colN; j++){
                mat[i + 1][j + 1] = matrix[i][j] + mat[i + 1][j] + mat[i][j + 1] - mat[i][j];
            }
        }
    }
    public int sumRegion(int row1, int col1, int row2, int col2){
        return mat[row2 + 1][col2 + 1] - mat[row1][col2 + 1] - mat[row2 + 1][col1] + mat[row1][col1];
    }
}
