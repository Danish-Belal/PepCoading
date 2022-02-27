package DynamicProgramming;

import java.util.Scanner;

public class SudokoSolver {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n  = 9;
        char[][] board = new char[n][n];
        for(int i = 0 ; i<n ; i++){
            for(int j = 0 ; j< n ; j++){
                board[i][j] = scn.next().charAt(0);
            }
        }

        solveSudoku(board);


        for(char[] c : board){
            for(char a : c){
                System.out.print(a+" ");
            }
            System.out.println();
        }
    }

//    private static boolean solve(char[][] board) {
//
//        for(int i =0 ; i<board.length ; i++){
//            for(int j = 0 ; j<board[0].length ; j++){
//
//                if(board[i][j] == '.'){
//                    for(char ch = '1' ; ch <='9' ; ch++){ //trial. Try 1 through 9
//                        if(isSafe(board , i , j , ch)){
//                            board[i][j] = ch;   //Put c for this cell
//
//                            if(solve(board)){
//                                return true;   //If it's the solution return true
//                            }else{
//                                board[i][j] = '.';    //Otherwise go back
//                            }
//                        }
//                        return false;
//
//                    }
//                }
//
//            }
//        }
//        return true;
//    }
//
//    private static boolean isSafe(char[][] board, int row, int col, char c) {
//        for(int i = 0; i < 9; i++) {
//            if(board[i][col] != '.' && board[i][col] == c) return false; //check row
//            if(board[row][i] != '.' && board[row][i] == c) return false; //check column
//            if(board[3 * (row / 3) + i / 3][ 3 * (col / 3) + i % 3] != '.' &&
//                    board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false; //check 3*3 block
//        }
//        return true;
//    }

    public static void solveSudoku(char[][] board) {
        if(board == null || board.length == 0)
            return;
        solve(board);
    }

    public static boolean solve(char[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '.'){
                    for(char c = '1'; c <= '9'; c++){//trial. Try 1 through 9
                        if(isValid(board, i, j, c)){
                            board[i][j] = c; //Put c for this cell

                            if(solve(board))
                                return true; //If it's the solution return true
                            else
                                board[i][j] = '.'; //Otherwise go back
                        }
                    }

                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValid(char[][] board, int row, int col, char c){
        for(int i = 0; i < 9; i++) {
            if(board[i][col] != '.' && board[i][col] == c) return false; //check row
            if(board[row][i] != '.' && board[row][i] == c) return false; //check column
            if(board[3 * (row / 3) + i / 3][ 3 * (col / 3) + i % 3] != '.' &&
                    board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false; //check 3*3 block
        }
        return true;
    }
}
