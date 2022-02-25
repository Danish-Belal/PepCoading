package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

/*

1. You are given a number n, representing the number of houses.
2. In the next n rows, you are given 3 space separated numbers representing the cost of painting nth house with red or blue or green color.
3. You are required to calculate and print the minimum cost of painting all houses without painting any consecutive house with same color.
Constraints
1 <= n <= 1000
0 <= n1red, n1blue, .. <= 1000


Sample Input

4
1 5 7
5 8 4
3 2 9
1 2 4
Sample Output
8
 */
public class PaintHouse {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] cost = new int[n][3];

        for (int i = 0; i < n; i++) {
           for(int j = 0 ; j<3 ; j++){
               cost[i][j] = scn.nextInt();
           }
        }
        System.out.println(minCost(cost));

    }

    private static int minCost(int[][] cost) {


        int[][] dp = new int[cost.length][3];

        for(int i = 0 ; i<cost[0].length  ; i++){
            dp[0][i] = cost[0][i];
        }


        for(int i = 1 ; i<cost.length ; i++){
                dp[i][0] = cost[i][0] + Math.min(dp[i-1][1] , dp[i-1][2]);
                dp[i][1] = cost[i][1] + Math.min(dp[i-1][0] , dp[i-1][2]);
                dp[i][2] = cost[i][2] + Math.min(dp[i-1][1] , dp[i-1][0]);

        }


        int max = Integer.MAX_VALUE;
        for(int i = 0 ; i<dp[0].length ; i++){
            max = Math.min(dp[dp.length-1][i] , max);
        }
        return max;
    }
}
