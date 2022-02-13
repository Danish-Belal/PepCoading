package DynamicProgramming;

import java.util.Scanner;

/*
1. You are given a number n, representing the number of stairs in a staircase.
2. You are on the 0th step and are required to climb to the top.
3. You are given n numbers, where ith element's value represents - till how far from the step you
     could jump to in a single move.  You can of-course fewer number of steps in the move.
4. You are required to print the number of minimum moves in which you can reach the top of
     staircase.

Note -> If there is no path through the staircase print null.
Constraints

0 <= n <= 20

0 <= n1, n2, .. <= 20
Format
Input

A number n

.. n more elements

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
4
 */
public class ClimbStairsWithMinimumMoves {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
       int n = scn.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

       // System.out.println(cs3(arr));
        System.out.println(greedy(arr));



    }

    public static int cs3(int[] arr){
        int[] dp = new int[arr.length];
        dp[arr.length-1] = 0;

        for(int i = dp.length-2 ; i>=0 ; i--){
            int min = Integer.MAX_VALUE-1;

            for(int jump = 1 ; jump <= arr[i] ; jump++){
                if(i+jump < dp.length) {
                    min = Math.min(min, dp[i + jump]);
                }
            }
            dp[i] = 1+ min;
        }
        return dp[0];
    }

    static int greedy(int[] arr){

        int step = 0;
        for(int i = 0 ; i<arr.length ; ){
            if(arr[i] == 0) break;
            int maxidx = 0;
            int max = 0;
            for(int jump = 1 ; jump<=arr[i] ; jump++){
                int j = i+jump;
                if(j == arr.length-1) return ++step;
                if(j + arr[j] > max){
                    maxidx = j;
                    max = j+arr[j];
                }
            }
            i = maxidx;
            ++step;
        }

        return Integer.MAX_VALUE;


    }
}
