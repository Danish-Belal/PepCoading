package Recursion_on_the_Way_up;
/*
1. You are given a string str.
2. Complete the body of printPermutations function - without changing signature -
    to calculate and print all permutations of str.
Use sample input and output to take idea about permutations.

Constraints
0 <= str.length <= 7

Sample Input
abc

Sample Output
abc
acb
bac
bca
cab
cba

 */

import java.util.Scanner;

public class PrintPermutations {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        printPermutations(s , "");

    }

    public static void printPermutations(String str, String asf) {

        if(str.length()==0){
            System.out.println(asf);
            return ;

        }

        for(int i = 0 ; i <str.length() ; i++){
        char c = str.charAt(i);
        String ros = str.substring(0 , i)+str.substring(i+1);

        printPermutations(ros , asf+c);

    }}
}
