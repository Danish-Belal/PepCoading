package DynamicProgramming;

import java.util.Scanner;
/*
1. You are given a number n, representing the number of elements.
2. You are given a number k, representing the number of subsets.
3. You are required to print the number of ways in which these elements can be partitioned in k non-empty subsets.

E.g.
For n = 4 and k = 3 total ways is 6
12-3-4
1-23-4
13-2-4
14-2-3
1-24-3
1-2-34

 */
public class PartitionSubSet {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        // Tabulation.
        System.out.println(pair(n , k));


        System.out.println(pairR(n , k));
    }

    private static int pair(int n, int k) {

        int[][] dp = new int[n+1][k+1];
        dp[0][0] = 1;

        for(int i = 1 ; i<dp.length ; i++){
            for(int j = 1 ; j<= i  && j <=k ; j++){
                if(i == j) dp[i][j] = 1;
                else
                    dp[i][j] = dp[i-1][j-1] + j*dp[i-1][j];
            }
        }
        return dp[n][k];

    }

    private static int pairR(int n , int k) {

        if(n ==0) return 0;
        if(k == n) {
            return 1;
        }

        if(k > n) {
            return 0;
        }

        int f1 =  pairR(n-1 , k-1);
        int f2 = (k)* pairR(n-1 , k);
        return (f1+f2);
    }
}
