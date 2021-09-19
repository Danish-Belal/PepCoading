package DP;

import java.util.Scanner;

/*
1. You are given a number n, representing the number of rows.
2. You are given a number m, representing the number of columns.
3. You are given n*m numbers, representing elements of 2d array a, which represents a maze.
4. You are standing in top-left cell and are required to move to bottom-right cell.
5. You are allowed to move 1 cell right (h move) or 1 cell down (v move) in 1 motion.
6. Each cell has a value that will have to be paid to enter that cell (even for the top-left and bottom-
     right cell).
7. You are required to traverse through the matrix and print the cost of path which is least costly.
Sample Input

6
6
0 1 4 2 8 2
4 3 6 5 0 4
1 2 4 1 4 6
2 0 7 3 2 2
3 1 5 9 2 4
2 7 0 8 5 1

Sample Output

23


 */
public class MinCostInMazeraversal {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner in  = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int[][] arr = new int[n][m];
        for (int i = 0; i <n; i++) {
            for (int j = 0; j <m; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        // We will use memorization where variable will vary , her3e source row and source column will vary.
        int[][] dp = new int[n][m];
        System.out.println(MinCost(arr , 0 , 0 , dp));
    }

    public static int MinCost(int[][] arr, int sr, int sc , int[][] dp) {
        if(sr >= arr.length || sc >=arr[0].length)  {
            return Integer.MAX_VALUE;
        }

        if(sr == arr.length-1 && sc == arr[0].length-1){
            return arr[sr][sc];
        }
        if(dp[sr][sc] != 0){
            return  dp[sr][sc];
        }
        int f1 = MinCost(arr , sr,sc+1 , dp);        // For Horizontal
        int f2 = MinCost(arr , sr+1 , sc  , dp );   // For Vertical.

        int ans = Math.min(f1,f2) + arr[sr][sc] ;
        dp[sr][sc] = ans;
        return ans ;


    }
}
