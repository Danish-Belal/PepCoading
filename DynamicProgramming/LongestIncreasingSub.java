package DynamicProgramming;

import java.util.Scanner;

public class LongestIncreasingSub {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
       // System.out.println(longSubR(arr , 0 , -1));

        // Approach2.
        // Consider every point as ending point.
        int ans = 0  ;
        int[] dp = new int[arr.length];
        for(int i = 0 ;  i<arr.length ; i++){
            ans = Math.max(ans , lis2(arr , i , dp));
        }
        System.out.println(ans);

    }

    private static int lis2(int[] arr, int idx , int[]dp) {

        int max = 0 ;
        if(dp[idx] != 0) return dp[idx];
        for(int i = idx-1 ; i>=0; i--){
            if(arr[i] <arr[idx]){
                max = Math.max(max , lis2(arr , i , dp));
            }
        }
        return dp[idx] = max+1;
    }

    private static int longSubR(int[] arr , int idx , int lidx) {
        if(idx == arr.length) return  0;
        int f1 =  longSubR(arr , idx+1 , lidx);
        int f2 =0;
        if(lidx == -1 || arr[idx]> arr[lidx]){
            f2 = 1+ longSubR(arr , idx+1 , idx);
        }
        return Math.max(f1,f2);

    }
}
