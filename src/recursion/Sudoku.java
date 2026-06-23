package recursion;

public class Sudoku {
    static void main() {
        int n=9;
        int[][] board = new int[n][n];
        solveSudoku(board,n);
    }

    private static boolean solveSudoku(int[][] board, int n) {
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == 0){
                    for(int k = 1; k<= 9;k++){
                        if(canPut(board, n, k, i, j)){
                            board[i][j] = k;
                            if(solveSudoku(board, n)){
                                return true;
                            }
                            board[i][j] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean canPut(int[][] board, int n, int val, int row, int col) {
        for(int i=0; i<9;i++){
            if(board[i][col] == val) return false;
            if(board[row][i] == val) return false;
            if(board[3*(row/3) + i/3][3*(col/3)+i%3] == val) return false;
        }
        return true;
    }
}
