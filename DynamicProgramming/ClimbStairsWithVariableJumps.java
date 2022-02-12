package DynamicProgramming;

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
Format
Input

A number n

Output

A number representing the number of ways to climb the stairs from 0 to top.
Example

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

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
       // int n = 10;
        int[] arr = {3, 3, 0, 2, 1, 2, 4, 2, 0, 0};

//        for(int i = 0 ; i<n ; i++){
//            arr[i] = scn.nextInt();
//        }



      //  System.out.println(jump(arr , 0 , new int[arr.length]));

       // System.out.println(v);

       // System.out.println(jumpTab(arr));
        System.out.println(bottomUp(arr));
    }

    static int v = 0;
    static int jump( int[] arr , int idx , int[] dp){

        if(idx == arr.length) return 1;
        if( idx > arr.length || arr[idx] == 0) return 0;

        if(dp[idx] != 0) return dp[idx];
        int val = 0;
        for(int jump = 1 ; jump<= arr[idx] ; jump++){
           v++;     // For checking how many times will it run.
           val += jump(arr,idx+jump , dp);
        }

        dp[idx] = val;
        return val;

    }


    static int jumpTab(int[] arr ){

        int[] dp = new int[arr.length+1];
        dp[dp.length-1] = 1;

       for(int i = dp.length-2 ; i >=0 ; i--){
           int val = 0;
           for(int jump = 1 ; jump <= arr[i] ; jump++){
               if(i+jump < dp.length){
                   val += dp[i+jump];
               }
           }
           dp[i] = val;
       }
       return dp[0];

    }

    public static int bottomUp(int[] arr){
        int[] dp = new int[arr.length+1];
        dp[0] = 1;

        for(int i =1 ; i<dp.length ; i++){
            int val = 0 ;
            for(int jump = i-1 ; jump >=0 ; jump-- ){
                if( i-jump  <= arr[jump]) val+= dp[jump];
               // System.out.print("Hello" +" ");
            }
            dp[i] = val;
        }
        return dp[dp.length-1];
    }


}
