package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

/*
1. You are given a number n, representing the number of days.
2. You are given n numbers, where ith number represents price of stock on ith day.
3. You are required to print the maximum profit you can make if you are allowed a single transaction.
Sample Input
9
11
6
7
19
4
1
6
18
4
Sample Output

17
 */
public class BuyAndSellStocks {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i<n ; i++){
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();

        //System.out.println(mp(arr));
       // System.out.println(mtp(arr));
        System.out.println(multiT(arr , k));
    }

    // This is for when one transaction Allowed.
    private static int mp(int[] arr) {

        int maxr = arr[arr.length-1];
        int mf = 0;

        for(int i = arr.length-2 ; i>=0 ; i--){
            if(arr[i] > maxr) maxr = arr[i];
            if(maxr-arr[i] > mf) mf = maxr-arr[i];
        }
        return mf;
    }

    // This is for two transaction Allowed.

    public static int mtp(int[] arr){

       int[] buy = new int[arr.length];
       int[] sell = new int[arr.length];


       int mb = arr[arr.length-1];

        for(int i = arr.length-2 ; i>=0 ; i--){
            mb = Math.max(mb , arr[i]);
            buy[i] = Math.max(buy[i+1] , mb-arr[i]);
        }

        int ms = arr[0];
        for(int i=1 ; i<arr.length ; i++){
            ms = Math.min(ms , arr[i]);
            sell[i] = Math.max(sell[i-1] , arr[i]-ms);
        }

        int ans = 0 ;
        for(int i = 0 ; i<arr.length  ; i++){
            ans = Math.max(ans , buy[i]+sell[i]);
        }




        System.out.println(Arrays.toString(sell));
        System.out.println(Arrays.toString(buy));
        return ans;

    }

    // K transaction allow .
    // once you buy then you mush have to sell it first then again buy another stock.

    static int multiT(int[] arr , int k){
        int[][] dp = new int[k+1][arr.length];

        for(int i = 1 ; i<dp.length ; i++){
            int max = dp[i][0] - arr[0];
            for(int j = 1 ; j<dp[0].length ; j++){
                dp[i][j] = Math.max(dp[i][j-1] , max+arr[j]);
                max = Math.max(max , dp[i-1][j]-arr[j]);
            }
        }

        return dp[dp.length-1][dp[0].length-1];
    }
    

}
