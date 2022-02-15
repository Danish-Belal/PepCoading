package DynamicProgramming;

import java.util.Scanner;
import java.lang.Boolean;

/*
1. You are given a number n, representing the count of elements.
2. You are given n numbers.
3. You are given a number "tar".
4. You are required to calculate and print true or false, if there is a subset the elements of which add
     up to "tar" or not.

Constraints

1 <= n <= 30

0 <= n1, n2, .. n elements <= 20

0 <= tar <= 50

Sample Input

5
4
2
7
1
3
10
Sample Output

true
 */
public class TargetSumSubsets {

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i = 0 ; i<n ; i++){
            arr[i]= scn.nextInt();
        }
        int t = scn.nextInt();
        Boolean[][]  dp  = new Boolean[n][t+1];
        System.out.println(target(arr , 0 ,  t ,dp));

    }

    static boolean target(int[] arr , int idx ,  int tar , Boolean[][] dp){

        if(tar == 0) return true;
        if(idx == arr.length || tar < 0 ){
            return false;
        }

        if(dp[idx][tar] != null) return dp[idx][tar];

         boolean t1 = target(arr , idx+1 , tar ,dp);
         boolean t2 = target(arr , idx+1 ,  tar-arr[idx]  , dp);
         return dp[idx][tar] = t1||t2;

    }

}
