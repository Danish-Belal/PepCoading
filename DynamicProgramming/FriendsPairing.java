package DynamicProgramming;

import java.util.Scanner;

/*
1. You are given a number n, representing the number of friends.
2. Each friend can stay single or pair up with any of it's friends.
3. You are required to print the number of ways in which these friends can stay single or pair up.
E.g.

1 person can stay single or pair up in 1 way.
2 people can stay singles or pair up in 2 ways. 12 => 1-2, 12.

3 people (123) can stay singles or pair up in 4 ways. 123 => 1-2-3, 12-3, 13-2, 23-1.
Sample Input

4
Sample Output

10
 */
public class FriendsPairing {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(pair(n));
        System.out.println(pairR(n));
    }
    static int pairR(int n){

        if(n == 1) return 1;
        if(n == 2) return 2;

        int f1 = pairR(n-1);
        int f2 = (n-1) * pairR(n-2);
        return f1+f2;
    }
    static int pair(int n){

        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3 ; i<=n ; i++){
            dp[i] = dp[i-1] + ((i-1)*dp[i-2]);
        }
        return dp[n];

    }
}
