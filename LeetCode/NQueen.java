package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class NQueen {
    public static void main(String[] str){
        int n = 4;

        /*
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i = 0 ; i<n ; i++){
            for(int j = 0 ; j<n ; j++){
                board[i][j] = '.';

            }
        }
        Queens(0 , board , ans);
        System.out.println(ans);

         */

        // Optmize Soltuon.
        System.out.println(solveNQueens( n));
    }

    // Recursive solution
    /*
    private static void Queens(int col , char[][] board , List<List<String>> ans) {
        if(col == board.length){
            ans.add(construct(board));
            return;
        }
        for(int row = 0 ; row<board.length ; row++){
            if(isQueenSafe(row ,col , board )){
                board[row][col] = 'Q';
                Queens(col+1 , board , ans);
                board[row][col] = '.';
            }
        }
    }

    private static List<String> construct(char[][] board) {
        List<String> res = new LinkedList<String>();
        for(int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }

    private static boolean isQueenSafe(int row, int col, char[][] board) {

        int nr = row;
        int nc = col;

        // for right upper.
        while(nr >= 0 && nc >=0){
            if(board[nr][nc] == 'Q') return false;
            nr--;
            nc--;
        }

        nc = col;
        while(nc >=0){
            if(board[row][nc] == 'Q') return false;
            nc--;
        }

        nr = row;
        nc = col;
        while(nr < board.length && nc >=0){
            if(board[nr][nc] == 'Q') return false;
            nr++;
            nc--;
        }

        return true;
    }

   */



    public static List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                board[i][j] = '.';
        List<List<String>> res = new ArrayList<List<String>>();
        int[] leftRow = new int[n];
        int[] upperDiagonal = new int[2*n-1];
        int[] lowerDiagonal = new int[2*n-1];
        solve(0, board, res, leftRow, lowerDiagonal, upperDiagonal);
        return res;
    }



    private static void solve(int col, char[][] board, List<List<String>> res, int[] leftRow, int[] lowerDiagonal, int[] upperDiagonal) {
        if(col == board.length) {
            res.add(construct(board));
            return;
        }

        for(int row = 0; row < board.length; row++) {
            if(leftRow[row] == 0 && lowerDiagonal[row+col] == 0 && upperDiagonal[board.length -1 + col - row] == 0) {
                board[row][col] = 'Q';
                leftRow[row] = 1;
                lowerDiagonal[row+col] = 1;
                upperDiagonal[board.length-1 + col - row] = 1;
                solve(col+1, board, res, leftRow, lowerDiagonal, upperDiagonal );
                board[row][col] = '.';
                leftRow[row] = 0;
                lowerDiagonal[row+col] = 0;
                upperDiagonal[board.length - 1 + col - row] = 0;
            }
        }
    }


    private static List<String> construct(char[][] board) {
        List<String> res = new LinkedList<String>();
        for(int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
}
