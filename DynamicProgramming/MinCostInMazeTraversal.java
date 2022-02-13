package DynamicProgramming;

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

Constraints
1 <= n <= 10^2
1 <= m <= 10^2
0 <= e1, e2, .. n * m elements <= 1000

Example

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
public class MinCostInMazeTraversal {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        int[][] maze = new int[n][m];
        for(int i = 0 ; i<n ; i++){
            for(int j= 0 ; j <m ; j++){
                maze[i][j] = scn.nextInt();
            }
        }

       // System.out.println(minCost(maze,0 , 0));

        // Memorization.
        int[][] dp = new int[n][m];
        System.out.println(minCost(maze,0 , 0 , dp));
        System.out.println(minCostTab(maze, dp));

    }



    public static int minCost(int[][] maze , int row , int col){

        if(row >= maze.length || col >=  maze[0].length) return Integer.MAX_VALUE;
        if(row == maze.length-1 && col == maze[0].length-1) return maze[row][col];

        int c1 = minCost(maze , row , col+1);
        int r1 = minCost(maze , row+1 , col);

        int cost = Math.min(c1 , r1) + maze[row][col];
        return cost;

    }

    // Memorization.
    public static int minCost(int[][] maze , int row , int col , int[][] dp){

        if(row >= maze.length || col >=  maze[0].length) return Integer.MAX_VALUE;
        if(row == maze.length-1 && col == maze[0].length-1) return maze[row][col];

        if(dp[row][col] != 0) return dp[row][col];

        int c1 = minCost(maze , row , col+1 , dp);
        int r1 = minCost(maze , row+1 , col , dp);

        int cost = Math.min(c1 , r1) + maze[row][col];
        dp[row][col] = cost;
        return cost;
    }

    public static int minCostTab(int[][] maze , int[][] dp){

        int m = maze.length ;
        int n = maze[0].length ;
        dp[m-1][n-1] = maze[m-1][n-1];

        for(int i = m-1 ; i >=0 ; i--){
           for( int j = n-1 ; j >=0 ; j--){

               if(i == m-1 && j == n-1)
                   dp[i][j] = maze[m-1][n-1];

               else if(i == m-1)
                   dp[i][j] = dp[i][j+1] + maze[i][j] ;


               else if( j == n-1)
                   dp[i][j] = dp[i+1][j] +maze[i][j] ;


               else{
                   int min = Math.min(dp[i+1][j] , dp[i][j+1]);
                   dp[i][j] = maze[i][j] + min;
               }
            }
        }

        return dp[0][0];
    }

}
