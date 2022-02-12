package DynamicProgramming;

/*
1. You are given a number n.
2. You are required to print the nth element of fibonnaci sequence.

Note -> Notice precisely how we have defined the fibonnaci sequence
0th element -> 0
1st element -> 1
2nd element -> 1
3rd element -> 2
4th element -> 3
5th element -> 5
6th element -> 8

Constraints
0 <= n <= 45
Format
Input
A number n
Output

A number representing the nth element of fibonnaci sequence
Example

Sample Input
10

Sample Output
55

 */
public class Fibo {

    public static void main(String[] args) throws Exception {
        int n =47;
        System.out.println(fibo(n  , new int[n+1]));
        System.out.println(fiboTab(n ));
    }

    static int fibo(int n  , int[] dp){

//      if( n < 2) return n;
//
//      if(dp[n] != 0) return dp[n];
//
//      return dp[n] = fibo(n-1 , dp)+fibo(n-2 , dp);

      return (n< 2 ? n : (dp[n] !=0) ? dp[n] : (dp[n] = fibo(n-1 , dp)+fibo(n-2 , dp)));

    }

    public static int fiboTab(int  n){

        int[] dp = new int[n+1];

        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2 ; i<=n ; i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

}
