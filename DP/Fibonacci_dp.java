package DP;
import java.util.*;
import java.util.Scanner;

public class Fibonacci_dp {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int[] dp = new int[n+1];
//        System.out.println(fib(n , dp));
//        System.out.println(fibiona(n));

        int[] arr = {-2,-4,-5,-2,-3,-4 , 0 , -1};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));


    }

    public static int fib(int n , int[] dp) {
        if(n==0 || n==1) return n;

        if(dp[n] != 0){
            return dp[n];
        }

        int fib1 = fib(n-1 , dp) ;
        int fib2 = fib(n-2 , dp);
        int fibona = fib1+fib2;
        dp[n]  = fibona;
        return fibona;
    }
    public static int fibiona(int n){
        int[] dp = new int[n+1];
        for(int i = 0 ; i<= n ; i++){
            if( i ==0 || i == 1){
                dp[i] = i;
            }else{
                dp[i] = dp[i-1] + dp[i-2];
            }

        }
        return dp[n];
    }

//    public static int fibosum(int n){
//        int a = 0  , b = 1 , sum = 0 , i;
//        for(i = 0 ; i<n ; i++){
//            sum = a+b;
//            a = b;
//            b = sum;
//        }
//        return sum;
//    }
}
