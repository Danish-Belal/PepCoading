package DynamicProgramming;

import java.util.Scanner;

/*
1. You are given a number n, representing the count of items.
2. You are given n numbers, representing the values of n items.
3. You are given n numbers, representing the weights of n items.
3. You are given a number "cap", which is the capacity of a bag you've.
4. You are required to calculate and print the maximum value that can be created in the bag without
     overflowing it's capacity.


Note -> Each item can be taken 0 or 1 number of times. You are not allowed to put the same item
               again and again.
Constraints

1 <= n <= 20

0 <= v1, v2, .. n elements <= 50

0 < w1, w2, .. n elements <= 10

0 < cap <= 10
Format
Input

A number n
v1 v2 .. n number of elements
w1 w2 .. n number of elements
A number cap

Output
A number representing the maximum value that can be created in the bag without overflowing it's capacity
Example

Sample Input

5
15 14 10 45 30
2 5 1 3 4
7
Sample Output

75
 */
public class ZeroOneKnapSack {

    public static void main(String[] args) throws Exception {
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
       // System.out.println(knapSack01(prices , wts , cap));
        System.out.println(knapSack(prices , wts , 0 , cap));
    }

    private static int knapSack(int[] prices, int[] wts, int idx, int cap) {
        if(cap < 0) return Integer.MIN_VALUE;

        if(idx == prices.length) return 0;  // reach at last+1 so return 0.

        int f1 = knapSack(prices, wts, idx + 1, cap);  // Element doesnot want to add so remain cap same
        int f2 = prices[idx] + knapSack(prices , wts , idx+1 , cap-wts[idx]);  // Element  wants to add so remove wt from cap.

        int ans = Math.max(f1,f2);
        return ans;
    }

    static int knapSack01(int[] prices, int[] wts, int cap) {

        int[][] dp = new int[wts.length+1][cap+1];

        for(int i = 1 ; i<dp.length ; i++){
            for(int j = 1 ; j<dp[0].length ; j++){
                dp[i][j] = dp[i-1][j];
                if(j-wts[i-1] >=0){
                    dp[i][j] = Math.max(dp[i][j] , prices[i-1]+dp[i-1][j-wts[i-1]]);
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }

}
