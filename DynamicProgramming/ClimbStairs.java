package DynamicProgramming;
/*

1. You are given a number n, representing the number of stairs in a staircase.
2. You are on the 0th step and are required to climb to the top.
3. In one move, you are allowed to climb 1, 2 or 3 stairs.
4. You are required to print the number of different paths via which you can climb to the top.
Constraints

0 <= n <= 20
Format
Input

A number n

Output

A number representing the number of ways to climb the stairs from 0 to top.
Example

Sample Input
4
Sample Output
7
 */
public class ClimbStairs {
    public static void main(String[] args) throws Exception {
        int n = 4;
//        System.out.println(stairs(n , new int[n+1]));
//        System.out.println(stairs(n ));
        System.out.println(stairsTab(n));

    }

    public static int stairs(int n){

        if(n == 0) return 1;
        if(n < 0) return 0;

        return stairs(n-1)+stairs(n-2)+stairs(n-3);
    }
    public static int stairs(int n , int[] dp){

        if(n == 0) return 1;
        if(n < 0) return 0;

        if(dp[n] !=0) return dp[n];

        return dp[n] =  stairs(n-1 , dp)+stairs(n-2 , dp)+stairs(n-3 , dp);

    }

    static int stairsTab(int n){

        int[] dp = new int[n+1];

        dp[0] = 1;
        for(int i =1 ; i<=n ; i++){
            dp[i] += dp[i-1];
            if (i-2 >=0) dp[i] += dp[i-2];
            if (i-3 >=0) dp[i] += dp[i-3];
        }
        return dp[n];
    }
}
