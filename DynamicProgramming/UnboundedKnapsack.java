package DynamicProgramming;

import java.util.Scanner;

/*
1. You are given a number n, representing the count of items.

2. You are given n numbers, representing the values of n items.

3. You are given n numbers, representing the weights of n items.

3. You are given a number "cap", which is the capacity of a bag you've.

4. You are required to calculate and print the maximum value that can be created in the bag without

    overflowing it's capacity.

Note -> Each item can be taken any number of times. You are allowed to put the same item again

                  and again.
Constraints

1 <= n <= 20

0 <= v1, v2, .. n elements <= 50

0 < w1, w2, .. n elements <= 10

0 < cap <= 10
Example

Sample Input

5
15 14 10 45 30
2 5 1 3 4
7
Sample Output

100
 */
public class UnboundedKnapsack {

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] prices = new int[n];
        for(int i = 0 ; i<n ; i++){
            prices[i] = scn.nextInt();
        }
        int[] wts = new int[n];
        for(int i = 0 ; i<n ; i++){
            wts[i] = scn.nextInt();
        }

        int cap = scn.nextInt();
      //  System.out.println(unKnp(prices , wts , cap));
        System.out.println(unKnap(prices , wts  ,0, cap));

    }

    public static int unKnp(int[] prices , int[] wts , int cap){
        int[] dp = new int[cap+1];

        for(int i =0 ; i<prices.length ; i++){
           int ip = prices[i];
           int iw = wts[i];
           for(int j = iw ; j<dp.length ; j++){
               dp[j] = Math.max(dp[j] , ip+dp[j-iw]);
           }
        }
        return dp[cap];
    }

    public static int unKnap(int[] prices , int[] wts , int idx , int cap){
        if(cap < 0) return Integer.MIN_VALUE;
        if( idx == prices.length) return 0;



        int f1 =  unKnap(prices , wts , idx+1 , cap);
        int f2 = prices[idx] +unKnap(prices , wts , idx , cap-wts[idx]);
        return Math.max(f1,f2);
    }



}
