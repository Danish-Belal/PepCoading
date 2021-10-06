package DP;

import java.util.Arrays;
import java.util.Scanner;

/*
1. You are given a number n, representing the number of rows.
2. You are given a number m, representing the number of columns.
3. You are given n*m numbers, representing elements of 2d array a, which represents a gold mine.
4. You are standing in front of left wall and are supposed to dig to the right wall. You can start from
     any row in the left wall.
5. You are allowed to move 1 cell right-up (d1), 1 cell right (d2) or 1 cell right-down(d3).
Constraints

1 <= n <= 10^2
1 <= m <= 10^2
0 <= e1, e2, .. n * m elements <= 1000

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
public class GoldMine {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int[][] arr = new int[n][m];
        for (int i = 0; i <n; i++) {
            for (int j = 0; j <m; j++) {
                arr[i][j] = in.nextInt();
            }
        }
//       int ans =  maxGlod(arr);
//        System.out.println(ans);

        // For recursive approach.
        int max = 0;
        int[][] dp = new int[n][m];
        for (int i = 0 ; i< arr.length ; i++){
             max = Math.max(max , goldmine(arr , i , 0 , dp));
        }
        System.out.println(max);
    }

    public static int maxGlod(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int[][] dp = new int[n][m];

        for(int j = m-1 ; j>=0 ; j--){
         for(int i = 0; i < n ; i++){
             if(j == m-1){
                 dp[i][j] = arr[i][j];
             }
              else if(i==0){
                 dp[i][j] = arr[i][j] +  Math.max(dp[i][j+1], dp[i+1][j+1]);
             }
              else if(i==n-1){

                 dp[i][j] = arr[i][j] +  Math.max(dp[i][j+1] , dp[i-1][j+1]);
             }else{
                 dp[i][j] = arr[i][j] +  Math.max(dp[i-1][j+1] , Math.max(dp[i][j+1]  , dp[i+1][j+1]));
             }
         }
     }



      int ans = 0;
        for(int i = 0 ; i<n ; i++){
            ans = Math.max( ans , dp[i][0]);
        }
      return ans;

    }

    public static int goldmine(int[][] arr ,int sr , int sc , int[][] dp){

        if(sr <0 || sr >=arr.length) return Integer.MIN_VALUE;
        if(sc== arr[0].length-1) return arr[sr][sc];

        if(dp[sr][sc] !=0){
            return dp[sr][sc];
        }

        int f1  = goldmine(arr , sr-1 , sc+1 , dp);
        int f2 = goldmine(arr ,sr , sc+1 , dp );
        int f3 = goldmine(arr , sr+1 , sc+1 , dp );

        int ans = Math.max(f1 , Math.max(f2,f3))+arr[sr][sc];
        return ans;
    }
}
