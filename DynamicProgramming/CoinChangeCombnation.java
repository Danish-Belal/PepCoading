package DynamicProgramming;

/*

1. You are given a number n, representing the count of coins.
2. You are given n numbers, representing the denominations of n coins.
3. You are given a number "amt".
4. You are required to calculate and print the number of combinations of the n coins using which the
        amount "amt" can be paid.

Note1 -> You have an infinite supply of each coin denomination i.e. same coin denomination can be
                  used for many installments in payment of "amt"
Note2 -> You are required to find the count of combinations and not permutations i.e.
                  2 + 2 + 3 = 7 and 2 + 3 + 2 = 7 and 3 + 2 + 2 = 7 are different permutations of same
                  combination. You should treat them as 1 and not 3.

Constraints
1 <= n <= 30
0 <= n1, n2, .. n elements <= 20
0 <= amt <= 50

Example

Sample Input

4
2
3
5
6
7
Sample Output

2
 */

import java.util.Scanner;

public class CoinChangeCombnation {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] coin = new int[n];
        for(int i = 0 ; i<n ; i++){
            coin[i] = scn.nextInt();
        }
        int amount = scn.nextInt();




        int count =coinchangeR(coin ,0, amount );
        System.out.println(count);

      //  System.out.println(coinchangetab(coin , amount));


    }

    private static int coinchangeR(int[] coin,int idx, int t) {

        if(t == 0) return 1;
        if(t < 0 || idx == coin.length) return 0;

       int f1 = coinchangeR(coin , idx+1 , t);
       int f2 = coinchangeR(coin , idx , t-coin[idx]);
       return f1+f2;
    }



    public static int coinchangetab(int[] arr, int t){
        int[] dp = new int[t+1];

        dp[0] = 1;

        for(int i =0 ; i<arr.length ; i++){
             int val = arr[i];
             for(int j = val ; j<dp.length ; j++){
                 dp[j] += dp[j-val];
             }

        }
        return dp[t];

    }

}
