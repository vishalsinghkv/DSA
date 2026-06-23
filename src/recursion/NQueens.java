package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    static void main() {
        int n=4;
        char[][] arr = new char[n][n];
        for (char[] row : arr) {
            Arrays.fill(row, '.');
        }
        List<char[][]> ans = new ArrayList<>();
        findWaysToPlaceQueen(arr,n, 0, ans);
        ans.forEach(array->{
            for(int i=0; i<n;i++){
                for(int j=0;j<n;j++){
                    System.out.print(array[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println("==================");
        });
    }

    private static void findWaysToPlaceQueen(char[][] arr, int n, int col, List<char[][]> ans) {
        if(col == n){
            // deep copy of board
            char[][] copy = new char[n][n];
            for (int i = 0; i < arr.length; i++) {
                System.arraycopy(arr[i], 0, copy[i], 0, n);
            }
            ans.add(copy);
            return;
        }
        for(int i=0;i<n;i++){
            if(canPlace(arr, n, i, col)){
                arr[i][col] = 'Q';
                findWaysToPlaceQueen(arr, n, col+1, ans);
                arr[i][col] = '.';
            }
        }
    }

    private static boolean canPlace(char[][] arr, int n, int row, int col) {
        int i=0;
        while(i<col){
            if(arr[row][i] == 'Q') return false;
            i++;
        }
        int dupRow = row;
        int dupCol = col;
        while(dupRow >=0 && dupCol>=0){
            if(arr[dupRow][dupCol] == 'Q') return false;
            dupRow--;
            dupCol--;
        }
         dupRow = row;
         dupCol = col;
        while(dupRow <n && dupCol>=0){
            if(arr[dupRow][dupCol] == 'Q') return false;
            dupRow++;
            dupCol--;
        }
        return true;
    }
}
