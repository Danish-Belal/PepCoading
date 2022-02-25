package DynamicProgramming;

import java.util.Scanner;

/*
1. You are given a number n, which represents the length of a road. The road has n plots on it's each side.
2. The road is to be so planned that there should not be consecutive buildings on either side of the road.
3. You are required to find and print the number of ways in which the buildings can be built on both side of roads.

Constraints
0 < n <= 45
Format
Input
A number n

Output
A number representing the number of ways in which the buildings can be built on both side of roads.

Example
Sample Input
6
Sample Output
441

 */
public class ArrangeBuildings {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        long[] zero = new long[n+1];
        long[] ones = new long[n+1];

        zero[0] = ones[0] = 0;
        zero[1] = ones[1] = 1;

        for(int i = 2 ; i<= n ; i++){
            zero[i] = ones[i-1];
            ones[i] = (zero[i-1]+ones[i-1]);
        }
        long ans = zero[n]+ones[n];
        System.out.println(ans*ans);
    }

}
