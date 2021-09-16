package DP;
import java.util.Scanner;
import java.util.*;

/*
PepCoading.
1. You are given a number n, representing the number of stairs in a staircase.
2. You are on the 0th step and are required to climb to the top.
3. In one move, you are allowed to climb 1, 2 or 3 stairs.
4. You are required to print the number of different paths via which you can climb to the top.
Sample input.
4
Sample Output

7
 */
public class Climb_Stairs {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] dp = new int[n+1];
      int ans = climbStairs(n ,dp);
        System.out.println(ans);

        System.out.println(cs(n,dp));

    }
    public static int climbStairs(int n , int[] dp ) {

       if(n== 0){
           return 1;
       }
       if( n < 0) {
           return 0;
       }

       if(dp[n] != 0){
           return dp[n];
       }
//        int stp1 = climbStairs(n-1 );
//        int stp2 = climbStairs(n-2 );
//        int stp3 = climbStairs(n-3 );
//        dp[n] = stp1+stp2+stp3;
        dp[n] = climbStairs(n-1 ,dp )+ climbStairs(n-2 , dp)+climbStairs(n-3 , dp );
        return dp[n];

    }
    public static int cs(int n , int[] dp){
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3 ; i<= n ; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];

        }
        return dp[n];
    }
}

