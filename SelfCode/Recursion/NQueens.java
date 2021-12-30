package SelfCode.Recursion;

import java.util.Scanner;

/*
1. You are given a number n, the size of a chess board.
2. You are required to place n number of queens in the n * n cells of
 board such that no queen can kill another.
Note - Queens kill at distance in all 8 directions
3. Complete the body of printNQueens function -
    without changing signature - to calculate and print all safe configurations of n-queens.
    Use sample input and output to get more idea.

    Constraints
1 <= n <= 10

Sample Input
4

Sample Output
0-1, 1-3, 2-0, 3-2, .
0-2, 1-0, 2-3, 3-1, .

 */
public class NQueens {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        boolean[][] chess= new boolean[n][n];
        printNQueens(chess , "" , 0);

    }

    private static boolean isQueenSafe(boolean[][] chess , int row , int col){
        // for up;
        for(int i = row-1 ; i>=0 ; i--){
            if(chess[i][col]) return false;
        }

        // for left diagnole.
        for(int i = row-1 , j = col-1 ; i>=0 && j>=0 ; i-- , j--){
            if(chess[i][j]) return false;
        }

        // for right Diagnol
        for(int i = row-1  , j = col+1 ; i >=0 && j <chess.length ; i--,j++){
            if(chess[i][j]) return false;
        }

        // The Queen is Safe.
        return true;

    }

    public static void printNQueens(boolean[][] chess, String qsf, int row) {

        if(row == chess.length){
            System.out.println(qsf+".");
            return;
        }

        for(int col = 0 ; col< chess.length ; col++) {
            if (isQueenSafe(chess, row, col)) {
                // Place the Queen
                chess[row][col] = true;

                // Make Recursive call.
                printNQueens(chess, qsf + row + "-" + col + ",", row + 1);

                // Unplace the Queen.
                chess[row][col] = false;
            }
        }

    }
}
