package DP;

import java.util.Scanner;

/*
1. You are given a number n, representing the number of stairs in a staircase.
2. You are on the 0th step and are required to climb to the top.
3. You are given n numbers, where ith element's value represents - till how far from the step you
     could jump to in a single move.
     You can of course jump fewer number of steps in the move.
4. You are required to print the number of different paths via which you can climb to the top.
Constraints

0 <= n <= 20
0 <= n1, n2, .. <= 20

Sample Input
10
3
3
0
2
1
2
4
2
0
0

Sample Output

5
 */
public class ClimbStairsWithVariableJumps {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] arr = new int[n];
        for (int i = 0 ; i<arr.length ; i++){
            arr[i] = in.nextInt();
        }

        int[] dp = new int[n];

     //   System.out.println(jump(arr , 0 , dp));
        System.out.println(jump1(arr));

//        int[] arr1 = {2,3,0,1,4};
//        System.out.println(jump1(arr1));

    }

    // Using Memorization .
     static int jump(int[] arr , int idx , int[] dp) {
        if(idx == arr.length){
            return 1;
        }
        if(idx > arr.length){
            return 0;
        }
        int ans = 0;

        if(dp[idx] != 0){
            return dp[idx];
        }
        for(int jump =1 ; jump<=arr[idx] ; jump++){
            ans += jump(arr , idx+jump , dp);
        }
        dp[idx] = ans;
        return ans;
    }

    // Using Tabulation form.
    public static int jump1(int[] nums){
        int[] dp= new int[nums.length+1];
        dp[dp.length-1] = 1;  // destination --> destination = 1 Way.


        for(int i = dp.length-2 ; i>=0 ; i--){
            int ans= 0;
            for(int jump = 1 ; jump<=nums[i]; jump++){
                if(i+jump <dp.length) {
                    ans += dp[i + jump];
                }
            }
            dp[i] = ans;
        }


        return dp[0];
    }

}
