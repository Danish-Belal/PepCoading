package DynamicProgramming;

import java.util.Scanner;

/*
1. You are given a number n, representing the count of elements.
2. You are given n numbers, representing n elements.
3. You are required to find the maximum sum of a subsequence with no adjacent elements.
Constraints
1 <= n <= 1000
-1000 <= n1, n2, .. n elements <= 1000

Sample Input
6
5
10
10
100
5
6

Sample Output
116

 */
public class MaximumSumNonAdjacentElements {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

       // System.out.println(maxSum(arr , 0 , new int[n]));
      //  System.out.println(max(arr ));
        System.out.println(includeExclude(arr));
    }

    private static int maxSum(int[] arr, int idx , int[] dp) {

        if(idx >= arr.length) return 0;


        int f1 = maxSum (arr , idx+1 ,dp);
        int f2 = arr[idx]+ maxSum (arr , idx+2 ,dp);
        dp[idx] = Math.max(f1,f2);
        return dp[idx];

    }

    static int max(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n+1];

        dp[1] = Math.max(0 , arr[0]);
        for(int i = 2 ; i<dp.length ; i++){
                dp[i] = Math.max(dp[i-1] , arr[i-1]+dp[i-2]);
        }
        return dp[n];
    }

    static int includeExclude(int[]arr){
        int inc = arr[0];
        int exc = 0;

        for(int i = 1 ; i<arr.length ; i++){
            int ninc  = arr[i]+exc;
            int nexc = Math.max(inc , exc);

            inc = ninc;
            exc = nexc;

        }
        return Math.max(inc , exc);
    }

}
