package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

/*
1. You are given a number n, representing the number of rows.
2. You are given a number m, representing the number of columns.
3. You are given n*m numbers, representing elements of 2d array a, which represents a gold mine.
4. You are standing in front of left wall and are supposed to dig to the right wall. You can start from
     any row in the left wall.
5. You are allowed to move 1 cell right-up (d1), 1 cell right (d2) or 1 cell right-down(d3).
6. Each cell has a value that is the amount of gold available in the cell.
7. You are required to identify the maximum amount of gold that can be dug out from the mine.
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
33
 */
public class GoldMIne {

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        int[][] maze = new int[n][m];
        for(int i = 0 ; i<n ; i++){
            for(int j= 0 ; j <m ; j++){
                maze[i][j] = scn.nextInt();
            }
        }

        // Recursive Approach
        int[][] dp = new int[n][m];
        int max =0;
        for(int i =0 ; i<n;i++) {
            max = Math.max(max , (maxgold(maze, i, 0, n, m , dp)));
        }
        System.out.println(max);

        // Tabulation.
        System.out.println(maxGold(maze));


    }

    static int maxgold(int[][] maze , int sr ,int sc , int dr , int dc , int[][] dp){

        if(sr >= dr || sc >= dc || sr < 0 || sc < 0){
            return 0;
        }
        if(sc == dc-1){
            return maze[sr][sc];
        }

        if(dp[sr][sc] != 0) return dp[sr][sc];

        int s1 = maxgold(maze , sr-1 , sc+1 , dr , dc , dp );
        int s2 = maxgold(maze , sr , sc+1 , dr , dc ,dp);
        int s3 = maxgold(maze , sr+1 , sc+1 , dr , dc , dp );

        return dp[sr][sc] =  Math.max(s2 , Math.max(s1,s3)) + maze[sr][sc];

    }

    static int maxGold(int[][] maze){


        int n = maze.length;
        int m = maze[0].length;
        int[][] dp = new int[n][m];

        for(int j = m-1 ; j>=0 ;  j--){
            for(int i = 0 ; i<n ; i++){

                if( j == m-1){
                    dp[i][j] = maze[i][j];
                }
                else if(i == 0  ){
                    dp[i][j] = Math.max(dp[i][j+1] , dp[i+1][j+1])+maze[i][j];
                }
                else if(i == n-1){
                    dp[i][j] = Math.max(dp[i][j+1] , dp[i-1][j+1])+maze[i][j];
                }else{
                    dp[i][j] = Math.max(dp[i][j+1] , Math.max(dp[i+1][j+1] , dp[i-1][j+1]))+maze[i][j];
                }
            }
        }

       int max = Integer.MIN_VALUE;

        for(int i = 0 ; i <n ; i++){
            if(dp[i][0] > max) max = dp[i][0];
        }
        return max;


    }

}
