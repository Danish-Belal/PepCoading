package DynamicProgramming;

import java.util.Scanner;

/*
1. You are given a number n and a number k in separate lines,
representing the number of fences and number of colors.

2. You are required to calculate and print the number of ways in which the fences could be painted so that not more than two consecutive
    fences have same colors.

    Example
Sample Input
8
3
Sample Output

3672
 */
public class PaintFence {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        System.out.println(pf(n , k ));
        System.out.println(print(n , k ));
    }

    static int pf(int n, int k ){

        if(n == 1) return k;
        if(n == 2) return k*k;

        return (pf(n-1 , k) + pf(n-1 , k))*(k-1);


    }

    private static int print(int n, int k) {
        long[] same = new long[n+1];
        long[] diff = new long[n+1];

        same[1] = 0;
        diff[1] = k;

        for(int i = 2 ; i<=n ; i++){
            same[i] = diff[i-1];
            diff[i] = (same[i-1]+diff[i-1])*(k-1);
        }

        return (int)(same[n]+diff[n]);
    }
}
