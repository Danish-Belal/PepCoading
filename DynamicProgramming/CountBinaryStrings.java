package DynamicProgramming;

import java.util.Scanner;

/*
1. You are given a number n.
2. You are required to print the number of binary strings of length n with no consecutive 0's.
Constraints

0 < n <= 45
Format
Input

A number n
Output
A number representing the number of binary strings of length n with no consecutive 0's.

Example
Sample Input
6
Sample Output
21
 */
public class CountBinaryStrings {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(count(n));
    }

    private static int count(int n) {

        int[] zero = new int[n+1];
        int[] ones = new int[n+1];

        zero[0] = ones[0] = 0;
        zero[1] = ones[1] = 1;

        for(int i = 2 ; i<= n ; i++){
            zero[i] = ones[i-1];
            ones[i] = (zero[i-1]+ones[i-1]);
        }
        return (zero[n]+ones[n]);
    }
}
