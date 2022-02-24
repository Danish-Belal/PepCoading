package DynamicProgramming;

import java.util.Scanner;

/*

1. You are given a number n, representing the count of coins.
2. You are given n numbers, representing the denominations of n coins.
3. You are given a number "amt".
4. You are required to calculate and print the number of permutations of the n coins using which the
     amount "amt" can be paid.



Note1 -> You have an infinite supply of each coin denomination i.e. same coin denomination can be
                  used for many installments in payment of "amt"

Note2 -> You are required to find the count of permutations and not combinations i.e.
                  2 + 2 + 3 = 7 and 2 + 3 + 2 = 7 and 3 + 2 + 2 = 7 are different permutations of same
                  combination. You should treat them as 3 and not 1.
Constraints
1 <= n <= 20
0 <= n1, n2, .. n elements <= 20
0 <= amt <= 30

Example

Sample Input

4
2
3
5
6
7
Sample Output
5
 */
public class CoinChangePermutations {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] coin = new int[n];
        for(int i = 0 ; i<n ; i++){
            coin[i] = scn.nextInt();
        }
        int amount = scn.nextInt();
      //  System.out.println(ccP(coin , amount));
        System.out.println(ccpR(coin , amount ,new Integer [amount+1]));
        System.out.println((v));

    }

    static int v = 0;   // as simple recursion it is running 40 times, using dp its running 24 time. v is used tp check value.
    static int ccpR(int[] coin , int t , Integer[] dp){

        if(t == 0) return 1;
        if(t <0 ) return 0;

        if(dp[t] != null) return dp[t];
        int sum = 0 ;
        for(int i = 0 ; i<coin.length ; i++){
            sum += ccpR(coin , t-coin[i] , dp);
            v++;
        }
        return dp[t] = sum;
    }

    public static int ccP(int[] arr, int t){
        int[] dp = new int[t+1];

        dp[0] = 1;

        for(int i =1 ; i<dp.length ; i++){
            for(int j = 0 ; j<arr.length ; j++){
                int val = arr[j];
                if(i-val >=0)
                    dp[i] += dp[i-val];
            }
        }
        return dp[t];

    }


}
