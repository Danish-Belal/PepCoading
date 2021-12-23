package SelfCode.Recursion;

import java.util.Scanner;

/*
1. You are given a string str.
2. Complete the body of printSS function - without changing signature -
 to calculate and print all subsequences of str.
Use sample input and output to take idea about subsequences.
 */
public class PrintSubSequence {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();
        printSS(s," ");

    }

    public static void printSS(String str, String ans) {
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }

        char ch = str.charAt(0);
        String ros = str.substring(1);
        printSS(ros , ans+ch);
        printSS(ros , ans);


    }
}
